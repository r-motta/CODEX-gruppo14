import java.util.Scanner;	
import javax.swing.*;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;


public class Main {

	public static int numGiocatori;
	
	private Giocatore gamers[] = new Giocatore[numGiocatori];

	public static void main(String[] args) {

		public static Carta nextCarta(Carta[] mazzo) {
	        // Generazione casuale di un indice
	        Random random = new Random();
	        int indiceCasuale = random.nextInt(mazzo.length);

	        // Restituisci la carta corrispondente all'indice casuale
	        return mazzo[indiceCasuale];
	    }

		
			CartaRisorsa cr1 = new CartaRisorsa(Color.RED, "fungo", "vuoto", "fungo", null, 0, "https://drive.google.com/file/d/1P_3Tllh30W6Jax1v58YJPEDhSmAubbsz/view");
			CartaRisorsa cr2 = new CartaRisorsa(Color.RED, "fungo", "fungo", null , "vuoto", 0, "https://drive.google.com/file/d/1noZZi_qI3I8iR33NHl_eUqcHjAqnNaSV/view");
			CartaRisorsa cr3 = new CartaRisorsa(Color.RED, "vuoto", null, "fungo", "fungo", 0, "https://drive.google.com/file/d/1SWYdH1900PRY2sE48pDxsLyVrxsuUz6M/view");
			CartaRisorsa cr4 = new CartaRisorsa(Color.RED, null, "fungo", "vuoto", "fungo", 0, "https://drive.google.com/file/d/1vGBJZrAjJ3EKTSAaztmEzZY7cEDfKCNe/view");
			CartaRisorsa cr5 = new CartaRisorsa(Color.RED, null, "piuma", "foglia", "fungo", 0, "https://drive.google.com/file/d/1tbnoy5YKhtpgsVjTGbTNTi6UplgMRFuX/view");
			CartaRisorsa cr6 = new CartaRisorsa(Color.RED, "bottiglia", "fungo", null, "lupo", 0, "https://drive.google.com/file/d/1Cywntb1qpLQhOfzNP4GCbgvz286wIkOI/view");
			CartaRisorsa cr7 = new CartaRisorsa(Color.RED, "fungo", "farfalla", "pergamena", null, 0, "https://drive.google.com/file/d/1qsbhYpMMXCkuV--uX4l5VcSruXOohYCT/view");
			CartaRisorsa cr8 = new CartaRisorsa(Color.RED, "vuoto", "fungo", "vuoto", null, 1, "https://drive.google.com/file/d/1P_GgOcgstqP9fn0M-EPUVd7_yrFiiylv/view");
			CartaRisorsa cr9 = new CartaRisorsa(Color.RED, "fungo", null, "vuoto", "vuoto", 1, "https://drive.google.com/file/d/1_RecsmzelsIPNruSdBsKf1W9ll0z0Zek/view");
			CartaRisorsa cr10 = new CartaRisorsa(Color.RED, null, "vuoto", "fungo", "vuoto", 1, "https://drive.google.com/file/d/1aH5DU6bBJbK-T5-31Ms3zsiKDpHhcGhT/view");
			CartaRisorsa cr11 = new CartaRisorsa(Color.GREEN, "foglia", "vuoto", "foglia", null, 0, "https://drive.google.com/file/d/1b26w1kKjcVetvgsFfPE2pudHUaWVMsWx/view");
			CartaRisorsa cr12 = new CartaRisorsa(Color.GREEN, "foglia", "foglia", null, "vuoto", 0, "https://drive.google.com/file/d/1uwHYLq5d7PXEC3my25_VFl_ifTj_vfMf/view");
			CartaRisorsa cr13 = new CartaRisorsa(Color.GREEN, "vuoto", null, "foglia", "foglia", 0, "https://drive.google.com/file/d/17YWeVb4bVS9Cq0yC83evZMVq_vS9xbLQ/view");
			CartaRisorsa cr14 = new CartaRisorsa(Color.GREEN, null, "foglia", "vuoto", "foglia", 0, "https://drive.google.com/file/d/1CJPTof9KvBohldXbxBC4P1GAcOyhS3ED/view");
			CartaRisorsa cr15 = new CartaRisorsa(Color.GREEN, null, "farfalla", "piuma", "foglia", 0, "https://drive.google.com/file/d/1O1TypZWUHB3b897-OyK7P3bjpmHUDtQj/view");
			CartaRisorsa cr16 = new CartaRisorsa(Color.GREEN, "fungo", "foglia", null, "bottiglia", 0, "https://drive.google.com/file/d/19d9OO-MVQH5ID_d30Pc13UtY3hIf8zmm/view");
			CartaRisorsa cr17 = new CartaRisorsa(Color.GREEN, "pergamena", null, "foglia", "lupo", 0, "https://drive.google.com/file/d/1tGWT2e7pxNYtTBAtoNnH9ErLy0ITwDwX/view");
			CartaRisorsa cr18 = new CartaRisorsa(Color.GREEN, "vuoto", "vuoto", "foglia", null, 1, "https://drive.google.com/file/d/17MkJhL4WmDqrUrD1lM7cOCuqlK_01eau/view");
			CartaRisorsa cr19 = new CartaRisorsa(Color.GREEN, "vuoto", "vuoto", null, "foglia", 1, "https://drive.google.com/file/d/1grrFFGxOE8vHNgxkrRCL06bygpVi9Z8J/view");
			CartaRisorsa cr20 = new CartaRisorsa(Color.GREEN, null, "foglia", "vuoto", "vuoto", 1, "https://drive.google.com/file/d/1yumhXwzZGF_FVkDuu11mcMkADRx67PV3/view");
			CartaRisorsa cr21 = new CartaRisorsa(Color.BLUE, "lupo", "lupo", "vuoto", null, 0, "https://drive.google.com/file/d/1w4B1j1LGX1byRjabkfXQYwaivFaKgAWz/view");
			CartaRisorsa cr22 = new CartaRisorsa(Color.BLUE, null, "vuoto", "lupo", "lupo", 0, "https://drive.google.com/file/d/1oljNa3UTWSFojHS1irjq-Zbw46Oc4P06/view");
			CartaRisorsa cr23 = new CartaRisorsa(Color.BLUE, "lupo", null, "lupo", "vuoto", 0, "https://drive.google.com/file/d/1KsjPP2wATALtR3dJUrIMkug-1un84OJg/view");
			CartaRisorsa cr24 = new CartaRisorsa(Color.BLUE, "vuoto", "lupo", null, "lupo", 0, "https://drive.google.com/file/d/1qDrOypyiTuE15C_8O0NIsTUI4csi5agn/view");
			CartaRisorsa cr25 = new CartaRisorsa(Color.BLUE, null, "farfalla", "bottiglia", "lupo", 0, "https://drive.google.com/file/d/1OodZHoTgwdLv1CsJOAN6g4LiJhxMmDw7/view");
			CartaRisorsa cr26 = new CartaRisorsa(Color.BLUE, "foglia", "lupo", null, "pergamena", 0, "https://drive.google.com/file/d/1gT4tZZte-O7QC2Zen37HY36hUTS9Cao9/view");
			CartaRisorsa cr27 = new CartaRisorsa(Color.BLUE, "piuma", null, "lupo", "fungo", 0, "https://drive.google.com/file/d/1cbH8LQS6m1Lo0oMHqlB0TZbLvCPGyljk/view");
			CartaRisorsa cr28 = new CartaRisorsa(Color.BLUE, null, "vuoto", "lupo", "vuoto", 1, "https://drive.google.com/file/d/1l9dTbLC3IVB26OZb5DfabZenQHJGRR7W/view");
			CartaRisorsa cr29 = new CartaRisorsa(Color.BLUE, "vuoto", null, "vuoto", "lupo", 1, "https://drive.google.com/file/d/14_tcmcvAlYmlH1FIgUh3mvBkdZhf9FoJ/view");
			CartaRisorsa cr30 = new CartaRisorsa(Color.BLUE, "vuoto", "lupo", "vuoto", null, 1, "https://drive.google.com/file/d/1HA75WIz3vuZGE-bt2c8qYHlKm91y_g8m/view");
			CartaRisorsa cr31 = new CartaRisorsa(Color.MAGENTA, "farfalla", "farfalla", "vuoto", null, 0, "https://drive.google.com/file/d/1EBhqlCun8TnpNV6ubA_wdnQ8W_zQDI_G/view");
			CartaRisorsa cr32 = new CartaRisorsa(Color.MAGENTA, null, "vuoto", "farfalla", "farfalla", 0, "https://drive.google.com/file/d/1pfXzezEEpTBlVEBUgwcbh0zT8Q6etrru/view");
			CartaRisorsa cr33 = new CartaRisorsa(Color.MAGENTA, "farfalla", null, "farfalla", "vuoto", 0, "https://drive.google.com/file/d/1GSMxopBjzpR7yfQPfTrYbsfUavDw4f5y/view");
			CartaRisorsa cr34 = new CartaRisorsa(Color.MAGENTA, "vuoto", "farfalla", null, "farfalla", 0, "https://drive.google.com/file/d/1U9IVB5Ahl692NUud_VZ7b5aOUkJzCM0m/view");
			CartaRisorsa cr35 = new CartaRisorsa(Color.MAGENTA, null, "piuma", "lupo", "farfalla", 0, "https://drive.google.com/file/d/1bmz3I9np648g27yPnR_ahAZG9qy3gkpF/view");
			CartaRisorsa cr36 = new CartaRisorsa(Color.MAGENTA,  "pergamena", "farfalla", null, "fungo", 0, "https://drive.google.com/file/d/1bnUWCz-RpRpX3C61yrXICVob2Oq8nWdv/view");
			CartaRisorsa cr37 = new CartaRisorsa(Color.MAGENTA, "farfalla", "foglia", "bottiglia", null, 0, "https://drive.google.com/file/d/1U9L5GgG7naErSwKfsGeQ7x7NyCzlEUbd/view");
			CartaRisorsa cr38 = new CartaRisorsa(Color.MAGENTA, "farfalla", "lupo", "lupo", null, 1, "https://drive.google.com/file/d/1wksZ8Us2txsMcy2zntzqnYHPxYaD2ogy/view");
			CartaRisorsa cr39 = new CartaRisorsa(Color.MAGENTA, "vuoto", "vuoto", null, "farfalla", 1, "https://drive.google.com/file/d/1Mh4zqx9Jeh3IqZ-xhsrv7yaz5RpPzdi8/view");
			CartaRisorsa cr40 = new CartaRisorsa(Color.MAGENTA, null, "farfalla", "vuoto", "vuoto", 1, "https://drive.google.com/file/d/1deY2KYf-z-EcZMu8FjaU3Qkyz2Uwj_ju/view");
	

		// colore, asx, adx, bsx, bdx, requisiti, punteggio, url
		//
				CartaOro co1 = new CartaOro(Color.RED, null, "vuoto", "vuoto", "piuma", "fungo fungo lupo", 1, "");
				CartaOro co2 = new CartaOro(Color.RED, "vuoto", "bottiglia", null, "vuoto", "fungo fungo pianta", 1, "");
                CartaOro co3 = new CartaOro(Color.RED, "pergamena", "vuoto", "vuoto", null, "fungo fungo farfalla", 1, "");
                CartaOro co4 = new CartaOro(Color.RED, "vuoto", "vuoto", null, "vuoto", "fungo fungo fungo lupo", 2, "");
                CartaOro co5 = new CartaOro(Color.RED, "vuoto", "vuoto", "vuoto", null, "fungo fungo fungo pianta", 2, "");
                CartaOro co6 = new CartaOro(Color.RED, "vuoto", null, "vuoto", "vuoto", "fungo fungo fungo farfalla", 2, "");
                CartaOro co7 = new CartaOro(Color.RED, "vuoto", null, "bottiglia", null, "fungo fungo fungo", 3, "");
                CartaOro co8 = new CartaOro(Color.RED, "piuma", "vuoto", null, null, "fungo fungo fungo", 3, "");
                CartaOro co9 = new CartaOro(Color.RED, null, "pergamena", null, "vuoto", "fungo fungo fungo", 3, "");
                CartaOro co10 = new CartaOro(Color.RED, "vuoto", null, "vuoto", null, "fungo fungo fungo fungo fungo", 5, "");
                CartaOro co11 = new CartaOro(Color.GREEN, "piuma", "vuoto", "vuoto", null, "pianta pianta farfalla", 1, "");
                CartaOro co12 = new CartaOro(Color.GREEN, "vuoto", "pergamena", null, "vuoto", "pianta pianta fungo", 1, "");
                CartaOro co13 = new CartaOro(Color.GREEN, "vuoto", null, "bottiglia", "vuoto", "pianta pianta lupo", 1, "");
                CartaOro co14 = new CartaOro(Color.GREEN, null, "vuoto", "vuoto", "vuoto", "pianta pianta pianta farfalla", 2, "");
                CartaOro co15 = new CartaOro(Color.GREEN, "vuoto", "vuoto", "vuoto", null, "pianta pianta pianta lupo", 2, "");
                CartaOro co16 = new CartaOro(Color.GREEN, "vuoto", null, "vuoto", "vuoto", "pianta pianta pianta fungo", 2, "");
                CartaOro co17 = new CartaOro(Color.GREEN, "vuoto", null, "piuma", null, "pianta pianta pianta ", 3, "");
                CartaOro co18 = new CartaOro(Color.GREEN, "pergamena", "vuoto",  null, null, "pianta pianta pianta ", 3, "");
                CartaOro co19 = new CartaOro(Color.GREEN, null, "bottiglia", null, "vuoto", "pianta pianta pianta ", 3, "");
                CartaOro co20 = new CartaOro(Color.GREEN, "vuoto", "vuoto", null, null, "pianta pianta pianta pianta pianta", 5, "");
                CartaOro co21 = new CartaOro(Color.BLUE, "bottiglia", "vuoto", "vuoto", "piuma", "fungo fungo farfalla", 1, "");
                CartaOro co22 = new CartaOro(Color.BLUE, null, "vuoto", "vuoto", null, "lupo lupo farfalla", 1, "");
                CartaOro co23 = new CartaOro(Color.BLUE, null, "vuoto", "vuoto", "pergamena", "lupo lupo pianta", 1, "");
                CartaOro co24 = new CartaOro(Color.BLUE, "vuoto", null, "piuma", "vuoto", "lupo lupo fungo", 1, "");
                CartaOro co25 = new CartaOro(Color.BLUE, "vuoto", "vuoto", null, "vuoto", "lupo lupo lupo farfalla", 2, "");
                CartaOro co26 = new CartaOro(Color.BLUE, "vuoto", null, "vuoto", "vuoto", "lupo lupo lupo fungo", 2, "");
                CartaOro co27 = new CartaOro(Color.BLUE, null, "vuoto", "vuoto", "vuoto", "lupo lupo lupo pianta", 2, "");
                CartaOro co28 = new CartaOro(Color.BLUE, "vuoto", null, "pergamena", null, "lupo lupo lupo", 3, "");
                CartaOro co29 = new CartaOro(Color.BLUE, "vuoto", "bottiglia", null, null, "lupo lupo lupo", 3, "");
                CartaOro co30 = new CartaOro(Color.BLUE, null, "vuoto", null, "piuma", "lupo lupo lupo", 3, "");
                CartaOro co31 = new CartaOro(Color.MAGENTA, null, "vuoto", null, "vuoto", "lupo lupo lupo lupo lupo", 5, "");
                CartaOro co32 = new CartaOro(Color.MAGENTA, null, "vuoto", "vuoto", "piuma", "fungo fungo farfalla", 1, "");
                CartaOro co33 = new CartaOro(Color.MAGENTA, null, "vuoto", "vuoto", "piuma", "fungo fungo farfalla", 1, "");
                CartaOro co34 = new CartaOro(Color.MAGENTA, null, "vuoto", "vuoto", "piuma", "fungo fungo farfalla", 1, "");
                CartaOro co35 = new CartaOro(Color.MAGENTA, null, "vuoto", "vuoto", "piuma", "fungo fungo farfalla", 1, "");
                CartaOro co36 = new CartaOro(Color.MAGENTA, null, "vuoto", "vuoto", "piuma", "fungo fungo farfalla", 1, "");
                CartaOro co37 = new CartaOro(Color.MAGENTA, null, "vuoto", "vuoto", "piuma", "fungo fungo farfalla", 1, "");
                CartaOro co38 = new CartaOro(Color.MAGENTA, null, "vuoto", "vuoto", "piuma", "fungo fungo farfalla", 1, "");
                CartaOro co39 = new CartaOro(Color.MAGENTA, null, "vuoto", "vuoto", "piuma", "fungo fungo farfalla", 1, "");
                CartaOro co40 = new CartaOro(Color.MAGENTA, null, "vuoto", "vuoto", "piuma", "fungo fungo farfalla", 1, "");
                
                
                CartaIniziale ci1 = new CartaIniziale("fungo","foglia","farfalla","lupo");
                CartaIniziale ci2 = new CartaIniziale("fungo","lupo","foglia","farfalla");
                CartaIniziale ci3 = new CartaIniziale("farfalla","fungo","foglia","lupo");
                CartaIniziale ci4 = new CartaIniziale("foglia","farfalla","lupo","fungo");
                CartaIniziale ci5 = new CartaIniziale("farfalla","lupo","fungo","foglia");
                CartaIniziale ci6 = new CartaIniziale("foglia","lupo","fungo","farfalla");
               
		
		CartaRisorsa mazzoRisorse[] = new CartaRisorsa[40];
		
		mazzoRisorse[0] = cr1;
		mazzoRisorse[1] = cr2;
		mazzoRisorse[2] = cr3;
		mazzoRisorse[3] = cr4;
		mazzoRisorse[4] = cr5;
		mazzoRisorse[5] = cr6;
		mazzoRisorse[6] = cr7;
		mazzoRisorse[7] = cr8;
		mazzoRisorse[8] = cr9;
		mazzoRisorse[9] = cr10;
		mazzoRisorse[10] = cr11;
		mazzoRisorse[11] = cr12;
		mazzoRisorse[12] = cr13;
		mazzoRisorse[13] = cr14;
		mazzoRisorse[14] = cr15;
		mazzoRisorse[15] = cr16;
		mazzoRisorse[16] = cr17;
		mazzoRisorse[17] = cr18;
		mazzoRisorse[18] = cr19;
		mazzoRisorse[19] = cr20;
		mazzoRisorse[20] = cr21;
		mazzoRisorse[21] = cr22;
		mazzoRisorse[22] = cr23;
		mazzoRisorse[23] = cr24;
		mazzoRisorse[24] = cr25;
		mazzoRisorse[25] = cr26;
		mazzoRisorse[26] = cr27;
		mazzoRisorse[27] = cr28;
		mazzoRisorse[28] = cr29;
		mazzoRisorse[29] = cr30;
		mazzoRisorse[30] = cr31;
		mazzoRisorse[31] = cr32;
		mazzoRisorse[32] = cr33;
		mazzoRisorse[33] = cr34;
		mazzoRisorse[34] = cr35;
		mazzoRisorse[35] = cr36;
		mazzoRisorse[36] = cr37;
		mazzoRisorse[37] = cr38;
		mazzoRisorse[38] = cr39;
		mazzoRisorse[39] = cr40;
		
		CartaOro mazzoOro[] = new CartaOro[40];

		mazzoOro[40] = co1;
		mazzoOro[41] = co2;
		mazzoOro[42] = co3;
		mazzoOro[43] = co4;
		mazzoOro[44] = co5;
		mazzoOro[45] = co6;
		mazzoOro[46] = co7;
		mazzoOro[47] = co8;
		mazzoOro[48] = co9;
		mazzoOro[49] = co10;
		mazzoOro[50] = co11;
		mazzoOro[51] = co12;
		mazzoOro[52] = co13;
		mazzoOro[53] = co14;
		mazzoOro[54] = co15;
		mazzoOro[55] = co16;
		mazzoOro[56] = co17;
		mazzoOro[57] = co18;
		mazzoOro[58] = co19;
		mazzoOro[59] = co20;
		mazzoOro[60] = co21;
		mazzoOro[61] = co22;
		mazzoOro[62] = co23;
		mazzoOro[63] = co24;
		mazzoOro[64] = co25;
		mazzoOro[65] = co26;
		mazzoOro[66] = co27;
		mazzoOro[67] = co28;
		mazzoOro[68] = co29;
		mazzoOro[69] = co30;
		mazzoOro[70] = co31;
		mazzoOro[71] = co32;
		mazzoOro[72] = co33;
		mazzoOro[73] = co34;
		mazzoOro[74] = co35;
		mazzoOro[75] = co36;
		mazzoOro[76] = co37;
		mazzoOro[77] = co38;
		mazzoOro[78] = co39;
		mazzoOro[79] = co40;
		
		
		
		
		ArrayList<CartaObiettivo> mazzoObiettivo = new ArrayList<CartaObiettivo>();
		
		
		
		CartaObiettivo cob1 = new CartaObiettivo();
		CartaObiettivo cob2 = new CartaObiettivo();
		CartaObiettivo cob3 = new CartaObiettivo();
		CartaObiettivo cob4 = new CartaObiettivo();
		CartaObiettivo cob5 = new CartaObiettivo();
		CartaObiettivo cob6 = new CartaObiettivo();
		CartaObiettivo cob7 = new CartaObiettivo();
		CartaObiettivo cob8 = new CartaObiettivo();
		CartaObiettivo cob9 = new CartaObiettivo();
		CartaObiettivo cob10 = new CartaObiettivo();
		CartaObiettivo cob11 = new CartaObiettivo();
		CartaObiettivo cob12 = new CartaObiettivo();
		CartaObiettivo cob13 = new CartaObiettivo();
		CartaObiettivo cob14 = new CartaObiettivo();
		CartaObiettivo cob15 = new CartaObiettivo();
		CartaObiettivo cob16 = new CartaObiettivo();
		
		
		
		
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
		
		
		
		Carta CarteDaPescare[] = new Carta[4];

		
		Scanner sc = new Scanner(System.in);
		
		
		do
		{
			System.out.println("Quante persone giocano? (Min: 2 - Max: 4) ");
			numGiocatori = sc.nextInt();
		}while(numGiocatori<2 || numGiocatori>4);


		System.out.println("Inserite i vostri nickname: ");
		System.out.println("(L'ordine dei giocatori in partita sar� uguale a come vi inserirete adesso)");
		
		for(int i=0;i<numGiocatori;i++)
		{
			System.out.println("Giocatore "+(i+1)+": ");
			gamers[i] = new Giocatore(sc.next());
			
		}
		
		Random random = new Random();
			
			
			
			ArrayList<CartaIniziale> MazzoCarteIniziali = new ArrayList<CartaIniziale>();
			
			
			
			MazzoCarteIniziali.add(ci1);
			MazzoCarteIniziali.add(ci2);
			MazzoCarteIniziali.add(ci3);
			MazzoCarteIniziali.add(ci4);
			MazzoCarteIniziali.add(ci5);
			MazzoCarteIniziali.add(ci6);
			
			MazzoCarteIniziale.shuffle();
			
			
			//assegnazione delle carte inziali
			for(int i=0;i<numGiocatori;i++)
			
			{
				
					int j=0;
					
					gamers[i].setCartaInizialePropria(MazzoCarteIniziali.get(j));
					
					j++;		 
			    
			//per le carte ore bisogna utilizzare il remove() qua non lo abbiamo fatto perhchè il giocatore interessa questo mazzo una sola volta
			   
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			mazzoObiettivo.shuffle();
			
			//assegnazione delle carte OBIETTIVO
			for(int i=0;i<numGiocatori;i++)
			{
					int j=0,k=0;
					
					int scelta=0;
					
					switch(scelta)
					{
					case 1:
					{
						break;
					}
					
					case 2:
					{
						break;
					}
					
					
					}
					
					gamers[i].
					
					j++;		  
				
			}

	

			
			System.out.println("Quale carta obiettivo vuoi usare? ");
			System.out.println("[1] Prima carta ");
			System.out.println("[2] Seconda carta ");
			scelta1 = sc.nextInt();
		
			switch(scelta1)
			{
				case 1: 
				{
					//getPuntatore
					//guarda codice discord 22/04 15:24
					System.out.println("Vuoi usare il fronte o il retro? ");
					System.out.println("[1] fronte ");
					System.out.println("[2] retro ");
					scelta2 = sc.nextInt();
					
					switch(scelta2)
					{
						
						case 3:
						{
							
						}
						case 4:
						{
							case1.useRetro();
						}
					}
				}
				case 2:
				{
					
				}
			
			}
		}
		

		//Frame f1 = new Frame();
		
		
}