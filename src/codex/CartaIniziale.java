package codex;

public class CartaIniziale{

    private String nome,as,ad,bs,bd;
    private String simboloRetro;

    public CartaIniziale(String nome, String asx, String adx, String bsx, String bdx)
    {
    	this.nome = nome;
        this.as = asx;
        this.ad = adx;
        this.bs = bsx;
        this.bd = bdx;
        simboloRetro = "vuoto";
    }
    
    
    
    public CartaIniziale useRetro(CartaIniziale ci)
    {
    	if(ci.nome == "ci1")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "foglia";
	            ci.bs = "farfalla";
	            ci.bd ="vuoto";
	            simboloRetro = "farfalla";
    		}
    	else if(ci.nome == "ci2")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "vuoto";
	            ci.bs = null;
	            ci.bd = null;
	            String simboloRetro = "foglia,lupo,fungo";
    		}
    	else if(ci.nome == "ci3")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "vuoto";
	            ci.bs = null;
	            ci.bd = null;
	            simboloRetro = "lupo,farfalla,foglia";
    		}
    	else if(ci.nome == "ci4")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "vuoto";
	            ci.bs = "vuoto";
	            ci.bd = "vuoto";
	            simboloRetro = "lupo,farfalla";
    		}
    	else if(ci.nome == "ci5")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "vuoto";
	            ci.bs = "vuoto";
	            ci.bd = "vuoto";
	            simboloRetro = "foglia,fungo";
    		}
    	else if(ci.nome == "ci6")
    		{
	    		ci.as = "lupo";
	            ci.ad = "vuoto";
	            ci.bs = "vuoto";
	            ci.bd = "fungo";
	            simboloRetro = "fungo";
    		}
    	
    		return ci;
    }



    public String getNome() {
        return nome;
    }
    
    public String toString() {
		return "Angolo alto sinistra = " + as +"\n"+ "Angolo alto destra = " + ad +"\n"+ "Angolo basso sinistra =" + bs +"\n"+ " Angolo basso destra = " + bd+"\n"+ " Simbolo retro = " + simboloRetro+"\n";
	}

    public static CartaIniziale clonaCarta(CartaIniziale c)
	{
    	CartaIniziale temp = new CartaIniziale(c.getNome(), c.getAs(), c.getAd(), c.getBs(), c.getBd());
		
		return temp;
		
		//ho bisogno di clonare questi attributi in modo da poter richiamare sempre il to string 
	}



	public String getAs() {
		return as;
	}



	public String getAd() {
		return ad;
	}



	public String getBs() {
		return bs;
	}



	public String getBd() {
		return bd;
	}


}