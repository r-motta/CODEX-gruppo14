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
    
    public void posizionaCarta(Tavolo t, int i)
    {
    	boolean validInput = false;
    	Scanner sc = new Scanner(System.in);
    	int sceltaCartaInMano = 0;
    	
    	System.out.println("Quale carta vuoi posizionare? ");
    	System.out.println();
    	System.out.println("CARTA [0]: ");
    	t.getGamers()[i].getCarteInMano()[0].toString();
    	System.out.println();
    	System.out.println("CARTA [1]: ");
    	t.getGamers()[i].getCarteInMano()[1].toString();
    	System.out.println();
    	System.out.println("CARTA [2]: ");
    	t.getGamers()[i].getCarteInMano()[2].toString();
    	System.out.println();
    	
    	while (!validInput) {
            System.out.print("Inserisci un numero: ");
            try {
            	sceltaCartaInMano = sc.nextInt();
            	
            	if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano] instanceof CartaOro)
            	{
            		if(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano].controllo() == true)
            			validInput = true;
            		else
            		{
            			System.out.println("I requisiti per utilizzare questa carta non sono soddisfatti. ");
            			System.out.println("Vuoi usare il retro della carta? ");
            			t.getGamers()[i].getCarteInMano()[sceltaCartaInMano].useRetro(t.getGamers()[i].getCarteInMano()[sceltaCartaInMano]);
            			String rispostaRetro = sc.next() 
            		}
            	}
            	
                
            } catch (InputMismatchException e) {
                System.out.println("Errore: per favore inserisci un numero tra 0 e 2.");
                sc.nextLine(); // Consuma l'input non valido
            }
        }
    	
    	//se è carta oro deve fare controllo --> se non va bene --> chiedere se vuole usare retro
    	
    	
    	
    	
    	validInput = false;
    	
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
            System.out.print("Inserisci una posizone: ");
            try {
            	sceltaPosizioneCarta = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Errore: per favore inserisci un numero tra 0 e "+t.getGamers()[i].getAreaDiGioco().posizioniLibere().size());
                sc.next(); // Consuma l'input non valido per evitare un loop infinito
            }
        }
    	
    	
    	
    	t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()] = t.getGamers()[i].getCarteInMano()[sceltaCartaInMano];                
    	
    	//mettere angolo = "vuoto" alla/e carta/e prima
    	
    	//controllo se c'è carta in alto a destra rispetto a dove posiziono io la carta. se c'è, angolo basso sinitro = "vuoto"
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()-1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()+1] != null)
    	((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()-1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()+1]).getBs().equals("vuoto");
    	
    	//controllo se c'è carta in alto a sinistra rispetto a dove posiziono io la carta. se c'è, angolo basso destro = "vuoto"
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()-1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()-1] != null)
        	((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()-1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()-1]).getBs().equals("vuoto");
        	
    	//controllo se c'è carta in basso a sinistra rispetto a dove posiziono io la carta. se c'è, angolo alto destro = "vuoto"
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()+1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()-1] != null)
        	((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()+1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()-1]).getBs().equals("vuoto");
    	
    	//controllo se c'è carta in basso a destra rispetto a dove posiziono io la carta. se c'è, angolo alto sinistro = "vuoto"
    	if(t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()+1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()+1] != null)
        	((Carta) t.getGamers()[i].getAreaDiGioco().getArea()[t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getX()+1][t.getGamers()[i].getAreaDiGioco().posizioniLibere().get(sceltaPosizioneCarta).getY()+1]).getBs().equals("vuoto");
        	
    	
    	//se è una carta risorsa con i punti, incrementa punti
    	
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
	

}