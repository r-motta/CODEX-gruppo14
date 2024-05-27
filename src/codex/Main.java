package codex;
import java.util.Scanner;				
import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;



public class Main {

	public static int numGiocatori;
	public static CartaObiettivo cobPubblica1;
	public static CartaObiettivo cobPubblica2;
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("______________ CODEX NATURALIS ______________");
		System.out.println();
		
		do
		{
			try
			{
				System.out.print("Quante persone giocano (Min: 2 - Max: 4):  ");
				numGiocatori = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Errore: per favore inserisci un numero tra 2 e 4.");
                sc.nextLine();
			}
			
		}while(numGiocatori<2 || numGiocatori>4);
		
		Tavolo t = new Tavolo();
		
		Collections.shuffle(t.getMazzoObiettivo());
		
		cobPubblica1 = t.getMazzoObiettivo().get(0);
		t.getMazzoObiettivo().remove(0);
		cobPubblica2 = t.getMazzoObiettivo().get(1);
		t.getMazzoObiettivo().remove(0);

		Assegnazione a = new Assegnazione(t);
		
		boolean finito = false;
		int pos=0;
		
		while(finito == false)
		{
			for(int i=0;i<Main.numGiocatori;i++)
			{
					t.getGamers()[i].posizionaCarta(t, i);
					t.getGamers()[i].pesca(t,i);
					t.getGamers()[i].visualizza(t,i);
					
				if(t.getGamers()[i].getPunti()>=20)
				{
					finito = true;
					pos = i;
					break;
				}
					
			}
			
		}
		
		
		//turno addizionale per i giocatori rimanenti per concludere il giro, dopo che un giocatore ha raggiunto i 20 punti
		System.out.println("---------->  TURNO ADDIZIONALE PRIMA DEL TERMINE DELLA PARTITA <---------- ");
		System.out.println();
		
		for(int i=pos+1; i<Main.numGiocatori;i++)
		{
			t.getGamers()[i].posizionaCarta(t, i);
			t.getGamers()[i].pesca(t,i);
			t.getGamers()[i].visualizza(t,i);
		}
		
		//punti totali
		for(int i=0;i<Main.numGiocatori;i++)
		{
			System.out.println("@@@@@@@@@@@@ Giocatore: "+t.getGamers()[i].getNickname()+" @@@@@@@@@@@@");
			System.out.println();
			System.out.println("_______________________ Carta obiettivo segreta ___________________________________________");
			System.out.println();
			t.getGamers()[i].getCartaObiettivoSegreta().controllo(t.getGamers()[i].getCartaObiettivoSegreta(), t.getGamers()[i]);
			System.out.println("___________________________________________________________________________________________|");
			
			System.out.println();
			
			System.out.println("___________________ Carta obiettivo pubblica n°1 __________________________________________");
			System.out.println();
			Main.cobPubblica1.controllo(Main.cobPubblica1, t.getGamers()[i]);
			System.out.println("___________________________________________________________________________________________|");

			System.out.println();
			
			System.out.println("___________________ Carta obiettivo pubblica n°2 __________________________________________");
			System.out.println();
			Main.cobPubblica2.controllo(Main.cobPubblica2, t.getGamers()[i]);
			System.out.println("___________________________________________________________________________________________|");

			System.out.println();
		}
		
	
		
		//fa la graduatoria
		Arrays.sort(t.getGamers(), new Comparator<Giocatore>()
		{
            @Override
            public int compare(Giocatore g1, Giocatore g2) {
                return Integer.compare(g2.getPunti(), g1.getPunti());
            }
        });
		
		System.out.println();
		
		// stampa la graduatoria
        System.out.println("§§§§§§§§§   Graduatoria  §§§§§§§§§ ");
        System.out.println();
        for(int i=0;i<t.getGamers().length;i++)
        {
            System.out.println((i + 1)+". "+ t.getGamers()[i].getNickname() + " - " + t.getGamers()[i].getPunti()+" punti");
        }
		System.out.println();
		System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§ ");
		
}
	
}
