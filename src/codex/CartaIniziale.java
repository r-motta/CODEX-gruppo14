package codex;

import java.awt.Color;

public class CartaIniziale{

    private String nome,as,ad,bs,bd;
    

    public CartaIniziale(String nome, String asx, String adx, String bsx, String bdx)
    {
    	this.nome = nome;
        this.as = asx;
        this.ad = adx;
        this.bs = bsx;
        this.bd = bdx;
    }
    
    public void useRetro(CartaIniziale ci)
    {
    	if(ci.nome == "ci1")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "foglia";
	            ci.bs = "farfalla";
	            ci.bd ="vuoto";
	            String simboloRetro = "farfalla";
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
	            String simboloRetro = "lupo,farfalla,foglia";
    		}
    	else if(ci.nome == "ci4")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "vuoto";
	            ci.bs = "vuoto";
	            ci.bd = "vuoto";
	            String simboloRetro = "lupo,farfalla";
    		}
    	else if(ci.nome == "ci5")
    		{
	    		ci.as = "vuoto";
	            ci.ad = "vuoto";
	            ci.bs = "vuoto";
	            ci.bd = "vuoto";
	            String simboloRetro = "foglia,fungo";
    		}
    	else if(ci.nome == "ci6")
    		{
	    		ci.as = "lupo";
	            ci.ad = "vuoto";
	            ci.bs = "vuoto";
	            ci.bd = "fungo";
	            String simboloRetro = "fungo";
    		}
    }



    public String getNome() {
        return nome;
    }



}