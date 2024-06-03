package codex;

public class CartaIniziale{

    private String nome,as,ad,bs,bd;
    private String percorsoImmagine;
    private String simboloRetro;

    /**
     * Crea una nuova carta iniziale con i parametri specificati.
     *
     * @param nome il nome della carta iniziale
     * @param asx il simbolo dell'angolo alto sinistra della carta iniziale
     * @param adx il simbolo dell'angolo alto destra della carta iniziale
     * @param bsx il simbolo dell'angolo basso sinistra della carta iniziale
     * @param bdx il simbolo dell'angolo basso destra della carta iniziale
     * @param percorso il percorso dell'immagine associata alla carta iniziale
     */
    public CartaIniziale(String nome, String asx, String adx, String bsx, String bdx, String percorso)
    {
    	this.nome = nome;
        this.as = asx;
        this.ad = adx;
        this.bs = bsx;
        this.bd = bdx;
        simboloRetro = "vuoto";
        percorsoImmagine = percorso;
    }
    
    
    /**
     * Imposta i valori degli angoli della carta iniziale in base al suo nome e imposta il simbolo e il percorso dell'immagine retro.
     *
     * @param ci la carta iniziale su cui applicare le modifiche
     * @return la carta iniziale con i valori degli angoli e l'immagine retro modificati
     */
    public CartaIniziale useRetro(CartaIniziale ci)
    {
    	if(ci.nome == "ci1")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "foglia";
	            ci.bs = "farfalla";
	            ci.bd ="vuoto";
	            simboloRetro = "farfalla";
	            percorsoImmagine = "/immagini/carteIniziali/ci1Retro.jpg";
    		}
    	else if(ci.nome == "ci2")
    		{
	    		ci.as = "lupo";
	            ci.ad = "vuoto";
	            ci.bs = "vuoto";
	            ci.bd = "fungo";
	            simboloRetro = "fungo";
	            percorsoImmagine = "/immagini/carteIniziali/ci2Retro.jpg";
    		}
    	else if(ci.nome == "ci3")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "vuoto";
	            ci.bs = "vuoto";
	            ci.bd = "vuoto";
	            simboloRetro = "foglia,fungo";
	            percorsoImmagine = "/immagini/carteIniziali/ci3Retro.jpg";
    		}
    	else if(ci.nome == "ci4")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "vuoto";
	            ci.bs = "vuoto";
	            ci.bd = "vuoto";
	            simboloRetro = "lupo,farfalla";
	            percorsoImmagine = "/immagini/carteIniziali/ci4Retro.jpg";
    		}
    	else if(ci.nome == "ci5")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "vuoto";
	            ci.bs = null;
	            ci.bd = null;
	            simboloRetro = "lupo,farfalla,foglia";
	            percorsoImmagine = "/immagini/carteIniziali/ci5Retro.jpg";
    		}
    	else if(ci.nome == "ci6")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "vuoto";
	            ci.bs = null;
	            ci.bd = null;
	            simboloRetro = "foglia,lupo,fungo";
	            percorsoImmagine = "/immagini/carteIniziali/ci6Retro.jpg";
    		}
    	
    		return ci;
    }
    
    /**
     * Restituisce il percorso dell'immagine associata a questa carta iniziale.
     *
     * @return il percorso dell'immagine della carta iniziale
     */
    public String getPercorsoImmagine()
    {
    	return percorsoImmagine;
    }

    /**
     * Restituisce il nome della carta iniziale.
     *
     * @return il nome della carta iniziale
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Restituisce una rappresentazione in formato stringa della carta iniziale, che include gli angoli e il simbolo retro.
     *
     * @return una stringa che rappresenta la carta iniziale
     */
    public String toString() {
		return "Angolo alto sinistra = " + as +"\n"+ "Angolo alto destra = " + ad +"\n"+ "Angolo basso sinistra = " + bs +"\n"+ "Angolo basso destra = " + bd+"\n"+ "Simbolo retro = " + simboloRetro+"\n";
	}

    
    /**
     * Restituisce il valore dell'angolo alto sinistra della carta iniziale.
     *
     * @return il valore dell'angolo alto sinistra
     */
	public String getAs() {
		return as;
	}


	/**
	 * Restituisce il valore dell'angolo alto destra della carta iniziale.
	 *
	 * @return il valore dell'angolo alto destra
	 */
	public String getAd() {
		return ad;
	}


	/**
	 * Restituisce il valore dell'angolo basso sinistra della carta iniziale.
	 *
	 * @return il valore dell'angolo basso sinistra
	 */
	public String getBs() {
		return bs;
	}


	/**
	 * Restituisce il valore dell'angolo basso destra della carta iniziale.
	 *
	 * @return il valore dell'angolo basso destra
	 */
	public String getBd() {
		return bd;
	}


	/**
	 * Restituisce il simbolo retro della carta iniziale.
	 *
	 * @return il simbolo retro della carta iniziale
	 */
	public String getSimboloRetro() {
		return simboloRetro;
	}


	/**
	 * Imposta il valore dell'angolo alto sinistra della carta iniziale.
	 *
	 * @param as il valore da impostare per l'angolo alto sinistra
	 */
	public void setAs(String as) {
		this.as = as;
	}


	/**
	 * Imposta il valore dell'angolo alto destra della carta iniziale.
	 *
	 * @param ad il valore da impostare per l'angolo alto destra
	 */
	public void setAd(String ad) {
		this.ad = ad;
	}


	/**
	 * Imposta il valore dell'angolo basso sinistra della carta iniziale.
	 *
	 * @param bs il valore da impostare per l'angolo basso sinistra
	 */
	public void setBs(String bs) {
		this.bs = bs;
	}


	/**
	 * Imposta il valore dell'angolo basso destra della carta iniziale.
	 *
	 * @param bd il valore da impostare per l'angolo basso destra
	 */
	public void setBd(String bd) {
		this.bd = bd;
	}
	
	/**
	 * Clona la carta iniziale specificata, restituendo una nuova istanza con gli stessi attributi.
	 *
	 * @param c la carta iniziale da clonare
	 * @return una nuova istanza di CartaIniziale con gli stessi attributi della carta specificata
	 */
	public static CartaIniziale clonaCarta(CartaIniziale c)
	{
    	CartaIniziale temp = new CartaIniziale(c.getNome(), c.getAs(), c.getAd(), c.getBs(), c.getBd(), c.getPercorsoImmagine());
		
		return temp;
		
		//ho bisogno di clonare questi attributi in modo da poter richiamare sempre il to string sulla carta ma stampando il retro
	}
	


}