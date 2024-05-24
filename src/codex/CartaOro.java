package codex;
import java.awt.Color;
import java.awt.Image;

public class CartaOro extends Carta{
	
	private String nome;
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
						{
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									contaFunghi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
										contaLupi++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
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
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("piuma"))
								contaPiume++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("piuma"))
									contaPiume++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("piuma"))
									contaPiume++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("piuma"))
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
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglie++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglie++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglie++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglie++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									contaFunghi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
										contaFoglie++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglie++;
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglie++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglie++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
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
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("bottiglia"))
								contaBottiglie++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("bottiglia"))
									contaBottiglie++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("bottiglia"))
									contaBottiglie++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("bottiglia"))
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
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalle++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalle++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalle++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalle++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									contaFunghi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalle++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalle++;
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalle++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalle++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
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
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("pergamena"))
								contaPergamene++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("pergamena"))
									contaPergamene++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("pergamena"))
									contaPergamene++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("pergamena"))
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
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									contaFunghi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
										contaLupi++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								    contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaFoglie++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaFoglie++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaFoglie++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
									contaFunghi++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaFoglie++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									contaFunghi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
								    contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								    contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaFoglie++;
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaFoglie++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaFoglie++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
									contaFunghi++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
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
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								 contaFunghi++;
							 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									 contaFarfalle++;
									
							 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									 contaFunghi++;
							 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									 contaFarfalle++;
									
							 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									 contaFunghi++;
							 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									 contaFarfalle++;
									
							 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
										contaFunghi++;
							 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										contaFarfalle++;
									
							 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
										contaFunghi++;
							 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalle++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								 contaFunghi++;
							 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									 contaFarfalle++;
									
							 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									 contaFunghi++;
							 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									 contaFarfalle++;
									
							 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									 contaFunghi++;
							 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									 contaFarfalle++;
									
							 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
										contaFunghi++;
							 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
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
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
						    contaFunghi++;
						
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
							contaFunghi++;
						
						
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
							contaFunghi++;
						
						
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
							contaFunghi++;
						
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
							contaFunghi++;
					}
					else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
					{
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
						    contaFunghi++;
						
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
							contaFunghi++;
						
						
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
							contaFunghi++;
						
						
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
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
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
						    contaFunghi++;
						
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
							contaFunghi++;
						
						
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
							contaFunghi++;
						
						
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
							contaFunghi++;
						
						
						if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
							contaFunghi++;
					}
					else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
					{
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
						    contaFunghi++;
						
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
							contaFunghi++;
						
						
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
							contaFunghi++;
						
						
						if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
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
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
								contaFoglia++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
									contaFoglia++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
									contaFoglia++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
									contaFoglia++;
								else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									contaFoglia++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalla++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
								contaFoglia++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
									contaFoglia++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
									contaFoglia++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
									contaFoglia++;
								else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
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
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("piuma"))
								contaPiume++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("piuma"))
									contaPiume++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("piuma"))
									contaPiume++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("piuma"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFungo++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
										contaFoglia++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFungo++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
										contaFoglia++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFungo++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
										contaFoglia++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFungo++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
										contaFoglia++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
											contaFungo++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFungo++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
										contaFoglia++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFungo++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
										contaFoglia++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFungo++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
										contaFoglia++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("pergamena"))
									contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("pergamena"))
										contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("pergamena"))
										contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("pergamena"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
										contaFoglia++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
										contaFoglia++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
										contaFoglia++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
										contaFoglia++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
											contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
										contaFoglia++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
										contaFoglia++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
										contaFoglia++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("bottiglia"))
									contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("bottiglia"))
										contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("bottiglia"))
										contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("bottiglia"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
											contaFarfalle++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
											contaFarfalle++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
									 contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
									 contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
									 contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
									 contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
									 contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
									 contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contafunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contafunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contafunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contafunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contaFoglia++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									 contafunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contafunghi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
									 contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contafunghi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
									 contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contafunghi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
									 contaFoglia++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
										contaFoglia++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
										contaFoglia++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
										contaFoglia++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
										contaFoglia++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglia++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
										contaFoglia++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
										contaFoglia++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("piuma"))
									contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("piuma"))
										contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("piuma"))
										contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("piuma"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglie++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
									contaFoglie++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
									contaFoglie++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
									contaFoglie++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									contaFoglie++;
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia"))
									contaFoglie++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia"))
									contaFoglie++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Lupo"))
									contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
										contaFarfalle++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Lupo"))
										contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
										contaFarfalle++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Lupo"))
										contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
										contaFarfalle++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Lupo"))
										contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
										contaFarfalle++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Lupo"))
										contaLupi++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Farfalla"))
											contaFarfalle++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Lupo"))
									contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
										contaFarfalle++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Lupo"))
										contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
										contaFarfalle++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Lupo"))
										contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
										contaFarfalle++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Lupo"))
										contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("bottiglia"))
									contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("bottiglia"))
										contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("bottiglia"))
										contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("bottiglia"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Lupo"))
									contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Lupo"))
										contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Lupo"))
										contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Lupo"))
										contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Lupo"))
										contaLupi++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
											contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Lupo"))
									contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Lupo"))
										contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Lupo"))
										contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Lupo"))
										contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("pergamena"))
									contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("pergamena"))
										contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("pergamena"))
										contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("pergamena"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("lupo"))
										contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("lupo"))
										contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("lupo"))
										contaLupi++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
										contaLupi++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
											contaFunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("lupo"))
										contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("lupo"))
										contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("lupo"))
										contaLupi++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("piuma"))
									contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("piuma"))
										contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("piuma"))
										contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("piuma"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
											contaFarfalle++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
											contaFarfalle++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("lupo"))
									 contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("lupo"))
									 contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
										 contaFarfalle++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("lupo"))
									 contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									 contaFunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("lupo"))
									 contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("lupo"))
									 contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("lupo"))
									 contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("lupo"))
									 contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("lupo"))
									 contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("lupo"))
									 contaLupi++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Lupo"))
									contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Lupo"))
										contaLupi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Lupo"))
										contaLupi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Lupo"))
										contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Lupo"))
										contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Lupo"))
									contaLupi++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Lupo"))
										contaLupi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Lupo"))
										contaLupi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Lupo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("pergamena"))
									contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("pergamena"))
										contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("pergamena"))
										contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("pergamena"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Lupo"))
									contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Lupo"))
										contaLupi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Lupo"))
										contaLupi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Lupo"))
										contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Lupo"))
										contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Lupo"))
									contaLupi++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Lupo"))
										contaLupi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Lupo"))
										contaLupi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Lupo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("bottiglia"))
									contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("bottiglia"))
										contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("bottiglia"))
										contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("bottiglia"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Lupo"))
									contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Lupo"))
										contaLupi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Lupo"))
										contaLupi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Lupo"))
										contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Lupo"))
										contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Lupo"))
									contaLupi++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Lupo"))
										contaLupi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Lupo"))
										contaLupi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Lupo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("piuma"))
									contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("piuma"))
										contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("piuma"))
										contaPiume++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("piuma"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("lupo"))
									contaLupi++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("lupo"))
									contaLupi++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("lupo"))
									contaLupi++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									contaLupi++;
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("lupo"))
									contaLupi++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("lupo"))
									contaLupi++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("lupo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
										contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
										contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
										contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalla++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
											contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
										contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
										contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
										contaFoglie++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
										contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
										contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
										contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
										contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalla++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
											contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
										contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
										contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaLupi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
										contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Pergamena"))
									contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Pergamena"))
										contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Pergamena"))
										contaPergamene++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Pergamena"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
										contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
										contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
										contaFarfalla++;
									else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
										contaFarfalla++;
										else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
											contaFunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
										contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
										contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
										contaFunghi++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
										contaFarfalla++;
									else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
									 contaLupi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
									 contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaLupi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("foglia"))
									 contaFoglie++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
									 contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
									 contaFoglie++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
									 contaFarfalla++;
								 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
									 contaFunghi++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
									 contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
									 contaFunghi++;
										
								 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
									 contaFarfalla++;
								 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
									contaFarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Farfalla"))
										contaFarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Farfalla"))
										contaFarfalla++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
									contaFarfalla++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Farfalla"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Bottiglia"))
									contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Bottiglia"))
										contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Bottiglia"))
										contaBottiglie++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Bottiglia"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
									contaFarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Farfalla"))
										contaFarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Farfalla"))
										contaFarfalla++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
									contaFarfalla++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Farfalla"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Pergamena"))
									contaPergamena++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Pergamena"))
										contaPergamena++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Pergamena"))
										contaPergamena++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Pergamena"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
									contaFarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Farfalla"))
										contaFarfalla++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("Farfalla"))
										contaFarfalla++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Farfalla"))
									contaFarfalla++;
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Farfalla"))
										contaFarfalla++;
									
									
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Farfalla"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("Piuma"))
									contaPiuma++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("Piuma"))
										contaPiuma++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("Piuma"))
										contaPiuma++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("Piuma"))
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
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalle++;
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
									contaFarfalle++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
									contaFarfalle++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
									contaFarfalle++;
								
								
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("farfalla"))
									contaFarfalle++;
							}
							else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
							{
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla"))
									contaFarfalle++;
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla"))
									contaFarfalle++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla"))
									contaFarfalle++;
								
								
								if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla"))
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
			
  }
	
}
	
