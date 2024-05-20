package codex;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assegnazione {
	
	Scanner sc = new Scanner(System.in);
	
	public Assegnazione(Tavolo t)
	{
		this.sc = new Scanner(System.in);
		
		System.out.println("Inserite i vostri nickname: ");
		System.out.println("(L'ordine dei giocatori in partita sara' uguale all'ordine in cui vi inserirete adesso)");
		
		
		for(int i=0;i<Main.numGiocatori;i++)
		{
			boolean nicknameValido;
			
			do
			{
				nicknameValido = true;
				
				try
				{
					System.out.println("Giocatore "+(i+1)+": ");
					t.getGamers()[i] = new Giocatore(sc.next());
					
					// Verifica se il nickname contiene numeri
					for(int p=0;p<t.getGamers()[i].getNickname().length();p++)
			        {
			            if(!Character.isLetter(t.getGamers()[i].getNickname().charAt(p)))
			            {
			            	nicknameValido = false;
			                break;
			            }
			        }
					
				}
				catch(Exception e)
				{
					System.out.println("Errore: per favore scrivi una parola. Il nickname non pu� contenere numeri ");
	                sc.nextLine();
				}
				
			}while(!nicknameValido);
			
			
		}
			
			
		Collections.shuffle(t.getMazzoIniziali());
			
			//parte grafica per mostarre le carte inziaili per fronte e retro
			
		int j=0;
			
			//assegnazione delle carte inziali e decisione su fronte o retro
			for(int i=0;i<Main.numGiocatori;i++)
			{
				System.out.println("--------------- GIOCATORE: "+t.getGamers()[i].getNickname()+" ---------------");
					
					
					if(i==0)
						j=0;
					
					String scelta = null;
					
					t.getGamers()[i].setCartaInizialePropria(t.getMazzoIniziali().get(j));

					System.out.println("---------- PARTE FRONTALE DELLA CARTA ---------- ");
					System.out.println(t.getGamers()[i].getCartaInizialePropria().toString()); 
					System.out.println();
					System.out.println("---------- PARTE RETRO DELLA CARTA ---------- ");
					
					CartaIniziale tempRetroIniziale = CartaIniziale.clonaCarta(t.getGamers()[i].getCartaInizialePropria());
					
					System.out.println(tempRetroIniziale.useRetro(tempRetroIniziale).toString()); 
					
					System.out.println();
					
					do {
						try
						{
							System.out.println("Vuoi usare il retro della carta? (SI/NO)");
						    scelta = sc.next();
						}
						catch(InputMismatchException e)
            			{
            				System.out.println("Errore: per favore scrivi si oppure no in maiuscolo o minuscolo.");
                            sc.nextLine();
            			}
					    
					}while(!(scelta.equalsIgnoreCase("SI") || scelta.equalsIgnoreCase("NO")));
					
					
					if(scelta.equalsIgnoreCase("SI"))
				    {
						t.getGamers()[i].getCartaInizialePropria().useRetro(t.getGamers()[i].getCartaInizialePropria());
				    		
				    }
				    	
					j++;
				
			}
			
			

			
			
			
			Collections.shuffle(t.getMazzoObiettivo());//mischia le carte obbiettivo
			
			//assegnazione delle carte OBIETTIVO
			for(int i=0;i<Main.numGiocatori;i++)
			{
					int y=0,k=1;
					
					System.out.println("--------------- GIOCATORE "+t.getGamers()[i].getNickname()+" ---------------");
				
					System.out.println("--------------------------------------------------------------|");
					System.out.println("questa e' la prima carta obiettivo:                           |");
					System.out.println(t.getMazzoObiettivo().get(y).toString());
					System.out.println("--------------------------------------------------------------|");
					
					System.out.println();
					System.out.println();
					
					System.out.println("--------------------------------------------------------------|");
					System.out.println("questa e' la seconda carta:                                   |");
					System.out.println(t.getMazzoObiettivo().get(k).toString());
					System.out.println("--------------------------------------------------------------|");
					
					
					int scelta=0;
					
					System.out.println();
					System.out.println();
					
					
					do
					{
						try
						{
							System.out.println("scegli una tra le due carte obiettivo: ");
							System.out.println("[1] prima carta");
							System.out.println("[2] seconda carta");
							scelta= sc.nextInt();
						}
						catch(InputMismatchException e)
						{
							System.out.println("Errore, per favore inserire un numero compreso tra 1 e 2");
							sc.nextLine();
						}
						
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
			
			//fa vedere carte obiettivo comuni
			System.out.println("Questa e' la prima carta obiettivo comune: ");
			System.out.println(Main.cobPubblica1.toString());
			System.out.println();
			System.out.println("Questa e' la seconda carta obiettivo comune: ");
			System.out.println(Main.cobPubblica2.toString());

			Collections.shuffle(t.getMazzoRisorse());//mischia le carte risorsa
			Collections.shuffle(t.getMazzoOro());//mischia le carte oro

			//assegnazione 1 carta oro e 2 carta risorsa ad inizio partita
			
			for(int i=0;i<Main.numGiocatori;i++)
			{
				System.out.println("--------------- GIOCATORE "+t.getGamers()[i].getNickname()+" ---------------");
				
				
				t.getGamers()[i].getCarteInMano()[0] = t.getMazzoOro().get(0);
				System.out.println("Questa � la tua carta oro: ");
				System.out.println(t.getMazzoOro().get(0).toString());
				System.out.println();
				t.getMazzoOro().remove(0);
				
				t.getGamers()[i].getCarteInMano()[1] = t.getMazzoRisorse().get(0);
				System.out.println("Questa � la tua prima carta risorsa: ");
				System.out.println(t.getMazzoRisorse().get(0).toString());
				System.out.println();
				
				t.getGamers()[i].getCarteInMano()[2] = t.getMazzoRisorse().get(1);
				System.out.println("Questa � la tua prima carta risorsa: ");
				System.out.println(t.getMazzoRisorse().get(1).toString());
				System.out.println();
				
				t.getMazzoRisorse().remove(0);
				t.getMazzoRisorse().remove(1);
				
				
				
				
			}
			
			//assegno ad ogni giocatore la propria area di gioco con al centro la carta iniziale 
			
			for(int i=0;i<Main.numGiocatori;i++)
			{
				t.getGamers()[i].setArea(t.getGamers()[i]);
			}
	}

}
