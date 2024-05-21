package codex;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Giocatore {

    private String nickname;
    private int punti=0;
    private CartaObiettivo cartaObiettivoSegreta;
    private CartaIniziale CartaInizialePropria = null;
    private final int maxCarteInMano=3;
    private Carta[] carteInMano = new Carta[maxCarteInMano];
    private AreaDiGioco area;
    
    Scanner sc = new Scanner(System.in);
    
    public Giocatore(String nome)
    {
        this.nickname = nome;
        this.sc = new Scanner(System.in);
    }

    public void pesca(Tavolo t)
    {
    			int p=0;
				int y=0,k=1;
				
				System.out.println("--------------- GIOCATORE "+(p+1)+" ---------------");
			
				System.out.println("--------------------------------------------------------------|");
				System.out.println("questa e' la prima carta risorsa:                             |");
				t.getMazzoRisorse().get(y).toString();
				System.out.println("--------------------------------------------------------------|");
				
				System.out.println();
				System.out.println();
				
				System.out.println("--------------------------------------------------------------|");
				System.out.println("questa e' la seconda carta risorsa:                             |");
				t.getMazzoRisorse().get(k).toString();
				System.out.println("--------------------------------------------------------------|");
				
				System.out.println();
				System.out.println();
				
				System.out.println("--------------------------------------------------------------|");
				System.out.println("questa e' la prima carta oro:                             |");
				t.getMazzoOro().get(y).toString();
				System.out.println("--------------------------------------------------------------|");
				
				System.out.println();
				System.out.println();
				
				System.out.println("--------------------------------------------------------------|");
				System.out.println("questa e' la seconda carta oro:                             |");
				t.getMazzoOro().get(k).toString();
				System.out.println("--------------------------------------------------------------|");
				
				
				int scelta=0;
				
				System.out.println();
				System.out.println();
				
				
				do
				{
					System.out.println("Quale carta vuoi pescare? ");
					System.out.println("[1] prima carta risorsa ");
					System.out.println("[2] seconda carta risorsa ");
					System.out.println("[3] prima carta oro ");
					System.out.println("[4] seconda carta oro ");
					scelta= sc.nextInt();
				}while(scelta<1 || scelta>4);
				
				
				switch(scelta)
				{
				case 1:
				{

					for(int i=0;i<maxCarteInMano;i++)
					{
						if(carteInMano[i]==null)
						{
							carteInMano[i] = t.getMazzoRisorse().get(y);
							t.getMazzoRisorse().remove(y);
							break;
						}
					}
					
					break;
				}
				
				case 2:
				{
					
					for(int i=0;i<maxCarteInMano;i++)
					{
						if(carteInMano[i]==null)
						{
							carteInMano[i] = t.getMazzoRisorse().get(k);
							t.getMazzoRisorse().remove(k);
							break;
						}
					}
					
					break;
				}
				
				case 3:
				{
					
					for(int i=0;i<maxCarteInMano;i++)
					{
						if(carteInMano[i]==null)
						{
							carteInMano[i] = t.getMazzoOro().get(y);
							t.getMazzoOro().remove(y);
							break;
						}
					}
					
					break;
				}
				
				case 4:
				{
					
					for(int i=0;i<maxCarteInMano;i++)
					{
						if(carteInMano[i]==null)
						{
							carteInMano[i] = t.getMazzoOro().get(k);
							t.getMazzoOro().remove(k);
							break;
						}
					}
					
					break;
				}
				
				default:
				{
					System.out.println("Errore, riprova! ");
					break;
				}
				
				
				}
				
    	
    	
        

    }
    
    public void stampaAreaDiGioco(Giocatore g)
    {
    	for(int i=0;i<AreaDiGioco.maxRighe;i++)
    	{
    		for(int j=0;j<AreaDiGioco.maxColonne;j++)
    		{
    			
    		if(g.getAreaDiGioco().getArea()[i][j]!=null)
    		{
    			System.out.println("|X|");
    			System.out.println("-");
    		}
    		else
    		{
    			System.out.println("|O|");
    			System.out.println("-");
    		}
    		
    		
    			
    		}
    	}
    }
    
    public void posizionaCarta(Tavolo t, int i)
    {
    	boolean validInput = false;
    	Scanner sc = new Scanner(System.in);
    	int sceltaCartaInMano = 0;
    	boolean haScelto = false;
    	
    	do
    	{
    	
    	System.out.println("Quale carta vuoi posizionare? ");
    	System.out.println();
    	System.out.println("CARTA [0]: ");
    	System.out.println(t.getGamers()[i].getCarteInMano()[0].toString());
    	System.out.println();
    	System.out.println("CARTA [1]: ");
    	System.out.println(t.getGamers()[i].getCarteInMano()[1].toString());
    	System.out.println();
    	System.out.println("CARTA [2]: ");
    	System.out.println(t.getGamers()[i].getCarteInMano()[2].toString());
    	System.out.println();
    	
    	while (!validInput) {
    		
    		
            try {
            	
            	do
        		{
            	
	            	System.out.print("Inserisci un numero: ");
	            	sceltaCartaInMano = sc.nextInt();
            	
        		}while(sceltaCartaInMano<0 || sceltaCartaInMano>2);
            	
            	if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] instanceof CartaOro)
            	{
            		if(((CartaOro) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]).controlloRequisiti((CartaOro) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano], t.getGamers()[i]) == true)
            		{
            			validInput = true;
            			haScelto = true;
            		}	
            		else
            		{
            			System.out.println("I requisiti per utilizzare questa carta non sono soddisfatti. ");
            			System.out.println("Vuoi usare il retro della carta? ");
            			
            			CartaOro tempRetro = CartaOro.clonaCarta((CartaOro) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]);
            			
            			
            			//creo carta temporanea uguale a cui applico il metodo retro cosi da poter fare il to string.
            			// se facessi metodo retro su originale e utente mi dice che non vuole usare il retro della carta ma sceglierne 
            			// un'altra, non posso settarla frontale di nuovo
            			
            			tempRetro.useRetro(tempRetro).toString();
            			String rispostaRetro = null;
            			
            			do
            			{
            				try
                			{
                				System.out.println("SI oppure NO? ");
                    			System.out.println("Risposta: ");
                    			rispostaRetro = sc.next();
                			}
                			catch(InputMismatchException e)
                			{
                				System.out.println("Errore: per favore scrivi si oppure no in maiuscolo o minuscolo.");
                                sc.nextLine();
                			}
            			}while(!(rispostaRetro.equalsIgnoreCase("SI") || rispostaRetro.equalsIgnoreCase("NO")));
            			
            			if(rispostaRetro.equalsIgnoreCase("SI"))
            			{
            				t.getGamers()[i].getCarteInMano()[sceltaCartaInMano].useRetro(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]);
            				haScelto = true;
            			}
            			
            			
            		}
            	}
            	
            	//richiesta del retro per unacarta risorsa
            	
            	
            	if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] instanceof CartaRisorsa)
            	{
            		if(((CartaRisorsa) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]).controlloRequisiti((CartaRisorsa) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano], t.getGamers()[i]) == true)
            		{
            			validInput = true;
            			haScelto = true;
            		}	
            		else
            		{
            			System.out.println("I requisiti per utilizzare questa carta non sono soddisfatti. ");
            			System.out.println("Vuoi usare il retro della carta? ");
            			
            			CartaRisorsa tempRetro = CartaRisorsa.clonaCarta((CartaRisorsa) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]);
            			
            			
            			//creo carta temporanea uguale a cui applico il metodo retro cosi da poter fare il to string.
            			// se facessi metodo retro su originale e utente mi dice che non vuole usare il retro della carta ma sceglierne 
            			// un'altra, non posso settarla frontale di nuovo
            			
            			tempRetro.useRetro(tempRetro).toString();
            			String rispostaRetro = null;
            			
            			do
            			{
            				try
                			{
                				System.out.println("SI oppure NO? ");
                    			System.out.println("Risposta: ");
                    			rispostaRetro = sc.next();
                			}
                			catch(InputMismatchException e)
                			{
                				System.out.println("Errore: per favore scrivi si oppure no in maiuscolo o minuscolo.");
                                sc.nextLine();
                			}
            			}while(!(rispostaRetro.equalsIgnoreCase("SI") || rispostaRetro.equalsIgnoreCase("NO")));
            			
            			if(rispostaRetro.equalsIgnoreCase("SI"))
            			{
            				t.getGamers()[i].getCarteInMano()[sceltaCartaInMano].useRetro(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]);
            				haScelto = true;
            			}
            			
            			
            		}
            	}
            	
            	
            	if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] instanceof CartaRisorsa)
            		haScelto = true;
            	
                
            } catch (InputMismatchException e) {
                System.out.println("Errore: per favore inserisci un numero tra 0 e 2.");
                sc.nextLine(); // Consuma l'input non valido
            }
            
    		
        }
    	
    	}while(haScelto != true);
    	
    	//se � carta risorsa deve fare controllo --> se non va bene --> chiedere se vuole usare retro --> se non vuole, richiedere che carta vuole giocare
    	
    	
    	
    	validInput = false;
    	
    	//stampa matrice prima
    	
    	
    	t.getGamers()[i].stampaAreaDiGioco(t.getGamers()[i]);
    	
    	
    	System.out.println("Dove vuoi posizionare la carta");
    	for(int j=0;j<t.getGamers()[i].getAreaDiGioco().posizioniLibere().size();j++)
    	{
    		
    		
    	
    		//esempio stampa: [posizione 1] --> x: 1   y: 3
    		System.out.println("------------------------------------------- ");
    		System.out.println("[Posizione "+(j)+"] --->  x: "+t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(j).getX() + "    y: " + t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(j).getY());
    		System.out.println("------------------------------------------- ");
    		System.out.println();
    	}
    	
    	System.out.println();
    	int sceltaPosizioneCarta = 0;
    	
    	while (!validInput) {
            
            try {
            	System.out.print("Inserisci una posizone: ");
            	sceltaPosizioneCarta = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Errore: per favore inserisci un numero tra 0 e "+t.getGamers()[i].getAreaDiGioco().posizioniLibere().size());
                sc.nextLine(); // Consuma l'input non valido per evitare un loop infinito
            }
        }
    	
    	
    	//POSIZIONA CARTA SCELTA IN POSIZIONE SCELTA
    	t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()] = t.getGamers()[i].getCarteInMano()[sceltaCartaInMano];                
    	
    	//mettere angolo = "vuoto" alla/e carta/e prima
    	
    	//controllo se c'� carta in alto a destra rispetto a dove posiziono io la carta. se c'�, angolo basso sinitro = "vuoto"
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()-1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()+1] != null)
    	((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()-1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()+1]).getBs().equals("vuoto");
    	
    	//controllo se c'� carta in alto a sinistra rispetto a dove posiziono io la carta. se c'�, angolo basso destro = "vuoto"
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()-1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()-1] != null)
        	((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()-1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()-1]).getBs().equals("vuoto");
        	
    	//controllo se c'� carta in basso a sinistra rispetto a dove posiziono io la carta. se c'�, angolo alto destro = "vuoto"
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()+1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()-1] != null)
        	((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()+1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()-1]).getBs().equals("vuoto");
    	
    	//controllo se c'� carta in basso a destra rispetto a dove posiziono io la carta. se c'�, angolo alto sinistro = "vuoto"
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()+1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()+1] != null)
        	((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()+1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()+1]).getBs().equals("vuoto");
        	
    	
    	//se � una carta risorsa con i punti, incrementa punti
    	
    	if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] instanceof CartaRisorsa)
    	{
    		if(((CartaRisorsa) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]).getPuntoVittoria()>0)
    			t.getGamers()[i].incrementaPunti(1);
    	}
    	
    }
    
    

    public CartaIniziale getCartaInizialePropria() {
        return CartaInizialePropria;
    }

    public void setCartaInizialePropria(CartaIniziale cartaInizialePropria) {
        CartaInizialePropria = cartaInizialePropria;
    }

    public CartaObiettivo getCartaObiettivoSegreta() {
        return cartaObiettivoSegreta;
    }

    public void setCartaObiettivoSegreta(CartaObiettivo cartaObiettivoSegreta) {
        this.cartaObiettivoSegreta = cartaObiettivoSegreta;
    }

	public String getNickname() {
		return nickname;
	}

	public AreaDiGioco getAreaDiGioco() {
		return area;
	}
	
	

	public int getPunti() {
		return punti;
	}
	
	
	public void incrementaPunti(int valore) {
        this.punti += valore;
    }

	public Carta[] getCarteInMano() {
		return carteInMano;
	}

	public void setArea(Giocatore g) {
		area = new AreaDiGioco(g);
	}
	
	public void visualizza(Tavolo t, int i)
	{
		int scelta =0;
		
		do
		{
			try
			{
				System.out.println("Vuoi visualizzare altro? ");
				System.out.println("[1] Carte in mano ");
				System.out.println("[2] Carta obiettivo segreta ");
				System.out.println("[3] Carte obiettivo comuni ");
				System.out.println("[4] Punteggio ");
				System.out.println("[5] posizione carta nella matrice);");
				System.out.println("[6] no ");
				System.out.println("Risposta: ");
				scelta = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Errore: per favore inserisci un numero tra 1 e 4.");
                sc.nextLine();
			}
			
			switch(scelta)
			{
				case 1:
				{
						System.out.println("PRIMA CARTA IN MANO: ");
						t.getGamers()[i].getCarteInMano()[0].toString();
						System.out.println();
						System.out.println("SECONDA CARTA IN MANO: ");
						t.getGamers()[i].getCarteInMano()[1].toString();
						System.out.println();
						System.out.println("TERZA CARTA IN MANO: ");
						t.getGamers()[i].getCarteInMano()[2].toString();
						System.out.println();
						
						break;
				}
				case 2:
				{
					
					System.out.println("CARTA OBIETTIVO SEGRETA: ");
					t.getGamers()[i].getCartaObiettivoSegreta().toString();
					System.out.println();
					
					break;
				}
				case 3:
				{
					System.out.println("Questa e' la prima carta obiettivo comune: ");
					System.out.println(Main.cobPubblica1.toString());
					System.out.println();
					System.out.println("Questa e' la seconda carta obiettivo comune: ");
					System.out.println(Main.cobPubblica2.toString());
					
					break;
				}
				case 4:
				{
					t.getGamers()[i].getPunti();
					break;
				}
				
				
				case 5:
				{
					
					        // Acquisizione della riga
					        System.out.println("Inserire riga i:");
					        int riga = sc.nextInt(); 

					        // Acquisizione della colonna
					        System.out.println("Inserire colonna j:");
					        int colonna = sc.nextInt(); 

					        // Controlla che i valori siano entro i limiti della matrice
					        if (riga >= 0 && riga < t.getGamers()[i].getAreaDiGioco().getMaxRighe() &&
					            colonna >= 0 && colonna < t.getGamers()[i].getAreaDiGioco().getMaxColonne())
					        {

					          

          // Recupera la carta alla posizione specificata
            Carta carta = t.getGamers()[i].getAreaDiGioco().getArea()[riga][colonna];
            if (carta != null) {
                
                if (carta instanceof CartaIniziale) {
                    CartaIniziale cartaIniziale = (CartaIniziale) carta;
                    System.out.println(cartaIniziale.toString());
                } else if (carta instanceof CartaRisorsa) {
                    CartaRisorsa cartaRisorsa = (CartaRisorsa) carta;
                    System.out.println(cartaRisorsa.toString()); 
                } else {
                    System.out.println(carta.toString()); 
                }
            } else {
                System.out.println("Nessuna carta presente nella cella specificata.");
            }
        } else {
            System.out.println("Le coordinate inserite sono fuori dai limiti della matrice.");
        }

       
					        break;
}

					
				
				case 6:
				{
					
					break;
				}
				
				default:
				{
					System.out.println("Errore, riprova ");
					break;
				}
				
		
			}
	

		}while(scelta!=6);//qua ho messo 67 orima cera quattro forse avete modificato lo switch e non avete mdoficato la condizione di uscitq proavte a vedere
	}
}