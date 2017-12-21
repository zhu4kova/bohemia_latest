import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuswertungLitBestellen extends JFrame {
	
	private JPanel contentPane;
	
	private File file;
	private Date today;
	private Desktop desktop;
	
	private JComboBox person;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public AuswertungLitBestellen() {
		setName("AuswertungLitBestellen");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AuswertungLitBestellen.class.getResource("/Bilder/FFHS_logo.png")));
		setTitle("Auswertung zu bestellende Literatur");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 797, 450);
		
		/*
		 * Menue Bar mit Verlinkungen zu anderen Menuepunkten
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
		mntmPersonErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				PersonErfassen PersErf = new PersonErfassen();
				PersErf.setVisible(true);
			}
		});
		mntmPersonErfassen.setIcon(new ImageIcon(AuswertungLitBestellen.class.getResource("/Bilder/online-student_small.png")));
		mntmPersonErfassen.setSelectedIcon(null);
		mntmPersonErfassen.setSelected(true);
		mnErfassung.add(mntmPersonErfassen);
		mntmModulErfassen.setIcon(new ImageIcon(AuswertungLitBestellen.class.getResource("/Bilder/internet-education-graduation_small.png")));
		mnErfassung.add(mntmModulErfassen);
		
		JMenuItem mntmLiteraturErfassen = new JMenuItem("Literatur erfassen");
		mntmLiteraturErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LiteraturErfassen LitErf = new LiteraturErfassen();
				LitErf.setVisible(true);
			}
		});
		mntmLiteraturErfassen.setIcon(new ImageIcon(AuswertungLitBestellen.class.getResource("/Bilder/books-stack_small.png")));
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
		mntmPersonZuModul.setIcon(new ImageIcon(AuswertungLitBestellen.class.getResource("/Bilder/classroom_small.png")));
		mnZuweisung.add(mntmPersonZuModul);
		
		JMenuItem mntmLiteraturZuModul = new JMenuItem("Literatur zu Modul zuweisen");
		mntmLiteraturZuModul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LiteraturModulzuweisen LMz = new LiteraturModulzuweisen();
				LMz.setVisible(true);
			}
		});
		mntmLiteraturZuModul.setIcon(new ImageIcon(AuswertungLitBestellen.class.getResource("/Bilder/study_small.png")));
		mnZuweisung.add(mntmLiteraturZuModul);
		
		JMenu mnAuswertung = new JMenu("Auswertung");
		menuBar.add(mnAuswertung);
		
		JMenuItem mntmFlligeLiteraturbestellungen = new JMenuItem("F\u00E4llige Literaturbestellungen");
		mntmFlligeLiteraturbestellungen.setEnabled(false);
		mntmFlligeLiteraturbestellungen.setSelectedIcon(new ImageIcon(AuswertungLitBestellen.class.getResource("/Bilder/books-stack.png")));
		mntmFlligeLiteraturbestellungen.setIcon(new ImageIcon(AuswertungLitBestellen.class.getResource("/Bilder/schedule_small.png")));
		mnAuswertung.add(mntmFlligeLiteraturbestellungen);
		
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
		mntmHelp.setIcon(new ImageIcon(AuswertungLitBestellen.class.getResource("/Bilder/question-mark_small.png")));
		menuBar.add(mntmHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][200,grow]", "[][][grow][]"));
		
		/*
		 * Titel der Seite
		 */
		JLabel lblTitel = new JLabel("Auswertung zu bestellende Literatur");
		lblTitel.setIcon(new ImageIcon(AuswertungLitBestellen.class.getResource("/Bilder/schedule.png")));
		lblTitel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblTitel, "cell 0 0 2 1,grow");
		
		/*
		 * Auswertung holen Button
		 */
		JButton btnAuswertungLaden = new JButton("Auswertung laden");
		btnAuswertungLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillTable();
			}
		});
		btnAuswertungLaden.setFocusPainted(false);
		btnAuswertungLaden.setToolTipText("Klicken Sie hier um eine Liste mit der zu bestellenden Literatur zu erstellen.");
		btnAuswertungLaden.setHorizontalAlignment(SwingConstants.LEFT);
		btnAuswertungLaden.setIconTextGap(10);
		btnAuswertungLaden.setIcon(new ImageIcon(AuswertungLitBestellen.class.getResource("/Bilder/download.png")));
		contentPane.add(btnAuswertungLaden, "cell 1 1,alignx left");

		/*
		 * Platzhalter für den Auszug, scrollbar
		 */
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 2,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		/*
		 * Zurück zur Startseite Button
		 */
		
		JButton btnZurueck = new JButton("Zurück zur Startseite");
		btnZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		

		/*
		 * Button für den Export der Tabelle sowie speichern der Bestellung in der Datenbank
		 */
		
		JButton btnExportBestellen = new JButton("Exportieren und Bestellen");
		btnExportBestellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//vor dem Ausführen, muss die Bestellung bestätigt werden
				 int result = JOptionPane.showConfirmDialog((Component) e.getSource(),"Möchten Sie die Liste exportieren und eine Bestellung auslösen?","Warnung", JOptionPane.OK_CANCEL_OPTION);
				        if (result == JOptionPane.OK_OPTION) {
				        	exportToExcelFile();
				        	litBestellen();
				        	JOptionPane.showMessageDialog((Component) e.getSource(), "Die Bestellunge wurde erfolgreich erfasst.");
				        } else if (result == JOptionPane.CANCEL_OPTION) {
				          System.out.println("Do nothing");
				        }
			}
		});
		contentPane.add(btnExportBestellen, "flowx,cell 1 3");
		contentPane.add(btnZurueck, "cell 1 3,alignx right,aligny center");
	}
	
	public void exportToExcelFile (){
	    try{
	        TableModel model = table.getModel();
	        
	        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	        today = new Date();	        
	        
	        File filepath = new File("C:\\Auswertungen");
	        if(!filepath.exists()) {
	        	filepath.mkdir();
	        }
	        file = new File("C:\\Auswertungen\\" + dateFormat.format(today) + "_LiteraturBestellung.xls");
	        file.createNewFile();
	        desktop = Desktop.getDesktop();
	        desktop.open(filepath);

	        
	        FileWriter excel = new FileWriter(file);

	        for(int i = 0; i < model.getColumnCount(); i++){
	            excel.write(model.getColumnName(i) + "\t");
	        }

	        excel.write("\n");

	        for(int i=0; i< model.getRowCount(); i++) {
	            for(int j=0; j < model.getColumnCount(); j++) {
	                excel.write(model.getValueAt(i,j).toString()+"\t");
	            }
	            excel.write("\n");
	        }

	        excel.close();

	    }catch(IOException e){ System.out.println(e); }
	}
	
	/*
	 * Methode zur Abfüllung der Tabelle mit den fälligen Literaturbestellungen
	 */
	
	public void fillTable() {
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
					String query=
							"SELECT s.id as StudentenID, " +
									" s.nachname as Nachname, "+ 
									" s.vorname as Vorname," + 
									" s.adresse as Adresse," + 
									" s.plz as PLZ," + 
									" s.ort as Ort," + 
									" c.land as Land, " +
									" l.id as LiteraturID," +
									" l.titel as Literaturtitel," + 
									" l.autor as Autor," + 
									" l.isbn as 'ISBN-Nummer'," + 
									" l.herausgeber as Herausgeber," + 
									" l.auflage as Auflage," + 
									" l.jahr as Jahr" + 
									" FROM bohemia.student s" + 
									" JOIN bohemia.einschreibungen e on s.id = e.student_id" + 
									" JOIN bohemia.modul m on e.modul_id = m.id" + 
									" JOIN bohemia.modul_hat_literatur mhl on m.id = mhl.modul_id" + 
									" JOIN bohemia.literatur l on l.id = mhl.literatur_id" + 
									" JOIN bohemia.land c on s.land_id = c.id" + 
									" WHERE (s.id, l.id) not in (SELECT student_id, literatur_id from bohemia.literatur_bestellung);";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch (SQLException e) {
					String error = e.getLocalizedMessage();
	        		JOptionPane.showMessageDialog(null, error);
				}
			
	}
	
	/*
	 * Methode zur Abfüllung der Datebank mit den neuen Bestellungen
	 */
	
	public void litBestellen () {
		int anzEintraege = table.getRowCount();
		DateFormat dateFormat = new SimpleDateFormat("dd.mm.YYYY");
        today = new Date();	     
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis()); 
        
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
			String query = "INSERT INTO bohemia.literatur_bestellung (student_id,literatur_id,bestelldatum) values (?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			for (int zeile = 0; zeile < anzEintraege; zeile++) {
				int student_id = (int)table.getValueAt(zeile, 0);
				int literatur_id = (int)table.getValueAt(zeile, 7);
				pst.setInt(1, student_id);
				pst.setInt(2, literatur_id);
				pst.setDate(3, (java.sql.Date) sqlDate);
				pst.addBatch();
				pst.executeBatch();
			}								
		}
		catch (SQLException e) {
			String error = e.getLocalizedMessage();
			JOptionPane.showMessageDialog(null, error);
		}
		
	}

}
