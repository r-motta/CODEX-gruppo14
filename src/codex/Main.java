package codex;
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
				System.out.println("--------------- GIOCATORE "+(i+1)+" ---------------");
					
					
					if(i==0)
						j=0;
					
					String scelta = null;
					
					t.getGamers()[i].setCartaInizialePropria(t.getMazzoIniziali().get(j));
					//far vedere davanti e retro della carta
					
					do {
					    System.out.println("Vuoi usare il retro della carta? (SI/NO)");
					    scelta = sc.nextLine();
					} while (!(scelta.equalsIgnoreCase("SI") || scelta.equalsIgnoreCase("NO")));
					
					
					if(scelta.equalsIgnoreCase("SI"))
				    {
						t.getGamers()[i].getCartaInizialePropria().useRetro(t.getGamers()[i].getCartaInizialePropria());
				    		
				    }
				    	
					j++;
				
			}
			
			

			
			
			
			Collections.shuffle(t.getMazzoObiettivo());//mischia le carte obbiettivo
			
			//assegnazione delle carte OBIETTIVO
			for(int i=0;i<numGiocatori;i++)
			{
					int y=0,k=1;
					
					System.out.println("--------------- GIOCATORE "+(i+1)+" ---------------");
				
					System.out.println("--------------------------------------------------------------|");
					System.out.println("questa e' la prima carta obiettivo:                           |");
					System.out.println("Requisiti: "+ t.getMazzoObiettivo().get(y).getRequisiti()+"   |");
					System.out.println("Punti: "+ t.getMazzoObiettivo().get(y).getPunti()+"           |");
					System.out.println("--------------------------------------------------------------|");
					
					System.out.println();
					System.out.println();
					
					System.out.println("--------------------------------------------------------------|");
					System.out.println("questa e' la seconda carta:                                   |");
					System.out.println("Requisiti: "+ t.getMazzoObiettivo().get(k).getRequisiti()+"   |");
					System.out.println("Punti: "+ t.getMazzoObiettivo().get(k).getPunti()+"           |");
					System.out.println("--------------------------------------------------------------|");
					
					
					int scelta=0;
					
					System.out.println();
					System.out.println();
					
					
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
						t.getMazzoObiettivo().remove(k);
						k++;	
						
						break;
					}
					
					default:
					{
						System.out.println("Errore, riprova! ");
						break;
					}
					
					
					}
					
							  
				
			}

			Collections.shuffle(t.getMazzoRisorse());//mischia le carte risorsa
			Collections.shuffle(t.getMazzoOro());//mischia le carte oro

			//assegnazione 1 carta oro e 2 carta risorsa ad inizio partita
			
			for(int i=0;i<numGiocatori;i++)
			{
				t.getGamers()[i].getCarteInMano()[0] = t.getMazzoOro().get(0);
				t.getMazzoOro().remove(0);
				
				t.getGamers()[i].getCarteInMano()[1] = t.getMazzoRisorse().get(0);
				t.getGamers()[i].getCarteInMano()[2] = t.getMazzoRisorse().get(1);
				
				t.getMazzoRisorse().remove(0);
				t.getMazzoRisorse().remove(1);
				
				
				
				
			}
			
			//assegno ad ogni giocatore la propria area di gioco con al centro la carta iniziale 
			
			for(int i=0;i<numGiocatori;i++)
			{
				t.getGamers()[i].setArea(t.getGamers()[i]);
			}
		
		
}
	
}
