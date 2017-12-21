
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class ModulErfassen extends JFrame {
	
	protected static final int INFORMATION_MESSAGE = 0;
	private JTextField id;
	private JTextField kuerzel;
	private JTextField bezeichnung;

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ModulErfassen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonErfassen.class.getResource("/Bilder/FFHS_logo.png")));
		setTitle("Modul erfassen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 450);

	/*
	 * Menue bar mit Verlinkungen zu anderen Menuepunkten	
	 */
		
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu mnErfassung = new JMenu("Erfassung");
	menuBar.add(mnErfassung);
	
	JMenuItem mntmModulErfassen = new JMenuItem("Modul erfassen");
	mntmModulErfassen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			ModulErfassen ModErf = new ModulErfassen();
			ModErf.setVisible(true);
		}
	});
	mntmModulErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/internet-education-graduation_small.png")));
	mntmModulErfassen.setEnabled(false);
	mnErfassung.add(mntmModulErfassen);
	
	JSeparator separator = new JSeparator();
	mnErfassung.add(separator);
	
	JMenuItem mntmPersonErfassen = new JMenuItem("Person erfassen");
	mntmPersonErfassen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			PersonErfassen PersErf = new PersonErfassen();
			PersErf.setVisible(true);
		}
	});
	mntmPersonErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/online-student_small.png")));
	mntmPersonErfassen.setSelectedIcon(null);
	mntmPersonErfassen.setSelected(true);
	mnErfassung.add(mntmPersonErfassen);
	
	JMenuItem mntmLiteraturErfassen = new JMenuItem("Literatur erfassen");
	mntmLiteraturErfassen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			LiteraturErfassen LitErf = new LiteraturErfassen();
			LitErf.setVisible(true);
		}
	});
	mntmLiteraturErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/books-stack_small.png")));
	mnErfassung.add(mntmLiteraturErfassen);
	
	JMenu mnZuweisung = new JMenu("Zuweisung");
	menuBar.add(mnZuweisung);
	
	JMenuItem mntmPersonZuModul = new JMenuItem("Person zu Modul zuweisen");
	mntmPersonZuModul.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			PersonModulzuweisen PMz = new PersonModulzuweisen();
			PMz.setVisible(true);
		}
	});	
	mntmPersonZuModul.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/classroom_small.png")));
	mnZuweisung.add(mntmPersonZuModul);
	
	JMenuItem mntmLiteraturZuModul = new JMenuItem("Literatur zu Modul zuweisen");
	mntmLiteraturZuModul.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			LiteraturModulzuweisen lMz = new LiteraturModulzuweisen();
			lMz.setVisible(true);
		}
	});
	mntmLiteraturZuModul.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/study_small.png")));
	mnZuweisung.add(mntmLiteraturZuModul);
	
	JMenu mnAuswertung = new JMenu("Auswertung");
	menuBar.add(mnAuswertung);
	
	JMenuItem mntmAuswertungLitBestellen = new JMenuItem("F\u00E4llige Literaturbestellungen");
	mntmAuswertungLitBestellen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			AuswertungLitBestellen lBs = new AuswertungLitBestellen();
			lBs.setVisible(true);
		}
	});
	mntmAuswertungLitBestellen.setSelectedIcon(new ImageIcon(PersonErfassen.class.getResource("/Bilder/books-stack.png")));
	mntmAuswertungLitBestellen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/schedule_small.png")));
	mnAuswertung.add(mntmAuswertungLitBestellen);
	
	JMenuItem mntmHelp = new JMenuItem("Help");
	mntmHelp.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (Desktop.isDesktopSupported()) {
	            try {
	            	ClassLoader classLoader = getClass().getClassLoader();
	            	File myFile = new File(classLoader.getResource("PA_5_kickoff_ZH_alles_2017_V02.pdf").getFile());
	                Desktop.getDesktop().open(myFile);
	            } catch (IOException ex) {
	                // no application registered for PDFs
	            }
	        }
		}
	});
	mntmHelp.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/question-mark_small.png")));
	menuBar.add(mntmHelp);
	
	
	
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[][200,grow][][]", "[][][][][][][][][]"));
	
	/*
	 * Titel der Seite
	 */
	
	JLabel lblTitel = new JLabel("Modul erfassen");
	lblTitel.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/internet-education-graduation.png")));
	lblTitel.setFont(new Font("Tahoma", Font.BOLD, 24));
	contentPane.add(lblTitel, "cell 0 0 2 1,grow");
	
	/*
	 * Modul ID Feld wird erst in der DB vergeben
	 */
	
	JLabel lblId = new JLabel("ID");
	contentPane.add(lblId, "cell 0 2");
	
	id = new JTextField();
	id.setEnabled(false);
	id.setColumns(50);
	id.setBackground(new Color(204, 204, 204));
	contentPane.add(id, "cell 1 2");

	/*
	 * Feld fuer Eingabe des Modul Kuerzels
	 */
	
	JLabel lblKuerzel = new JLabel("K\u00FCrzel *");
	contentPane.add(lblKuerzel, "cell 0 3");
	
	kuerzel = new JTextField();
	kuerzel.setColumns(50);
	kuerzel.setBackground(Color.WHITE);
	contentPane.add(kuerzel, "cell 1 3");
	
	/*
	 * Feld fuer Eingabe der Modul Bezeichnung
	 */
	
	JLabel lblBezeichnung = new JLabel("Bezeichnung *");
	contentPane.add(lblBezeichnung, "cell 0 4");
	
	bezeichnung = new JTextField();
	bezeichnung.setColumns(50);
	bezeichnung.setBackground(Color.WHITE);
	contentPane.add(bezeichnung, "cell 1 4 3 1,growx");

	/*
	 * Speichern Button
	 */
	JButton btnSpeichern = new JButton("Speichern");
	btnSpeichern.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				addModulToDb();
			} catch (SQLException e) {
			}
		}
	});
	
	
	/*
	 * Modulliste aus dem Internet im Standardbrowser aufrufen
	 */
	
	JButton btnModullisteOnlineAbrufen = new JButton("Modulliste online abrufen");
	btnModullisteOnlineAbrufen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			    try {
			        Desktop.getDesktop().browse(new URL("https://moodle.ffhs.ch/course/view.php?id=3").toURI());
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
		}
	});
	btnModullisteOnlineAbrufen.setFocusPainted(false);
	btnModullisteOnlineAbrufen.setSelectedIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/FFHS_logo.png")));
	btnModullisteOnlineAbrufen.setIcon(null);
	contentPane.add(btnModullisteOnlineAbrufen, "cell 1 6");
	contentPane.add(btnSpeichern, "flowx,cell 1 8,alignx left,aligny center");

	
	/*
	 * Abbrechen Button
	 */
	JButton btnAbbrechen = new JButton("Abbrechen");
	btnAbbrechen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		}
	});
	contentPane.add(btnAbbrechen, "cell 1 8,alignx right,aligny center");
	
	JLabel label = new JLabel("* Mussfelder");
	contentPane.add(label, "cell 2 8 2 1");
	
	}
	
	/*
	 * Füge die im GUI eingegebenen Daten in die Datenbank hinzu. 
	 * @author Halil Koca
	 * @version 1.0
	 * @param 
	 * @return
	 */
	private void addModulToDb () throws SQLException  {
		
		// Daten auslesen
			String kuerzel_ = kuerzel.getText();
			String bezeichnung_ = bezeichnung.getText();
		
		// Verbindung mit Datenbank herstellen (online)
			String url = "jdbc:mysql://bohemia.mysql.database.azure.com:3306/bohemia?autoReconnect=true&useSSL=false"; 
	        String username = "myadmin@bohemia"; // DB-Benutzername
	        String password = "Bohemia2017"; // DB-Passwort	         
	        
	        // Überprüfe, ob DB Benutzername und Passwort mitgegeben werden! 
	        	if (username == "" || password == "") {
	        		JOptionPane.showMessageDialog(null, "Datenbank Username oder Passwort fehlt.");
	        		return;
	        	}
	        	
	        // Überprüfe, ob die Mussfelder ausgefüllt wurden
	        	if (kuerzel.getText().equals("") || bezeichnung.getText().equals("")){
	        		JOptionPane.showMessageDialog(null, "Modul konnten nicht gespeichert werdem. Bitte alle Mussfelder ausfüllen.");
	        		return;
	        	}
	        	
	        	try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        		//Erstelle neues Statement
	        		Statement st = connection.createStatement();
	        		// Aufbau SQL-Befehl
		        		try { 
		        			st.executeUpdate("INSERT INTO modul (kuerzel, modul) VALUES ('"+ kuerzel_ +"', '"+ bezeichnung_ + "')");
		        			JOptionPane.showMessageDialog(null, "Modul: " + bezeichnung_ + " wurde erfolgreich erfasst.");
		        			kuerzel.setText("");
		        			bezeichnung.setText("");
		        		}
		        		catch (SQLException e) {
		        			String error = e.getLocalizedMessage();
		        			JOptionPane.showMessageDialog(null, error);
		        		}
	        	
	        	}
	        
	        	catch (SQLException e) {
	        		JOptionPane.showMessageDialog(null, "Verbindung zur Datenbank ist fehlgeschlagen!");
	        	}
	}
}
