package codex;
import java.util.ArrayList;
import java.util.List;

public class AreaDiGioco {
	
	private Object[][] area;
	private List <Cella> posLibere;
	public static final int maxRighe=20; //static perché le usiamo in CartaObiettivo per scorrere la matrice
	public static final int maxColonne=20;
	
	/**
	 * Crea un'area di gioco per il giocatore specificato.
	 * L'area di gioco è rappresentata da una matrice di oggetti con dimensioni predefinite
	 * e contiene la carta iniziale del giocatore nella posizione centrale (10, 10).
	 * 
	 * @param g Il giocatore a cui appartiene l'area di gioco.
	 */
	public AreaDiGioco(Giocatore g)
	{
		area = new Object[AreaDiGioco.maxRighe][AreaDiGioco.maxColonne];
		area[10][10] = (CartaIniziale) g.getCartaInizialePropria();
		posLibere = new ArrayList <Cella>();
	}
	
	/**
	 * Restituisce l'area di gioco rappresentata da una matrice di oggetti.
	 * 
	 * @return La matrice di oggetti che rappresenta l'area di gioco.
	 */
	public Object[][] getArea() {
		return area;
	}

	/**
	 * Restituisce la lista delle posizioni libere nell'area di gioco.
	 * 
	 * @return La lista delle posizioni libere nell'area di gioco.
	 */

	public List<Cella> getPosLibere() {
		return posLibere;
	}
	
	/**
	 * Trova e restituisce le posizioni libere attorno alle carte presenti nell'area di gioco del giocatore specificato.
	 *
	 * @param g Il giocatore di cui si vuole trovare le posizioni libere attorno alle carte.
	 * @return Un elenco delle posizioni libere attorno alle carte nell'area di gioco del giocatore.
	 */
	public ArrayList <Cella> posizioniLibere(Giocatore g)
	{
		
		g.getAreaDiGioco().getPosLibere().clear();
		
		for(int i=0;i<maxRighe;i++)
		{
			for(int j=0;j<maxColonne;j++)
			{
				if(g.getAreaDiGioco().getArea()[i][j]!=null)
				{
					if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
					{
						//controllo che ci sia angolo alto destro della carta
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd() != null)
						{
							//controllo alto destra
							if(g.getAreaDiGioco().getArea()[i-1][j+1]==null)
								g.getAreaDiGioco().getPosLibere().add(new Cella(i-1,j+1));
						}
						
						//controllo che ci sia angolo alto sinistro della carta
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs() != null)
						{
							
							//controllo alto sinistra
							if(g.getAreaDiGioco().getArea()[i-1][j-1]==null)
								g.getAreaDiGioco().getPosLibere().add(new Cella(i-1,j-1));

						}
						
						//controllo che ci sia angolo basso destro della carta
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd() != null)
						{	
							//controllo basso destra
							if(g.getAreaDiGioco().getArea()[i+1][j+1]==null)
								g.getAreaDiGioco().getPosLibere().add(new Cella(i+1,j+1));
							

						}
						
						//controllo che ci sia angolo basso sinistro della carta
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs() != null)
						{
							//controllo basso sinistra
							if(g.getAreaDiGioco().getArea()[i+1][j-1]==null)
								g.getAreaDiGioco().getPosLibere().add(new Cella(i+1,j-1));
						}
					}
					else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
					{
						//controllo che ci sia angolo alto destro della carta
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd() != null)
						{
							//controllo alto destra
							if(g.getAreaDiGioco().getArea()[i-1][j+1]==null)
								g.getAreaDiGioco().getPosLibere().add(new Cella(i-1,j+1));
						}
						
						//controllo che ci sia angolo alto sinistro della carta
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs() != null)
						{
							
							//controllo alto sinistra
							if(g.getAreaDiGioco().getArea()[i-1][j-1]==null)
								g.getAreaDiGioco().getPosLibere().add(new Cella(i-1,j-1));

						}
						
						//controllo che ci sia angolo basso destro della carta
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd() != null)
						{	
							//controllo basso destra
							if(g.getAreaDiGioco().getArea()[i+1][j+1]==null)
								g.getAreaDiGioco().getPosLibere().add(new Cella(i+1,j+1));
							

						}
						
						//controllo che ci sia angolo basso sinistro della carta
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs() != null)
						{
							//controllo basso sinistra
							if(g.getAreaDiGioco().getArea()[i+1][j-1]==null)
								g.getAreaDiGioco().getPosLibere().add(new Cella(i+1,j-1));
						}
					}
					
					
				}
			}
		}
		
		return (ArrayList<Cella>) g.getAreaDiGioco().getPosLibere();
	}

	

}
