package codex;
import java.awt.Color;
import java.awt.Image;

public class CartaOro extends Carta{

	private String requisiti;
	
	
	
	public CartaOro(Color colore, String asx, String adx, String bsx, String bdx, String req, String percorsoImmagine)
	{
		super(colore, asx, adx, bsx, bdx, percorsoImmagine);
		
		requisiti = req; //una stringa tipo: farfalla farfalla foglia
		// quando la vado ad usare, spezzetto questa stringa tra i vari spazi e conto le parole 
		// (2 farfalle e 1 foglia) e faccio controllo  
		
		//i punti faccio funzione controllo per ogni carta e non uno generale nel costruttore
		
	}
	
	public String getRequisiti() {
		return requisiti;
	}
	
	
	
	
	public static CartaOro clonaCarta(CartaOro c)
	{
		CartaOro temp = new CartaOro(c.getColore(), c.getAs(), c.getAd(), c.getBs(), c.getBd(), c.getRequisiti(), c.getPercorsoImmagine());
		
		return temp;
		
		//ho bisogno di clonare questi attributi in modo da poter richiamare sempre il to string 
	}
	
	
	@Override
	public String toString() {
		return super.toString();
	}
	
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
				
				g.incrementaPunti(contaPiume);
				
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
				
				g.incrementaPunti(contaBottiglie);
				
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
				
				g.incrementaPunti(contaPergamene);
				
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
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								
								
								if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								
								
								if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaLupi++;
								
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglie++;
								
								
								if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglie++;
								
								
								if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglie++;
								
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglie++;
								
								
								if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFunghi++;
								else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
							 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFarfalle++;
									
							 if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFunghi++;
							 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFarfalle++;
									
							 if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFunghi++;
							 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
							 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFarfalle++;
									
							 if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFunghi++;
							 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFarfalle++;
									
