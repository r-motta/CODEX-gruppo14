package codex;
import java.awt.Color;	


public class CartaOro extends Carta{

	private String requisiti;
	private String punti;
	
	/**
	 * Crea una nuova carta oro con il colore specificato, gli angoli e il percorso dell'immagine.
	 *
	 * @param colore il colore della carta oro
	 * @param asx l'angolo alto sinistra della carta oro
	 * @param adx l'angolo alto destra della carta oro
	 * @param bsx l'angolo basso sinistra della carta oro
	 * @param bdx l'angolo basso destra della carta oro
	 * @param req i requisiti associati alla carta oro
	 * @param p i punti associati alla carta oro
	 * @param percorsoImmagine il percorso dell'immagine della carta oro
	 */
	public CartaOro(Color colore, String asx, String adx, String bsx, String bdx, String req, String p, String percorsoImmagine)
	{
		super(colore, asx, adx, bsx, bdx, percorsoImmagine);
		
		requisiti = req; 
		punti = p;
	}
	
	/**
	 * Restituisce i requisiti associati alla carta oro.
	 *
	 * @return i requisiti della carta oro
	 */
	public String getRequisiti() {
		return requisiti;
	}
	
	/**
	 * Restituisce i punti associati alla carta oro.
	 *
	 * @return i punti della carta oro
	 */
	public String getPunti()
	{
		return punti;
	}
	
	
	/**
	 * Crea una copia della carta oro specificata.
	 *
	 * @param c la carta oro da clonare
	 * @return una copia della carta oro
	 */
	public static CartaOro clonaCarta(CartaOro c)
	{
		CartaOro temp = new CartaOro(c.getColore(), c.getAs(), c.getAd(), c.getBs(), c.getBd(), c.getRequisiti(), c.getPunti() ,c.getPercorsoImmagine());
		
		return temp;
		
		//ho bisogno di clonare questi attributi in modo da poter richiamare sempre il to string 
	}
	
	/**
	 * Restituisce una rappresentazione testuale della carta oro, incluso il colore, gli angoli, i requisiti, i punti e il percorso dell'immagine.
	 *
	 * @return una stringa che rappresenta la carta oro
	 */
	@Override
	public String toString() {
		return super.toString() +"\n"+"Requisiti: "+requisiti+"\n"+punti+"\n";
	}
	
	/**
	 * Controlla se un giocatore soddisfa i requisiti specificati da una carta oro.
	 *
	 * @param c la carta oro contenente i requisiti da soddisfare
	 * @param g il giocatore di cui controllare l'area di gioco
	 * @return true se il giocatore soddisfa i requisiti della carta oro, false altrimenti
	 */
	public boolean controlloRequisiti(CartaOro c, Giocatore g)
	{
		if(c.getRequisiti().equals("fungo fungo lupo"))
		{
			int contaFunghi=0;
			int contaLupi=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe;i++)
			{
				for(int j=0;j<AreaDiGioco.maxColonne;j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{	//messo al contrario perche' ad puo' essere null e (null equals) mi da eccezione null pointer
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaLupi++;
								
								
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaLupi++;
								
								
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaLupi++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									contaFunghi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
										contaLupi++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaLupi++;
								
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaLupi++;
								
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaLupi++;
						
							
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
							{
								String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
								
								for(int k=0;k<simboli.length;k++)
								{
									if(simboli[i].equals("fungo"))
										contaFunghi++;
									else if(simboli[i].equals("lupo"))
										contaLupi++;
									
								}
							}
						}
						
						
					}
				}
			}
			
			if(contaFunghi>=2 && contaLupi>=1)
			{
				int contaPiume =0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
				
				//+1 perché conta piume che ci sono gia' giu' prima di posizionare questa carta (ogni carta di questo tipo ha gia' un simbolo su essa)
				g.incrementaPunti(contaPiume+1);
				
				return true;
			}
			
