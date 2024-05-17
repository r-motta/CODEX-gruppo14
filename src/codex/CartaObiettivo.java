package codex;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class CartaObiettivo{
	
	private String requisiti;
	private int punti;
	private Set<Cella> posCartaDiagonale = new HashSet<Cella>();
	private Set<Cella> posCartaVerticale = new HashSet<Cella>();
	
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
		//prima carta obiettivo
		if(co.requisiti.equals("Diagonale dx di tre carte rosse"))
		{
			boolean completato=false;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.RED))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j-1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j-1]).getColore().equals(Color.RED))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j-2]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j-2]).getColore().equals(Color.RED))
								{
									
									if(posCartaDiagonale.add(new Cella(i,j))==true)
									{
										if(posCartaDiagonale.add(new Cella(i+1,j-1))==true)
										{
											if(posCartaDiagonale.add(new Cella(i+2,j-2))==true)
											{
												System.out.println("Diagonale dx di tre carte rosse COMPLETATA! ");
												g.incrementaPunti(2);
												completato = true;
											}
										}
									}
									
									
								}
							}
					}
						
				}
			}
			if(completato == false)
				System.out.println("Diagonale dx di tre carte rosse NON completata! ");
		}
		
		
		//seconda carta
		else if (co.requisiti.equals("Diagonale sx di tre carte verdi"))
		{
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.GREEN))
						{
							if(g.getAreaDiGioco().getArea()[i+1][j+1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j+1]).getColore().equals(Color.GREEN))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j+2]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j+2]).getColore().equals(Color.GREEN))
								{
									System.out.println("Diagonale sx di tre carte verdi completata! ");
									g.incrementaPunti(2);
									
								}
							}
							else
								System.out.println("Diagonale sx di tre carte verdi NON completata! ");
						}
						else
							System.out.println("Diagonale sx di tre carte verdi NON completata! ");
					}
					else
						System.out.println("Diagonale sx di tre carte verdi NON completata! ");
				}
			}
		}
		else if (co.requisiti.equals("Diagonale dx di tre carte blu"))
		{
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.BLUE))
						{
							if(g.getAreaDiGioco().getArea()[i+1][j-1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j-1]).getColore().equals(Color.BLUE))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j-2]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j-2]).getColore().equals(Color.BLUE))
								{
									System.out.println("Diagonale dx di tre carte blu completata! ");
									g.incrementaPunti(2);
									
								}
							}
							else
								System.out.println("Diagonale dx di tre carte blu NON completata! ");
						}
						else
							System.out.println("Diagonale dx di tre carte blu NON completata! ");
					}
					else
						System.out.println("Diagonale dx di tre carte blu NON completata! ");
				}
			}
		}
		else if (co.requisiti.equals("Verticale di due carte verdi e diagonale in basso a sx di una carta magenta"))
		{
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.GREEN))
						{
							if(((Carta) g.getAreaDiGioco().getArea()[i+1][j]).getColore().equals(Color.GREEN))
							{
								if(((Carta) g.getAreaDiGioco().getArea()[i+2][j-1]).getColore().equals(Color.MAGENTA))
								{
									System.out.println("Verticale di due carte verdi e diagonale in basso a sx di una carta magenta completata!");
									g.incrementaPunti(3);
									
								}
							}
							else
								System.out.println("Verticale di due carte verdi e diagonale in basso a sx di una carta magenta NON completata! ");
						}
						else
							System.out.println("Verticale di due carte verdi e diagonale in basso a sx di una carta magenta NON completata! ");
					}
					else
						System.out.println("Verticale di due carte verdi e diagonale in basso a sx di una carta magenta NON completata! ");
				}
			}
		}
		else if (co.requisiti.equals("Verticale di due carte rosse e diagonale in basso a dx di una carta blu"))
		{
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.RED))
						{
							if(((Carta) g.getAreaDiGioco().getArea()[i+1][j]).getColore().equals(Color.RED))
							{
								if(((Carta) g.getAreaDiGioco().getArea()[i+2][j+1]).getColore().equals(Color.BLUE))
								{
									System.out.println("Verticale di due carte rosse e diagonale in basso a dx di una carta blu completata!");
									g.incrementaPunti(3);
									
								}
							}
							else
								System.out.println("Verticale di due carte rosse e diagonale in basso a dx di una carta blu NON completata! ");
						}
						else
							System.out.println("Verticale di due carte rosse e diagonale in basso a dx di una carta blu NON completata! ");
					}
					else
						System.out.println("Verticale di due carte rosse e diagonale in basso a dx di una carta blu NON completata! ");
				}
			}
		}
		else if (co.requisiti.equals("Diagonale sx di tre carte magenta"))
		{
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.MAGENTA))
						{
							if(((Carta) g.getAreaDiGioco().getArea()[i+1][j+1]).getColore().equals(Color.MAGENTA))
							{
								if(((Carta) g.getAreaDiGioco().getArea()[i+2][j+2]).getColore().equals(Color.MAGENTA))
								{
									System.out.println("Diagonale sx di tre carte magenta completata!");
									g.incrementaPunti(2);
									
								}
							}
							else
								System.out.println("Diagonale sx di tre carte magenta NON completata! ");
						}
						else
							System.out.println("Diagonale sx di tre carte magenta NON completata! ");
					}
					else
						System.out.println("Diagonale sx di tre carte magenta NON completata! ");
				}
			}
		}
		else if (co.requisiti.equals("Verticale di due carte blu e diagonale in alto a dx di una carta rossa"))
		{
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.RED))
						{
							if(((Carta) g.getAreaDiGioco().getArea()[i+1][j-1]).getColore().equals(Color.BLUE))
							{
								if(((Carta) g.getAreaDiGioco().getArea()[i+2][j-1]).getColore().equals(Color.BLUE))
								{
									System.out.println("Verticale di due carte blu e diagonale in alto a dx di una carta rossa completata! ");
									g.incrementaPunti(3);
									
								}
							}
							else
								System.out.println("Verticale di due carte blu e diagonale in alto a dx di una carta rossa NON completata! ");
						}
						else
							System.out.println("Verticale di due carte blu e diagonale in alto a dx di una carta rossa NON completata! ");
					}
					else
						System.out.println("Verticale di due carte blu e diagonale in alto a dx di una carta rossa NON completata! ");
				}
			}
		}
		else if (co.requisiti.equals("Verticale di due carte magenta e diagonale in alto a sx di una carta blu"))
		{
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.BLUE))
						{
							if(((Carta) g.getAreaDiGioco().getArea()[i+1][j+1]).getColore().equals(Color.MAGENTA))
							{
								if(((Carta) g.getAreaDiGioco().getArea()[i+2][j+1]).getColore().equals(Color.MAGENTA))
								{
									System.out.println("Verticale di due carte magenta e diagonale in alto a sx di una carta blu completata! ");
									g.incrementaPunti(3);
									
								}
							}
							else
								System.out.println("Verticale di due carte magenta e diagonale in alto a sx di una carta blu NON completata! ");
						}
						else
							System.out.println("Verticale di due carte magenta e diagonale in alto a sx di una carta blu NON completata! ");
					}
					else
						System.out.println("Verticale di due carte magenta e diagonale in alto a sx di una carta blu NON completata! ");
				}
			}
		}
		
		
		//nona carta
		else if(co.requisiti.equals("Tre funghi"))
		{
			int contaFunghi=0;
			
			boolean completato = false;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
						contaFunghi++;
						
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
							contaFunghi++;
						
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
							contaFunghi++;
						
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
							contaFunghi++;
						
						
					}
					
						
				}
			}
			
			if(contaFunghi<3)
				System.out.println("Tre funghi NON completato! ");
			else
			{
				g.incrementaPunti(((int)(contaFunghi/3)) * 2);
				System.out.println("Tre funghi completato "+(((int)(contaFunghi/3)) * 2)+" volta/e! ");
			}
			
			
				
		}
		
	}

	
	
	
}