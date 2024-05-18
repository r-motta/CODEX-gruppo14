package codex;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Carta {

    private Color colore;
    private String as; // sui vari angoli ci sarà una parola/stringa corrispondente al simbolo 
    private String ad; // fungo, lupo, foglia, farfalla, pergamena, piuma, bottiglia
    private String bs;
    private String bd;
    private Image image;
    private String percorsoImmagine;
    private String immRetro;

    public Carta(Color colore, String asx, String adx, String bsx, String bdx, String percorsoImmagine)
    {
        this.colore = colore;
        this.as = asx;
        this.ad = adx;
        this.bs = bsx;
        this.bd = bdx;
        this.percorsoImmagine = percorsoImmagine;
    }

    public Image caricaImmagine() throws IOException {
        this.image = ImageIO.read(new File(percorsoImmagine));

        return image;
    }

    public void useRetro(Carta c)
    {
        c.as = "vuoto";
        c.ad = "vuoto";
        c.bs = "vuoto";
        c.bd = "vuoto";
        String simboloRetro;

        if(c.colore == Color.RED)
            simboloRetro = "fungo";
        else if(c.colore == Color.MAGENTA)
            simboloRetro = "farfalla";
        else if(c.colore == Color.BLUE)
            simboloRetro = "lupo";
        else if(c.colore == Color.GREEN)
            simboloRetro = "foglia";

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
    
    @Override
	public String toString() {
		return "Angolo alto sinistra = " + as +"\n"+ "Angolo alto destra = " + ad +"\n"+ "Angolo basso sinistra =" + bs +"\n"+ " Angolo basso destra = " + bd;
	}
    
    



}