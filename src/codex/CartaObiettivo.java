package codex;

import java.awt.Color;	
import java.util.HashSet;
import java.util.Set;

public class CartaObiettivo{
	
	private String requisiti;
	private int punti;
	private String percorsoImmagine;
	
	/**
	 * Crea una nuova carta obiettivo con i requisiti specificati, il numero di punti e il percorso dell'immagine.
	 *
	 * @param req          i requisiti associati alla carta obiettivo
	 * @param punt         il numero di punti assegnati alla carta obiettivo
	 * @param percorso     il percorso dell'immagine associata alla carta obiettivo
	 */
	public CartaObiettivo(String req, int punt, String percorso)
	{
		requisiti = req;
		punti = punt;
		percorsoImmagine = percorso;
	}
	
	/**
	 * Restituisce i requisiti associati alla carta obiettivo.
	 *
	 * @return i requisiti associati alla carta obiettivo
	 */
	public String getRequisiti() {
		return requisiti;
	}
	
	/**
	 * Restituisce il numero di punti assegnati alla carta obiettivo.
	 *
	 * @return il numero di punti assegnati alla carta obiettivo
	 */
	public int getPunti() {
		return punti;
	}
	
	/**
	 * Restituisce il percorso dell'immagine associata alla carta obiettivo.
	 *
	 * @return il percorso dell'immagine associata alla carta obiettivo
	 */
	public String getPercorsoImmagine()
	{
		return percorsoImmagine;
	}
	
	/**
	 * Restituisce una stringa che rappresenta la carta obiettivo, includendo i requisiti e i punti.
	 *
	 * @return una stringa che rappresenta la carta obiettivo
	 */
	public String toString()
	{
		return "Requisiti: "+requisiti+"\n"+"Punti: "+punti;
	}
	
