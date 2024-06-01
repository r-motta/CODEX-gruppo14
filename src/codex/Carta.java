package codex;
import java.awt.Color;	

public abstract class Carta {
	
    private Color colore;
    private String as; 
    private String ad; 
    private String bs;
    private String bd;
    private String percorsoImmagine;
    private String simboloRetro;

    /**
     * Costruisce un oggetto Carta con i dettagli specificati.
     *
     * @param colore il colore della carta
     * @param asx il simbolo del lato alto sinistro della carta
     * @param adx il simbolo del lato alto destro della carta
     * @param bsx il simbolo del lato basso sinistro della carta
     * @param bdx il simbolo del lato basso destro della carta
     * @param percorsoImmagine il percorso dell'immagine associata alla carta
     */
    public Carta(Color colore, String asx, String adx, String bsx, String bdx, String percorsoImmagine)
    {
        this.colore = colore;
        this.as = asx;
        this.ad = adx;
        this.bs = bsx;
        this.bd = bdx;
        this.simboloRetro = "vuoto";
        this.percorsoImmagine = percorsoImmagine;
    }    
    
    /**
     * Imposta il retro della carta e restituisce la carta stessa.
     * 
     * Il retro della carta viene impostato in base al colore della carta stessa e se fa parte delle carte risorsa oppure oro
     *
     * @param c la carta per cui impostare il retro
     * @return la carta con il retro impostato
     */
    public Carta useRetro(Carta c)
    {
        c.as = "vuoto";
        c.ad = "vuoto";
        c.bs = "vuoto";
        c.bd = "vuoto";

        if(c.getColore() == Color.RED)
            simboloRetro = "fungo";
        else if(c.getColore() == Color.MAGENTA)
            simboloRetro = "farfalla";
        else if(c.getColore() == Color.BLUE)
            simboloRetro = "lupo";
        else if(c.getColore() == Color.GREEN)
            simboloRetro = "foglia";
        
        if(c instanceof CartaRisorsa)
        {
        	if(c.getColore() == Color.RED)
        		percorsoImmagine = "/immagini/carteRisorsa/crRetroRosso.jpg";
            else if(c.getColore() == Color.MAGENTA)
            	percorsoImmagine = "/immagini/carteRisorsa/crRetroViola.jpg";
            else if(c.getColore() == Color.BLUE)
            	percorsoImmagine = "/immagini/carteRisorsa/crRetroBlu.jpg";
            else if(c.getColore() == Color.GREEN)
            	percorsoImmagine = "/immagini/carteRisorsa/crRetroVerde.jpg";
        		
        }
        else if(c instanceof CartaOro)
        {
        	if(c.getColore() == Color.RED)
        		percorsoImmagine = "/immagini/carteOro/coRetroRosso.jpg";
            else if(c.getColore() == Color.MAGENTA)
            	percorsoImmagine = "/immagini/carteOro/coRetroViola.jpg";
            else if(c.getColore() == Color.BLUE)
            	percorsoImmagine = "/immagini/carteOro/coRetroBlu.jpg";
            else if(c.getColore() == Color.GREEN)
            	percorsoImmagine = "/immagini/carteOro/coRetroVerde.jpg";
        		
        }
        
        return c; //no metodo voi ma ritorna carta perché ci serve nel metodo posiziona carta in Giocatore

    }
    
    /**
     * Restituisce il simbolo del retro della carta.
     *
     * @return il simbolo del retro della carta
     */
    public String getSimboloRetro() {
		return simboloRetro;
	}
    
    
    /**
     * Restituisce il colore della carta.
     *
     * @return il colore della carta
     */
	public Color getColore() {
		return colore;
	}
	
	/**
	 * Restituisce il simbolo dell'angolo alto sinistra della carta.
	 *
	 * @return il simbolo dell'angolo alto sinistra della carta
	 */
	public String getAs() {
		return as;
	}
	
	/**
	 * Imposta il simbolo dell'angolo alto sinistra della carta.
	 *
	 * @param as il nuovo simbolo dell'angolo alto sinistra della carta
	 */
	public void setAs(String as) {
		this.as = as;
	}
	
	/**
	 * Restituisce il simbolo dell'angolo alto destra della carta.
	 *
	 * @return il simbolo dell'angolo alto destra della carta
	 */
	public String getAd() {
		return ad;
	}
	
	/**
	 * Imposta il simbolo dell'angolo alto destra della carta.
	 *
	 * @param ad il nuovo simbolo dell'angolo alto destra della carta
	 */
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	/**
	 * Restituisce il simbolo dell'angolo basso sinistra della carta.
	 *
	 * @return il simbolo dell'angolo basso sinistra della carta
	 */
	public String getBs() {
		return bs;
	}	
	
	/**
	 * Imposta il simbolo dell'angolo basso sinistra della carta.
	 *
	 * @param bs il nuovo simbolo dell'angolo basso sinistra della carta
	 */
	public void setBs(String bs) {
		this.bs = bs;
	}
	
	/**
	 * Restituisce il simbolo dell'angolo basso destra della carta.
	 *
	 * @return il simbolo dell'angolo basso destra della carta
	 */
	public String getBd() {
		return bd;
	}
	
	/**
	 * Imposta il simbolo dell'angolo basso destra della carta.
	 *
	 * @param bd il nuovo simbolo dell'angolo basso destra della carta
	 */
	public void setBd(String bd) {
		this.bd = bd;
	}
	
	/**
	 * Restituisce una stringa corrispondente al colore specificato.
	 *
	 * @param colore il colore da convertire in stringa
	 * @return una stringa corrispondente al colore specificato
	 */
	public static String stampaColore(Color colore)
	{
		if(colore == Color.RED)
            return "rosso";
        else if(colore == Color.MAGENTA)
        	return "magenta";
        else if(colore == Color.BLUE)
        	return "blu";
        else if(colore == Color.GREEN)
        	return "verde";
		
		return null;
	}
    
	/**
	 * Restituisce una rappresentazione testuale della carta.
	 *
	 * @return una stringa contenente informazioni sulla carta
	 */
	public String toString() {
		return "Colore = " + Carta.stampaColore(colore) +"\n"+ "Angolo alto sinistra = " + as +"\n"+ "Angolo alto destra = " + ad +"\n"+ "Angolo basso sinistra = " + bs +"\n"+ "Angolo basso destra = " + bd+"\n"+ "Simbolo retro = " + simboloRetro+"\n";
	}
	
	/**
	 * Restituisce il percorso dell'immagine associata alla carta.
	 *
	 * @return il percorso dell'immagine associata alla carta
	 */
	public String getPercorsoImmagine() {
		return percorsoImmagine;
	}




}