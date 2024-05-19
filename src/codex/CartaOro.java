package codex;
import java.awt.Color;
import java.awt.Image;

public class CartaOro extends Carta{
	
	public CartaOro(Color colore, String asx, String adx, String bsx, String bdx, String req, int p, String percorsoImmagine)
	{
		super(colore, asx, adx, bsx, bdx, percorsoImmagine);
		
		String requisiti = req; //una stringa tipo: farfalla farfalla foglia
		// quando la vado ad usare, spezzetto questa stringa tra i vari spazi e conto le parole 
		// (2 farfalle e 1 foglia) e faccio controllo  
		
		//i punti faccio funzione controllo per ogni carta e non uno generale nel costruttore
		
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