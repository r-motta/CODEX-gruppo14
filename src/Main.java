import java.util.Scanner;			
import javax.swing.*;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

	public static int numGiocatori;
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		do
		{
			System.out.println("Quante persone giocano? (Min: 2 - Max: 4) ");
			numGiocatori = sc.nextInt();
		}while(numGiocatori<2 || numGiocatori>4);
		
		Tavolo t = new Tavolo();


		System.out.println("Inserite i vostri nickname: ");
		System.out.println("(L'ordine dei giocatori in partita sara' uguale all'ordine in cui vi inserirete adesso)");
		
		for(int i=0;i<numGiocatori;i++)
		{
			System.out.println("Giocatore "+(i+1)+": ");
			t.getGamers()[i] = new Giocatore(sc.next());
			
		}
		
		Random random = new Random();
			
			
			
			
			
		Collections.shuffle(t.getMazzoIniziali());
			
			//parte grafica per mostarre le carte inziaili per fronte e retro
			
		int j=0;
			
			//assegnazione delle carte inziali e decisione su fronte e retro
			for(int i=0;i<numGiocatori;i++)
			{
				
					
					
					if(i==0)
						j=0;
					
					String scelta = null;
					
					t.getGamers()[i].setCartaInizialePropria(t.getMazzoIniziali().get(j));
					
					do
					{
						System.out.println("vuoi usare il retro della carta? (si=s) e (no=n)");
						scelta=sc.nextLine();
					}while(!(scelta.equals('s') || scelta.equals('n')));
					
					
				    if(scelta.equals('s'))
				    {
				    	
				    	if(t.getGamers()[i].getCartaInizialePropria().getNome() == "ci1")
				    		t.getGamers()[i].getCartaInizialePropria().useRetroCi1();
				    	else if(t.getGamers()[i].getCartaInizialePropria().getNome() == "ci2")
				    		t.getGamers()[i].getCartaInizialePropria().useRetroCi2();
				    	else if(t.getGamers()[i].getCartaInizialePropria().getNome() == "ci3")
				    		t.getGamers()[i].getCartaInizialePropria().useRetroCi3();
				    	else if(t.getGamers()[i].getCartaInizialePropria().getNome() == "ci4")
				    		t.getGamers()[i].getCartaInizialePropria().useRetroCi4();
				    	else if(t.getGamers()[i].getCartaInizialePropria().getNome() == "ci5")
				    		t.getGamers()[i].getCartaInizialePropria().useRetroCi5();
				    	else if(t.getGamers()[i].getCartaInizialePropria().getNome() == "ci6")
				    		t.getGamers()[i].getCartaInizialePropria().useRetroCi6();
				    		
				    }
				    	
						
					j++;		 
			    
			//per le carte ore bisogna utilizzare il remove() qua non lo abbiamo fatto perhchÃ¨ il giocatore interessa questo mazzo una sola volta
			   
				
			}
			
			

			
			
			
			Collections.shuffle(t.getMazzoObiettivo());//mischia le carte obbiettivo
			
			//assegnazione delle carte OBIETTIVO
			for(int i=0;i<numGiocatori;i++)
			{
					int y=0,k=1;
					
					

				  //parte grafica per mostare le carte da scegliere
					
					
					int scelta=0;
					
					
					do
					{
						System.out.println("scegli una tra le due carte obiettivo: ");
						System.out.println("[1] prima carta");
						System.out.println("[2] seconda carta");
						scelta= sc.nextInt();
					}while(scelta<1 || scelta>2);
					
					
					switch(scelta)//serve per gestire la scelta delle due carte obbiettivo
					{
					case 1:
					{

						t.getGamers()[i].setCartaObiettivoSegreta(t.getMazzoObiettivo().get(y));
						t.getMazzoObiettivo().remove(y);
						
						break;
					}
					
					case 2:
					{
						
						t.getGamers()[i].setCartaObiettivoSegreta(t.getMazzoObiettivo().get(k));
						
						k++;	
						
						break;
					}
					
					
					
					
					}
					
					//gamers[i].
					
					//j++;		  
				
			}

	

		//Frame f1 = new Frame();
		
		
}
	
}
