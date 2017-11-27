import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Component;
import javax.swing.Box;

public class Person_erfassen {

	private JFrame frame;
	private JTextField id;
	private JTextField nachname;
	private JTextField vorname;
	private JTextField adresse;
	private JTextField plz;
	private JTextField ort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Person_erfassen window = new Person_erfassen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Person_erfassen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\annaz\\Pictures\\logo@2x.png"));
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 591, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmStartseite = new JMenuItem("Startseite");
		menuBar.add(mntmStartseite);
		frame.getContentPane().setLayout(new MigLayout("", "[100][33.45%][100][50%]", "[39px][60px][30][30][30][30.00][30.00][60.00px][30.00][30.00]"));
		
		JLabel lblPerson = new JLabel("Person erfassen");
		lblPerson.setFont(new Font("Tahoma", Font.BOLD, 24));
		frame.getContentPane().add(lblPerson, "cell 0 0 2 1,grow");
		
		JLabel lblId = new JLabel("ID");
		frame.getContentPane().add(lblId, "cell 0 2");
		
		id = new JTextField();
		id.setEnabled(false);
		id.setColumns(50);
		id.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(id, "cell 1 2");
		
		JLabel lblNachname = new JLabel("Nachname");
		frame.getContentPane().add(lblNachname, "cell 0 3");
		
		nachname = new JTextField();
		nachname.setColumns(50);
		nachname.setBackground(Color.WHITE);
		frame.getContentPane().add(nachname, "cell 1 3");
		
		JLabel lblVorname = new JLabel("Vorname");
		frame.getContentPane().add(lblVorname, "cell 2 3");
		
		vorname = new JTextField();
		vorname.setColumns(50);
		vorname.setBackground(Color.WHITE);
		frame.getContentPane().add(vorname, "cell 3 3");
		
		JLabel lblAdresse = new JLabel("Adresse");
		frame.getContentPane().add(lblAdresse, "cell 0 4");
		
		adresse = new JTextField();
		adresse.setColumns(50);
		adresse.setBackground(Color.WHITE);
		frame.getContentPane().add(adresse, "cell 1 4 3 1,growx");
		
		JLabel lblPlz = new JLabel("PLZ");
		frame.getContentPane().add(lblPlz, "cell 0 5");
		
		plz = new JTextField();
		plz.setColumns(50);
		plz.setBackground(Color.WHITE);
		frame.getContentPane().add(plz, "cell 1 5,growx,aligny center");
		
		JLabel lblOrt = new JLabel("Ort");
		frame.getContentPane().add(lblOrt, "cell 2 5");
		
		ort = new JTextField();
		ort.setColumns(50);
		ort.setBackground(Color.WHITE);
		frame.getContentPane().add(ort, "cell 3 5,growx,aligny center");
		
		JLabel lblLand = new JLabel("Land");
		frame.getContentPane().add(lblLand, "cell 0 6");
		
		JComboBox land = new JComboBox();
		frame.getContentPane().add(land, "cell 1 6,growx,aligny center");
		
		JButton btnSpeichern = new JButton("Speichern");
		frame.getContentPane().add(btnSpeichern, "flowx,cell 1 8,aligny center");
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		frame.getContentPane().add(btnAbbrechen, "cell 1 8,aligny center");
		
		JButton btnSpeichernUndModule = new JButton("Speichern und Module zuweisen");
		frame.getContentPane().add(btnSpeichernUndModule, "cell 1 9,alignx left,aligny center");

	}
}
