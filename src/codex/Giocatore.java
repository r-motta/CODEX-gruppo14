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

    public void pesca(Tavolo t, int s)
    {
    			int p=0;
				int y=0,k=1;
				
				System.out.println("@@@@@@@@@@ GIOCATORE "+(t.getGamers()[s].getNickname())+" @@@@@@@@@@");
				System.out.println();
				System.out.println(t.getGamers()[s].getNickname()+", ora devi pescare una tra le 4 carte proposte: ");
				System.out.println();
			
				System.out.println("_______________ Questa e' la prima carta risorsa ________________");
				System.out.println();
				System.out.println(t.getMazzoRisorse().get(y).toString());
				System.out.println("_________________________________________________________________|");
				
				System.out.println();
				System.out.println();
				
				System.out.println("______________ Questa e' la seconda carta risorsa _______________");
				System.out.println();
				System.out.println(t.getMazzoRisorse().get(k).toString());
				System.out.println("_________________________________________________________________|");
				
				System.out.println();
				System.out.println();
				
				System.out.println("_________________ Questa e' la prima carta oro __________________");
				System.out.println();
				System.out.println(t.getMazzoOro().get(y).toString());
				System.out.println("_________________________________________________________________|");
				
				System.out.println();
				System.out.println();
				
				System.out.println("_______________ Questa e' la seconda carta oro __________________");
				System.out.println();
				System.out.println(t.getMazzoOro().get(k).toString());
				System.out.println("_________________________________________________________________|");
				
				
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
					System.out.print("Risposta: ");
					scelta= sc.nextInt();
				}while(scelta<1 || scelta>4);
				
				
				switch(scelta)
				{
				case 1:
				{

					for(int i=0;i<maxCarteInMano;i++)
					{
						if(t.getGamers()[s].getCarteInMano()[i]==null)
						{
							t.getGamers()[s].getCarteInMano()[i] = t.getMazzoRisorse().get(y);
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
						if(t.getGamers()[s].getCarteInMano()[i]==null)
						{
							t.getGamers()[s].getCarteInMano()[i] = t.getMazzoRisorse().get(k);
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
						if(t.getGamers()[s].getCarteInMano()[i]==null)
						{
							t.getGamers()[s].getCarteInMano()[i] = t.getMazzoOro().get(y);
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
						if(t.getGamers()[s].getCarteInMano()[i]==null)
						{
							t.getGamers()[s].getCarteInMano()[i] = t.getMazzoOro().get(k);
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
				
    	
				System.out.println();
				System.out.println();
        

    }
    
    public void stampaAreaDiGioco(Giocatore g)
    {
    	System.out.println("Area di gioco di: "+g.getNickname());
    	System.out.println();
    	System.out.print("   "); // Spazio per l'indice delle righe
        for (int j = 0; j < AreaDiGioco.maxColonne; j++) {
            System.out.printf("%3d", j);
        }
        System.out.println(); // Nuova linea

        for (int i = 0; i < AreaDiGioco.maxRighe; i++) {
            // Stampa l'indice della riga
            System.out.printf("%3d", i);
            
            for (int j = 0; j < AreaDiGioco.maxColonne; j++) {
                if (g.getAreaDiGioco().getArea()[i][j] != null) {
                    System.out.print("  X");
                } else {
                    System.out.print("  O");
                }
            }
            System.out.println(); // Nuova linea alla fine della riga
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
    		
    	System.out.println(" @@@@@@@@@@ Giocatore: "+t.getGamers()[i].getNickname()+" @@@@@@@@@@");
    	System.out.println();
    	
    	System.out.println(t.getGamers()[i].getNickname()+", quale carta vuoi posizionare? ");
    	System.out.println();
    	System.out.println("__________ CARTA [0] __________ ");
    	System.out.println(t.getGamers()[i].getCarteInMano()[0].toString());
    	System.out.println("_______________________________|");
    	System.out.println();
    	System.out.println("__________ CARTA [1] __________ ");
    	System.out.println(t.getGamers()[i].getCarteInMano()[1].toString());
    	System.out.println("_______________________________|");
    	System.out.println();
    	System.out.println("__________ CARTA [2] __________ ");
    	System.out.println(t.getGamers()[i].getCarteInMano()[2].toString());
    	System.out.println("_______________________________|");
    	System.out.println();
    	
    	
    		
    		
            try {
            	
            	do
        		{
            	
	            	System.out.print("Inserisci il numero corrispondente alla carta che vuoi giocare: ");
	            	sceltaCartaInMano = sc.nextInt();
            	
        		}while(sceltaCartaInMano<0 || sceltaCartaInMano>2);
            	
            	if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] instanceof CartaOro)
            	{
            		
            		String rispostaRetroOro=null;
            		do
        			{
        				try
            			{
        					System.out.println("Vuoi usare il retro della carta oro? ");
            				System.out.println("SI oppure NO? ");
                			System.out.println("Risposta: ");
                			rispostaRetroOro = sc.next();
            			}
            			catch(InputMismatchException e)
            			{
            				System.out.println("Errore: per favore scrivi si oppure no in maiuscolo o minuscolo.");
                            sc.nextLine();
            			}
        			}while(!(rispostaRetroOro.equalsIgnoreCase("SI") || rispostaRetroOro.equalsIgnoreCase("NO")));
            		
            		if(rispostaRetroOro.equalsIgnoreCase("NO"))
            		{
            			if(((CartaOro) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]).controlloRequisiti((CartaOro) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano], t.getGamers()[i]) == true)
                		haScelto = true;
                		else
                		{
                			System.out.println();
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
                					System.out.println();
                    				System.out.println("SI oppure NO? ");
                        			System.out.print("Risposta: ");
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
            			
            		}else //sceglie già subito che vuole usare il retro della carta oro
            		{
            			t.getGamers()[i].getCarteInMano()[sceltaCartaInMano].useRetro(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]);
        				haScelto = true;
            		}
            		
            		
                	}
            		
            		
            		
            			
            		
            	
            	if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] instanceof CartaRisorsa)
            	{
            		String rispostaRetroRisorsa=null;
            		do
        			{
        				try
            			{
        					System.out.println();
        					System.out.println("Vuoi usare il retro della carta risorsa (SI/NO)? ");
                			System.out.print("Risposta: ");
                			rispostaRetroRisorsa = sc.next();
            			}
            			catch(InputMismatchException e)
            			{
            				System.out.println("Errore: per favore scrivi 'si' oppure 'no' in maiuscolo o minuscolo.");
                            sc.nextLine();
            			}
        			}while(!(rispostaRetroRisorsa.equalsIgnoreCase("SI") || rispostaRetroRisorsa.equalsIgnoreCase("NO")));
            		
            		if(rispostaRetroRisorsa.equalsIgnoreCase("NO"))
            		haScelto = true;
            		else
            		{
            			t.getGamers()[i].getCarteInMano()[sceltaCartaInMano].useRetro(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]);
            			haScelto = true;
            		}
            	}
            		
            	
                
            } catch (InputMismatchException e) {
                System.out.println("Errore: per favore inserisci un numero tra 0 e 2.");
                sc.nextLine(); // Consuma l'input non valido
            }
            
    		
        
    	
    	}while(haScelto != true);
    	
    	//se ï¿½ carta risorsa deve fare controllo --> se non va bene --> chiedere se vuole usare retro --> se non vuole, richiedere che carta vuole giocare
    	
    	System.out.println();
    	
    	validInput = false;
    	
    	//stampa matrice prima
    	t.getGamers()[i].stampaAreaDiGioco(t.getGamers()[i]);
    	
    	System.out.println();
    	
    	
    	System.out.println(t.getGamers()[i].getNickname()+", dove vuoi posizionare la carta? ");
    	System.out.println("Queste sono le poszioni libere in cui puoi mettere la carta: ");
    	System.out.println();
    	for(int j=0;j<t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).size();j++)
    	{
    		
    		
    	
    		//esempio stampa: [posizione 1] --> x: 1   y: 3
    		System.out.println("------------------------------------------- ");
    		System.out.println("[Posizione "+(j)+"] --->  x: "+t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(j).getX() + "    y: " + t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(j).getY());
    		System.out.println("------------------------------------------- ");
    		System.out.println();
    	}
    	
    	System.out.println();
    	int sceltaPosizioneCarta = 0;
    	
    	while (!validInput) {
            
            try {
            	System.out.print(t.getGamers()[i].getNickname()+", inserisci una posizone: ");
            	sceltaPosizioneCarta = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Errore: per favore inserisci un numero tra 0 e "+t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).size());
                sc.nextLine(); // Consuma l'input non valido per evitare un loop infinito
            }
        }
    	
    	
    	
    	
    	//POSIZIONA CARTA SCELTA IN POSIZIONE SCELTA
    	t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()][t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()] = t.getGamers()[i].getCarteInMano()[sceltaCartaInMano];                
    	
    	//mettere angolo = "vuoto" alla/e carta/e prima
    	
    	
    	//controllo se c'e' carta in alto a destra rispetto a dove posiziono io la carta. se c'e', angolo basso sinitro = "vuoto"
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()-1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()+1)] != null) {
    		
    		if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()-1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()+1)] instanceof Carta)
    			((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()-1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()+1)]).setBs("vuoto");
    		
    		else if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()-1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()+1)] instanceof CartaIniziale)	
    			((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()-1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()+1)]).setBs("vuoto");
    		
    	}	
    	
    	//controllo se c'e' carta in alto a sinistra rispetto a dove posiziono io la carta. se c'e', angolo basso destro = "vuoto"
    	
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()-1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()-1)] != null)
    	{	
    		if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()-1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()-1)] instanceof Carta)
    			((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()-1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()-1)]).setBd("vuoto");
    		else if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()-1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()-1)] instanceof CartaIniziale)
    			((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()-1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()-1)]).setBd("vuoto");
    		
    	}
    	//controllo se c'e' carta in basso a sinistra rispetto a dove posiziono io la carta. se c'e', angolo alto destro di quella carta in basso a sinistra = "vuoto"
    	
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()+1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()-1)] != null)
    	{
    		if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()+1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()-1)] instanceof Carta)
    			((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()+1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()-1)]).setAd("vuoto");
    		else if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()+1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()-1)] instanceof CartaIniziale)
    			((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()+1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()-1)]).setAd("vuoto");
        	
    	}
        	
    	//controllo se c'e' carta in basso a destra rispetto a dove posiziono io la carta. se c'e', angolo alto sinistro = "vuoto"
    	
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()+1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()+1)] != null)
    	{
    		if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()+1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()+1)] instanceof Carta)
    			((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()+1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()+1)]).setAs("vuoto");
    		else if(t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()+1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()+1)] instanceof CartaIniziale)
    			((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX()+1)][(t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY()+1)]).setAs("vuoto");
        	
    	}
    	
        	
    	
    	//se e' una carta risorsa con i punti, incrementa punti
    	
    	if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] instanceof CartaRisorsa)
    	{
    		if(((CartaRisorsa) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]).getPuntoVittoria()>0)
    			t.getGamers()[i].incrementaPunti(1);
    	}
    	
    	System.out.println();
    	
    	//stampa matrice dopo posizionamento
    	t.getGamers()[i].stampaAreaDiGioco(t.getGamers()[i]);
    	
    	System.out.println();
    	
    	
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
				System.out.println();
				System.out.println(t.getGamers()[i].getNickname()+", vuoi visualizzare altro? ");
				System.out.println();
				System.out.println("[1] Carte in mano ");
				System.out.println("[2] Carta obiettivo segreta ");
				System.out.println("[3] Carte obiettivo comuni ");
				System.out.println("[4] Punteggio ");
				System.out.println("[5] Descrizione di una specifica carta nell'area di gioco ");
				System.out.println("[6] no ");
				System.out.print("Risposta: ");
				scelta = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Errore: per favore inserisci un numero tra 1 e 6.");
                sc.nextLine();
			}
			
			System.out.println();
			
			switch(scelta)
			{
				case 1:
				{
					System.out.println("__________ CARTA [0] __________ ");
			    	System.out.println(t.getGamers()[i].getCarteInMano()[0].toString());
			    	System.out.println("_______________________________|");
			    	System.out.println();
			    	System.out.println("__________ CARTA [1] __________ ");
			    	System.out.println(t.getGamers()[i].getCarteInMano()[1].toString());
			    	System.out.println("_______________________________|");
			    	System.out.println();
			    	System.out.println("__________ CARTA [2] __________ ");
			    	System.out.println(t.getGamers()[i].getCarteInMano()[2].toString());
			    	System.out.println("_______________________________|");
			    	System.out.println();
						
						break;
				}
				case 2:
				{
					
					System.out.println("_____________________ CARTA OBIETTIVO SEGRETA _______________________");
					System.out.println();
					System.out.println(t.getGamers()[i].getCartaObiettivoSegreta().toString());
					System.out.println("_____________________________________________________________________|");					
					System.out.println();
					
					break;
				}
				case 3:
				{
					System.out.println("____________ Questa e' la prima carta obiettivo comune ____________________");
					System.out.println();
					System.out.println(Main.cobPubblica1.toString());
					System.out.println("_____________________________________________________________________|");					

					System.out.println();
					
					System.out.println("____________ Questa e' la seconda carta obiettivo comune ____________________");
					System.out.println();
					System.out.println("Questa e' la seconda carta obiettivo comune: ");
					System.out.println(Main.cobPubblica2.toString());
					System.out.println("_____________________________________________________________________|");	
					System.out.println();
					
					break;
				}
				case 4:
				{
					System.out.println("Punteggio di "+t.getGamers()[i].getNickname()+": "+t.getGamers()[i].getPunti());
					System.out.println();
					break;
				}
				
				
				case 5:
				{
					boolean verificato = false;
					int riga=0, colonna=0;
					
					do
					{
						
						do
						{
							try
					        {
					        	System.out.print("Inserire la riga in cui si trova la carta: ");
						        riga = sc.nextInt(); 
					        }catch(InputMismatchException e)
					        {
					        	System.out.println("Errore, inserisci un numero da 0 a "+AreaDiGioco.maxRighe);
					        	sc.nextLine();
					        }
						}while(riga<0 || riga>AreaDiGioco.maxRighe);
					        
					   
					    do
					    {
					    	try
					        {
					        	System.out.print("Inserire la colonna in cui si trova la carta: ");
						        colonna = sc.nextInt(); 
					        }catch(InputMismatchException e)
					        {
					        	System.out.println("Errore, inserisci un numero da 0 a "+AreaDiGioco.maxColonne);
					        	sc.nextLine();
					        }
					    }while(colonna<0 || riga>AreaDiGioco.maxColonne);
			        
					        
					        
					        if(t.getGamers()[i].getAreaDiGioco().getArea()[riga][colonna]!=null)
					        	verificato = true;
					        else
					        	System.out.println("Errore, nella posizione inserita non c'e' alcuna carta, riprovare! ");
					        
					}while(verificato!=true);
					
					System.out.println();
					          
					System.out.println("______________________________________________________ ");
					System.out.println();
					
			         if(t.getGamers()[i].getAreaDiGioco().getArea()[riga][colonna] instanceof Carta)
			        	 System.out.println(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[riga][colonna]).toString()); 
			         else if(t.getGamers()[i].getAreaDiGioco().getArea()[riga][colonna] instanceof CartaIniziale)
			        	System.out.println(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[riga][colonna]).toString()); 
			         
					System.out.println("______________________________________________________ ");
					System.out.println();

       
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
	

		}while(scelta!=6);
		
		System.out.println();
		System.out.println();
	}
}