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
						
						if(g.getAreaDiGioco().getArea()[i][j] instanceof CartaIniziale)
						{
							if(((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().equals("vuoto") == false)
							{
								String[] simboli = ((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloRetro().split(",");
								
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
		
	}
	//seconda carta
	public boolean controlloRequisiti(CartaOroBonus c, Giocatore g) {
		if (c.getRequisiti().equals("fungo fungo foglia")) {
			int contaFunghi = 0;
			int contaFoglie = 0;
			int contaBarattoliOro = 0; // Variabile per il conteggio dei barattoli d'oro

			for (int i = 0; i < AreaDiGioco.maxRighe; i++) {
				for (int j = 0; j < AreaDiGioco.maxColonne; j++) {
					if (g.getAreaDiGioco().getArea()[i][j] != null) {
						// Controllo funghi
						if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo")) {
							contaFunghi++;
						} else if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("foglia")) {
							contaFoglie++;
						}

						if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo")) {
							contaFunghi++;
						} else if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("foglia")) {
							contaFoglie++;
						}

						if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo")) {
							contaFunghi++;
						} else if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("foglia")) {
							contaFoglie++;
						}

						if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo")) {
							contaFunghi++;
						} else if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("foglia")) {
							contaFoglie++;
						}

						// Controllo barattoli d'oro (aggiunto)
						if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloBonus().equals("barattolo_oro")) {
							contaBarattoliOro++;
							// Assegna 1 punto bonus per ogni barattolo d'oro
							g.aggiungiPunti(1);
						}
					}
				}
			}

			// Controllo requisiti
			if (contaFunghi >= 2 && contaFoglie >= 1) {
				return true; // Requisiti soddisfatti
			} else {
				return false; // Requisiti non soddisfatti
			}
		} else {
			// Se i requisiti non corrispondono a "fungo fungo foglia"
			return false; // Carta non giocabile
		}
	}
	
	//terza carta
	public boolean controlloRequisiti(CartaOroBonus c, Giocatore g) {
		if (c.getRequisiti().equals("fungo fungo farfalla")) { // Modifica dei requisiti
			int contaFunghi = 0;
			int contaFarfalle = 0; // Modifica per contare le farfalle
			int contaPergameneOro = 0; // Variabile per il conteggio delle pergamene d'orata

			for (int i = 0; i < AreaDiGioco.maxRighe; i++) {
				for (int j = 0; j < AreaDiGioco.maxColonne; j++) {
					if (g.getAreaDiGioco().getArea()[i][j] != null) {
						// Controllo funghi
						if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("fungo")) {
							contaFunghi++;
						}

						if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("fungo")) {
							contaFunghi++;
						}

						if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("fungo")) {
							contaFunghi++;
						}

						if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("fungo")) {
							contaFunghi++;
						}

						// Controllo farfalle (modifica)
						if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getAd().equals("farfalla")) {
							contaFarfalle++;
						} else if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getAs().equals("farfalla")) {
							contaFarfalle++;
						} else if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getBd().equals("farfalla")) {
							contaFarfalle++;
						} else if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getBs().equals("farfalla")) {
							contaFarfalle++;
						}

						// Controllo pergamene d'orata (aggiunto)
						if (((Carta) g.getAreaDiGioco().getArea()[i][j]).getSimboloBonus().equals("pergamena_oro")) {
							contaPergameneOro++;
							g.aggiungiPunti(1); // Assegna 1 punto bonus per ogni pergamena d'orata
						}
					}
				}
			}

			// Controllo requisiti
			if (contaFunghi >= 2 && contaFarfalle >= 1) {
				return true; // Requisiti soddisfatti
			} else {
				return false; // Requisiti non soddisfatti
			}
		} else {
			// Se i requisiti non corrispondono a "fungo fungo farfalla"
			return false; // Carta non giocabile
		}
	}
	
}