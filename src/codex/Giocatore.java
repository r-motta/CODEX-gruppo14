package codex;

import java.util.Collections;
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

    public Carta getCartaInizialePropria() {
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
	
    
    


}