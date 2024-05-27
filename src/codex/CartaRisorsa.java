package codex;
import java.awt.Color;

public class CartaRisorsa extends Carta{
	
	private int puntoVittoria;
	
	public CartaRisorsa(Color colore, String asx, String adx, String bsx, String bdx, int p, String percorsoImmagine)
	{
		super(colore, asx, adx, bsx, bdx, percorsoImmagine);
		puntoVittoria = p; //una carta risorsa può non avere punti oppure un 1 punto vittoria
	}

	@Override
	public String toString() {
		return super.toString()+"\n"+"Punti: "+puntoVittoria+"\n";
	}

	public int getPuntoVittoria() {
		return puntoVittoria;
	}
	
	public int getPunti()
	{
		return puntoVittoria;
	}
	
	public static CartaRisorsa clonaCarta(CartaRisorsa c)
	{
		CartaRisorsa temp = new CartaRisorsa(c.getColore(), c.getAs(), c.getAd(), c.getBs(), c.getBd(), c.getPunti() ,c.getPercorsoImmagine());
		
		return temp;
		
		//ho bisogno di clonare questi attributi in modo da poter richiamare sempre il to string 
	}
	
	
			
	
}