	/**
	 * Controlla una carta obiettivo di un giocatore specifico, verificando se ha completato l'obiettivo della carta
	 * Se l'obiettivo è stato completato verrà stampata una stringa contenente: nome dell'obiettivo + completato
	 * altrimenti: nome dell'obiettivo + NON completato
	 *
	 * @param co          La carta obiettivo da controllare
	 * @param g           Il giocatore di cui si vuole verificare il completamento della carta obiettivo
	 */
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
					if(g.getAreaDiGioco().getArea()[i][j] != null)
					{
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.RED))
						{
								if(g.getAreaDiGioco().getArea()[i+1][j-1] instanceof Carta && g.getAreaDiGioco().getArea()[i+1][j-1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j-1]).getColore().equals(Color.RED))
								{
									if(g.getAreaDiGioco().getArea()[i+2][j-2] instanceof Carta && g.getAreaDiGioco().getArea()[i+2][j-2]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j-2]).getColore().equals(Color.RED))
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
					if(g.getAreaDiGioco().getArea()[i][j] != null)
					{
					if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.GREEN))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j+1] instanceof Carta && g.getAreaDiGioco().getArea()[i+1][j+1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j+1]).getColore().equals(Color.GREEN))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j+2] instanceof Carta && g.getAreaDiGioco().getArea()[i+2][j+2]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j+2]).getColore().equals(Color.GREEN))
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
					if(g.getAreaDiGioco().getArea()[i][j] != null)
					{
					if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.BLUE))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j-1] instanceof Carta && g.getAreaDiGioco().getArea()[i+1][j-1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j-1]).getColore().equals(Color.BLUE))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j-2] instanceof Carta && g.getAreaDiGioco().getArea()[i+2][j-2]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j-2]).getColore().equals(Color.BLUE))
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
					if(g.getAreaDiGioco().getArea()[i][j] != null)
					{
					if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.GREEN))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j] instanceof Carta && g.getAreaDiGioco().getArea()[i+1][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j]).getColore().equals(Color.GREEN))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j-1] instanceof Carta && g.getAreaDiGioco().getArea()[i+2][j-1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j-1]).getColore().equals(Color.MAGENTA))
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
					if(g.getAreaDiGioco().getArea()[i][j] != null)
					{
					if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.RED))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j] instanceof Carta && g.getAreaDiGioco().getArea()[i+1][j]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j]).getColore().equals(Color.RED))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j+1] instanceof Carta && g.getAreaDiGioco().getArea()[i+2][j+1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j+1]).getColore().equals(Color.BLUE))
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
					if(g.getAreaDiGioco().getArea()[i][j] != null)
					{
					if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.MAGENTA))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j+1] instanceof Carta && g.getAreaDiGioco().getArea()[i+1][j+1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j+1]).getColore().equals(Color.MAGENTA))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j+2] instanceof Carta && g.getAreaDiGioco().getArea()[i+2][j+2]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j+2]).getColore().equals(Color.MAGENTA))
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
					if(g.getAreaDiGioco().getArea()[i][j] != null)
					{
					if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.RED))
					{
							if(g.getAreaDiGioco().getArea()[i+1][j-1] instanceof Carta && g.getAreaDiGioco().getArea()[i+1][j-1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j-1]).getColore().equals(Color.BLUE))
							{
								if(g.getAreaDiGioco().getArea()[i+2][j-1] instanceof Carta && g.getAreaDiGioco().getArea()[i+2][j-1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j-1]).getColore().equals(Color.BLUE))
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
				if(g.getAreaDiGioco().getArea()[i][j] != null)
				{
				if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta && ((Carta) g.getAreaDiGioco().getArea()[i][j]).getColore().equals(Color.BLUE))
				{
						if(g.getAreaDiGioco().getArea()[i+1][j+1] instanceof Carta && g.getAreaDiGioco().getArea()[i+1][j+1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+1][j+1]).getColore().equals(Color.MAGENTA))
						{
							if(g.getAreaDiGioco().getArea()[i+2][j+1] instanceof Carta && g.getAreaDiGioco().getArea()[i+2][j+1]!=null && ((Carta) g.getAreaDiGioco().getArea()[i+2][j+1]).getColore().equals(Color.MAGENTA))
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
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							    contaFunghi++;
							
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
								contaFunghi++;
							
							
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
								contaFunghi++;
							
							
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
								contaFunghi++;
							
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
								contaFunghi++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							    contaFunghi++;
							
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
								contaFunghi++;
							
							
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
								contaFunghi++;
							
							
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
								contaFunghi++;
							
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
							{
								String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
								
								for(int k=0;k<simboli.length;k++)
								{
									if(simboli[i].equals("fungo"))
										contaFunghi++;
									
								}
							}
						}
						
						
					}
					
						
				}
			}
			
			
			if(contaFunghi<3)
				System.out.println("Tre funghi NON completato! ");
			else
			{
				g.incrementaPunti(((int)(contaFunghi/3)) * 2);
				System.out.println("Tre funghi completato "+(((int)(contaFunghi/3)))+" volta/e! ");
			}
			
			
				
		}
	// decima carta
		else if(co.requisiti.equals("Tre foglie"))
		{
			int contaFoglie=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{
							if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFoglie++;
								
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFoglie++;
								
								
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFoglie++;
								
								
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFoglie++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									contaFoglie++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFoglie++;
								
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFoglie++;
								
								
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFoglie++;
								
								
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFoglie++;
								
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
							{
								String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
								
								for(int k=0;k<simboli.length;k++)
								{
									if(simboli[i].equals("foglia"))
									contaFoglie++;
									
								}
							}
						}
						
						
					}
					
						
				}
			}
			
			
			if(contaFoglie<3)
				System.out.println("Tre foglie NON completato! ");
			else
			{
				g.incrementaPunti(((int)(contaFoglie/3)) * 2);
				System.out.println("Tre foglie completato "+(((int)(contaFoglie/3)))+" volta/e! ");
			}
			
			
				
		}
	    // undicesima carta
		else if(co.requisiti.equals("Tre lupi"))
		{
			int contaLupi=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{
							if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaLupi++;
								
								if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaLupi++;
								
								
								if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaLupi++;
								
								
								if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaLupi++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									contaLupi++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaLupi++;
								
								if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaLupi++;
								
								
								if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaLupi++;
								
								
								if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaLupi++;
								
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
							{
								String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
								
								for(int k=0;k<simboli.length;k++)
								{
									if(simboli[i].equals("lupo"))
										contaLupi++;
									
								}
							}
						}
						
						
					}
					
						
				}
			}
			
			
			if(contaLupi<3)
				System.out.println("Tre lupi NON completato! ");
			else
			{
				g.incrementaPunti(((int)(contaLupi/3)) * 2);
				System.out.println("Tre lupi completato "+(((int)(contaLupi/3)))+" volta/e! ");
			}
			
			
				
		}
	    // dodicesima carta
		else if(co.requisiti.equals("Tre farfalle"))
		{
			int contaFarfalle=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{
							if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFarfalle++;
								
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFarfalle++;
								
								
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFarfalle++;
								
								
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFarfalle++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
									contaFarfalle++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFarfalle++;
								
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFarfalle++;
								
								
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFarfalle++;
								
								
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFarfalle++;
								
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
							{
								String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
								
								for(int k=0;k<simboli.length;k++)
								{
									if(simboli[i].equals("farfalla"))
										contaFarfalle++;
									
								}
							}
						}
						
						
					}
					
						
				}
			}
			
			
			if(contaFarfalle<3)
				System.out.println("Tre farfalle NON completato! ");
			else
			{
				g.incrementaPunti(((int)(contaFarfalle/3)) * 2);
				System.out.println("Tre farfalle completato "+(((int)(contaFarfalle/3)))+" volta/e! ");
			}
			
			
				
		}
	
		//tredicesima carta
	
		else if(co.requisiti.equals("Piuma, bottiglia e pergamena"))
		{
			int contaPiume=0;
			int contaBottiglie=0;
			int contaPergamene=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null && g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
					{
						if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							contaPiume++;
						else if("bottiglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							contaBottiglie++;
						else if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							contaPergamene++;
						
						
						if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
							contaPiume++;
						else if("bottiglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							contaBottiglie++;
						else if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							contaPergamene++;
						
						
						if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
							contaPiume++;
						else if("bottiglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							contaBottiglie++;
						else if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							contaPergamene++;
						
						
						if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
							contaPiume++;
						else if("bottiglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							contaBottiglie++;
						else if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							contaPergamene++;
						
						
					}
					
						
				}
			}
			
			if(contaPiume==0 || contaBottiglie==0 || contaPergamene==0)
				System.out.println("Piuma, bottiglia e pergamena NON completato! ");
			else
			{
				int min=100000;
				
				if(contaPiume<min)
					min = contaPiume;
				
				if(contaBottiglie < min)
					min = contaBottiglie;
				
				if(contaPergamene<min)
					min = contaPergamene;
				
				g.incrementaPunti(min * 3);
				System.out.println("Piuma, bottiglia e pergamena "+min+" volta/e! ");
			}
		}
	
	
	    // quattordicesima carta
		else if(co.requisiti.equals("Due pergamene"))
		{
			int contaPergamene=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe; i++)
			{
				for(int j=0; j<AreaDiGioco.maxColonne; j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null && g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
					{
						if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
							contaPergamene++;
						
						if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
							contaPergamene++;
						
						if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
							contaPergamene++;
						
						if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
							contaPergamene++;
						
						
					}
					
						
				}
			}
			
			if(contaPergamene<2)
				System.out.println("Due pergamene NON completato! ");
			else
			{
				g.incrementaPunti(((int)(contaPergamene/2)) * 2);
				System.out.println("Due pergamene completato "+(((int)(contaPergamene/2)))+" volta/e! ");
			}
			
			
				
		}
	        // quindicesima carta
			else if(co.requisiti.equals("Due bottiglie"))
			{
				int contaBottiglie=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe; i++)
				{
					for(int j=0; j<AreaDiGioco.maxColonne; j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null && g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{
							if("bottiglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaBottiglie++;
							
							if("bottiglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
								contaBottiglie++;
							
							if("bottiglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
								contaBottiglie++;
							
							if("bottiglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
								contaBottiglie++;
							
							
						}
						
							
					}
				}
				
				if(contaBottiglie<2)
					System.out.println("Due pergamene NON completato! ");
				else
				{
					g.incrementaPunti(((int)(contaBottiglie/2)) * 2);
					System.out.println("Due pergamene completato "+(((int)(contaBottiglie/2)))+" volta/e! ");
				}
				
				
					
			}
	            // sedicesima carta
				else if(co.requisiti.equals("Due piume"))
				{
					int contaPiume=0;
					
					for(int i=0;i<AreaDiGioco.maxRighe; i++)
					{
						for(int j=0; j<AreaDiGioco.maxColonne; j++)
						{
							if(g.getAreaDiGioco().getArea()[i][j]!=null && g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaPiume++;
								
								if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaPiume++;
								
								if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaPiume++;
								
								if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaPiume++;
								
								
							}
							
								
						}
					}
					
					if(contaPiume<2)
						System.out.println("Due piume NON completato! ");
					else
					{
						g.incrementaPunti(((int)(contaPiume/2)) * 2);
						System.out.println("Due piume completato "+(((int)(contaPiume/2)))+" volta/e! ");
					}
					
					
						
				}
			
	
	}

	
	
}