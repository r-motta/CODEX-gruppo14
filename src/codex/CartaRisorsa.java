package codex;
import java.awt.Color;

public class CartaRisorsa extends Carta{
	
	private int puntoVittoria;
	
	/**
     * Crea una nuova carta risorsa con il colore specificato, gli angoli e il percorso dell'immagine.
     *
     * @param colore           il colore della carta risorsa
     * @param asx              il simbolo dell'angolo alto sinistra
     * @param adx              il simbolo dell'angolo alto destra
     * @param bsx              il simbolo dell'angolo basso sinistra
     * @param bdx              il simbolo dell'angolo basso destra
     * @param p                il valore dei punti vittoria associato alla carta risorsa
     * @param percorsoImmagine il percorso dell'immagine associata alla carta risorsa
     */
	public CartaRisorsa(Color colore, String asx, String adx, String bsx, String bdx, int p, String percorsoImmagine)
	{
		super(colore, asx, adx, bsx, bdx, percorsoImmagine);
		puntoVittoria = p; //una carta risorsa può non avere punti oppure un 1 punto vittoria
	}
	
	/**
     * Restituisce una stringa rappresentante la carta risorsa, inclusi i dettagli del colore, degli angoli e dei punti vittoria.
     *
     * @return una stringa rappresentante la carta risorsa
     */
	@Override
	public String toString() {
		return super.toString()+"\n"+"Punti: "+puntoVittoria+"\n";
	}
	
	/**
     * Restituisce il valore dei punti vittoria associato alla carta risorsa.
     *
     * @return il valore dei punti vittoria
     */
	public int getPuntoVittoria() {
		return puntoVittoria;
	}
	
	/**
     * Restituisce il valore dei punti vittoria associato alla carta risorsa.
     *
     * @return il valore dei punti vittoria
     */
	public int getPunti()
	{
		return puntoVittoria;
	}
	
	/**
     * Crea una copia della carta risorsa.
     *
     * @param c la carta risorsa da copiare
     * @return una nuova carta risorsa con gli stessi attributi della carta originale
     */
	public static CartaRisorsa clonaCarta(CartaRisorsa c)
	{
		CartaRisorsa temp = new CartaRisorsa(c.getColore(), c.getAs(), c.getAd(), c.getBs(), c.getBd(), c.getPunti() ,c.getPercorsoImmagine());
		
		return temp;
		
		//ho bisogno di clonare questi attributi in modo da poter richiamare sempre il to string 
	}
	
	
			
	
}
