
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class LiteraturErfassen extends JFrame {
	
	private JTextField textId;
	private JTextField isbn;
	private JTextField titel;
	private JTextField autor;
	private JTextField auflage;
	private JTextField herausgeber;
	private JTextField jahr;

	private JPanel contentPane;
	private JTextField litTitel;


	/**
	 * Create the frame.
	 */
	public LiteraturErfassen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonErfassen.class.getResource("/Bilder/FFHS_logo.png")));
		setTitle("Literatur erfassen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 450);
		

		/*
		 * Menue bar mit Verlinkungen zu anderen Menuepunkten	
		 */
			
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnErfassung = new JMenu("Erfassung");
		menuBar.add(mnErfassung);
		
		JMenuItem mntmPersonErfassen = new JMenuItem("Person erfassen");
		mntmPersonErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				PersonErfassen PersErf = new PersonErfassen();
				PersErf.setVisible(true);
			}
		});
		
		JMenuItem mntmLiteraturErfassen = new JMenuItem("Literatur erfassen");
		mntmLiteraturErfassen.setEnabled(false);
		mntmLiteraturErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LiteraturErfassen LitErf = new LiteraturErfassen();
				LitErf.setVisible(true);
			}
		});
		mntmLiteraturErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/books-stack_small.png")));
		mnErfassung.add(mntmLiteraturErfassen);
		
		JSeparator separator = new JSeparator();
		mnErfassung.add(separator);
		mntmPersonErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/online-student_small.png")));
		mntmPersonErfassen.setSelectedIcon(null);
		mntmPersonErfassen.setSelected(true);
		mnErfassung.add(mntmPersonErfassen);
		
		JMenuItem mntmModulErfassen = new JMenuItem("Modul erfassen");
		mntmModulErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				ModulErfassen ModErf = new ModulErfassen();
				ModErf.setVisible(true);
			}
		});
		mntmModulErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/internet-education-graduation_small.png")));
		mnErfassung.add(mntmModulErfassen);
		
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
		mntmPersonZuModul.setIcon(new ImageIcon(LiteraturErfassen.class.getResource("/Bilder/classroom_small.png")));
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
		mntmAuswertungLitBestellen.setIcon(new ImageIcon(LiteraturErfassen.class.getResource("/Bilder/schedule_small.png")));
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
		mntmHelp.setIcon(new ImageIcon(LiteraturErfassen.class.getResource("/Bilder/question-mark_small.png")));
		menuBar.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][200,grow][31.00][]", "[][][][][][][][][][]"));

		
		/*
		 * Titel der Seite
		 */
		
		JLabel lblTitel = new JLabel("Literatur erfassen");
		lblTitel.setIcon(new ImageIcon(LiteraturErfassen.class.getResource("/Bilder/books-stack.png")));
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblTitel, "cell 0 0 2 1,grow");
		
		
		/*
		 * Modul ID Feld wird erst in der DB vergeben
		 */
		JLabel lblId = new JLabel("ID");
		contentPane.add(lblId, "cell 0 2");
		
		textId = new JTextField();
		textId.setEnabled(false);
		textId.setColumns(50);
		textId.setBackground(new Color(204, 204, 204));
		contentPane.add(textId, "cell 1 2");
		
		/*
		 * Feld fuer die Titel
		 */

		
		JLabel lblLitTitel = new JLabel("Titel *");
		contentPane.add(lblLitTitel, "cell 0 3,alignx left,growy");
		
		titel = new JTextField();
		contentPane.add(titel, "cell 1 3,growx");
		titel.setColumns(10);

		
		
		/*
		 * Feld fuer die ISBN
		 */
		
		JLabel lblISBN = new JLabel("ISBN *");
		contentPane.add(lblISBN, "cell 0 4");
		
		isbn = new JTextField();
		isbn.setColumns(50);
		isbn.setBackground(Color.WHITE);
		contentPane.add(isbn, "cell 1 4 3 1,growx");
		
		/*
		 * Feld fuer den Autor
		 */
		JLabel lblAutor = new JLabel("Autor");
		contentPane.add(lblAutor, "cell 0 5");
			
		autor = new JTextField();
		autor.setColumns(50);
		autor.setBackground(Color.WHITE);
		contentPane.add(autor, "cell 1 5 3 1,growx,aligny center");
		
		/*
		 * Feld fuer den Herausgeber
		 */
		
		JLabel lblHerausgeber = new JLabel("Herausgeber");
		contentPane.add(lblHerausgeber, "cell 0 6,alignx trailing");
		
		herausgeber = new JTextField();
		contentPane.add(herausgeber, "cell 1 6,growx,aligny center");
		herausgeber.setColumns(10);
		
		/*
		 * Feld fuer die Auflage
		 */
		
		JLabel lblAuflage = new JLabel("Auflage");
		contentPane.add(lblAuflage, "cell 0 7");
		
		auflage = new JTextField();
		auflage.setColumns(50);
		auflage.setBackground(Color.WHITE);
		contentPane.add(auflage, "cell 1 7,growx,aligny center");
		
		/*
		 * Dropdown Feld fuer Jahr
		 */
		JLabel lblJahr = new JLabel("Jahr");
		contentPane.add(lblJahr, "cell 2 7,alignx center");
		
		jahr = new JTextField();
		jahr.setToolTipText("Nur Zahlen k\u00F6nnen eingegeben werden.");
		jahr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char vchar = evt.getKeyChar();
				if(!(Character.isDigit(vchar))
					|| (vchar == KeyEvent.VK_BACK_SPACE)
					|| (vchar == KeyEvent.VK_DELETE)) {
					evt.consume();
				}
			}
		});
		contentPane.add(jahr, "cell 3 7,growx,aligny center");
		
		/*
		 * Speichern Button
		 */
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addLiteraturToDb();
				} catch (SQLException e) {
				}
			}
		});
		contentPane.add(btnSpeichern, "flowx,cell 1 9,alignx left,aligny center");
		
		/*
		 * Abbrechen Button
		 */
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		contentPane.add(btnAbbrechen, "cell 1 9,alignx right,aligny center");
		
		JLabel label = new JLabel("* Mussfelder");
		contentPane.add(label, "cell 2 9 2 1");
	}
	
	/*
	 * Füge die im GUI eingegebenen Daten in die Datenbank hinzu. 
	 * @author Halil Koca
	 * @version 1.0
	 * @param 
	 * @return
	 */
	private void addLiteraturToDb () throws SQLException  {
		
		// Daten auslesen
			String isbn_ = isbn.getText();
			String titel_ = titel.getText();
			String autor_ = autor.getText();
			String auflage_ = auflage.getText();
			String herausgeber_ = herausgeber.getText();
			String jahr_ = jahr.getText();
		
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
	        	if (titel.getText().equals("") || autor.getText().equals("") || isbn.getText().equals("")){
	        		JOptionPane.showMessageDialog(null, "Literatur konnten nicht gespeichert werdem. Bitte alle Mussfelder ausfüllen.");
	        		return;
	        	}
	        	
	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        	//Erstelle neues Statement
	        	Statement st = connection.createStatement();
	        	// Aufbau SQL-Befehl
		        	try { 
		        		st.executeUpdate("INSERT INTO literatur (titel,autor,isbn,herausgeber,auflage,jahr) VALUES ('"+titel_+"', '"+ autor_+"', '"+ isbn_+"', '" + herausgeber_ +"', '"+ auflage_+ "','"+ jahr_ +"')");
		        		JOptionPane.showMessageDialog(null, "Die Literatur " + titel_ + " von " + autor_ + " wurde erfoglreich gespeichert.");
		        		textId.setText("");
		        		isbn.setText("");
		        		titel.setText("");
		        		autor.setText("");
		        		auflage.setText("");
		        		herausgeber.setText("");
		        		jahr.setText("");
		        	}
		        	catch (SQLException e) {
		        		String error = e.getLocalizedMessage();
		        		JOptionPane.showMessageDialog(null, error);
		        	}
	        	
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null, "Verbindung zur Datenbank ist fehlgeschlagen!");
	        }
	}


}
