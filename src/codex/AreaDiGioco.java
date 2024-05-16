package codex;
import java.util.ArrayList;

public class AreaDiGioco {
	
	private Carta[][] area;
	private ArrayList <Cella> posLibere;
	public static final int maxRighe=80;
	public static final int maxColonne=80;
	
	public AreaDiGioco()
	{
		area = new Carta[80][80];
		posLibere = new ArrayList <Cella>();
		//carta iniziale [40][40]
	}
	
	public ArrayList <Cella> posizioniLibere()
	{
		
		for(int i=0;i<maxRighe;i++)
		{
			for(int j=0;j<maxColonne;j++)
			{
				if(area[i][j]!=null)
				{
					//controllo alto destra
					if(area[i+1][j-1]==null)
						posLibere.add(new Cella(i+1,j-1));
					
					//controllo alto sinistra
					if(area[i-1][j-1]==null)
						posLibere.add(new Cella(i-1,j-1));
					
					//controllo basso destra
					if(area[i+1][j+1]==null)
						posLibere.add(new Cella(i+1,j+1));
					
					//controllo basso sinistra
					if(area[i-1][j+1]==null)
						posLibere.add(new Cella(i-1,j+1));
				}
			}
		}
		
		return posLibere;
	}

	public Carta[][] getArea() {
		return area;
	}
	
	

}
