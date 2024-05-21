package codex;
import java.util.Scanner;			
import javax.swing.*;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;


public class Main {

	public static int numGiocatori;
	public static CartaObiettivo cobPubblica1;
	public static CartaObiettivo cobPubblica2;
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		do
		{
			try
			{
				System.out.println("Quante persone giocano? (Min: 2 - Max: 4) ");
				numGiocatori = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Errore: per favore inserisci un numero tra 2 e 4.");
                sc.nextLine();
			}
			
		}while(numGiocatori<2 || numGiocatori>4);
		
		Tavolo t = new Tavolo();
		
		cobPubblica1 = t.getMazzoObiettivo().get(0);
		cobPubblica2 = t.getMazzoObiettivo().get(1);
		
		t.getMazzoObiettivo().remove(0);
		t.getMazzoObiettivo().remove(1);

		Assegnazione a = new Assegnazione(t);
		
		boolean finito = false;
		
		while(finito == false)
		{
			for(int i=0;i<Main.numGiocatori;i++)
			{
				if(t.getGamers()[i].getPunti()<20)
				{
					
					t.getGamers()[i].posizionaCarta(t, i);
					t.getGamers()[i].pesca(t);
					t.getGamers()[i].stampaAreaDiGioco(t.getGamers()[i]);
					t.getGamers()[i].visualizza(t,i);
				}
				else
					finito = true;
			}
			
		}
		
		int pos=0;
		//prendo posizione del giocatore che è arrivato per primo a 20 punti
		for(int i=0;i<Main.numGiocatori;i++)
		{
			if(t.getGamers()[i].getPunti()>20)
			{
				pos = i;
				break;
			}
		}
		
		//turno addizionale per i giocatori rimanenti per concludere il giro, dopo che un giocatore ha raggiunto i 20 punti
		for(int i=pos+1; i<Main.numGiocatori;i++)
		{
			t.getGamers()[i].posizionaCarta(t, i);
			t.getGamers()[i].pesca(t);
			t.getGamers()[i].stampaAreaDiGioco(t.getGamers()[i]);
			t.getGamers()[i].visualizza(t,i);
		}
		
		//punti totali
		for(int i=0;i<Main.numGiocatori;i++)
		{
			t.getGamers()[i].getCartaObiettivoSegreta().controllo(t.getGamers()[i].getCartaObiettivoSegreta(), t.getGamers()[i]);
			
			Main.cobPubblica1.controllo(Main.cobPubblica1, t.getGamers()[i]);
			Main.cobPubblica2.controllo(Main.cobPubblica2, t.getGamers()[i]);
		}
		
	
		
		//fa la graduatoria
		Arrays.sort(t.getGamers(), new Comparator<Giocatore>()
		{
            @Override
            public int compare(Giocatore g1, Giocatore g2) {
                return Integer.compare(g2.getPunti(), g1.getPunti());
            }
        });
		
		// stampa la graduatoria
        System.out.println("Graduatoria: ");
        for (int i = 0; i < t.getGamers().length; i++) {
            System.out.println((i + 1) + ". " + t.getGamers()[i].getNickname() + " - " + t.getGamers()[i].getPunti() + " punti");
        }
		
		
}
	
}
