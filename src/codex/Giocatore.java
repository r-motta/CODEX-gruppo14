package codex;


import java.util.InputMismatchException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
				
				mostraCarteDaPescareInJPG(t.getMazzoRisorse().get(y),t.getMazzoRisorse().get(k),t.getMazzoOro().get(y),t.getMazzoOro().get(k));
				
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
					try
					{
						scelta= sc.nextInt();
					}
					catch(InputMismatchException e)
					{
						System.out.println("Errore, inserire un numero tra 1 e 4 ");
						System.out.println();
						sc.nextLine();
					}
					
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
					System.out.println("Errore, inserisci un numero da 1 a 4! ");
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
        System.out.println();

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
            System.out.println(); 
        }
    }
    
    public void posizionaCarta(Tavolo t, int i)
    {
    	boolean validInput = false;
    	
    	int sceltaCartaInMano = 0;
    	boolean haScelto = false;
    	
    	do
    	{
    		
    	System.out.println(" @@@@@@@@@@ Giocatore: "+t.getGamers()[i].getNickname()+" @@@@@@@@@@");
    	System.out.println();
    	
    	System.out.println(t.getGamers()[i].getNickname()+", quale carta vuoi posizionare? ");
    	System.out.println();
    	System.out.println("__________ CARTA [0] __________________ ");
    	System.out.println(t.getGamers()[i].getCarteInMano()[0].toString());
    	System.out.println("_______________________________________|");
    	System.out.println();
    	System.out.println("__________ CARTA [1] __________________ ");
    	System.out.println(t.getGamers()[i].getCarteInMano()[1].toString());
    	System.out.println("_______________________________________|");
    	System.out.println();
    	System.out.println("__________ CARTA [2] __________________ ");
    	System.out.println(t.getGamers()[i].getCarteInMano()[2].toString());
    	System.out.println("_______________________________________|");
    	System.out.println();
    	
    	
    		
    		
            try {
            	
            	do
        		{
            	
	            	System.out.print("Inserisci il numero corrispondente alla carta che vuoi giocare: ");
	            	sceltaCartaInMano = sc.nextInt();
            	
        		}while(sceltaCartaInMano<0 || sceltaCartaInMano>2);
            	
            	mostraCartaDaJPG(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]);
            	
            	if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] instanceof CartaOro)
            	{
            		
            		String rispostaRetroOro=null;
            		do
        			{
        				try
            			{
        					
        					System.out.println("Vuoi usare il retro della carta oro? ");
            				System.out.println("SI oppure NO? ");
                			System.out.print("Risposta: ");
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
                			
                			CartaOro tempRetroOro = CartaOro.clonaCarta((CartaOro) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]);
                			
                			mostraCartaRetroDaJPG(tempRetroOro.useRetro(tempRetroOro));
                			
                			
                			//creo carta temporanea uguale a cui applico il metodo retro cosi da poter fare il to string.
                			// se facessi metodo retro su originale e utente mi dice che non vuole usare il retro della carta ma sceglierne 
                			// un'altra, non posso settarla frontale di nuovo
                			System.out.println();
                			System.out.println("_____________retro della carta _______________");
                			System.out.println();
                			System.out.println(tempRetroOro.useRetro(tempRetroOro).toString());
                			System.out.println("______________________________________________|");
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
            			
            		}else //sceglie gi� subito che vuole usare il retro della carta oro
            		{
            			t.getGamers()[i].getCarteInMano()[sceltaCartaInMano].useRetro(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]);
        				haScelto = true;
            		}
            		
            		
                	}
            		
            		
            	if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] instanceof CartaRisorsa)
            	{
            		CartaRisorsa tempRetroRisorsa = CartaRisorsa.clonaCarta((CartaRisorsa) t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]);
            		mostraCartaRetroDaJPG(tempRetroRisorsa.useRetro(tempRetroRisorsa));
            		String rispostaRetroRisorsa=null;
            		do
        			{
        				try
            			{
        					System.out.println();
        					System.out.println("____________retro della carta ________________");
                			System.out.println();
                			System.out.println(tempRetroRisorsa.useRetro(tempRetroRisorsa).toString());
                			System.out.println("______________________________________________|");
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
    	
    	//se � carta risorsa deve fare controllo --> se non va bene --> chiedere se vuole usare retro --> se non vuole, richiedere che carta vuole giocare
    	
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
    	
    	int sceltaPosizioneCarta=0;
    	
    	
    	while (!validInput) {
            
            try {
            	do
            	{
            		System.out.print(t.getGamers()[i].getNickname()+", inserisci una posizone: ");
                	sceltaPosizioneCarta = sc.nextInt();
            	}while(sceltaPosizioneCarta<0 || sceltaPosizioneCarta>t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).size());
            	
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Errore: per favore inserisci un numero tra 0 e "+t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).size());
                sc.nextLine(); // Consuma l'input non valido per evitare un loop infinito
            }
        }
    	
    	
    	int xPosizione=t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getX(); 
    	int yPosizione=t.getGamers()[i].getAreaDiGioco().posizioniLibere(t.getGamers()[i]).get(sceltaPosizioneCarta).getY();
    	
    	//POSIZIONA CARTA SCELTA IN POSIZIONE SCELTA
    	t.getGamers()[i].getAreaDiGioco().getArea()[xPosizione][yPosizione] = t.getGamers()[i].getCarteInMano()[sceltaCartaInMano];                
    	
    	//mettere angolo = "vuoto" alla/e carta/e prima
    	
    	int contaAngoliCoperti=0;
    	
    	//controllo se c'e' carta in alto a destra rispetto a dove posiziono io la carta. se c'e', angolo basso sinitro = "vuoto"
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[xPosizione-1][(yPosizione+1)] != null)
    	{
    		contaAngoliCoperti++;
    		
    		if(t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione-1)][(yPosizione+1)] instanceof Carta)
    			((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione-1)][(yPosizione+1)]).setBs("vuoto");
    		
    		else if(t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione-1)][(yPosizione+1)] instanceof CartaIniziale)	
    			((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione-1)][(yPosizione+1)]).setBs("vuoto");
    		
    	}	
    	
    	
    	
    	//controllo se c'e' carta in alto a sinistra rispetto a dove posiziono io la carta. se c'e', angolo basso destro = "vuoto"
    	
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione-1)][(yPosizione-1)] != null)
    	{	
    		contaAngoliCoperti++;
    		
    		if(t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione-1)][(yPosizione-1)] instanceof Carta)
    			((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione-1)][(yPosizione-1)]).setBd("vuoto");
    		else if(t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione-1)][(yPosizione-1)] instanceof CartaIniziale)
    			((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione-1)][(yPosizione-1)]).setBd("vuoto");
    		
    	}
    	//controllo se c'e' carta in basso a sinistra rispetto a dove posiziono io la carta. se c'e', angolo alto destro di quella carta in basso a sinistra = "vuoto"
    	
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione+1)][(yPosizione-1)] != null)
    	{
    		contaAngoliCoperti++;
    		
    		if(t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione+1)][(yPosizione-1)] instanceof Carta)
    			((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione+1)][(yPosizione-1)]).setAd("vuoto");
    		else if(t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione+1)][(yPosizione-1)] instanceof CartaIniziale)
    			((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione+1)][(yPosizione-1)]).setAd("vuoto");
        	
    	}
        	
    	//controllo se c'e' carta in basso a destra rispetto a dove posiziono io la carta. se c'e', angolo alto sinistro = "vuoto"
    	
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione+1)][(xPosizione+1)] != null)
    	{
    		contaAngoliCoperti++;
    		
    		if(t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione+1)][(yPosizione+1)] instanceof Carta)
    			((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione+1)][(yPosizione+1)]).setAs("vuoto");
    		else if(t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione+1)][(yPosizione+1)] instanceof CartaIniziale)
    			((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[(xPosizione+1)][(yPosizione+1)]).setAs("vuoto");
        	
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
    	
    	//controllo carte oro che prendono punti per ogni angolo che coprono
    	
    	String[] carteOroPuntiPerAngoli = {"fungo fungo fungo lupo", "fungo fungo fungo foglia", "fungo fungo fungo farfalla", "foglia foglia foglia farfalla", "foglia foglia foglia lupo", "foglia foglia foglia fungo", "lupo lupo lupo farfalla", "lupo lupo lupo fungo", "lupo lupo lupo foglia","farfalla farfalla farfalla lupo","farfalla farfalla farfalla foglia", "farfalla farfalla farfalla fungo"};
    	
    	if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] instanceof CartaOro)
    	{
    		for(int k=0;k<carteOroPuntiPerAngoli.length;k++)
    		{
    			if(((CartaOro)t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]).getRequisiti().equals(carteOroPuntiPerAngoli[k]))
    			{
    				t.getGamers()[i].incrementaPunti(2*contaAngoliCoperti);
    			}
    		}
    	}
    	
    	t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] = null;
    	
    	contaAngoliCoperti = 0;
    	
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
				System.out.println("[6] Conteggio simboli nell'area di gioco ");
				System.out.println("[7] no ");
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
					System.out.println("__________ CARTA [0] __________________ ");
			    	System.out.println(t.getGamers()[i].getCarteInMano()[0].toString());
			    	System.out.println("_______________________________________|");
			    	System.out.println();
			    	System.out.println("__________ CARTA [1] __________________ ");
			    	System.out.println(t.getGamers()[i].getCarteInMano()[1].toString());
			    	System.out.println("_______________________________________|");
			    	System.out.println();
			    	System.out.println("__________ CARTA [2] __________________ ");
			    	System.out.println(t.getGamers()[i].getCarteInMano()[2].toString());
			    	System.out.println("_______________________________________|");
			    	System.out.println();
			    	
			    	mostraCarteInManoInJPG(t.getGamers()[i].getCarteInMano()[0],t.getGamers()[i].getCarteInMano()[1],t.getGamers()[i].getCarteInMano()[2],i,t);
						
						break;
				}
				case 2:
				{
					
					System.out.println("_____________________ CARTA OBIETTIVO SEGRETA _______________________");
					System.out.println();
					System.out.println(t.getGamers()[i].getCartaObiettivoSegreta().toString());
					System.out.println("_____________________________________________________________________|");					
					System.out.println();
					
					mostraCartaObiettivoSegretaDaJPG(t.getGamers()[i].getCartaObiettivoSegreta());
					
					break;
				}
				case 3:
				{
					System.out.println("____________ Questa e' la prima carta obiettivo comune ____________________");
					System.out.println();
					System.out.println(Main.cobPubblica1.toString());
					System.out.println("___________________________________________________________________________|");					

					System.out.println();
					
					System.out.println("____________ Questa e' la seconda carta obiettivo comune __________________");
					System.out.println();
					System.out.println("Questa e' la seconda carta obiettivo comune: ");
					System.out.println(Main.cobPubblica2.toString());
					System.out.println("___________________________________________________________________________|");	
					System.out.println();
					
					mostraCarteObiettivoInJPG(Main.cobPubblica1, Main.cobPubblica2);
					
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

					if(t.getGamers()[i].getAreaDiGioco().getArea()[riga][colonna] instanceof Carta)
						mostraCartaDaJPG((Carta)t.getGamers()[i].getAreaDiGioco().getArea()[riga][colonna]);
					else if(t.getGamers()[i].getAreaDiGioco().getArea()[riga][colonna] instanceof CartaIniziale)
						mostraCartaInizialeDaJPG((CartaIniziale)t.getGamers()[i].getAreaDiGioco().getArea()[riga][colonna]);
					
					   break;
				}

				case 6:	
				{
					int contaFunghi=0;
					int contaLupi=0;
					int contaFarfalle=0;
					int contaFoglie=0;
					int contaPiume=0;
					int contaPergamene=0;
					int contaBottiglie=0;
					
					for(int r=0;r<AreaDiGioco.maxRighe;r++)
					{
						for(int c=0;c<AreaDiGioco.maxColonne;c++)
						{
							if(t.getGamers()[i].getAreaDiGioco().getArea()[r][c]!=null)
							{
								if(t.getGamers()[i].getAreaDiGioco().getArea()[r][c] instanceof Carta)
								{	
									if("fungo".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAd()))
										contaFunghi++;
										else if("lupo".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAd()))
											contaLupi++;
										else if("farfalla".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAd()))
											contaFarfalle++;
										else if("foglia".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAd()))
											contaFoglie++;
										else if("piuma".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAd()))
											contaFoglie++;
										else if("pergamena".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAd()))
											contaPergamene++;
										else if("bottiglia".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAd()))
											contaBottiglie++;
										
									if("fungo".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAs()))
											contaFunghi++;
									else if("lupo".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAs()))
										contaLupi++;
									else if("farfalla".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAs()))
										contaFarfalle++;
									else if("foglia".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAs()))
										contaFoglie++;
									else if("piuma".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAs()))
										contaFoglie++;
									else if("pergamena".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAs()))
										contaPergamene++;
									else if("bottiglia".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAs()))
										contaBottiglie++;
										
										
									if("fungo".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBd()))
											contaFunghi++;
									else if("lupo".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBd()))
										contaLupi++;
									else if("farfalla".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBd()))
										contaFarfalle++;
									else if("foglia".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBd()))
										contaFoglie++;
									else if("piuma".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBd()))
										contaFoglie++;
									else if("pergamena".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBd()))
										contaPergamene++;
									else if("bottiglia".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBd()))
										contaBottiglie++;
										
										
									if("fungo".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBs()))
											contaFunghi++;
									else if("lupo".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBs()))
										contaLupi++;
									else if("farfalla".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBs()))
										contaFarfalle++;
									else if("foglia".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBs()))
										contaFoglie++;
									else if("piuma".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBs()))
										contaFoglie++;
									else if("pergamena".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBs()))
										contaPergamene++;
									else if("bottiglia".equals(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBs()))
										contaBottiglie++;
										
										if(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getSimboloRetro().equals("fungo"))
											contaFunghi++;
											else if(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getSimboloRetro().equals("lupo"))
												contaLupi++;
											else if(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getSimboloRetro().equals("farfalla"))
												contaFarfalle++;
											else if(((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getSimboloRetro().equals("foglia"))
												contaFoglie++;
											
								}
								else if(t.getGamers()[i].getAreaDiGioco().getArea()[r][c] instanceof CartaIniziale)
								{
									if("fungo".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAd()))
										contaFunghi++;
									else if("lupo".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAd()))
										contaLupi++;
									else if("farfalla".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAd()))
										contaFarfalle++;
									else if("foglia".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAd()))
										contaFoglie++;
									
										
										if("fungo".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAs()))
											contaFunghi++;
										else if("lupo".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAs()))
											contaLupi++;
										else if("farfalla".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAs()))
											contaFarfalle++;
										else if("foglia".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getAs()))
											contaFoglie++;
										
										
										if("fungo".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBd()))
											contaFunghi++;
										else if("lupo".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBd()))
											contaLupi++;
										else if("farfalla".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBd()))
											contaFarfalle++;
										else if("foglia".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBd()))
											contaFoglie++;
										
										
										if("fungo".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBs()))
											contaFunghi++;
										else if("lupo".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBs()))
											contaLupi++;
										else if("farfalla".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBs()))
											contaFarfalle++;
										else if("foglia".equals(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getBs()))
											contaFoglie++;
								
									
									if(((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getSimboloRetro().equals("vuoto") == false)
									{
										String[] simboli = ((CartaIniziale) t.getGamers()[i].getAreaDiGioco().getArea()[r][c]).getSimboloRetro().split(",");
										
										for(int k=0;k<simboli.length;k++)
										{
											if(simboli[i].equals("fungo"))
												contaFunghi++;
											else if(simboli[i].equals("lupo"))
												contaLupi++;
											else if(simboli[i].equals("farfalla"))
												contaFarfalle++;
											else if(simboli[i].equals("foglia"))
												contaFoglie++;
											
										}
									}
								}
								
								
							}
						}
					}
					System.out.println();
					System.out.println("N� Funghi: "+contaFunghi);
					System.out.println("N� Lupi: "+contaLupi);
					System.out.println("N� Farfalle: "+contaFarfalle);
					System.out.println("N� Foglie: "+contaFoglie);
					System.out.println("N� Piume: "+contaPiume);
					System.out.println("N� Pergamene: "+contaPergamene);
					System.out.println("N� Bottiglie: "+contaBottiglie);
					System.out.println();
					
					break;
				}
				
				
				case 7:
				{
					
					break;
				}
				
				
				default:
				{
					System.out.println("Errore, riprova ");
					break;
				}
				
		
			}
	

		}while(scelta!=7);
		
		System.out.println();
		System.out.println();
	}
	
	public static void mostraCartaObiettivoSegretaDaJPG(CartaObiettivo c)
    {
    	JFrame frame = new JFrame("Visualizzazione Carta");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout()); // Usa FlowLayout per visualizzare le carte una accanto all'altra

        try {
            
            URL urlImmagine1 = Giocatore.class.getResource(c.getPercorsoImmagine());
            if (urlImmagine1 == null) {
                System.err.println("File non trovato: " + c.getPercorsoImmagine());
                return;
            }
            Image img1 = ImageIO.read(urlImmagine1);
            Image img1Scaled = img1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            JLabel label1 = new JLabel(new ImageIcon(img1Scaled));
            frame.getContentPane().add(label1);

        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.pack();
        
        frame.setVisible(true);
    }
	
	public static void mostraCartaRetroDaJPG(Carta c)
    {
    	JFrame frame = new JFrame("Visualizzazione Carta");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout()); // Usa FlowLayout per visualizzare le carte una accanto all'altra

        try {
            
            URL urlImmagine1 = Giocatore.class.getResource(c.getPercorsoImmagine());
            if (urlImmagine1 == null) {
                System.err.println("File non trovato: " + c.getPercorsoImmagine());
                return;
            }
            Image img1 = ImageIO.read(urlImmagine1);
            Image img1Scaled = img1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            JLabel label1 = new JLabel(new ImageIcon(img1Scaled));
            frame.getContentPane().add(label1);

        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.pack();
        
        int x = 350;
        int y = 0; // Sposta il frame a 50 pixel dal bordo superiore
        frame.setLocation(x, y);
        
        frame.setVisible(true);
    }
	
	

	public static void mostraCartaDaJPG(Carta c)
    {
    	JFrame frame = new JFrame("Visualizzazione Carta");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout()); // Usa FlowLayout per visualizzare le carte una accanto all'altra

        try {
            
            URL urlImmagine1 = Giocatore.class.getResource(c.getPercorsoImmagine());
            if (urlImmagine1 == null) {
                System.err.println("File non trovato: " + c.getPercorsoImmagine());
                return;
            }
            Image img1 = ImageIO.read(urlImmagine1);
            Image img1Scaled = img1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            JLabel label1 = new JLabel(new ImageIcon(img1Scaled));
            frame.getContentPane().add(label1);

        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.pack();
        
        frame.setVisible(true);
    }
	    
	    public static void mostraCarteInizialiInJPG(CartaIniziale c1, CartaIniziale c2, Tavolo t, int i)
	    {
	    	JFrame frame = new JFrame("Visualizzazione Carta iniziale di "+t.getGamers()[i].getNickname());
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setLayout(new FlowLayout()); // Usa FlowLayout per visualizzare le carte una accanto all'altra

	        try {
	            
	            URL urlImmagine1 = Giocatore.class.getResource(c1.getPercorsoImmagine());
	            if (urlImmagine1 == null) {
	                System.err.println("File non trovato: " + c1.getPercorsoImmagine());
	                return;
	            }
	            Image img1 = ImageIO.read(urlImmagine1);
	            Image img1Scaled = img1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label1 = new JLabel(new ImageIcon(img1Scaled));
	            frame.getContentPane().add(label1);

	            
	            URL urlImmagine2 = Giocatore.class.getResource(c2.getPercorsoImmagine());
	            if (urlImmagine2 == null) {
	                System.err.println("File non trovato: " + c2.getPercorsoImmagine());
	                return;
	            }
	            Image img2 = ImageIO.read(urlImmagine2);
	            Image img2Scaled = img2.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label2 = new JLabel(new ImageIcon(img2Scaled));
	            frame.getContentPane().add(label2);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        frame.pack();
	        
	        frame.setVisible(true);
	    }

	    public static void mostraCarteObiettivoInJPG(CartaObiettivo c1, CartaObiettivo c2)
	    {
	    	JFrame frame = new JFrame("Visualizzazione Carte obiettivo");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setLayout(new FlowLayout()); // Usa FlowLayout per visualizzare le carte una accanto all'altra

	        try {
	            
	            URL urlImmagine1 = Giocatore.class.getResource(c1.getPercorsoImmagine());
	            if (urlImmagine1 == null) {
	                System.err.println("File non trovato: " + c1.getPercorsoImmagine());
	                return;
	            }
	            Image img1 = ImageIO.read(urlImmagine1);
	            Image img1Scaled = img1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label1 = new JLabel(new ImageIcon(img1Scaled));
	            frame.getContentPane().add(label1);

	            
	            URL urlImmagine2 = Giocatore.class.getResource(c2.getPercorsoImmagine());
	            if (urlImmagine2 == null) {
	                System.err.println("File non trovato: " + c2.getPercorsoImmagine());
	                return;
	            }
	            Image img2 = ImageIO.read(urlImmagine2);
	            Image img2Scaled = img2.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label2 = new JLabel(new ImageIcon(img2Scaled));
	            frame.getContentPane().add(label2);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        frame.pack();
	        
	        
	        int x = 900;
	        int y = 0; 
	        frame.setLocation(x, y);
	        
	        frame.setVisible(true);
	    }
	    
	    public static void mostraCarteInManoInJPG(Carta c1, Carta c2, Carta c3,int i,Tavolo t) {
	        JFrame frame = new JFrame("Visualizzazione Carte in mano di "+t.getGamers()[i].getNickname());
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setLayout(new FlowLayout()); // Usa FlowLayout per visualizzare le carte una accanto all'altra

	        try {
	            // Carica e ridimensiona l'immagine della prima carta
	            URL urlImmagine1 = Giocatore.class.getResource(c1.getPercorsoImmagine());
	            if (urlImmagine1 == null) {
	                System.err.println("File non trovato: " + c1.getPercorsoImmagine());
	                return;
	            }
	            Image img1 = ImageIO.read(urlImmagine1);
	            Image img1Scaled = img1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label1 = new JLabel(new ImageIcon(img1Scaled));
	            frame.getContentPane().add(label1);

	            // Carica e ridimensiona l'immagine della seconda carta
	            URL urlImmagine2 = Giocatore.class.getResource(c2.getPercorsoImmagine());
	            if (urlImmagine2 == null) {
	                System.err.println("File non trovato: " + c2.getPercorsoImmagine());
	                return;
	            }
	            Image img2 = ImageIO.read(urlImmagine2);
	            Image img2Scaled = img2.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label2 = new JLabel(new ImageIcon(img2Scaled));
	            frame.getContentPane().add(label2);

	            // Carica e ridimensiona l'immagine della terza carta
	            URL urlImmagine3 = Giocatore.class.getResource(c3.getPercorsoImmagine());
	            if (urlImmagine3 == null) {
	                System.err.println("File non trovato: " + c3.getPercorsoImmagine());
	                return;
	            }
	            Image img3 = ImageIO.read(urlImmagine3);
	            Image img3Scaled = img3.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label3 = new JLabel(new ImageIcon(img3Scaled));
	            frame.getContentPane().add(label3);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        frame.pack();
	        
	        frame.setVisible(true);
	    }
	    
	    public static void mostraCarteDaPescareInJPG(Carta c1, Carta c2, Carta c3, Carta c4)
	    {
	        JFrame frame = new JFrame("Visualizzazione Carte da poter pescare");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setLayout(new FlowLayout()); // Usa FlowLayout per visualizzare le carte una accanto all'altra

	        try {
	            // Carica e ridimensiona l'immagine della prima carta
	            URL urlImmagine1 = Giocatore.class.getResource(c1.getPercorsoImmagine());
	            if (urlImmagine1 == null) {
	                System.err.println("File non trovato: " + c1.getPercorsoImmagine());
	                return;
	            }
	            Image img1 = ImageIO.read(urlImmagine1);
	            Image img1Scaled = img1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label1 = new JLabel(new ImageIcon(img1Scaled));
	            frame.getContentPane().add(label1);

	            // Carica e ridimensiona l'immagine della seconda carta
	            URL urlImmagine2 = Giocatore.class.getResource(c2.getPercorsoImmagine());
	            if (urlImmagine2 == null) {
	                System.err.println("File non trovato: " + c2.getPercorsoImmagine());
	                return;
	            }
	            Image img2 = ImageIO.read(urlImmagine2);
	            Image img2Scaled = img2.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label2 = new JLabel(new ImageIcon(img2Scaled));
	            frame.getContentPane().add(label2);

	            // Carica e ridimensiona l'immagine della terza carta
	            URL urlImmagine3 = Giocatore.class.getResource(c3.getPercorsoImmagine());
	            if (urlImmagine3 == null) {
	                System.err.println("File non trovato: " + c3.getPercorsoImmagine());
	                return;
	            }
	            Image img3 = ImageIO.read(urlImmagine3);
	            Image img3Scaled = img3.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label3 = new JLabel(new ImageIcon(img3Scaled));
	            frame.getContentPane().add(label3);
	            
	            // Carica e ridimensiona l'immagine della quarta carta
	            URL urlImmagine4 = Giocatore.class.getResource(c4.getPercorsoImmagine());
	            if (urlImmagine4 == null) {
	                System.err.println("File non trovato: " + c4.getPercorsoImmagine());
	                return;
	            }
	            Image img4 = ImageIO.read(urlImmagine1);
	            Image img4Scaled = img4.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label4 = new JLabel(new ImageIcon(img4Scaled));
	            frame.getContentPane().add(label4);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        frame.pack();
	        
	        frame.setVisible(true);
	    }
	    
	    public static void mostraCartaInizialeDaJPG(CartaIniziale c)
	    {
	    	JFrame frame = new JFrame("Visualizzazione Carta");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setLayout(new FlowLayout()); // Usa FlowLayout per visualizzare le carte una accanto all'altra

	        try {
	            
	            URL urlImmagine1 = Giocatore.class.getResource(c.getPercorsoImmagine());
	            if (urlImmagine1 == null) {
	                System.err.println("File non trovato: " + c.getPercorsoImmagine());
	                return;
	            }
	            Image img1 = ImageIO.read(urlImmagine1);
	            Image img1Scaled = img1.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
	            JLabel label1 = new JLabel(new ImageIcon(img1Scaled));
	            frame.getContentPane().add(label1);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        frame.pack();
	        
	        frame.setVisible(true);
	    }

	
}