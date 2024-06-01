package codex;

public class Cella {
	
	private int x;
	private int y;
	
	/**
     * Crea una nuova cella con le coordinate specificate.
     *
     * @param x la coordinata x della cella
     * @param y la coordinata y della cella
     */
	public Cella(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
     * Restituisce la coordinata x della cella.
     *
     * @return la coordinata x della cella
     */
	public int getX() {
		return x;
	}
	
	/**
     * Restituisce la coordinata y della cella.
     *
     * @return la coordinata y della cella
     */
	public int getY() {
		return y;
	}
	

}
