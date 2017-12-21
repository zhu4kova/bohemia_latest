import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class Bohemia {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bohemia window = new Bohemia();
					window.frmBohemiaLiteraturverwaltung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	JFrame frmBohemiaLiteraturverwaltung;

	/**
	 * Create the application.
	 */
	public Bohemia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBohemiaLiteraturverwaltung = new JFrame();
		frmBohemiaLiteraturverwaltung.setTitle("Bohemia - Literaturverwaltung");
		frmBohemiaLiteraturverwaltung.setIconImage(Toolkit.getDefaultToolkit().getImage(Bohemia.class.getResource("/Bilder/FFHS_logo.png")));
		frmBohemiaLiteraturverwaltung.setBounds(100, 100, 712, 450);
		frmBohemiaLiteraturverwaltung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBohemiaLiteraturverwaltung.getContentPane().setLayout(new MigLayout("", "[50%][100][50%,grow]", "[88.00px][][][][30.00][][][grow]"));
		
		/*
		 * Menue Bar mit Verlinkungen zu anderen Menuepunkten
		 */

		
		
		/*
		 * Header der Startseite
		 */
		JLabel lblWillkommen = new JLabel("Bohemia - Literaturverwaltung");
		lblWillkommen.setForeground(new Color(178, 34, 34));
		lblWillkommen.setFont(new Font("Arial", Font.BOLD, 24));
		frmBohemiaLiteraturverwaltung.getContentPane().add(lblWillkommen, "flowx,cell 0 0 3 1");
		
		/*
		 * Button zur Erfassungsmaske einer Person
		*/
		JButton btnPersonErfassen = new JButton("Person erfassen");
		btnPersonErfassen.setBorder(null);
		btnPersonErfassen.setFocusPainted(false);
		btnPersonErfassen.setHorizontalAlignment(SwingConstants.LEFT);
		btnPersonErfassen.setIconTextGap(30);
		btnPersonErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonErfassen PersErf = new PersonErfassen();
				PersErf.setVisible(true);
			}
		});
		btnPersonErfassen.setBackground(new Color(211, 211, 211));
		btnPersonErfassen.setForeground(new Color(178, 34, 34));
		btnPersonErfassen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPersonErfassen.setIcon(new ImageIcon(Bohemia.class.getResource("/Bilder/online-student.png")));
		frmBohemiaLiteraturverwaltung.getContentPane().add(btnPersonErfassen, "cell 0 1,grow");
		
		
		/*
		 * Button zur Erfassungsmaske einer Literatur
		*/
		
		JButton btnLiteraturErfassen = new JButton("Literatur erfassen");
		btnLiteraturErfassen.setBorder(null);
		btnLiteraturErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LiteraturErfassen LitErf = new LiteraturErfassen();
				LitErf.setVisible(true);
			}
		});
		btnLiteraturErfassen.setFocusPainted(false);
		btnLiteraturErfassen.setHorizontalAlignment(SwingConstants.LEFT);
		btnLiteraturErfassen.setIconTextGap(30);
		btnLiteraturErfassen.setBackground(new Color(211, 211, 211));
		btnLiteraturErfassen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLiteraturErfassen.setForeground(new Color(178, 34, 34));
		btnLiteraturErfassen.setIcon(new ImageIcon(Bohemia.class.getResource("/Bilder/books-stack.png")));
		frmBohemiaLiteraturverwaltung.getContentPane().add(btnLiteraturErfassen, "cell 0 2,grow");
		
		/*
		 * Button zur Erfassungsmaske eines Moduls
		*/
		
		JButton btnModulErfassen = new JButton("Modul erfassen");
		btnModulErfassen.setBorder(null);
		btnModulErfassen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModulErfassen ModErf = new ModulErfassen();
				ModErf.setVisible(true);
			}
		});
	
		btnModulErfassen.setFocusPainted(false);
		btnModulErfassen.setIconTextGap(30);
		btnModulErfassen.setHorizontalAlignment(SwingConstants.LEFT);
		btnModulErfassen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModulErfassen.setBackground(new Color(211, 211, 211));
		btnModulErfassen.setForeground(new Color(178, 34, 34));
		btnModulErfassen.setIcon(new ImageIcon(Bohemia.class.getResource("/Bilder/internet-education-graduation.png")));
		frmBohemiaLiteraturverwaltung.getContentPane().add(btnModulErfassen, "cell 0 3,grow");

		/*
		 * Button zur Zuweisungsmaske Modul zu Person
		 */
		JButton btnPersonModulzuweisen = new JButton("Person zu Modul zuweisen");
		btnPersonModulzuweisen.setBorder(null);
		btnPersonModulzuweisen.setIcon(new ImageIcon(Bohemia.class.getResource("/Bilder/classroom.png")));
		btnPersonModulzuweisen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonModulzuweisen PMz = new PersonModulzuweisen();
				PMz.setVisible(true);
			}
		});
		btnPersonModulzuweisen.setIconTextGap(30);
		btnPersonModulzuweisen.setHorizontalAlignment(SwingConstants.LEFT);
		btnPersonModulzuweisen.setForeground(new Color(178, 34, 34));
		btnPersonModulzuweisen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPersonModulzuweisen.setFocusPainted(false);
		btnPersonModulzuweisen.setBackground(new Color(211, 211, 211));
		
		frmBohemiaLiteraturverwaltung.getContentPane().add(btnPersonModulzuweisen, "cell 2 1,grow");
		
		/*
		 * Button zur Zuweisungsmaske Literatur zu Modul
		 */
		JButton btnLiteraturModulzuweisen = new JButton("Literatur zu Modul zuweisen");
		btnLiteraturModulzuweisen.setBorder(null);
		btnLiteraturModulzuweisen.setIcon(new ImageIcon(Bohemia.class.getResource("/Bilder/study.png")));
		btnLiteraturModulzuweisen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LiteraturModulzuweisen LMz = new LiteraturModulzuweisen();
				LMz.setVisible(true);
			}
		});
		btnLiteraturModulzuweisen.setIconTextGap(30);
		btnLiteraturModulzuweisen.setHorizontalAlignment(SwingConstants.LEFT);
		btnLiteraturModulzuweisen.setForeground(new Color(178, 34, 34));
		btnLiteraturModulzuweisen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLiteraturModulzuweisen.setFocusPainted(false);
		btnLiteraturModulzuweisen.setBackground(new Color(211, 211, 211));
		
		frmBohemiaLiteraturverwaltung.getContentPane().add(btnLiteraturModulzuweisen, "cell 2 2,grow");
		
		JButton btnAuswertungLitBestellen = new JButton("Auswertung zu bestellende Literatur");
		btnAuswertungLitBestellen.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAuswertungLitBestellen.setBorder(null);
		btnAuswertungLitBestellen.setBackground(new Color(211, 211, 211));
		btnAuswertungLitBestellen.setForeground(new Color(178, 34, 34));
		btnAuswertungLitBestellen.setIconTextGap(30);
		btnAuswertungLitBestellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AuswertungLitBestellen ALB = new AuswertungLitBestellen();
				ALB.setVisible(true);
			}
		});
		btnAuswertungLitBestellen.setHorizontalAlignment(SwingConstants.LEFT);
		btnAuswertungLitBestellen.setFocusPainted(false);
		btnAuswertungLitBestellen.setIcon(new ImageIcon(Bohemia.class.getResource("/Bilder/schedule.png")));
		frmBohemiaLiteraturverwaltung.getContentPane().add(btnAuswertungLitBestellen, "cell 2 3,grow");
		
		JLabel lblHelp = new JLabel(" ");
		lblHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		lblHelp.setIconTextGap(15);
		lblHelp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHelp.setIcon(new ImageIcon(Bohemia.class.getResource("/Bilder/question-mark.png")));
		frmBohemiaLiteraturverwaltung.getContentPane().add(lblHelp, "cell 2 0,alignx right,growy");
		
	}
}
