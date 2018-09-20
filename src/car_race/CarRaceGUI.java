package car_race;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import utils.MaterialButton;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;

public class CarRaceGUI extends JFrame {

	private JPanel contentPane,pista,meta,display;
	private JButton exit;
	public int x,y;
	private JLabel[] label = new JLabel[10];
	private JTextField addcar,distrace;
	private JLabel aviso;
	private JSeparator separator1,separator,separator_1,separator_2;
	private Random random = new Random();
	private String[] nameCar = new String[10];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					CarRaceGUI frame = new CarRaceGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
	}//end main

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
		//pista.setBackground(Color.WHITE);
		pista.setBounds(10, 85, 377, 269);
		contentPane.add(pista);
		pista.setLayout(null);
			
		meta = new JPanel();
		meta.setBackground(Color.WHITE);
		meta.setBounds(390, 85, 52, 269);
		contentPane.add(meta);
		meta.setLayout(null);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(50, 0, 2, 269);
		meta.add(separator_2);
		
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
			try {
				if(addcar.getText().isEmpty() == false  &&  Integer.parseInt(addcar.getText().trim())<=10 && Integer.parseInt(addcar.getText().trim())>0 ) {
				nameCar[0]="Nissan";nameCar[1]="Buggati";nameCar[2]="Audi";nameCar[3]="BMW";nameCar[4]="Mercedes";nameCar[5]="Toyota";nameCar[6]="Subaru";nameCar[7]="Mustang";nameCar[8]="For";nameCar[9]="Chrebrolet";
				aviso.setText("The threads were created.");aviso.setForeground(new Color(8,127,35));
				newcar.setEnabled(false);addcar.setEnabled(false);
				}else {
					aviso.setText("Entry error, try again.");aviso.setForeground(new Color(220, 20, 60));
				}
			}catch(Exception e) {
				aviso.setText("Entry error, try again.");aviso.setForeground(new Color(220, 20, 60));
								}
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
		vueltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				vueltas.setEnabled(false);distrace.setEnabled(false);
			}
		});
		vueltas.setText("Distance Race");
		vueltas.setFocusable(false);
		vueltas.setBounds(505, 149, 117, 35);
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
		aviso.setVisible(true);
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
		distrace.setBounds(452, 147, 45, 35);
		contentPane.add(distrace);
		
		separator1 = new JSeparator();
		separator1.setBounds(452, 182, 45, 2);
		contentPane.add(separator1);
		
		MaterialButton stop = new MaterialButton();
		stop.setText("Stop");
		stop.setFocusable(false);
		stop.setBounds(521, 325, 52, 35);
		stop.setColorNormal(new Color(8,127,35));
		stop.setColorHover(new Color(76,175,80));
		stop.setColorPressed(new Color(118,210,117));
		contentPane.add(stop);
		
		MaterialButton star = new MaterialButton();
		star.addActionListener(new ActionListener() {
			int yy;
			public void actionPerformed(ActionEvent a){
			try {
			  
				  for(int i=0;i<Integer.parseInt(addcar.getText().trim());i++) {
					  yy=i*(20-5);
					label[i] = new JLabel(" ");
					label[i].setIconTextGap(-1);
					label[i].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
					System.out.println(yy);
					label[i].setBounds(0, yy, 45, 20);
					label[i].setVisible(true);
					pista.add(label[i]);
				  new Car_GUI(nameCar[random.nextInt(10)], label[i],Integer.parseInt(distrace.getText().trim()),yy).start();System.out.println("se crea el hilo");
			  }
			}catch(Exception e) {}
			}//action performet
		});
		star.setText("Run");
		star.setFocusable(false);
		star.setBounds(575, 325, 52, 35);
		star.setColorNormal(new Color(8,127,35));
		star.setColorHover(new Color(76,175,80));
		star.setColorPressed(new Color(118,210,117));
		contentPane.add(star);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(388, 85, 2, 269);
		contentPane.add(separator_1);
	}//end builder
}//end class
