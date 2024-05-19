package codex;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class CartaObiettivo{
	
	private String requisiti;
	private int punti;
	
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
			Set<Cella> posDiagDxRossa = new HashSet<Cella>();
		
			int conta=0;
			
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
									
									if(posDiagDxRossa.add(new Cella(i,j))==true)
									{
										if(posDiagDxRossa.add(new Cella(i+1,j-1))==true)
										{
											if(posDiagDxRossa.add(new Cella(i+2,j-2))==true)
											{
												conta++;
												g.incrementaPunti(2);
											}
										}
									}
									
									
								}
							}
					}
						
				}
			}
			if(conta==0)
				System.out.println("Diagonale dx di tre carte rosse NON completata! ");
			else
				System.out.println("Diagonale dx di tre carte rosse COMPLETATA "+ conta +" volta/e ! ");
		}
		
		
		//seconda carta
		else if(co.requisiti.equals("Diagonale sx di tre carte verdi"))
		{
			Set<Cella> posDiagSxVerde = new HashSet<Cella>();
		
			int conta=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.GREEN))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j+1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j+1]).getColore().equals(Color.GREEN))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j+2]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j+2]).getColore().equals(Color.GREEN))
								{
									
									if(posDiagSxVerde.add(new Cella(i,j))==true)
									{
										if(posDiagSxVerde.add(new Cella(i+1,j+1))==true)
										{
											if(posDiagSxVerde.add(new Cella(i+2,j+2))==true)
											{
												conta++;
												g.incrementaPunti(2);
											}
										}
									}
									
									
								}
							}
					}
						
				}
			}
			if(conta==0)
				System.out.println("Diagonale sx di tre carte verdi NON completata! ");
			else
				System.out.println("Diagonale sx di tre carte verdi COMPLETATA "+ conta +" volta/e ! ");
		}
		
		//terza carta
		
		if(co.requisiti.equals("Diagonale dx di tre carte blu"))
		{
			Set<Cella> posDiagDxBlu = new HashSet<Cella>();
		
			int conta=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.BLUE))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j-1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j-1]).getColore().equals(Color.BLUE))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j-2]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j-2]).getColore().equals(Color.BLUE))
								{
									
									if(posDiagDxBlu.add(new Cella(i,j))==true)
									{
										if(posDiagDxBlu.add(new Cella(i+1,j-1))==true)
										{
											if(posDiagDxBlu.add(new Cella(i+2,j-2))==true)
											{
												conta++;
												g.incrementaPunti(2);
											}
										}
									}
									
									
								}
							}
					}
						
				}
			}
			if(conta==0)
				System.out.println("Diagonale dx di tre carte blu NON completata! ");
			else
				System.out.println("Diagonale dx di tre carte blu COMPLETATA "+ conta +" volta/e ! ");
		}
		//quarta carta
		
		
		
		if(co.requisiti.equals("Verticale di due carte verdi e diagonale in basso a sx di una carta magenta"))
		{
			Set<Cella> posTorreVerdeMagenta = new HashSet<Cella>();
		
			int conta=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.GREEN))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j]).getColore().equals(Color.GREEN))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j-1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j-1]).getColore().equals(Color.MAGENTA))
								{
									
									if(posTorreVerdeMagenta .add(new Cella(i,j))==true)
									{
										if(posTorreVerdeMagenta .add(new Cella(i+1,j))==true)
										{
											if(posTorreVerdeMagenta .add(new Cella(i+2,j-1))==true)
											{
												conta++;
												g.incrementaPunti(3);
											}
										}
									}
									
									
								}
							}
					}
						
				}
			}
			if(conta==0)
				System.out.println("Verticale di due carte verdi e diagonale in basso a sx di una carta magenta NON completata! ");
			else
				System.out.println("Verticale di due carte verdi e diagonale in basso a sx di una carta magenta COMPLETATA "+ conta +" volta/e ! ");
		}
		
		
		//quinta carta:
			
		if(co.requisiti.equals("Verticale di due carte rosse e diagonale in basso a dx di una carta blu"))
		{
			Set<Cella> posTorreRossadxBlu = new HashSet<Cella>();
		
			int conta=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.RED))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j]).getColore().equals(Color.RED))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j+1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j+1]).getColore().equals(Color.BLUE))
								{
									
									if(posTorreRossadxBlu.add(new Cella(i,j))==true)
									{
										if(posTorreRossadxBlu.add(new Cella(i+1,j))==true)
										{
											if(posTorreRossadxBlu.add(new Cella(i+2,j+1))==true)
											{
												conta++;
												g.incrementaPunti(3);
											}
										}
									}
									
									
								}
							}
					}
						
				}
			}
			if(conta==0)
				System.out.println("Verticale di due carte rosse e diagonale in basso a dx di una carta blu NON completata! ");
			else
				System.out.println("Verticale di due carte rosse e diagonale in basso a dx di una carta blu COMPLETATA "+ conta +" volta/e ! ");
		}
		
		
		
		
		//sesta carta
		
		
		
		else if(co.requisiti.equals("Diagonale sx di tre carte verdi"))
		{
			Set<Cella> posDiagSxMagenta = new HashSet<Cella>();
		
			int conta=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.MAGENTA))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j+1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j+1]).getColore().equals(Color.MAGENTA))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j+2]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j+2]).getColore().equals(Color.MAGENTA))
								{
									
									if(posDiagSxMagenta.add(new Cella(i,j))==true)
									{
										if(posDiagSxMagenta.add(new Cella(i+1,j+1))==true)
										{
											if(posDiagSxMagenta.add(new Cella(i+2,j+2))==true)
											{
												conta++;
												g.incrementaPunti(2);
											}
										}
									}
									
									
								}
							}
					}
						
				}
			}
			if(conta==0)
				System.out.println("Diagonale sx di tre carte magenta NON completata! ");
			else
				System.out.println("Diagonale sx di tre carte magenta COMPLETATA "+ conta +" volta/e ! ");
		}
		
		//settima carta
		
		
		if(co.requisiti.equals("Verticale di due carte blu e diagonale in alto a dx di una carta rossa"))
		{
			Set<Cella> posTorreBluDxRossa = new HashSet<Cella>();
		
			int conta=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.RED))
				
							if(g.getAreaDiGioco().getArea()[i+1][j-1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j-1]).getColore().equals(Color.BLUE))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j-1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j-1]).getColore().equals(Color.BLUE))
								{
									
									if(posTorreBluDxRossa.add(new Cella(i,j))==true)
									{
										if(posTorreBluDxRossa.add(new Cella(i+1,j-1))==true)
										{
											if(posTorreBluDxRossa.add(new Cella(i+2,j-1))==true)
											{
												conta++;
												g.incrementaPunti(3);
											}
										}
									}
									
									
								}
							}
					}
						
				}
			
			if(conta==0)
				System.out.println("Verticale di due carte blu e diagonale in alto a dx di una carta rossa NON completata! ");
			else
				System.out.println("Verticale di due carte blu e diagonale in alto a dx di una carta rossaCOMPLETATA "+ conta +" volta/e ! ");
		}
		
		
		
		//ottava carta
		
		
		
	if(co.requisiti.equals("Verticale di due carte magenta e diagonale in alto a sx di una carta blu"))
	{
		Set<Cella> posSxBluTorreMagenta = new HashSet<Cella>();
	
		int conta=0;
		
		for(int i=0;i<AreaDiGioco.maxRighe; i++)
		{
			for(int j=0; j<AreaDiGioco.maxColonne; j++)
			{
				if(g.getAreaDiGioco().getArea()[i][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.BLUE))
				{
						if(g.getAreaDiGioco().getArea()[i+1][j+1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j+1]).getColore().equals(Color.MAGENTA))
						{
							if(g.getAreaDiGioco().getArea()[i+2][j+1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j+1]).getColore().equals(Color.MAGENTA))
							{
								
								if(posSxBluTorreMagenta.add(new Cella(i,j))==true)
								{
									if(posSxBluTorreMagenta.add(new Cella(i+1,j+1))==true)
									{
										if(posSxBluTorreMagenta.add(new Cella(i+2,j+1))==true)
										{
											conta++;
											g.incrementaPunti(3);
										}
									}
								}
								
								
							}
						}
				}
					
			}
		}
		if(conta==0)
			System.out.println("Verticale di due carte magenta e diagonale in alto a sx di una carta blu NON completata! ");
		else
			System.out.println("Verticale di due carte magenta e diagonale in alto a sx di una carta blu COMPLETATA "+ conta +" volta/e ! ");
	}
	

		//nona carta
	
	
		else if(co.requisiti.equals("Tre funghi"))
		{
			int contaFunghi=0;
			
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
			//bisogna tener conto di angoli nascosti e contare anche simboli carta iniziale
			
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