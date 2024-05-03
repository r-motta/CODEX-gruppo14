public class CartaIniziale {

    private String nome,as,ad,bs,bd;

    public CartaIniziale(String nome, String asx, String adx, String bsx, String bdx)
    {
    	this.nome = nome;
        this.as = asx;
        this.ad = adx;
        this.bs = bsx;
        this.bd = bdx;
    }

    public void useRetroCi1()
    {
        this.as = "vuoto";
        this.ad = "foglia";
        this.bs = "farfalla";
        this.bd ="vuoto";
        String simboloRetro = "farfalla";
    }

    public void useRetroCi2()
    {
        this.as = "vuoto";
        this.ad = "vuoto";
        this.bs = null;
        this.bd = null;
        String simboloRetro = "foglia,lupo,fungo"; //visto che ce ne sono 3 possiamo fare spezzettamento come requisiti carte oro
    }


    public void useRetroCi3()
    {
        this.as = "vuoto";
        this.ad = "vuoto";
        this.bs = null;
        this.bd = null;
        String simboloRetro = "lupo,farfalla,foglia";
    }

    public void useRetroCi4()
    {
        this.as = "vuoto";
        this.ad = "vuoto";
        this.bs = "vuoto";
        this.bd = "vuoto";
        String simboloRetro = "lupo,farfalla";
    }

    public void useRetroCi5()
    {
        this.as = "vuoto";
        this.ad = "vuoto";
        this.bs = "vuoto";
        this.bd = "vuoto";
        String simboloRetro = "foglia,fungo";
    }

    public void useRetroCi6()
    {
        this.as = "lupo";
        this.ad = "vuoto";
        this.bs = "vuoto";
        this.bd = "fungo";
        String simboloRetro = "fungo";
    }


    public String getNome() {
        return nome;
    }



}