package codex;

import java.awt.Color;

public class CartaObiettivo{
	
	private String requisiti;
	private int punti;
	
	public CartaObiettivo(String req, int punt)
	{
		requisiti = req;
		punti = punt;
	}
	
	public String getRequisiti() {
		return requisiti;
	}
	public int getPunti() {
		return punti;
	}
	
	public void controllo(CartaObiettivo co, Giocatore g)
	{
		//co1 va fatto controllo solo in basso perché quando si scorre la matrice trova sempre quella in alto a destra per prima
		if(co.requisiti.equals("Diagonale dx di tre carte rosse"))
		{
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.RED))
						{
							if(((Carta) g.getAreaDiGioco().getArea()[i+1][j-1]).getColore().equals(Color.RED))
							{
								if(((Carta) g.getAreaDiGioco().getArea()[i+2][j-2]).getColore().equals(Color.RED))
								{
									System.out.println("Diagonale dx di tre carte rosseo completata! ");
									g.incrementaPunti(2);
									
								}
							}
							else
								System.out.println("Diagonale dx di tre carte rosseo NON completata! ");
						}
						else
							System.out.println("Diagonale dx di tre carte rosseo NON completata! ");
					}
					else
						System.out.println("Diagonale dx di tre carte rosseo NON completata! ");
				}
			}
		}
		//seconda carta
		else if
		{
			
		}
	}
	
	
}