			return false;
		}
		
	//seconda carta
		if(c.getRequisiti().equals("fungo fungo foglia"))
		{
			int contaFunghi=0;
			int contaFoglie=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe;i++)
			{
				for(int j=0;j<AreaDiGioco.maxColonne;j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFunghi++;
								else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglie++;
								
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFunghi++;
								else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFoglie++;
								
								
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFoglie++;
								
								
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFoglie++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									contaFunghi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
										contaFoglie++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFunghi++;
								else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglie++;
								
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFunghi++;
								else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFoglie++;
								
								
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFoglie++;
								
								
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFoglie++;
								
							
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
							{
								String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
								
								for(int k=0;k<simboli.length;k++)
								{
									if(simboli[i].equals("fungo"))
										contaFunghi++;
									else if(simboli[i].equals("foglia"))
										contaFoglie++;
									
								}
							}
						}
						
						
					}
				}
			}
			
			if(contaFunghi>=2 && contaFoglie>=1)
			{
				int contaBottiglie =0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
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
				
				g.incrementaPunti(contaBottiglie+1);
				
				return true;
			}
				
			return false;
		}
	
	//TERZA CARTA
		if(c.getRequisiti().equals("fungo fungo farfalla"))
		{
			int contaFunghi=0;
			int contaFarfalle=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe;i++)
			{
				for(int j=0;j<AreaDiGioco.maxColonne;j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFunghi++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalle++;
								
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFunghi++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFarfalle++;
								
								
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFarfalle++;
								
								
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFarfalle++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									contaFunghi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalle++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFunghi++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalle++;
								
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFunghi++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFarfalle++;
								
								
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFarfalle++;
								
								
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFarfalle++;
								
								
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
							{
								String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
								
								for(int k=0;k<simboli.length;k++)
								{
									if(simboli[i].equals("fungo"))
										contaFunghi++;
									else if(simboli[i].equals("farfalla"))
										contaFarfalle++;
									
								}
							}
						}
						
						
					}
				}
			}
			
			if(contaFunghi>=2 && contaFarfalle>=1)
			{
				int contaPergamene =0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
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
				
				g.incrementaPunti(contaPergamene+1);
				
				return true;
			}
				
			return false;
		}


	//quarta carta
		if(c.getRequisiti().equals("fungo fungo fungo lupo"))
		{
			int contaFunghi=0;
			int contaLupi=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe;i++)
			{
				for(int j=0;j<AreaDiGioco.maxColonne;j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								
								if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaLupi++;
								
								
								if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaLupi++;
								
								
								if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaLupi++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									contaFunghi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
										contaLupi++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaLupi++;
								
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaLupi++;
								
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaLupi++;
								
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
							{
								String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
								
								for(int k=0;k<simboli.length;k++)
								{
									if(simboli[i].equals("fungo"))
										contaFunghi++;
									else if(simboli[i].equals("lupo"))
										contaLupi++;
									
								}
							}
						}
						
						
					}
				}
			}
			if(contaFunghi>=3 && contaLupi>=1)
			{
				
				
					
			
			    
			
				return true;
			}
				
			return false;
	}
		
    //quinta carta
			if(c.getRequisiti().equals("fungo fungo fungo foglia"))
			{
				int contaFunghi=0;
				int contaFoglie=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								    contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglie++;
								
								if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFoglie++;
								
								
								if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFoglie++;
								
								
								if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFoglie++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									contaFunghi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
								    contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								    contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglie++;
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFoglie++;
								
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFoglie++;
								
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFoglie++;
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("fungo"))
											contaFunghi++;
										else if(simboli[i].equals("lupo"))
											contaFoglie++;
										
									}
								}
							}
							
							
						}
					}
				}
				if(contaFunghi>=3 && contaFoglie>=1)
				{
				
					//inserire parte controllo angoli coperti
						
				
				    
				
					return true;
				}
					
				return false;
             }
			
	//sesta carta
		if(c.getRequisiti().equals("fungo fungo fungo farfalla"))
			{
			 int contaFunghi=0;
			 int contaFarfalle=0;
					
			for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
				 for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
					 if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{
							if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								 contaFunghi++;
							 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFarfalle++;
									
							 if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFunghi++;
							 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFarfalle++;
									
							 if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFunghi++;
							 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFarfalle++;
									
							 if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFunghi++;
							 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalle++;
									
							 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
										contaFunghi++;
							 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalle++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								 contaFunghi++;
							 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFarfalle++;
									
							 if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFunghi++;
							 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFarfalle++;
									
							 if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFunghi++;
							 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFarfalle++;
									
							 if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFunghi++;
							 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalle++;
							 
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
									{
										String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
										
										for(int k=0;k<simboli.length;k++)
										{
											if(simboli[i].equals("fungo"))
												contaFunghi++;
											else if(simboli[i].equals("farfalla"))
												contaFarfalle++;
											
										}
									}
								}
								
								
							}
						}
					}
		if(contaFunghi>=3 && contaFarfalle>=1)
		  {
					
				//inserire parte controllo angoli coperti  
					
		return true;
	 }
						
		return false;
	}				
				
	//settima, ottava e nona carta
	if(c.getRequisiti().equals("fungo fungo fungo"))
	{
		int contaFunghi=0;
		
		for(int i=0;i<AreaDiGioco.maxRighe;i++)
		{
			for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
						
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
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
		
		if(contaFunghi>=3)
		{
			
			g.incrementaPunti(3);
			
			return true;
		}
			
		return false;	
     }
	
	//decima carta
	if(c.getRequisiti().equals("fungo fungo fungo fungo fungo"))
	{
		int contaFunghi=0;
		
		for(int i=0;i<AreaDiGioco.maxRighe;i++)
		{
			for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
						
						
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
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
		
		if(contaFunghi>=5)
		{
			
			g.incrementaPunti(5);
			
			return true;
		}
			
		return false;	
     }
	
	//undicesima carta
		if(c.getRequisiti().equals("foglia foglia farfalla"))
		{
			int contafoglia=0;
			int contafarfalla=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe;i++)
			{
				for(int j=0;j<AreaDiGioco.maxColonne;j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{
							if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contafoglia++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
								
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contafoglia++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contafarfalla++;
								
								
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contafoglia++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contafarfalla++;
								
								
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contafoglia++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contafarfalla++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									contafoglia++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contafarfalla++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contafoglia++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
								
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contafoglia++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contafarfalla++;
								
								
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contafoglia++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contafarfalla++;
								
								
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contafoglia++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contafarfalla++;
						
							
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
							{
								String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
								
								for(int k=0;k<simboli.length;k++)
								{
									if(simboli[i].equals("foglia"))
										contafoglia++;
									else if(simboli[i].equals("farfalla"))
										contafarfalla++;
									
								}
							}
						}
						
						
					}
				}
			}
			
			if(contafoglia>=2 && contafarfalla>=1)
			{
				int contaPiume =0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
				
				g.incrementaPunti(contaPiume+1);
				
				return true;
			}
			
			return false;
		}
	
	
		
		//dodicessima carta
			if(c.getRequisiti().equals("foglia foglia fungo"))
			{
				int contafoglia=0;
				int contafungo=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contafungo++;
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafoglia++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafungo++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafoglia++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafungo++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafoglia++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafungo++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
										contafoglia++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
											contafungo++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contafungo++;
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafoglia++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafungo++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafoglia++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafungo++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafoglia++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafungo++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("foglia"))
											contafoglia++;
										else if(simboli[i].equals("fungo"))
											contafungo++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contafoglia>=2 && contafungo>=1)
				{
					int contaPergamene =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
					
					g.incrementaPunti(contaPergamene+1);
					
					return true;
				}
				
				return false;
			}

			//tredicesima carta
			if(c.getRequisiti().equals("foglia foglia lupo"))
			{
				int contafoglia=0;
				int contaLupi=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafoglia++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaLupi++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafoglia++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafoglia++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
										contafoglia++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
											contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafoglia++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaLupi++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafoglia++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafoglia++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("foglia"))
											contafoglia++;
										else if(simboli[i].equals("lupo"))
											contaLupi++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contafoglia>=2 && contaLupi>=1)
				{
					int contaBottiglie =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
							if(g.getAreaDiGioco().getArea()[i][j]!=null)
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
					
					g.incrementaPunti(contaBottiglie+1);
					
					return true;
				}
					
				return false;
			}
			
			
			//quatordicesima carta
			if(c.getRequisiti().equals("foglia foglia foglia farfalla"))
				{
				 int contafoglia=0;
				 int contaFarfalle=0;
						
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
					 for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
						 if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafoglia++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										 contaFarfalle++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafoglia++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										 contaFarfalle++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafoglia++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
											contaFarfalle++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contafoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
											contaFarfalle++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafoglia++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										 contaFarfalle++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafoglia++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										 contaFarfalle++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafoglia++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
											contaFarfalle++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("foglia"))
													contafoglia++;
												else if(simboli[i].equals("lupo"))
													contaFarfalle++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contafoglia>=3 && contaFarfalle>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}
			
			
			//quindicesima carta
			if(c.getRequisiti().equals("foglia foglia foglia lupo"))
				{
				 int contafoglia=0;
				 int contaLupi=0;
						
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
					 for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
						 if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafoglia++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaLupi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafoglia++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafoglia++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contafoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafoglia++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaLupi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafoglia++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafoglia++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("foglia"))
													contafoglia++;
												else if(simboli[i].equals("lupo"))
													contaLupi++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contafoglia>=3 && contaLupi>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}
			
			//sedicesima carta
			if(c.getRequisiti().equals("foglia foglia foglia fungo"))
				{
				 int contafoglia=0;
				 int contafunghi=0;
						
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
					 for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
						 if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contafunghi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafoglia++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafunghi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafoglia++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafunghi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafoglia++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contafoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									 contafunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contafunghi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafoglia++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafunghi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafoglia++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafunghi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafoglia++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafunghi++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("foglia"))
													contafunghi++;
												else if(simboli[i].equals("fungo"))
													contafunghi++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contafoglia>=3 && contafunghi>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}
			
			
			//carte 17/18/19
			if(c.getRequisiti().equals("foglia foglia foglia"))
			{
				int contafoglia=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafoglia++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafoglia++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafoglia++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
										contafoglia++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafoglia++;
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafoglia++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafoglia++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafoglia++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("foglia"))
											contafoglia++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contafoglia>=3)
				{
					int contaPiume =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
					
					g.incrementaPunti(contaPiume);
					
					return true;
				}
				
				return false;
			}
			
			//ventesima carta
			if(c.getRequisiti().equals("foglia foglia foglia foglia foglia"))
			{
				int contaFoglie=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
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
				
				if(contaFoglie>=5)
				{
					
					g.incrementaPunti(5);
					
					return true;
				}
					
				return false;	
		     }
				
			
			
			//ventunesima carta
			if(c.getRequisiti().equals("lupo lupo farfalla"))
			{
				int contaLupi=0;
				int contaFarfalle=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
									else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFarfalle++;
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaLupi++;
									else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalle++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalle++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalle++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
										contaLupi++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
											contaFarfalle++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
									else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFarfalle++;
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaLupi++;
									else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalle++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalle++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalle++;
									
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("lupo"))
											contaLupi++;
										else if(simboli[i].equals("farfalla"))
											contaFarfalle++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaLupi>=2 && contaFarfalle>=1)
				{
					int contaBottiglie =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
							if(g.getAreaDiGioco().getArea()[i][j]!=null)
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
					
					g.incrementaPunti(contaBottiglie+1);
					
					return true;
				}
					
				return false;
			}		
			
			//ventiduesima carta
			if(c.getRequisiti().equals("lupo lupo foglia"))
			{
				int contaLupi=0;
				int contaFoglie=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaLupi++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFoglie++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFoglie++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFoglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
										contaLupi++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
											contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaLupi++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFoglie++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFoglie++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFoglie++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("lupo"))
											contaLupi++;
										else if(simboli[i].equals("foglia"))
											contaFoglie++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaLupi>=2 && contaFoglie>=1)
				{
					int contaPergamene =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
					
					g.incrementaPunti(contaPergamene+1);
					
					return true;
				}
				
				return false;
			}
	
			//ventritresima carta
			if(c.getRequisiti().equals("lupo lupo fungo"))
			{
				int contaLupi=0;
				int contaFunghi=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaLupi++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFunghi++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFunghi++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFunghi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
										contaLupi++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
											contaFunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaLupi++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFunghi++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFunghi++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFunghi++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("lupo"))
											contaLupi++;
										else if(simboli[i].equals("fungo"))
											contaFunghi++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaLupi>=2 && contaFunghi>=1)
				{
					int contaPiume =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
					
					g.incrementaPunti(contaPiume+1);
					
					return true;
				}
				
				return false;
			}
			
			//ventiquattresima carta
			if(c.getRequisiti().equals("lupo lupo lupo farfalla"))
				{
				 int contaLupi=0;
				 int contaFarfalle=0;
						
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
					 for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
						 if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaLupi++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										 contaFarfalle++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										 contaFarfalle++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
											contaFarfalle++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
											contaFarfalle++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaLupi++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										 contaFarfalle++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										 contaFarfalle++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
											contaFarfalle++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("lupo"))
													contaLupi++;
												else if(simboli[i].equals("farfalla"))
													contaFarfalle++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contaLupi>=3 && contaFarfalle>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}				
			
			//venticinquesima carta
			if(c.getRequisiti().equals("lupo lupo lupo fungo"))
				{
				 int contaLupi=0;
				 int contaFunghi=0;
						
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
					 for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
						 if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaLupi++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFunghi++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFunghi++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									 contaFunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaLupi++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFunghi++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFunghi++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFunghi++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("lupo"))
													contaLupi++;
												else if(simboli[i].equals("fungo"))
													contaFunghi++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contaLupi>=3 && contaFunghi>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}
			
			//ventiseiesima carta
			if(c.getRequisiti().equals("lupo lupo lupo fungo"))
				{
				 int contaLupi=0;
				 int contaFoglie=0;
						
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
					 for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
						 if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaLupi++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFoglie++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFoglie++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFoglie++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaLupi++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFoglie++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFoglie++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFoglie++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("lupo"))
													contaLupi++;
												else if(simboli[i].equals("foglia"))
													contaFoglie++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contaLupi>=3 && contaFoglie>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}
			
			//ventisettesima carta
			if(c.getRequisiti().equals("lupo lupo lupo"))
			{
				int contaLupi=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
				
				if(contaLupi>=3)
				{
					int contaPergamene =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
					
					g.incrementaPunti(contaPergamene);
					
					return true;
				}
				
				return false;
			}
	
			//ventottesima carta
			if(c.getRequisiti().equals("lupo lupo lupo"))
			{
				int contaLupi=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
				
				if(contaLupi>=3)
				{
					int contaBottiglie =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
					
					g.incrementaPunti(contaBottiglie);
					
					return true;
				}
				
				return false;
			}	
			
			//ventinovesima carta
			if(c.getRequisiti().equals("lupo lupo lupo"))
			{
				int contaLupi=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
				
				if(contaLupi>=3)
				{
					int contaPiume =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
					
					g.incrementaPunti(contaPiume);
					
					return true;
				}
				
				return false;
			}	
			
			//trentesima carta
			if(c.getRequisiti().equals("lupo lupo lupo lupo lupo"))
			{
				int contaLupi=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
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
				
				if(contaLupi>=5)
				{
					
					g.incrementaPunti(5);
					
					return true;
				}
					
				return false;	
		     }
			
			//trentunesima carta
			if(c.getRequisiti().equals("farfalla farfalla foglia"))
			{
				int contafarfalla=0;
				int contaFoglie=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFoglie++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFoglie++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFoglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contafarfalla++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
											contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFoglie++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFoglie++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFoglie++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("farfalla"))
											contafarfalla++;
										else if(simboli[i].equals("foglia"))
											contaFoglie++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contafarfalla>=2 && contaFoglie>=1)
				{
					int contaPiume =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
							if(g.getAreaDiGioco().getArea()[i][j]!=null && g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Piume"))
									contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Piume"))
										contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Piume"))
										contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Piume"))
										contaPiume++;
							}
						}
						
					}
					
					g.incrementaPunti(contaPiume+1);
					
					return true;
				}
				
				return false;
			}
			
			//trentaduesima carta
			if(c.getRequisiti().equals("farfalla farfalla lupo"))
			{
				int contafarfalla=0;
				int contaLupi=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaLupi++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contafarfalla++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
											contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaLupi++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("farfalla"))
											contafarfalla++;
										else if(simboli[i].equals("lupo"))
											contaLupi++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contafarfalla>=2 && contaLupi>=1)
				{
					int contaPergamene =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
					
					g.incrementaPunti(contaPergamene+1);
					
					return true;
				}
				
				return false;
			}	
			
			
			//trentatreesima carta
			if(c.getRequisiti().equals("farfalla farfalla fungo"))
			{
				int contafarfalla=0;
				int contaFunghi=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFunghi++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFunghi++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFunghi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contafarfalla++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
											contaFunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFunghi++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFunghi++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFunghi++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("farfalla"))
											contafarfalla++;
										else if(simboli[i].equals("fungo"))
											contaFunghi++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contafarfalla>=2 && contaFunghi>=1)
				{
					int contaBottiglie =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
							if(g.getAreaDiGioco().getArea()[i][j]!=null && g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Piume"))
									contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Piume"))
										contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Piume"))
										contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Piume"))
										contaBottiglie++;
							}
						}
						
					}
					
					g.incrementaPunti(contaBottiglie+1);
					
					return true;
				}
				
				return false;
			}			
			
			//trentaquattresima carta
			if(c.getRequisiti().equals("farfalla farfalla farfalla lupo"))
				{
				 int contafarfalla=0;
				 int contaLupi=0;
						
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
					 for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
						 if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafarfalla++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaLupi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafarfalla++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafarfalla++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
									 contafarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafarfalla++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaLupi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafarfalla++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafarfalla++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("farfalla"))
													contafarfalla++;
												else if(simboli[i].equals("lupo"))
													contaLupi++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contafarfalla>=3 && contaLupi>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}	
			
	
			//trentacinquesima carta
			if(c.getRequisiti().equals("farfalla farfalla farfalla foglia"))
				{
				 int contafarfalla=0;
				 int contaFoglie=0;
						
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
					 for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
						 if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafarfalla++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFoglie++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafarfalla++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFoglie++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafarfalla++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFoglie++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
									 contafarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafarfalla++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFoglie++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafarfalla++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFoglie++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafarfalla++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFoglie++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("farfalla"))
													contafarfalla++;
												else if(simboli[i].equals("foglia"))
													contaFoglie++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contafarfalla>=3 && contaFoglie>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}	
				
			
			//trentaseiesima carta
			if(c.getRequisiti().equals("farfalla farfalla farfalla fungo"))
				{
				 int contafarfalla=0;
				 int contaFunghi=0;
						
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
					 for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
						 if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafarfalla++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFunghi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafarfalla++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFunghi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafarfalla++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
									 contafarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									 contaFunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contafarfalla++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFunghi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contafarfalla++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFunghi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contafarfalla++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFunghi++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("farfalla"))
													contafarfalla++;
												else if(simboli[i].equals("fungo"))
													contaFunghi++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contafarfalla>=3 && contaFunghi>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}	
				
			//trentasettesima carta
			if(c.getRequisiti().equals("farfalla farfalla farfalla "))
			{
				int contafarfalla=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contafarfalla++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("farfalla"))
											contafarfalla++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contafarfalla>=3)
				{
					int contaBottiglie =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
					
					g.incrementaPunti(contaBottiglie);
					
					return true;
				}
				
				return false;
			}
		
			
			//trentaottesima carta
			if(c.getRequisiti().equals("farfalla farfalla farfalla "))
			{
				int contafarfalla=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contafarfalla++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("farfalla"))
											contafarfalla++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contafarfalla>=3)
				{
					int contaPergamena =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
							if(g.getAreaDiGioco().getArea()[i][j]!=null && g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaPergamena++;
									
									if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaPergamena++;
									
									if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaPergamena++;
									
									if("pergamena".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaPergamena++;
							}
						}
						
					}
					
					g.incrementaPunti(contaPergamena);
					
					return true;
				}
				
				return false;
			}
		
			//trentaottesima carta
			if(c.getRequisiti().equals("farfalla farfalla farfalla "))
			{
				int contafarfalla=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contafarfalla++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contafarfalla++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contafarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contafarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contafarfalla++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("farfalla"))
											contafarfalla++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contafarfalla>=3)
				{
					int contaPiuma =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
							if(g.getAreaDiGioco().getArea()[i][j]!=null && g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaPiuma++;
									
									if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaPiuma++;
									
									if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaPiuma++;
									
									if("piuma".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaPiuma++;
							}
						}
						
					}
					
					g.incrementaPunti(contaPiuma);
					
					return true;
				}
				
				return false;
			}			
			
			//quarantesima carta
			if(c.getRequisiti().equals("farfalla farfalla farfalla farfalla farfalla"))
			{
				int contaFarfalle=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
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
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
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
				
				if(contaFarfalle>=5)
				{
					
					g.incrementaPunti(5);
					
					return true;
				}
					
				return false;	
		     }
			
			return false;
			
  }
	
}
	
