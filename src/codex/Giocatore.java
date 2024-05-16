package codex;
public class Giocatore {

    private String nickname;
    private int punti=0;
    private CartaObiettivo cartaObiettivoSegreta;
    private CartaIniziale CartaInizialePropria = null;
    private Carta[] carteInMano = new Carta[3];
    private AreaDiGioco area;

    
    public Giocatore(String nome)
    {
        this.nickname = nome;
    }

    public boolean pesca()
    {
        return false;

    }

    public CartaIniziale getCartaInizialePropria() {
        return CartaInizialePropria;
    }

    public void setCartaInizialePropria(CartaIniziale cartaInizialePropria) {
        CartaInizialePropria = cartaInizialePropria;
    }

    public CartaObiettivo getCartaObiettivoSegreta() {
        return cartaObiettivoSegreta;
    }

    public void setCartaObiettivoSegreta(CartaObiettivo cartaObiettivoSegreta) {
        this.cartaObiettivoSegreta = cartaObiettivoSegreta;
    }

	public String getNickname() {
		return nickname;
	}

	public AreaDiGioco getAreaDiGioco() {
		return area;
	}

	public int getPunti() {
		return punti;
	}
	
	
	public void incrementaPunti(int valore) {
        this.punti += valore;
    }
	
    
    


}