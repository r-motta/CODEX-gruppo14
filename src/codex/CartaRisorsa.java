package codex;
import java.awt.Color;


public class CartaRisorsa extends Carta{
	
	public CartaRisorsa(Color colore, String asx, String adx, String bsx, String bdx, int p, String percorsoImmagine)
	{
		super(colore, asx, adx, bsx, bdx, percorsoImmagine);
		int puntoVittoria = p; //una carta risorsa può non avere punti oppure un 1 punto vittoria
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	public boolean controllo()
	{
		return false;
		
	}
			
	
}
