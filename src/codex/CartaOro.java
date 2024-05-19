package codex;
import java.awt.Color;
import java.awt.Image;

public class CartaOro extends Carta{
	
	private String nome;
	
	public CartaOro(String nome, Color colore, String asx, String adx, String bsx, String bdx, String req, int p, String percorsoImmagine)
	{
		super(colore, asx, adx, bsx, bdx, percorsoImmagine);
		
		this.nome = nome;
		
		
		String requisiti = req; //una stringa tipo: farfalla farfalla foglia
		// quando la vado ad usare, spezzetto questa stringa tra i vari spazi e conto le parole 
		// (2 farfalle e 1 foglia) e faccio controllo  
		
		//i punti faccio funzione controllo per ogni carta e non uno generale nel costruttore
		
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public boolean controlloRequisiti(CartaOro c, Giocatore g)
	{
		if(c.getNome().equals("fungo fungo lupo"))
		{
			int contaFunghi=0;
			int contaLupi=0;
			
			for(int i=0;i<AreaDiGioco.maxRighe;i++)
			{
				for(int j=0;j<AreaDiGioco.maxColonne;j++)
				{
					if(g.getAreaDiGioco().getArea()[i][j]!=null)
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
						if(g.getAreaDiGioco().getArea()[i][j]!=null)
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
		else if() {
			
		}
	}
	
	
	
	public void controlloPunti()
	{
		
	}



	
	

}