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
							 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaFarfalle++;
									
							 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									 contaFunghi++;
							 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaFarfalle++;
									
							 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									 contaFunghi++;
							 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaFarfalle++;
									
							 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
										contaFunghi++;
							 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaFarfalle++;
									
							 if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("fungo"))
										contaFunghi++;
							 else if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("lupo"))
										contaFarfalle++;
						}
						else if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo"))
								 contaFunghi++;
							 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaFarfalle++;
									
							 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo"))
									 contaFunghi++;
							 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaFarfalle++;
									
							 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo"))
									 contaFunghi++;
							 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
									 contaFarfalle++;
									
							 if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo"))
										contaFunghi++;
							 else if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("lupo"))
										contaFarfalle++;
							 
									if(((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
									{
										String[] simboli = ((CartaIniziale) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
										
										for(int k=0;k<simboli.length;k++)
										{
											if(simboli[i].equals("fungo"))
												contaFunghi++;
											else if(simboli[i].equals("lupo"))
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
			
			
			//diciasettesima carta
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
			
			//diciasettesima carta
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
			
			//diciasettesima carta
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
					int contaBottiglia =0;
					
					for(int i=0;i<AreaDiGioco.maxRighe;i++)
					{
						for(int j=0;j<AreaDiGioco.maxColonne;j++)
						{
							if(g.getAreaDiGioco().getArea()[i][j]!=null && g.getAreaDiGioco().getArea()[i][j] instanceof Carta)
							{
								if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("bottiglia"))
									contaBottiglia++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("bottiglia"))
										contaBottiglia++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("bottiglia"))
										contaBottiglia++;
									
									if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("bottiglia"))
										contaBottiglia++;
							}
						}
						
					}
					
					g.incrementaPunti(contaBottiglia);
					
					return true;
				}
				
				return false;
			}
			
  }
	
}
	
