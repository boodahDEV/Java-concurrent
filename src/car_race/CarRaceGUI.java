package car_race;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import utils.MaterialButton;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CarRaceGUI extends JFrame {

	private JPanel contentPane,pista,meta,display;
	private JButton exit;
	public int x,y;
	private JLabel[] label = new JLabel[10];
	private JTextField addcar;
	private JLabel aviso;
	private JTextField distrace;
	private JSeparator separator_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					CarRaceGUI frame = new CarRaceGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

	}

	/**
	 * Create the frame.
	 */
	public CarRaceGUI() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 365);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(8,127,35)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pista = new JPanel();
		pista.setBackground(Color.WHITE);
		pista.setBounds(10, 85, 377, 269);
		contentPane.add(pista);
		pista.setLayout(null);
		
//			label = new JLabel(" ");
//			label.setIconTextGap(-1);
//			label.setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
//			label.setBounds(10, 10, 45, 20);
//			pista.add(label);
			
		meta = new JPanel();
		meta.setBackground(Color.WHITE);
		meta.setBounds(390, 85, 52, 269);
		contentPane.add(meta);
		meta.setLayout(null);
		
		display = new JPanel();
		display.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent a) {
				int xx = a.getXOnScreen();
				int yy = a.getYOnScreen();
				setLocation(xx-x,yy-y);
			}
		});
		display.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent a) {
				x = a.getX();
				y = a.getY();
			}
		});
	
		display.setBackground(new Color(8,127,35));
		display.setBounds(0, 0, 632, 35);
		contentPane.add(display);
		display.setLayout(null);
		
		exit = new JButton("");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setFocusable(false);
		exit.setRolloverSelectedIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/exit2.png")));
		exit.setRolloverIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/exit2.png")));
		exit.setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/exit.png")));
		exit.setIconTextGap(-5);
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.setContentAreaFilled(false);
		exit.setBorder(null);
		exit.setBorderPainted(false);
		exit.setBounds(600, 8, 20, 20);
		display.add(exit);
		
		MaterialButton newcar = new MaterialButton();
		newcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				
			}
		});
		newcar.setText("Add Car");
		newcar.setFocusable(false);
		newcar.setBounds(505, 85, 117, 35);
		newcar.setColorNormal(new Color(8,127,35));
		newcar.setColorHover(new Color(76,175,80));
		newcar.setColorPressed(new Color(118,210,117));
		contentPane.add(newcar);
		
		MaterialButton vueltas = new MaterialButton();
		vueltas.setText("Distance Race");
		vueltas.setFocusable(false);
		vueltas.setBounds(505, 147, 117, 35);
		vueltas.setColorNormal(new Color(8,127,35));
		vueltas.setColorHover(new Color(76,175,80));
		vueltas.setColorPressed(new Color(118,210,117));
		contentPane.add(vueltas);
		
		addcar = new JTextField();
		addcar.setHorizontalAlignment(SwingConstants.CENTER);
		addcar.setForeground(Color.GRAY);
		addcar.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		addcar.setBorder(null);
		addcar.setBounds(450, 85, 45, 35);
		contentPane.add(addcar);
		addcar.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(450, 120, 45, 2);
		contentPane.add(separator);
		
		aviso = new JLabel("Los nombre se a\u00F1aden aleatoriamente");
		aviso.setVisible(false);
		aviso.setForeground(new Color(220, 20, 60));
		aviso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		aviso.setBounds(445, 122, 187, 14);
		contentPane.add(aviso);
		
		distrace = new JTextField();
		distrace.setHorizontalAlignment(SwingConstants.CENTER);
		distrace.setForeground(Color.GRAY);
		distrace.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		distrace.setColumns(10);
		distrace.setBorder(null);
		distrace.setBounds(450, 147, 45, 35);
		contentPane.add(distrace);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(450, 182, 45, 2);
		contentPane.add(separator_1);
	}//end builder
}//end class
