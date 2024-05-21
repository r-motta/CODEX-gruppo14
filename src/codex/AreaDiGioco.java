package codex;
import java.util.ArrayList;
import java.util.List;

public class AreaDiGioco {
	
	private Object[][] area;
	private List <Cella> posLibere;
	public static final int maxRighe=20; //static perché le usiamo in CartaObiettivo per scorrere la matrice
	public static final int maxColonne=20;
	
	public AreaDiGioco(Giocatore g)
	{
		area = new Object[AreaDiGioco.maxRighe][AreaDiGioco.maxColonne];
		area[10][10] = (CartaIniziale) g.getCartaInizialePropria();
		posLibere = new ArrayList <Cella>();
	}
	
	public ArrayList <Cella> posizioniLibere()
	{
		
		for(int i=0;i<maxRighe;i++)
		{
			for(int j=0;j<maxColonne;j++)
			{
				if(area[i][j]!=null)
				{
					//controllo che ci sia angolo alto destro della carta
					if(area[i][j] instanceof Carta)
					{
						if(((Carta) area[i][j]).getAd() != null)
						{
							//controllo alto destra
							if(area[i-1][j+1]==null)
								posLibere.add(new Cella(i-1,j+1));
						}
						
						//controllo che ci sia angolo alto sinistro della carta
						if(((Carta) area[i][j]).getAs() != null)
						{
							
							//controllo alto sinistra
							if(area[i-1][j-1]==null)
								posLibere.add(new Cella(i-1,j-1));

						}
						
						//controllo che ci sia angolo basso destro della carta
						if(((Carta) area[i][j]).getBd() != null)
						{	
							//controllo basso destra
							if(area[i+1][j+1]==null)
								posLibere.add(new Cella(i+1,j+1));
							
						}
						
						//controllo che ci sia angolo basso sinistro della carta
						if(((Carta) area[i][j]).getBs() != null)
						{
							//controllo basso sinistra
							if(area[i+1][j-1]==null)
								posLibere.add(new Cella(i+1,j-1));
						}
						
						
					}
					else if(area[i][j] instanceof CartaIniziale)
					{
						if(((CartaIniziale) area[i][j]).getAd() != null)
						{
							//controllo alto destra
							if(area[i-1][j+1]==null)
								posLibere.add(new Cella(i-1,j+1));
						}
						
						//controllo che ci sia angolo alto sinistro della carta
						if(((CartaIniziale) area[i][j]).getAs() != null || ((CartaIniziale) area[i][j]).getAs() != null)
						{
							
							//controllo alto sinistra
							if(area[i-1][j-1]==null)
								posLibere.add(new Cella(i-1,j-1));

						}
						
						//controllo che ci sia angolo basso destro della carta
						if(((CartaIniziale) area[i][j]).getBd() != null || ((CartaIniziale) area[i][j]).getBd() != null)
						{	
							//controllo basso destra
							if(area[i+1][j+1]==null)
								posLibere.add(new Cella(i+1,j+1));
							
						}
						
						//controllo che ci sia angolo basso sinistro della carta
						if(((CartaIniziale) area[i][j]).getBs() != null || ((CartaIniziale) area[i][j]).getBs() != null)
						{
							//controllo basso sinistra
							if(area[i+1][j-1]==null)
								posLibere.add(new Cella(i+1,j-1));
						}
					}
					
					
				}
			}
		}
		
		return (ArrayList<Cella>) posLibere;
	}

	public Object[][] getArea() {
		return area;
	}
	
	

}
