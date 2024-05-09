import java.util.ArrayList;

public class AreaDiGioco {
	
	private Carta[][] area;
	private ArrayList <Cella> posLibere;
	
	public AreaDiGioco()
	{
		area = new Carta[80][80];
		posLibere = new ArrayList <Cella>();
		//carta iniziale [40][40]
	}
	
	public ArrayList <Cella> posizioniLibere()
	{
		
		for(int i=0;i<80;i++)
		{
			for(int j=0;j<80;j++)
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

}
