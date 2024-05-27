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
    
    public String getSimboloRetro() {
		return simboloRetro;
	}
    
    

	public Color getColore() {
		return colore;
	}

	public String getAs() {
		return as;
	}

	public void setAs(String as) {
		this.as = as;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}
	
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
    
    
	public String toString() {
		return "Colore = " + Carta.stampaColore(colore) +"\n"+ "Angolo alto sinistra = " + as +"\n"+ "Angolo alto destra = " + ad +"\n"+ "Angolo basso sinistra = " + bs +"\n"+ "Angolo basso destra = " + bd+"\n"+ "Simbolo retro = " + simboloRetro+"\n";
	}

	public String getPercorsoImmagine() {
		return percorsoImmagine;
	}




}