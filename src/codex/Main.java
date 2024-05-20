package codex;
import java.util.Scanner;			
import javax.swing.*;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;


public class Main {

	public static int numGiocatori;
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		do
		{
			try
			{
				System.out.println("Quante persone giocano? (Min: 2 - Max: 4) ");
				numGiocatori = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Errore: per favore inserisci un numero tra 2 e 4.");
                sc.nextLine();
			}
			
		}while(numGiocatori<2 || numGiocatori>4);
		
		Tavolo t = new Tavolo();

		Assegnazione a = new Assegnazione(t);
		
		
		
		
		
}
	
}
