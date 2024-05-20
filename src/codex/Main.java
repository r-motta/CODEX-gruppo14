package codex;
import java.util.Scanner;			
import javax.swing.*;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;


public class Main {

	public static int numGiocatori;
	
	

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
					//scegliere se vedere le carte obiettivo comuni e sua personale
				}
				else
					finito = true;
				
			
			}
			
		}
		
		int pos=0;
		
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
		}
		
		for(int i=0;i<Main.numGiocatori;i++)
		{
			t.get
		}
		
		
		
}
	
}
