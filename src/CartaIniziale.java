public class CartaIniziale {

    private String as,ad,bs,bd;

    public CartaIniziale(String asx, String adx, String bsx, String bdx)
    {
        this.as = asx;
		this.ad = adx;
		this.bs = bsx;
		this.bd = bdx;
    }
    
    public void useRetro(CartaIniziale ci)
    {
    	if(ci.)
    }
    
    public void useRetroCi1(CartaIniziale ci1)
    {
        ci1.as = "vuoto";
        ci1.ad = "foglia";
        ci1.bs = "farfalla";
        ci1.bd ="vuoto";
        String simboloRetro = "farfalla";
    }

    public void useRetroCi2(CartaIniziale ci2)
    {
        ci2.as = "vuoto";
        ci2.ad = "vuoto";
        ci2.bs = null;
        ci2.bd = null;
        String simboloRetro = "foglia,lupo,fungo"; //visto che ce ne sono 3 possiamo fare spezzettamento come requisiti carte oro
    }


    public void useRetroCi3(CartaIniziale ci3)
    {
        ci3.as = "vuoto";
        ci3.ad = "vuoto";
        ci3.bs = null;
        ci3.bd = null;
        String simboloRetro = "lupo,farfalla,foglia";
    }

    public void useRetroCi4(CartaIniziale ci4)
    {
        ci4.as = "vuoto";
        ci4.ad = "vuoto";
        ci4.bs = "vuoto";
        ci4.bd = "vuoto";
        String simboloRetro = "lupo,farfalla";
    }

    public void useRetroCi5(CartaIniziale ci5)
    {
        ci5.as = "vuoto";
        ci5.ad = "vuoto";
        ci5.bs = "vuoto";
        ci5.bd = "vuoto";
        String simboloRetro = "foglia,fungo";
    }

    public void useRetroCi6(CartaIniziale ci6)
    {
        ci6.as = "lupo";
        ci6.ad = "vuoto";
        ci6.bs = "vuoto";
        ci6.bd = "fungo";
        String simboloRetro = "fungo";
    }

    
    
}