							 if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFunghi++;
							 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
			int contaFoglia=0;
			int contaFarfalla=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe;i++)
			{
				for(int j=0;j<AreaDiGioco.maxColonne;j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
					{
						if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
						{
							if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFoglia++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
								
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFoglia++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
								
								
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFoglia++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
								
								
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFoglia++;
								else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									contaFoglia++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalla++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
								contaFoglia++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
								
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									contaFoglia++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
								
								
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									contaFoglia++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
								
								
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									contaFoglia++;
								else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
						
							
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
							{
								String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
								
								for(int k=0;k<simboli.length;k++)
								{
									if(simboli[i].equals("foglia"))
										contaFoglia++;
									else if(simboli[i].equals("farfalla"))
										contaFarfalla++;
									
								}
							}
						}
						
						
					}
				}
			}
			
			if(contaFoglia>=2 && contaFarfalla>=1)
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
	
	
		
		//dodicessima carta
			if(c.getRequisiti().equals("foglia foglia fungo"))
			{
				int contaFoglia=0;
				int contaFungo=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglia++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFungo++;
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFoglia++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFungo++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFoglia++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFungo++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFoglia++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFungo++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
										contaFoglia++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
											contaFungo++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglia++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFungo++;
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFoglia++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFungo++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFoglia++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFungo++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFoglia++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFungo++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("foglia"))
											contaFoglia++;
										else if(simboli[i].equals("fungo"))
											contaFungo++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaFoglia>=2 && contaFungo>=1)
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

			//tredicesima carta
			if(c.getRequisiti().equals("foglia foglia Lupo"))
			{
				int contaFoglia=0;
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
									contaFoglia++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFoglia++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFoglia++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFoglia++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
										contaFoglia++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
											contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglia++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFoglia++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFoglia++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFoglia++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("foglia"))
											contaFoglia++;
										else if(simboli[i].equals("lupo"))
											contaLupi++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaFoglia>=2 && contaLupi>=1)
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
					
					g.incrementaPunti(contaBottiglie);
					
					return true;
				}
					
				return false;
			}
			
			
			//quatordicesima carta
			if(c.getRequisiti().equals("foglia foglia foglia farfalla"))
				{
				 int contaFoglia=0;
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
									contaFoglia++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFoglia++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFoglia++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFoglia++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
											contaFarfalle++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
											contaFarfalle++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglia++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFoglia++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFoglia++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFoglia++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
											contaFarfalle++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("foglia"))
													contaFoglia++;
												else if(simboli[i].equals("lupo"))
													contaFarfalle++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contaFoglia>=3 && contaFarfalle>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}
			
			
			//quindicesima carta
			if(c.getRequisiti().equals("foglia foglia foglia lupo"))
				{
				 int contaFoglia=0;
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
									contaFoglia++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFoglia++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFoglia++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFoglia++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglia++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFoglia++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFoglia++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFoglia++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("foglia"))
													contaFoglia++;
												else if(simboli[i].equals("lupo"))
													contaLupi++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contaFoglia>=3 && contaLupi>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}
			
			//sedicesima carta
			if(c.getRequisiti().equals("foglia foglia foglia fungo"))
				{
				 int contaFoglia=0;
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
									contaFoglia++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contafunghi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFoglia++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contafunghi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFoglia++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contafunghi++;
										
								 if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFoglia++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contafunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									 contafunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglia++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contafunghi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFoglia++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contafunghi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFoglia++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contafunghi++;
										
								 if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFoglia++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
			if(contaFoglia>=3 && contafunghi>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}
			
			
			//carte 17/18/19
			if(c.getRequisiti().equals("foglia foglia foglia"))
			{
				int contaFoglia=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglia++;
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFoglia++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFoglia++;
									
									
									if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFoglia++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
										contaFoglia++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFoglia++;
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFoglia++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFoglia++;
									
									
									if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFoglia++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("foglia"))
											contaFoglia++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaFoglia>=3)
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
			if(c.getRequisiti().equals("Lupo Lupo Farfalla"))
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
									else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFarfalle++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFarfalle++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFarfalle++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Lupo"))
										contaLupi++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Farfalla"))
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
									else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFarfalle++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFarfalle++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFarfalle++;
									
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("Lupo"))
											contaLupi++;
										else if(simboli[i].equals("Farfalla"))
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
					
					g.incrementaPunti(contaBottiglie);
					
					return true;
				}
					
				return false;
			}		
			
			//ventiduesima carta
			if(c.getRequisiti().equals("Lupo Lupo foglia"))
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
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Lupo"))
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
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("Lupo"))
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
					
					g.incrementaPunti(contaPergamene);
					
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
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									
									if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaLupi++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									
									if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaLupi++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
					
					g.incrementaPunti(contaPiume);
					
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
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										 contaFarfalle++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaLupi++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaLupi++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
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
			if(c.getRequisiti().equals("Lupo Lupo lupo"))
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
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Lupo"))
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
										if(simboli[i].equals("Lupo"))
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
			if(c.getRequisiti().equals("Lupo Lupo lupo"))
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
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Lupo"))
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
										if(simboli[i].equals("Lupo"))
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
			if(c.getRequisiti().equals("Lupo Lupo lupo"))
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
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Lupo"))
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
										if(simboli[i].equals("Lupo"))
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
				int contaFarfalla=0;
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
									contaFarfalla++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
									else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalla++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
											contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
									else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFoglie++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("farfalla"))
											contaFarfalla++;
										else if(simboli[i].equals("foglia"))
											contaFoglie++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaFarfalla>=2 && contaFoglie>=1)
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
					
					g.incrementaPunti(contaPiume);
					
					return true;
				}
				
				return false;
			}
			
			//trentaduesima carta
			if(c.getRequisiti().equals("farfalla farfalla lupo"))
			{
				int contaFarfalla=0;
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
									contaFarfalla++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
									else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalla++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
											contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
									else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaLupi++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("farfalla"))
											contaFarfalla++;
										else if(simboli[i].equals("lupo"))
											contaLupi++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaFarfalla>=2 && contaLupi>=1)
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
			
			
			//trentatreesima carta
			if(c.getRequisiti().equals("farfalla farfalla fungo"))
			{
				int contaFarfalla=0;
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
									contaFarfalla++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
									else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalla++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
											contaFunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
									else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
										contaFunghi++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("farfalla"))
											contaFarfalla++;
										else if(simboli[i].equals("fungo"))
											contaFunghi++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaFarfalla>=2 && contaFunghi>=1)
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
					
					g.incrementaPunti(contaBottiglie);
					
					return true;
				}
				
				return false;
			}			
			
			//trentaquattresima carta
			if(c.getRequisiti().equals("farfalla farfalla farfalla lupo"))
				{
				 int contaFarfalla=0;
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
									contaFarfalla++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFarfalla++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFarfalla++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFarfalla++;
								 else if("lupo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFarfalla++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFarfalla++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFarfalla++;
								 else if("lupo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaLupi++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("farfalla"))
													contaFarfalla++;
												else if(simboli[i].equals("lupo"))
													contaLupi++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contaFarfalla>=3 && contaLupi>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}	
			
	
			//trentacinquesima carta
			if(c.getRequisiti().equals("farfalla farfalla farfalla foglia"))
				{
				 int contaFarfalla=0;
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
									contaFarfalla++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFarfalla++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFarfalla++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFarfalla++;
								 else if("foglia".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFarfalla++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFarfalla++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFarfalla++;
								 else if("foglia".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFoglie++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("farfalla"))
													contaFarfalla++;
												else if(simboli[i].equals("foglia"))
													contaFoglie++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contaFarfalla>=3 && contaFoglie>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}	
				
			
			//trentaseiesima carta
			if(c.getRequisiti().equals("farfalla farfalla farfalla fungo"))
				{
				 int contaFarfalla=0;
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
									contaFarfalla++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFarfalla++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFarfalla++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFarfalla++;
								 else if("fungo".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									 contaFunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
									 contaFarfalla++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
									 contaFarfalla++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
										
								 if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
									 contaFarfalla++;
								 else if("fungo".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									 contaFunghi++;
								 
										if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
										{
											String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
											
											for(int k=0;k<simboli.length;k++)
											{
												if(simboli[i].equals("farfalla"))
													contaFarfalla++;
												else if(simboli[i].equals("fungo"))
													contaFunghi++;
												
											}
										}
									}
									
									
								}
							}
						}
			if(contaFarfalla>=3 && contaFunghi>=1)
			  {
						
					//inserire parte controllo angoli coperti  
						
			return true;
		 }
							
			return false;
		}	
				
			//trentasettesima carta
			if(c.getRequisiti().equals("Farfalla Farfalla Farfalla "))
			{
				int contaFarfalla=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Farfalla"))
										contaFarfalla++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("Farfalla"))
											contaFarfalla++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaFarfalla>=3)
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
			if(c.getRequisiti().equals("Farfalla Farfalla Farfalla "))
			{
				int contaFarfalla=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Farfalla"))
										contaFarfalla++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("Farfalla"))
											contaFarfalla++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaFarfalla>=3)
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
			if(c.getRequisiti().equals("Farfalla Farfalla Farfalla "))
			{
				int contaFarfalla=0;
				
				for(int i=0;i<AreaDiGioco.maxRighe;i++)
				{
					for(int j=0;j<AreaDiGioco.maxColonne;j++)
					{
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
						{
							if(g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Farfalla"))
										contaFarfalla++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd()))
									contaFarfalla++;
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd()))
										contaFarfalla++;
									
									
									if("farfalla".equals(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs()))
										contaFarfalla++;
							
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
								{
									String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
									
									for(int k=0;k<simboli.length;k++)
									{
										if(simboli[i].equals("Farfalla"))
											contaFarfalla++;
										
									}
								}
							}
							
							
						}
					}
				}
				
				if(contaFarfalla>=3)
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
	
