

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class PersonErfassen extends JFrame {

	private JTextField id;
	private JTextField nachname;
	private JTextField vorname;
	private JTextField adresse;
	private JTextField plz;
	private JTextField ort;
	
	private JComboBox land;

	/*
	 * Erstelle das GUI Panel für die Erfassung einer Person.
	 * @author Anna Zhuchkova
	 * @version 1.0
	 * @param 
	 * @return
	 */

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	
	public PersonErfassen() {
		setName("PersonErfassen");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonErfassen.class.getResource("/Bilder/FFHS_logo.png")));
		setTitle("Person erfassen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 450);
		
		/*
		 * Erstelle das GUI Menü und blende die Auwahl des aktuellen Panels aus.
		 * @author Christian Mächler
		 * @version 1.0
		 * @param 
		 * @return
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
		
		JMenuItem mntmPersonErfassen = new JMenuItem("Person erfassen");
		mntmPersonErfassen.setEnabled(false);
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
		
		JSeparator separator = new JSeparator();
		mnErfassung.add(separator);
		mntmModulErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/internet-education-graduation_small.png")));
		mnErfassung.add(mntmModulErfassen);
		
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
		mntmPersonZuModul.setIcon(new ImageIcon(PersonErfassen.class.getResource("/Bilder/classroom_small.png")));
		mnZuweisung.add(mntmPersonZuModul);
		
		JMenuItem mntmLiteraturZuModul = new JMenuItem("Literatur zu Modul zuweisen");
		mntmLiteraturZuModul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LiteraturModulzuweisen LMz = new LiteraturModulzuweisen();
				LMz.setVisible(true);
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
		mntmAuswertungLitBestellen.setIcon(new ImageIcon(PersonErfassen.class.getResource("/Bilder/schedule_small.png")));
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
		mntmHelp.setIcon(new ImageIcon(PersonErfassen.class.getResource("/Bilder/question-mark_small.png")));
		menuBar.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][200,grow][][]", "[][][][][][][][][][]"));
		
		
		/*
		 * Titel der Seite
		 */		
		JLabel lblTitel = new JLabel("Person erfassen");
		lblTitel.setIcon(new ImageIcon(PersonErfassen.class.getResource("/Bilder/online-student.png")));
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblTitel, "cell 0 0 2 1,grow");
		
		/*
		 * Modul ID Feld wird erst in der DB vergeben
		 */
		JLabel lblId = new JLabel("ID");
		contentPane.add(lblId,"cell 0 2,alignx left");
		
		id = new JTextField();
		id.setEnabled(false);
		id.setColumns(50);
		id.setBackground(new Color(204, 204, 204));
		contentPane.add(id, "cell 1 2");
		
		/*
		 * Eingabe für Nachname
		 */
		JLabel lblNachname = new JLabel("Nachname *");
		contentPane.add(lblNachname, "cell 0 3");
		
		nachname = new JTextField();
		nachname.setColumns(50);
		nachname.setBackground(Color.WHITE);
		contentPane.add(nachname, "cell 1 3");
		
		/*
		 * Eingabe für Vorname
		 */
		
		JLabel lblVorname = new JLabel("Vorname *");
		contentPane.add(lblVorname, "cell 2 3");
		
		vorname = new JTextField();
		vorname.setColumns(50);
		vorname.setBackground(Color.WHITE);
		contentPane.add(vorname, "cell 3 3");
		
		/*
		 * Eingabe für Adresse
		 */
		JLabel lblAdresse = new JLabel("Adresse*");
		contentPane.add(lblAdresse, "cell 0 4");
		
		adresse = new JTextField();
		adresse.setColumns(50);
		adresse.setBackground(Color.WHITE);
		contentPane.add(adresse, "cell 1 4 3 1,growx");
		
		/*
		 * Eingabe für PLZ
		 */
		JLabel lblPlz = new JLabel("PLZ*");
		contentPane.add(lblPlz, "cell 0 5");
		
		plz = new JTextField();
		plz.setColumns(50);
		plz.setBackground(Color.WHITE);
		contentPane.add(plz, "cell 1 5,growx,aligny center");
		
		
		/*
		 * Eingabe für Ort
		 */
		JLabel lblOrt = new JLabel("Ort*");
		contentPane.add(lblOrt, "cell 2 5");
		
		ort = new JTextField();
		ort.setColumns(50);
		ort.setBackground(Color.WHITE);
		contentPane.add(ort, "cell 3 5,growx,aligny center");
		
		
		/*
		 * Eingabe für Land aus Liste
		 */
		
		JLabel lblLand = new JLabel("Land*");
		contentPane.add(lblLand, "cell 0 6,alignx left");
		
		land = new JComboBox();
		contentPane.add(land, "cell 1 6,growx");
		contentPane.add(land, "flowx,cell 1 6,alignx left,aligny center");
		fillComboBox();
		
		

		
		/*
		 * Speichern Button
		 */
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addPersonToDb();
					// Module zuweisen öffnen (TODO)
				} catch (SQLException e) {
				}
			}
		});
		contentPane.add(btnSpeichern, "cell 1 8");


		
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
		
		/*
		 * Markierung der Mussfelder
		 */
		
		JLabel lblMussfelder = new JLabel("* Mussfelder");
		contentPane.add(lblMussfelder, "cell 3 9");
		    }
	

	/*
	 * Füge die im GUI eingegebenen Daten in die Datenbank hinzu. 
	 * @author Halil Koca
	 * @version 1.0
	 * @param 
	 * @return
	 */
	private void addPersonToDb () throws SQLException  {
		// Daten auslesen
			String nachname_ = nachname.getText();
			String vorname_ = vorname.getText();
			String adresse_ = adresse.getText();
			String plz_ = plz.getText();
			String ort_ = ort.getText();
			String land_ = (String) land.getSelectedItem();
		
		// Verbindung mit Datenbank herstellen
			String url = "jdbc:mysql://bohemia.mysql.database.azure.com:3306/bohemia?autoReconnect=true&useSSL=false"; 
	        String username = "myadmin@bohemia"; // DB-Benutzername
	        String password = "Bohemia2017"; // DB-Passwort	          
	        
	        // Überprüfe, ob DB Benutzername und Passwort mitgegeben werden! 
	        	if (username == "" || password == "") {
	        		JOptionPane.showMessageDialog(null, "Datenbank Username oder Passwort fehlt.");
	        		return;
	        	}
	        	
	        // Überprüfe, ob die Mussfelder ausgefüllt wurden
	        	if (nachname.getText().equals("") || vorname.getText().equals("") || adresse.getText().equals("") || plz.getText().equals("") || ort.getText().equals("")){
	        		JOptionPane.showMessageDialog(null, "Modul konnten nicht gespeichert werdem. Bitte alle Mussfelder ausfüllen.");
	        		return;
	        	}
	        	

	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        	//Erstelle neues Statement
	        	Statement st = connection.createStatement();
	        	
	        	// Aufbau SQL-Befehl
		        	try { 
		        		st.executeUpdate("INSERT INTO bohemia.student (nachname,vorname,adresse,plz,ort,land_id) VALUES ('"+nachname_+"', '"+vorname_+"', '"+ adresse_+"', '" +plz_+"', '"+ort_+"','"+land_+"')");
		        		JOptionPane.showMessageDialog(null, nachname_ + " " + vorname_ + " wurde erfolgreich erfasst.");
		        		id.setText("");
		        		nachname.setText("");
		        		vorname.setText("");
		        		adresse.setText("");
		        		plz.setText("");
		        		ort.setText("");
		        	}
		        	catch (SQLException e) {
		        		String error = e.getLocalizedMessage();
		        		JOptionPane.showMessageDialog(null, error);
		        	}
	        	
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Verbindung zur Datenbank ist fehlgeschlagen!");
	        }
	}
	
	/*
	 * Füge die die Länder aus der Datenbank in das Dropdown hinzu. 
	 * @author Anna Zhuchkova
	 * @version 1.0
	 * @param 
	 * @return
	 */
	
	public void fillComboBox() {
		// Verbindung mit Datenbank herstellen
					String url = "jdbc:mysql://bohemia.mysql.database.azure.com:3306/bohemia?autoReconnect=true&useSSL=false"; 
			        String username = "myadmin@bohemia"; // DB-Benutzername
			        String password = "Bohemia2017"; // DB-Passwort	          
			        
	   // Überprüfe, ob DB Benutzername und Passwort mitgegeben werden! 
			        if (username == "" || password == "") {
			        	JOptionPane.showMessageDialog(null, "DB Benutzername oder Passwort fehlt!");
			        	return;
			        }
		// Führe die SQL Anfrage aus und füll das Dropdown land ab
				try {
					Connection connection = DriverManager.getConnection(url, username, password);
					String query="SELECT * FROM bohemia.land order by id asc";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						land.addItem(rs.getString("id"));
					}
				}
				catch (SQLException e) {
					String error = e.getLocalizedMessage();
	        		JOptionPane.showMessageDialog(null, error);
				}
			
	}

}
