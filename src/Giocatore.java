
public class Giocatore {
	
	private String nickname;
	private int punti=0;
	private CartaObiettivo cartaObiettivoSegreta;
	private CartaIniziale CartaInizialePropria = null;
	
	
	
	private Carta[] carteInMano = new Carta[3];
	
	
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
	

}
