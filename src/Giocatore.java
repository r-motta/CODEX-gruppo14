
public class Giocatore {
	
	private String nickname;
	private int punti=0;
	private CartaObiettivo cartaObiettivoSegreta;
	
	private Carta[] carteInMano = new Carta[3];
	
	
	public Giocatore(String nome)
	{
		this.nickname = nome;
	}
	
	public boolean pesca()
	{
		return false;
		
	}
	

}
