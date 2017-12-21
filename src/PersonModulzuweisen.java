import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class PersonModulzuweisen extends JFrame {

	private JPanel contentPane;

	private JComboBox person;
	private JComboBox modul1;
	private JComboBox modul2;
	private JComboBox modul3;
	private JComboBox modul4;

	/**
	 * Create the frame.
	 */
	public PersonModulzuweisen() {
		setName("PersonModulzuweisen");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PersonModulzuweisen.class.getResource("/Bilder/FFHS_logo.png")));
		setTitle("Person zu Modul zuweisen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 450);
		
		/*
		 * Menue Bar mit Verlinkungen zu anderen Menuepunkten
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
		mntmLiteraturErfassen.setIcon(new ImageIcon(ModulErfassen.class.getResource("/Bilder/books-stack_small.png")));
		mnErfassung.add(mntmLiteraturErfassen);
		
		JMenu mnZuweisung = new JMenu("Zuweisung");
		menuBar.add(mnZuweisung);
		
		JMenuItem mntmPersonZuModul = new JMenuItem("Person zu Modul zuweisen");
		mntmPersonZuModul.setEnabled(false);
		mntmPersonZuModul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				PersonModulzuweisen PMz = new PersonModulzuweisen();
				PMz.setVisible(true);
			}
		});	
		mntmPersonZuModul.setIcon(new ImageIcon(PersonModulzuweisen.class.getResource("/Bilder/classroom_small.png")));
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
		mntmAuswertungLitBestellen.setIcon(new ImageIcon(PersonModulzuweisen.class.getResource("/Bilder/schedule_small.png")));
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
		mntmHelp.setIcon(new ImageIcon(PersonModulzuweisen.class.getResource("/Bilder/question-mark_small.png")));
		menuBar.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][200,grow][][]", "[][][][][][][][][][]"));
		
		/*
		 * Titel der Seite
		 */
		JLabel lblTitel = new JLabel("Person zu Modul zuweisen");
		lblTitel.setIcon(new ImageIcon(PersonModulzuweisen.class.getResource("/Bilder/classroom.png")));
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblTitel, "cell 0 0 2 1,grow");
		
		
		/*
		 * Auswahl Feld für die Person
		 */
		JLabel lblPerson = new JLabel("Person");
		contentPane.add(lblPerson, "cell 0 2,alignx trailing,aligny center");
		
		
		person = new JComboBox();
		contentPane.add(person, "cell 1 2,growx");
		person.setSelectedIndex(-1);
		fillComboBoxPerson();
		
		
		
		/*
		 * Auswahl Felder für das Modul, max 4
		 */
		
		JLabel lblModul1 = new JLabel("Modul");
		contentPane.add(lblModul1, "cell 0 4,alignx left,aligny center");
		
		modul1 = new JComboBox();
		contentPane.add(modul1, "cell 1 4,growx");
		
		JLabel lblModul2 = new JLabel("Modul");
		lblModul2.setVisible(false);
		contentPane.add(lblModul2, "cell 0 5,alignx left,aligny center");
		
		modul2 = new JComboBox();
		modul2.setVisible(false);
		contentPane.add(modul2, "cell 1 5,growx");
		
		JLabel lblModul3 = new JLabel("Modul");
		lblModul3.setVisible(false);
		contentPane.add(lblModul3, "cell 0 6,alignx left,aligny center");
		
		modul3 = new JComboBox();
		modul3.setVisible(false);
		contentPane.add(modul3, "cell 1 6,growx");
		
		JLabel lblModul4 = new JLabel("Modul");
		lblModul4.setVisible(false);
		contentPane.add(lblModul4, "cell 0 7,alignx left,aligny center");
		
		modul4 = new JComboBox();
		modul4.setVisible(false);
		contentPane.add(modul4, "cell 1 7,growx");
		
		fillComboBoxModul();
		
		
		/*
		 * Literaturauwahl hinzufügen und entfernen Button, zusätzliche Buttons sind per default ausgeblendet
		 */
		JButton btnPlus1 = new JButton("+");
		btnPlus1.setVisible(true);
		contentPane.add(btnPlus1, "flowx,cell 3 4,alignx left,aligny center");
		JButton btnPlus2 = new JButton("+");
		btnPlus2.setVisible(false);
		JButton btnPlus3 = new JButton("+");
		btnPlus3.setVisible(false);
		JButton btnMinus1 = new JButton("-");
		btnMinus1.setVisible(false);
		JButton btnMinus2 = new JButton("-");
		btnMinus2.setVisible(false);
		JButton btnMinus3 = new JButton("-");
		btnMinus3.setVisible(false);
		
		
		/*
		 * zusätzliche Auswahl einblenden
		 */
		
		btnPlus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblModul2.setVisible(true);
				modul2.setVisible(true);
				btnPlus2.setVisible(true);
				btnMinus1.setVisible(true);
			}
		});
		contentPane.add(btnPlus2, "flowx,cell 3 5");
		contentPane.add(btnMinus1, "cell 3 5");

		
		/*
		 * zweite zusätzliche Auswahl einblenden oder aktuelle ausblenden
		 */

		btnPlus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblModul3.setVisible(true);
				modul3.setVisible(true);
				btnPlus3.setVisible(true);
				btnMinus2.setVisible(true);
			}
		});
		contentPane.add(btnPlus3, "flowx,cell 3 6");
		contentPane.add(btnMinus2, "cell 3 6");
		
		btnMinus1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblModul2.setVisible(false);
				modul2.setVisible(false);
				btnPlus2.setVisible(false);
				btnMinus1.setVisible(false);
			}
		});

		
		
		/*
		 * dritte zusätzliche Auswahl einblenden oder zweite ausblenden
		 */
		
		btnPlus3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblModul4.setVisible(true);
				modul4.setVisible(true);
				btnMinus3.setVisible(true);
			}
		});
		contentPane.add(btnMinus3, "cell 3 7,alignx right");
		
		btnMinus2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblModul3.setVisible(false);
				modul3.setVisible(false);
				btnPlus3.setVisible(false);
				btnMinus2.setVisible(false);
			}
		});

		
		/*
		 * dritte zusätzliche Auswahl ausblenden
		 */
		
		btnMinus3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblModul4.setVisible(false);
				modul4.setVisible(false);
				btnMinus3.setVisible(false);
			}
		});
		
		
		
		/*
		 * Speichern Button
		 */
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addModulToPerson ();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	}
	
	/*
	 * Füge die im GUI eingegebenen Daten in die Datenbank hinzu. 
	 * @author Anna Zhuchkova
	 * @version 1.0
	 * @param 
	 * @return
	 */
	private void addModulToPerson () throws SQLException  {
		//Index und String initialisieren, um ID aus der DB herauszulesen
		
				//String Name von Person
				String pers;
				//String Nachname und Vorname von Person
				String pnv;
				//Index von \0 in Person
				int persInd;
				
				//String Name von Modul1
				String mod1;
				//Indes von \0 in Modul1
				int mod1Ind;
				
				//String Name von Modul2
				String mod2;
				//Indes von \0 in Modul2
				int mod2Ind;
				
				//String Name von Modul3
				String mod3;
				//Indes von \0 in Modul3
				int mod3Ind;
				
				//String Name von Modul4
				String mod4;
				//Indes von \0 in Modul4
				int mod4Ind;
				
				
				// Daten auslesen
				
				// Person ID herauslesen
				pers = (String) person.getSelectedItem();
				persInd = pers.indexOf("\0");
				pers = pers.substring(0, persInd);
				
				//Person Name und Vorname herauslesen
				pnv = (String) person.getSelectedItem();
				pnv = pnv.substring(persInd + 2, pnv.length()-1);
			
				
				//Modul ID herauslesen aus literatur1
				mod1 = (String) modul1.getSelectedItem();
				mod1Ind = mod1.indexOf("\0");
				mod1 = mod1.substring(0, mod1Ind);
				
				//Modul ID2 herauslesen, falls weieter Modul vorhanden
						if(modul2.isVisible()) {
							mod2 = (String) modul2.getSelectedItem();
							mod2Ind = mod2.indexOf("\0");
							mod2 = mod2.substring(0, mod2Ind);
						}
						else {
							mod2 = null;
						}
				
				//Modul ID3 herauslesen, falls weieter Modul vorhanden
						if(modul3.isVisible()) {
							mod3 = (String) modul3.getSelectedItem();
							mod3Ind = mod3.indexOf("\0");
							mod3 = mod3.substring(0, mod3Ind);
						}
						else {
							mod3 = null;
						}

				//Modul ID4 herauslesen, falls weieter Modul vorhanden
						if(modul4.isVisible()) {
							mod4 = (String) modul4.getSelectedItem();
							mod4Ind = mod4.indexOf("\0");
							mod4 = mod4.substring(0, mod4Ind);
						}
						else {
							mod4 = null;
						}
		
		// Verbindung mit Datenbank herstellen
			String url = "jdbc:mysql://bohemia.mysql.database.azure.com:3306/bohemia?autoReconnect=true&useSSL=false"; 
	        String username = "myadmin@bohemia"; // DB-Benutzername
	        String password = "Bohemia2017"; // DB-Passwort	          
	        
	        // Überprüfe, ob DB Benutzername und Passwort mitgegeben werden! 
	        	if (username == "" || password == "") {
	        		JOptionPane.showMessageDialog(null, "Datenbank Username oder Passwort fehlt.");
	        		return;
	        	} 	
	        	
	        // Überprüfe, ob die Modul ausgewählt wurde, wenn ja, der Person zuweisen
	      	

	        try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        	//Erstelle neues Statement
	        	Statement st = connection.createStatement();
	        	int anzahl = 1;
	        	
	        	// Aufbau SQL-Befehl
        		st.executeUpdate("INSERT INTO bohemia.einschreibungen (student_id, modul_id) VALUES ('"+pers+"', '"+mod1+"')");
		        	
		        	if(modul2.isVisible() && modul2.getSelectedIndex() != -1) {
	        			st.executeUpdate("INSERT INTO bohemia.einschreibungen (student_id,modul_id) VALUES ('"+pers+"', '"+mod2+"')");
	        			anzahl ++;
		        	}
		        	if(modul3.isVisible() && modul3.getSelectedIndex() != -1) {
	        			st.executeUpdate("INSERT INTO bohemia.einschreibungen (student_id,modul_id) VALUES ('"+pers+"', '"+mod3+"')");
	        			anzahl ++;
		        	}
		        	if(modul4.isVisible() && modul4.getSelectedIndex() != -1) {
		        		st.executeUpdate("INSERT INTO bohemia.einschreibungen (student_id,modul_id) VALUES ('"+pers+"', '"+mod4+"')");
		        		anzahl ++;
	        		}
		        	JOptionPane.showMessageDialog(null, pnv + " wurde(n) erfolgreich " + anzahl + " Modul(e) zugewiesen");
		        	person.setSelectedIndex(-1);
		        	modul1.setSelectedIndex(-1);
		        	modul2.setSelectedIndex(-1);
		        	modul3.setSelectedIndex(-1);
		        	modul4.setSelectedIndex(-1);
		        	
		        	
	        	
	        } catch (SQLException e) {
	        	String error = e.getLocalizedMessage();
        		JOptionPane.showMessageDialog(null, error);
	        }
	}
	
	public void fillComboBoxPerson() {
		// Verbindung mit Datenbank herstellen
					String url = "jdbc:mysql://bohemia.mysql.database.azure.com:3306/bohemia?autoReconnect=true&useSSL=false"; 
			        String username = "myadmin@bohemia"; // DB-Benutzername
			        String password = "Bohemia2017"; // DB-Passwort	          
			        
	   // Überprüfe, ob DB Benutzername und Passwort mitgegeben werden! 
			        if (username == "" || password == "") {
			        	JOptionPane.showMessageDialog(null, "Datenbank Username oder Passwort fehlt.");
			        	return;
			        }
		
				try {
					Connection connection = DriverManager.getConnection(url, username, password);
					String query="SELECT * FROM bohemia.student order by nachname asc";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						String anzeige = rs.getString("id") + "\0 " + rs.getString("nachname")+ " " +rs.getString("vorname");
						person.addItem(anzeige);
					}
				}
				catch (SQLException e) {
					String error = e.getLocalizedMessage();
	        		JOptionPane.showMessageDialog(null, error);
				}
			
	}
	
	public void fillComboBoxModul() {
		// Verbindung mit Datenbank herstellen
					String url = "jdbc:mysql://bohemia.mysql.database.azure.com:3306/bohemia?autoReconnect=true&useSSL=false"; 
			        String username = "myadmin@bohemia"; // DB-Benutzername
			        String password = "Bohemia2017"; // DB-Passwort	          
			        
	   // Überprüfe, ob DB Benutzername und Passwort mitgegeben werden! 
			        if (username == "" || password == "") {
			        	JOptionPane.showMessageDialog(null, "Datenbank Username oder Passwort fehlt.");
			        	return;
			        }
		
				try {
					Connection connection = DriverManager.getConnection(url, username, password);
					String query="SELECT * FROM bohemia.modul order by kuerzel asc";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						String anzeige1 = rs.getString("id") + "\0 " + rs.getString("kuerzel")+ " " +rs.getString("modul");
						modul1.addItem(anzeige1);
						String anzeige2 = rs.getString("id") + "\0 " + rs.getString("kuerzel")+ " " +rs.getString("modul");;
						modul2.addItem(anzeige2);
						String anzeige3 = rs.getString("id") + "\0 " + rs.getString("kuerzel")+ " " +rs.getString("modul");
						modul3.addItem(anzeige3);
						String anzeige4 = rs.getString("id") + "\0 " + rs.getString("kuerzel")+ " " +rs.getString("modul");
						modul4.addItem(anzeige4);
					}
				}
				catch (SQLException e) {
					String error = e.getLocalizedMessage();
	        		JOptionPane.showMessageDialog(null, error);
				}
			
	}

}
