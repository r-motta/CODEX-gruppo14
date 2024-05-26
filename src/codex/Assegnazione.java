package codex;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assegnazione {
	
	Scanner sc = new Scanner(System.in);
	
	public Assegnazione(Tavolo t)
	{
		this.sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Inserite i vostri nickname: ");
		System.out.println("(L'ordine dei giocatori in partita sara' uguale all'ordine in cui vi inserirete adesso)");
		System.out.println();
		
		
		for(int i=0;i<Main.numGiocatori;i++)
		{
			boolean nicknameValido;
			
			do
			{
				nicknameValido = true;
				
				try
				{
					System.out.print("Giocatore "+(i+1)+": ");
					t.getGamers()[i] = new Giocatore(sc.next());
					System.out.println();
					
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
					System.out.println("Errore: per favore scrivi una parola. Il nickname non può contenere numeri ");
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
				System.out.println("@@@@@@@@@@@@@ GIOCATORE: "+t.getGamers()[i].getNickname()+" @@@@@@@@@@@@@");
				
				System.out.println();
				System.out.println("Ciao "+t.getGamers()[i].getNickname()+", questa è la carta iniziale che ti è stata assegnata: ");
				System.out.println();
					
					if(i==0)
						j=0;
					
					String scelta = null;
					
					t.getGamers()[i].setCartaInizialePropria(t.getMazzoIniziali().get(j));

					System.out.println("______________ PARTE FRONTALE DELLA CARTA ______________ ");
					System.out.println();
					System.out.println(t.getGamers()[i].getCartaInizialePropria().toString()); 
					System.out.println("_____________________________________________________");
					System.out.println();
					System.out.println("______________ PARTE RETRO DELLA CARTA ______________ ");
					System.out.println();
					
					CartaIniziale tempRetroIniziale = CartaIniziale.clonaCarta(t.getGamers()[i].getCartaInizialePropria());
					
					System.out.println(tempRetroIniziale.useRetro(tempRetroIniziale).toString()); 
					System.out.println("_____________________________________________________");
					
					System.out.println();
					
					do {
						try
						{
							System.out.print("Vuoi usare il retro della carta? (SI/NO): ");
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
					
					System.out.println();
				
			}
			
			

			
			
			
			Collections.shuffle(t.getMazzoObiettivo());//mischia le carte obbiettivo
			
			//assegnazione delle carte OBIETTIVO
			for(int i=0;i<Main.numGiocatori;i++)
			{
					int y=0,k=1;
					
					System.out.println("@@@@@@@@@@@@@ GIOCATORE: "+t.getGamers()[i].getNickname()+" @@@@@@@@@@@@@");
					System.out.println();
					System.out.println(t.getGamers()[i].getNickname()+", scelgi una tra le due carte obiettivo proposte: ");
					System.out.println();
					
					System.out.println("__________________________ Questa e' la prima carta obiettivo ________________________");
					System.out.println();
					System.out.println(t.getMazzoObiettivo().get(y).toString());
					System.out.println("______________________________________________________________________________________|");
					
					System.out.println();
					System.out.println();
					
					System.out.println("__________________________ Questa e' la seconda carta obiettivo ______________________");
					System.out.println();
					System.out.println(t.getMazzoObiettivo().get(k).toString());
					System.out.println("______________________________________________________________________________________|");					
					
					int scelta=0;
					
					System.out.println();
					System.out.println();
					
					
					do
					{
						try
						{
							System.out.println("Scegli una tra le due carte obiettivo: ");
							System.out.println("[1] prima carta");
							System.out.println("[2] seconda carta");
							System.out.print("Risposta: ");
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
						
						break;
					}
					
					default:
					{
						System.out.println("Errore, riprova! ");
						break;
					}
					
					
					}
					
							  
				
			}
			System.out.println();
			System.out.println("Queste invece sono le due carte obiettivo comuni a tutti i giocatori: ");
			//fa vedere carte obiettivo comuni
			System.out.println("____________ Questa e' la prima carta obiettivo comune ____________________");
			System.out.println();
			System.out.println(Main.cobPubblica1.toString());
			System.out.println("___________________________________________________________________________|");					

			System.out.println();
			
			System.out.println("____________ Questa e' la seconda carta obiettivo comune __________________");
			System.out.println();
			System.out.println(Main.cobPubblica2.toString());
			System.out.println("___________________________________________________________________________|");					


			Collections.shuffle(t.getMazzoRisorse());//mischia le carte risorsa
			Collections.shuffle(t.getMazzoOro());//mischia le carte oro

			//assegnazione 1 carta oro e 2 carta risorsa ad inizio partita
			
			for(int i=0;i<Main.numGiocatori;i++)
			{
				System.out.println();
				System.out.println("@@@@@@@@@@@@@ GIOCATORE: "+t.getGamers()[i].getNickname()+" @@@@@@@@@@@@@");
				System.out.println();
				System.out.println(t.getGamers()[i].getNickname()+", queste sono le tue carte in mano ad inizio partita: ");
				System.out.println();
			
				t.getGamers()[i].getCarteInMano()[0] = t.getMazzoOro().get(0);
				System.out.println("_____________ Questa è la tua carta oro iniziale ____________________");
				System.out.println();
				System.out.println(t.getMazzoOro().get(0).toString());
				System.out.println("_____________________________________________________________________|");					

				System.out.println();
				t.getMazzoOro().remove(0);
				
				t.getGamers()[i].getCarteInMano()[1] = t.getMazzoRisorse().get(0);
				System.out.println("__________ Questa è la tua prima carta risorsa iniziale _____________");
				System.out.println();
				System.out.println(t.getMazzoRisorse().get(0).toString());
				System.out.println("_____________________________________________________________________|");					

				System.out.println();
				
				t.getGamers()[i].getCarteInMano()[2] = t.getMazzoRisorse().get(1);
				System.out.println("__________ Questa è la tua seconda carta risorsa iniziale _____________");
				System.out.println();
				System.out.println(t.getMazzoRisorse().get(1).toString());
				System.out.println("_____________________________________________________________________|");					
				
				System.out.println();
				
				t.getMazzoRisorse().remove(0);
				t.getMazzoRisorse().remove(0);
				
				
				
				
			}
			
			//assegno ad ogni giocatore la propria area di gioco con al centro la carta iniziale 
			
			for(int i=0;i<Main.numGiocatori;i++)
			{
				t.getGamers()[i].setArea(t.getGamers()[i]);
			}
	}

}
