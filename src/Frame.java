import javax.imageio.ImageIO;	
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.*;

public class Frame extends JFrame{
	
	private JPanel currentPanel;
	private JButton buttonGioca;
	private JButton buttonRegole;
	private JButton buttonEsci;
	private JLabel titolo;

	public Frame() {
	       
		super(" CODEX NATURALIS ");
		
		setSize(1200,800); //dare una dimensione alla finestra di 800 di larghezza e 500 di altezza
		
		setLocationRelativeTo(null); //centrare la finestra
		
		setResizable(false); // non permette di modellare la finestra con le freccette
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // termina l'esecuzione del programma quando chiudo la finestra
		
		setLayout(new BorderLayout()); //imposta il layout manager. Questo tipo, in particolare, suddivide
										// la finestra in NORD, SUD, EST, OVEST, CENTRO
		
		
		
		  
		
		
		buttonGioca = new JButton("Gioca");
		buttonRegole = new JButton("Regole");
		buttonEsci = new JButton("Esci");
		titolo = new JLabel("CODEX");
		
		
		add(titolo, BorderLayout.PAGE_START);
		//add(buttonGioca, BorderLayout.NORTH);
		//add(buttonRegole, BorderLayout.CENTER);
		//add(buttonEsci, BorderLayout.SOUTH);
		
		
		setVisible(true); // rende visibile tutte le modifiche che abbiamo fatto prima
							// messo alla fine perché coisì fa vedere tutte le modifiche;
		
	

	}
	
}