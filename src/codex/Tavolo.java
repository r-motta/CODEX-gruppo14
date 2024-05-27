package codex;
import java.awt.Color;	
import java.util.ArrayList;
import java.util.List;

public class Tavolo{
	
	private Giocatore[] gamers;
	private List <CartaRisorsa> mazzoRisorse;
	private List <CartaIniziale> mazzoIniziali;
	private List <CartaOro> mazzoOro;
	private List <CartaObiettivo> mazzoObiettivo;
	
	public Tavolo()
	{
	
				gamers = new Giocatore[Main.numGiocatori];

	
				CartaRisorsa cr1 = new CartaRisorsa(Color.RED, "fungo", "vuoto", "fungo", null, 0, "/immagini/carteRisorsa/cr1.jpg");
				CartaRisorsa cr2 = new CartaRisorsa(Color.RED, "fungo", "fungo", null , "vuoto", 0, "/immagini/carteRisorsa/cr2.jpg");
				CartaRisorsa cr3 = new CartaRisorsa(Color.RED, "vuoto", null, "fungo", "fungo", 0, "/immagini/carteRisorsa/cr3.jpg");
				CartaRisorsa cr4 = new CartaRisorsa(Color.RED, null, "fungo", "vuoto", "fungo", 0, "/immagini/carteRisorsa/cr4.jpg");
				CartaRisorsa cr5 = new CartaRisorsa(Color.RED, null, "piuma", "foglia", "fungo", 0, "/immagini/carteRisorsa/cr5.jpg");
				CartaRisorsa cr6 = new CartaRisorsa(Color.RED, "bottiglia", "fungo", null, "lupo", 0, "/immagini/carteRisorsa/cr6.jpg");
				CartaRisorsa cr7 = new CartaRisorsa(Color.RED, "fungo", "farfalla", "pergamena", null, 0, "/immagini/carteRisorsa/cr7.jpg");
				CartaRisorsa cr8 = new CartaRisorsa(Color.RED, "vuoto", "fungo", "vuoto", null, 1, "/immagini/carteRisorsa/cr8.jpg");
				CartaRisorsa cr9 = new CartaRisorsa(Color.RED, "fungo", null, "vuoto", "vuoto", 1, "/immagini/carteRisorsa/cr9.jpg");
				CartaRisorsa cr10 = new CartaRisorsa(Color.RED, null, "vuoto", "fungo", "vuoto", 1, "/immagini/carteRisorsa/cr10.jpg");
				
				CartaRisorsa cr11 = new CartaRisorsa(Color.GREEN, "foglia", "vuoto", "foglia", null, 0, "/immagini/carteRisorsa/cr11.jpg");
				CartaRisorsa cr12 = new CartaRisorsa(Color.GREEN, "foglia", "foglia", null, "vuoto", 0, "/immagini/carteRisorsa/cr12.jpg");
				CartaRisorsa cr13 = new CartaRisorsa(Color.GREEN, "vuoto", null, "foglia", "foglia", 0, "/immagini/carteRisorsa/cr13.jpg");
				CartaRisorsa cr14 = new CartaRisorsa(Color.GREEN, null, "foglia", "vuoto", "foglia", 0, "/immagini/carteRisorsa/cr14.jpg");
				CartaRisorsa cr15 = new CartaRisorsa(Color.GREEN, null, "farfalla", "piuma", "foglia", 0, "/immagini/carteRisorsa/cr15.jpg");
				CartaRisorsa cr16 = new CartaRisorsa(Color.GREEN, "fungo", "foglia", null, "bottiglia", 0, "/immagini/carteRisorsa/cr16.jpg");
				CartaRisorsa cr17 = new CartaRisorsa(Color.GREEN, "pergamena", null, "foglia", "lupo", 0, "/immagini/carteRisorsa/cr17.jpg");
				CartaRisorsa cr18 = new CartaRisorsa(Color.GREEN, "vuoto", "vuoto", "foglia", null, 1, "/immagini/carteRisorsa/cr18.jpg");
				CartaRisorsa cr19 = new CartaRisorsa(Color.GREEN, "vuoto", "vuoto", null, "foglia", 1, "/immagini/carteRisorsa/cr19.jpg");
				CartaRisorsa cr20 = new CartaRisorsa(Color.GREEN, null, "foglia", "vuoto", "vuoto", 1, "/immagini/carteRisorsa/cr20.jpg");
				
				CartaRisorsa cr21 = new CartaRisorsa(Color.BLUE, "lupo", "lupo", "vuoto", null, 0, "/immagini/carteRisorsa/cr21.jpg");
				CartaRisorsa cr22 = new CartaRisorsa(Color.BLUE, null, "vuoto", "lupo", "lupo", 0, "/immagini/carteRisorsa/cr22.jpg");
				CartaRisorsa cr23 = new CartaRisorsa(Color.BLUE, "lupo", null, "lupo", "vuoto", 0, "/immagini/carteRisorsa/cr23.jpg");
				CartaRisorsa cr24 = new CartaRisorsa(Color.BLUE, "vuoto", "lupo", null, "lupo", 0, "/immagini/carteRisorsa/cr24.jpg");
				CartaRisorsa cr25 = new CartaRisorsa(Color.BLUE, null, "farfalla", "bottiglia", "lupo", 0, "/immagini/carteRisorsa/cr25.jpg");
				CartaRisorsa cr26 = new CartaRisorsa(Color.BLUE, "foglia", "lupo", null, "pergamena", 0, "/immagini/carteRisorsa/cr26.jpg");
				CartaRisorsa cr27 = new CartaRisorsa(Color.BLUE, "piuma", null, "lupo", "fungo", 0, "/immagini/carteRisorsa/cr27.jpg");
				CartaRisorsa cr28 = new CartaRisorsa(Color.BLUE, null, "vuoto", "lupo", "vuoto", 1, "/immagini/carteRisorsa/cr28.jpg");
				CartaRisorsa cr29 = new CartaRisorsa(Color.BLUE, "vuoto", null, "vuoto", "lupo", 1, "/immagini/carteRisorsa/cr29.jpg");
				CartaRisorsa cr30 = new CartaRisorsa(Color.BLUE, "vuoto", "lupo", "vuoto", null, 1, "/immagini/carteRisorsa/cr30.jpg");
				
				CartaRisorsa cr31 = new CartaRisorsa(Color.MAGENTA, "farfalla", "farfalla", "vuoto", null, 0, "/immagini/carteRisorsa/cr31.jpg");
				CartaRisorsa cr32 = new CartaRisorsa(Color.MAGENTA, null, "vuoto", "farfalla", "farfalla", 0, "/immagini/carteRisorsa/cr32.jpg");
				CartaRisorsa cr33 = new CartaRisorsa(Color.MAGENTA, "farfalla", null, "farfalla", "vuoto", 0, "/immagini/carteRisorsa/cr33.jpg");
				CartaRisorsa cr34 = new CartaRisorsa(Color.MAGENTA, "vuoto", "farfalla", null, "farfalla", 0, "/immagini/carteRisorsa/cr34.jpg");
				CartaRisorsa cr35 = new CartaRisorsa(Color.MAGENTA, null, "piuma", "lupo", "farfalla", 0, "/immagini/carteRisorsa/cr35.jpg");
				CartaRisorsa cr36 = new CartaRisorsa(Color.MAGENTA,  "pergamena", "farfalla", null, "fungo", 0, "/immagini/carteRisorsa/cr36.jpg");
				CartaRisorsa cr37 = new CartaRisorsa(Color.MAGENTA, "farfalla", "foglia", "bottiglia", null, 0, "/immagini/carteRisorsa/cr37.jpg");
				CartaRisorsa cr38 = new CartaRisorsa(Color.MAGENTA, "farfalla", "lupo", "lupo", null, 1, "/immagini/carteRisorsa/cr38.jpg");
				CartaRisorsa cr39 = new CartaRisorsa(Color.MAGENTA, "vuoto", "vuoto", null, "farfalla", 1, "/immagini/carteRisorsa/cr39.jpg");
				CartaRisorsa cr40 = new CartaRisorsa(Color.MAGENTA, null, "farfalla", "vuoto", "vuoto", 1, "/immagini/carteRisorsa/cr40.jpg");
			
			
			// colore, asx, adx, bsx, bdx, requisiti, punteggio, url
			
				CartaOro co1 = new CartaOro(Color.RED, null, "vuoto", "vuoto", "piuma", "fungo fungo lupo","1 Punto x piuma","/immagini/carteOro/co1.jpg");
				CartaOro co2 = new CartaOro(Color.RED, "vuoto", "bottiglia", null, "vuoto", "fungo fungo foglia","1 Punto x bottiglia","/immagini/carteOro/co2.jpg");
				CartaOro co3 = new CartaOro(Color.RED, "pergamena", "vuoto", "vuoto", null, "fungo fungo farfalla","1 Punto per pergamena","/immagini/carteOro/co3.jpg");
				CartaOro co4 = new CartaOro(Color.RED, "vuoto", "vuoto", null, "vuoto", "fungo fungo fungo lupo","2 Punti x angolo","/immagini/carteOro/co4.jpg");
				CartaOro co5 = new CartaOro(Color.RED, "vuoto", "vuoto", "vuoto", null, "fungo fungo fungo foglia","2 Punti x angolo","/immagini/carteOro/co5.jpg");
				CartaOro co6 = new CartaOro(Color.RED, "vuoto", null, "vuoto", "vuoto", "fungo fungo fungo farfalla","2 Punti x angolo","/immagini/carteOro/co6.jpg");
				CartaOro co7 = new CartaOro(Color.RED, "vuoto", null, "bottiglia", null, "fungo fungo fungo","3 punti","/immagini/carteOro/co7.jpg");
				CartaOro co8 = new CartaOro(Color.RED, "piuma", "vuoto", null, null, "fungo fungo fungo","3 Punti","/immagini/carteOro/co8.jpg");
				CartaOro co9 = new CartaOro(Color.RED, null, "pergamena", null, "vuoto", "fungo fungo fungo","3 Punti","/immagini/carteOro/co9.jpg");
				CartaOro co10 = new CartaOro(Color.RED, "vuoto", null, "vuoto", null, "fungo fungo fungo fungo fungo","5 Punti","/immagini/carteOro/co10.jpg");
				
				CartaOro co11 = new CartaOro(Color.GREEN, "piuma", "vuoto", "vuoto", null, "foglia foglia farfalla","1 Punto x piuma","/immagini/carteOro/co11.jpg");
				CartaOro co12 = new CartaOro(Color.GREEN, "vuoto", "pergamena", null, "vuoto", "foglia foglia fungo","1 Punto x pergamena","/immagini/carteOro/co12.jpg");
				CartaOro co13 = new CartaOro(Color.GREEN, "vuoto", null, "bottiglia", "vuoto", "foglia foglia lupo","1 Punto x bottiglia","/immagini/carteOro/co13.jpg");
				CartaOro co14 = new CartaOro(Color.GREEN, null, "vuoto", "vuoto", "vuoto", "foglia foglia foglia farfalla","2 Punti x angolo","/immagini/carteOro/co14.jpg");
				CartaOro co15 = new CartaOro(Color.GREEN, "vuoto", "vuoto", "vuoto", null, "foglia foglia foglia lupo","2 Punti x angolo","/immagini/carteOro/co15.jpg");
				CartaOro co16 = new CartaOro(Color.GREEN, "vuoto", null, "vuoto", "vuoto", "foglia foglia foglia fungo","2 Punti x angolo","/immagini/carteOro/co16.jpg");
				CartaOro co17 = new CartaOro(Color.GREEN, "vuoto", null, "piuma", null, "foglia foglia foglia","3 Punti","/immagini/carteOro/co17.jpg");
				CartaOro co18 = new CartaOro(Color.GREEN, "pergamena", "vuoto",  null, null, "foglia foglia foglia","3 Punti","/immagini/carteOro/co18.jpg");
				CartaOro co19 = new CartaOro(Color.GREEN, null, "bottiglia", null, "vuoto", "foglia foglia foglia","3 Punti","/immagini/carteOro/co19.jpg");
				CartaOro co20 = new CartaOro(Color.GREEN, "vuoto", "vuoto", null, null, "foglia foglia foglia foglia foglia","5 Punti","/immagini/carteOro/co20.jpg");
				
				CartaOro co21 = new CartaOro(Color.BLUE, "bottiglia", "vuoto", "vuoto", null, "lupo lupo farfalla","1 Punto x bottiglia","/immagini/carteOro/co21.jpg");
				CartaOro co22 = new CartaOro(Color.BLUE, null, "vuoto", "vuoto", "pergamena", "lupo lupo foglia", "1 Punto x pergamena","/immagini/carteOro/co22.jpg");
				CartaOro co23 = new CartaOro(Color.BLUE, "vuoto", null, "piuma", "vuoto", "lupo lupo fungo", "1 Punto per piuma","/immagini/carteOro/co23.jpg");
				CartaOro co24 = new CartaOro(Color.BLUE, "vuoto", "vuoto", null, "vuoto", "lupo lupo lupo farfalla", "2 Punti x angolo","/immagini/carteOro/co24.jpg");
				CartaOro co25 = new CartaOro(Color.BLUE, "vuoto", null, "vuoto", "vuoto", "lupo lupo lupo fungo", "2 Punti x angolo","/immagini/carteOro/co25.jpg");
				CartaOro co26 = new CartaOro(Color.BLUE, null, "vuoto", "vuoto", "vuoto", "lupo lupo lupo foglia", "2 Punti x angolo","/immagini/carteOro/co26.jpg");
				CartaOro co27 = new CartaOro(Color.BLUE, "vuoto", null, "pergamena", null, "lupo lupo lupo", "3 Punti","/immagini/carteOro/co27.jpg");
				CartaOro co28 = new CartaOro(Color.BLUE, "vuoto", "bottiglia", null, null, "lupo lupo lupo", "3 Punti","/immagini/carteOro/co28.jpg");
				CartaOro co29 = new CartaOro(Color.BLUE, null, "vuoto", null, "piuma", "lupo lupo lupo", "3 Punti","/immagini/carteOro/co29.jpg");
				CartaOro co30 = new CartaOro(Color.BLUE, null, "vuoto", null, "vuoto", "lupo lupo lupo lupo lupo", "5 Punti","/immagini/carteOro/co30.jpg");
				
				CartaOro co31 = new CartaOro(Color.MAGENTA, "vuoto", "piuma", null, "vuoto", "farfalla farfalla foglia", "1 Punto x piuma","/immagini/carteOro/co31.jpg");
				CartaOro co32 = new CartaOro(Color.MAGENTA, "vuoto", null, "pergamena", "vuoto", "farfalla farfalla lupo", "1 Punto per pergamena","/immagini/carteOro/co32.jpg");
				CartaOro co33 = new CartaOro(Color.MAGENTA, null, "vuoto", "vuoto", "bottiglia", "farfalla farfalla fungo", "1 Punto x bottiglia","/immagini/carteOro/co33.jpg");
				CartaOro co34 = new CartaOro(Color.MAGENTA, "vuoto", "vuoto", null, "vuoto", "farfalla farfalla farfalla lupo", "2 Punti x angolo","/immagini/carteOro/co34.jpg");
				CartaOro co35 = new CartaOro(Color.MAGENTA, "vuoto", "vuoto", "vuoto", null, "farfalla farfalla farfalla foglia", "2 Punti x angolo","/immagini/carteOro/co35.jpg");
				CartaOro co36 = new CartaOro(Color.MAGENTA, "vuoto", null, "vuoto", "vuoto", "farfalla farfalla farfalla fungo", "2 Punti x angolo","/immagini/carteOro/co36.jpg");
				CartaOro co37 = new CartaOro(Color.MAGENTA, "bottiglia", null, "vuoto", null, "farfalla farfalla farfalla", "3 Punti","/immagini/carteOro/co37.jpg");
				CartaOro co38 = new CartaOro(Color.MAGENTA, "vuoto", "pergamena", null, null, "farfalla farfalla farfalla", "3 Punti","/immagini/carteOro/co38.jpg");
				CartaOro co39 = new CartaOro(Color.MAGENTA, null, null, "piuma", "vuoto", "farfalla farfalla farfalla", "3 Punti","/immagini/carteOro/co39.jpg");
				CartaOro co40 = new CartaOro(Color.MAGENTA, "vuoto", "vuoto", null, null, "farfalla farfalla farfalla farfalla farfalla", "5 Punti","/immagini/carteOro/co40.jpg");
			        
			        
			    CartaIniziale ci1 = new CartaIniziale("ci1","fungo","foglia","farfalla","lupo","/immagini/carteIniziali/ci1.jpg");
			    CartaIniziale ci2 = new CartaIniziale("ci2", "fungo","lupo","foglia","farfalla","/immagini/carteIniziali/ci2.jpg");
			    CartaIniziale ci3 = new CartaIniziale("ci3", "farfalla","fungo","foglia","lupo","/immagini/carteIniziali/ci3.jpg");
			    CartaIniziale ci4 = new CartaIniziale("ci4", "foglia","farfalla","lupo","fungo","/immagini/carteIniziali/ci4.jpg");
			    CartaIniziale ci5 = new CartaIniziale("ci5", "farfalla","lupo","fungo","foglia","/immagini/carteIniziali/ci5.jpg");
			    CartaIniziale ci6 = new CartaIniziale("ci6", "foglia","lupo","fungo","farfalla","/immagini/carteIniziali/ci6.jpg");
			        
			        
			    CartaObiettivo cob1 = new CartaObiettivo("Diagonale dx di tre carte rosse", 2,"/immagini/carteObiettivo/cob1.jpg");
				CartaObiettivo cob2 = new CartaObiettivo("Diagonale sx di tre carte verdi", 2,"/immagini/carteObiettivo/cob2.jpg");
				CartaObiettivo cob3 = new CartaObiettivo("Diagonale dx di tre carte blu", 2,"/immagini/carteObiettivo/cob3.jpg");
				CartaObiettivo cob4 = new CartaObiettivo("Verticale di due carte verdi e diagonale in basso a sx di una carta magenta", 3,"/immagini/carteObiettivo/cob4.jpg");
				CartaObiettivo cob5 = new CartaObiettivo("Verticale di due carte rosse e diagonale in basso a dx di una carta blu", 3,"/immagini/carteObiettivo/cob5.jpg");
				CartaObiettivo cob6 = new CartaObiettivo("Diagonale sx di tre carte magenta", 2,"/immagini/carteObiettivo/cob6.jpg");
				CartaObiettivo cob7 = new CartaObiettivo("Verticale di due carte blu e diagonale in alto a dx di una carta rossa", 3,"/immagini/carteObiettivo/cob7.jpg");
				CartaObiettivo cob8 = new CartaObiettivo("Verticale di due carte magenta e diagonale in alto a sx di una carta blu", 3,"/immagini/carteObiettivo/cob8.jpg");
				CartaObiettivo cob9 = new CartaObiettivo("Tre funghi", 2,"/immagini/carteObiettivo/cob9.jpg");
				CartaObiettivo cob10 = new CartaObiettivo("Tre foglie", 2,"/immagini/carteObiettivo/cob10.jpg");
				CartaObiettivo cob11 = new CartaObiettivo("Tre lupi", 2,"/immagini/carteObiettivo/cob11.jpg");
				CartaObiettivo cob12 = new CartaObiettivo("Tre farfalle", 2,"/immagini/carteObiettivo/cob12.jpg");
				CartaObiettivo cob13 = new CartaObiettivo("Piuma, bottiglia e pergamena", 3,"/immagini/carteObiettivo/cob13.jpg");
				CartaObiettivo cob14 = new CartaObiettivo("Due pergamene", 3,"/immagini/carteObiettivo/cob14.jpg");
				CartaObiettivo cob15 = new CartaObiettivo("Due bottiglie", 3,"/immagini/carteObiettivo/cob15.jpg");
				CartaObiettivo cob16 = new CartaObiettivo("Due piume", 3,"/immagini/carteObiettivo/cob16.jpg");
				
			
			    
			
			mazzoRisorse = new ArrayList<CartaRisorsa>();
			
			
			
			mazzoRisorse.add(cr1);
			mazzoRisorse.add(cr2);
			mazzoRisorse.add(cr3);
			mazzoRisorse.add(cr4);
			mazzoRisorse.add(cr5);
			mazzoRisorse.add(cr6);
			mazzoRisorse.add(cr7);
			mazzoRisorse.add(cr8);
			mazzoRisorse.add(cr9);
			mazzoRisorse.add(cr10);
			mazzoRisorse.add(cr11);
			mazzoRisorse.add(cr12);
			mazzoRisorse.add(cr13);
			mazzoRisorse.add(cr14);
			mazzoRisorse.add(cr15);
			mazzoRisorse.add(cr16);
			mazzoRisorse.add(cr17);
			mazzoRisorse.add(cr18);
			mazzoRisorse.add(cr19);
			mazzoRisorse.add(cr20);
			mazzoRisorse.add(cr21);
			mazzoRisorse.add(cr22);
			mazzoRisorse.add(cr23);
			mazzoRisorse.add(cr24);
			mazzoRisorse.add(cr25);
			mazzoRisorse.add(cr26);
			mazzoRisorse.add(cr27);
			mazzoRisorse.add(cr28);
			mazzoRisorse.add(cr29);
			mazzoRisorse.add(cr30);
			mazzoRisorse.add(cr31);
			mazzoRisorse.add(cr32);
			mazzoRisorse.add(cr33);
			mazzoRisorse.add(cr34);
			mazzoRisorse.add(cr35);
			mazzoRisorse.add(cr36);
			mazzoRisorse.add(cr37);
			mazzoRisorse.add(cr38);
			mazzoRisorse.add(cr39);
			mazzoRisorse.add(cr40);
			
			
			
			mazzoOro = new ArrayList<CartaOro>();
			
		
			mazzoOro.add(co1);
			mazzoOro.add(co2);
			mazzoOro.add(co3);
			mazzoOro.add(co4);
			mazzoOro.add(co5);
			mazzoOro.add(co6);
			mazzoOro.add(co7);
			mazzoOro.add(co8);
			mazzoOro.add(co9);
			mazzoOro.add(co10);
			mazzoOro.add(co11);
			mazzoOro.add(co12);
			mazzoOro.add(co13);
			mazzoOro.add(co14);
			mazzoOro.add(co15);
			mazzoOro.add(co16);
			mazzoOro.add(co17);
			mazzoOro.add(co18);
			mazzoOro.add(co19);
			mazzoOro.add(co20);
			mazzoOro.add(co21);
			mazzoOro.add(co22);
			mazzoOro.add(co23);
			mazzoOro.add(co24);
			mazzoOro.add(co25);
			mazzoOro.add(co26);
			mazzoOro.add(co27);
			mazzoOro.add(co28);
			mazzoOro.add(co29);
			mazzoOro.add(co30);
			mazzoOro.add(co31);
			mazzoOro.add(co32);
			mazzoOro.add(co33);
			mazzoOro.add(co34);
			mazzoOro.add(co35);
			mazzoOro.add(co36);
			mazzoOro.add(co37);
			mazzoOro.add(co38);
			mazzoOro.add(co39);
			mazzoOro.add(co40);
			
			
			
			
			mazzoObiettivo = new ArrayList<CartaObiettivo>();
			
			
			mazzoObiettivo.add(cob1);
			mazzoObiettivo.add(cob2);
			mazzoObiettivo.add(cob3);
			mazzoObiettivo.add(cob4);
			mazzoObiettivo.add(cob5);
			mazzoObiettivo.add(cob6);
			mazzoObiettivo.add(cob7);
			mazzoObiettivo.add(cob8);
			mazzoObiettivo.add(cob9);
			mazzoObiettivo.add(cob10);
			mazzoObiettivo.add(cob11);
			mazzoObiettivo.add(cob12);
			mazzoObiettivo.add(cob13);
			mazzoObiettivo.add(cob14);
			mazzoObiettivo.add(cob15);
			mazzoObiettivo.add(cob16);
			
			
			
			mazzoIniziali = new ArrayList<CartaIniziale>();
			
			
			mazzoIniziali.add(ci1);
			mazzoIniziali.add(ci2);
			mazzoIniziali.add(ci3);
			mazzoIniziali.add(ci4);
			mazzoIniziali.add(ci5);
			mazzoIniziali.add(ci6);
			
			}

	public ArrayList<CartaRisorsa> getMazzoRisorse() {
		return (ArrayList<CartaRisorsa>) mazzoRisorse;
	}

	public Giocatore[] getGamers() {
		return gamers;
	}

	public ArrayList<CartaIniziale> getMazzoIniziali() {
		return (ArrayList<CartaIniziale>) mazzoIniziali;
	}

	public ArrayList<CartaOro> getMazzoOro() {
		return (ArrayList<CartaOro>) mazzoOro;
	}

	public ArrayList<CartaObiettivo> getMazzoObiettivo() {
		return (ArrayList<CartaObiettivo>) mazzoObiettivo;
	}
	
	

}