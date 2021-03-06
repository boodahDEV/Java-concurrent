package car_race;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import print.Print;
import utils.MaterialButton;
import java.awt.event.*;
import java.net.URI;
import java.util.Random;
import java.awt.*;

public class CarRaceGUI extends JFrame {

	protected JPanel contentPane,pista,meta,display;
	protected JButton exit,git;
	protected int x,y;
	protected JLabel[] label = new JLabel[10];
	protected JTextField addcar,distrace;
	protected JTextArea jta;
	protected JLabel aviso, aviso2;
	protected JLabel ganador[] = new JLabel[10];
	protected JSeparator separator1,separator,separator_1,separator_2;
	//protected Random random = new Random();
	protected String[] nameCar = new String[10];
	protected Thread car[] =new Car_GUI[10];
	protected CarRaceGUI gui;
	protected MaterialButton star;
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
		pista.setBackground(Color.WHITE);
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
				nameCar[0]="Nissan";nameCar[1]="Buggati";nameCar[2]="Audi";nameCar[3]="BMW";nameCar[4]="Mercedes";nameCar[5]="Toyota";nameCar[6]="Subaru";nameCar[7]="Mustang";nameCar[8]="For";nameCar[9]="Camaro";
				aviso.setText("The cars are in the game.");aviso.setForeground(new Color(8,127,35));
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
			  if(distrace.getText().isEmpty() == false && Integer.parseInt(distrace.getText().trim())<=20 && Integer.parseInt(distrace.getText().trim())>0){
				 aviso2.setForeground(new Color(8,127,35));
				  aviso2.setText("The distance has been set.");
				  vueltas.setEnabled(false);distrace.setEnabled(false);
			  }else {
				  aviso2.setText("Entry error, try again.");aviso.setForeground(new Color(220, 20, 60));
			  }	
			}
		});
		vueltas.setText("Distance Race");
		vueltas.setFocusable(false);
		vueltas.setBounds(505, 150, 117, 35);
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
		
		aviso2 = new JLabel("EL maximo de distancia es de 20");
		aviso2.setVisible(true);
		aviso2.setForeground(new Color(220, 20, 60));
		aviso2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		aviso2.setBounds(445, 187, 187, 14);
		contentPane.add(aviso2);
		
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
		stop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pista.removeAll();
				label();
				pista.repaint();
				for(int i=0;i<car.length;i++)
					car[i].stop(); // No se debe hacer, pero por cuestion es asi, deternerlo en caliente
				//System.gc();
			}
			
		});
		stop.setText("Stop");
		stop.setFocusable(false);
		stop.setBounds(521, 325, 52, 35);
		stop.setColorNormal(new Color(8,127,35));
		stop.setColorHover(new Color(76,175,80));
		stop.setColorPressed(new Color(118,210,117));
		stop.setVisible(false);
		contentPane.add(stop);
	
		star = new MaterialButton();
		star.addActionListener(new ActionListener() {
			int yy;
			public void actionPerformed(ActionEvent a){
			if(newcar.isEnabled()==false && vueltas.isEnabled()==false) {
				star.setEnabled(false);
				display.setBackground(new Color(8,127,35));
				contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(8,127,35)));
			try {
			  label();
			  pista.repaint();
				  for(int i=0;i<Integer.parseInt(addcar.getText().trim());i++) {
				  car[i] = new Car_GUI(nameCar[i/*random.nextInt(10)*/], label[i],Integer.parseInt(distrace.getText().trim()),yy, ganador[i],pista.getWidth(),jta,i);System.out.println("se crea el hilo");
				 }
				  for(int i = 0;i<car.length;i++)
					  car[i].start();
				  
			}catch(Exception e) {}
				}else {
					display.setBackground(new Color(220, 20, 60));
					contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(220, 20, 60/*8,127,35*/)));
					System.out.println("ERROR");
					
				}
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
		
		jta = new JTextArea();
		jta.setFont(new Font("Monospaced", Font.PLAIN, 12));
		jta.setEditable(false);
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBounds(452, 233, 170, 81);
		jsp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(8,127,35)));
		contentPane.add(jsp);
		
		git = new JButton("");
		git.setBounds(595, 40, 30, 30);
		contentPane.add(git);
		git.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/boodahDEV/Java-concurrent"));
					} catch (Exception e) {
						//aviso.setVisible(true);
						System.out.println("Error, sin conexion!");
					} 
			}
		});
		git.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		git.setRolloverSelectedIcon(new ImageIcon(Print.class.getResource("/print/github2.png")));
		git.setRolloverIcon(new ImageIcon(Print.class.getResource("/print/github2.png")));
		git.setIcon(new ImageIcon(Print.class.getResource("/print/github.png")));
		git.setIconTextGap(-11);
		git.setFocusable(false);
		git.setContentAreaFilled(false);
		git.setBorderPainted(false);
		
	}//end builder
	
	
	public void label() {
		//System.out.println("LAbel pegados.");
			label[0] = new JLabel(" ");
			label[0].setIconTextGap(-1);
			label[0].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
			label[0].setBounds(10, 10, 45, 20);
			label[0].setVisible(true);
			pista.add(label[0]);
			
			ganador[0] = new JLabel();
			ganador[0].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/ganador.png")));
			ganador[0].setBounds(10, 10, 30, 30);
			ganador[0].setVisible(false);
			meta.add(ganador[0]);
			
			label[1] = new JLabel(" ");
			label[1].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
			label[1].setIconTextGap(-1);
			label[1].setBounds(10, 36, 45, 20);
			label[1].setVisible(true);
			pista.add(label[1]);
			
			ganador[1] = new JLabel();
			ganador[1].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/ganador.png")));
			ganador[1].setBounds(10, 36, 30, 30);
			ganador[1].setVisible(false);
			meta.add(ganador[1]);
			
			label[2] = new JLabel(" ");
			label[2].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
			label[2].setIconTextGap(-1);
			label[2].setBounds(10, 86, 45, 20);
			label[2].setVisible(true);
			pista.add(label[2]);
			
			ganador[2] = new JLabel();
			ganador[2].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/ganador.png")));
			ganador[2].setBounds(10, 86, 30, 30);
			ganador[2].setVisible(false);
			meta.add(ganador[2]);
			
			label[3] = new JLabel(" ");
			label[3].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
			label[3].setIconTextGap(-1);
			label[3].setBounds(10, 61, 45, 20);
			label[3].setVisible(true);
			pista.add(label[3]);
			
			ganador[3] = new JLabel();
			ganador[3].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/ganador.png")));
			ganador[3].setBounds(10, 61, 30, 30);
			ganador[3].setVisible(false);
			meta.add(ganador[3]);
			
			label[5] = new JLabel(" ");
			label[5].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
			label[5].setIconTextGap(-1);
			label[5].setBounds(10, 136, 45, 20);
			label[5].setVisible(true);
			pista.add(label[5]);
			
			ganador[5] = new JLabel();
			ganador[5].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/ganador.png")));
			ganador[5].setBounds(10, 136, 30, 30);
			ganador[5].setVisible(false);
			meta.add(ganador[5]);
			
			label[4] = new JLabel(" ");
			label[4].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
			label[4].setIconTextGap(-1);
			label[4].setBounds(10, 111, 45, 20);
			label[4].setVisible(true);
			pista.add(label[4]);
			
			ganador[4] = new JLabel();
			ganador[4].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/ganador.png")));
			ganador[4].setBounds(10, 111, 30, 30);
			ganador[4].setVisible(false);
			meta.add(ganador[4]);
			
			label[6] = new JLabel(" ");
			label[6].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
			label[6].setIconTextGap(-1);
			label[6].setBounds(10, 186, 45, 20);
			label[6].setVisible(true);
			pista.add(label[6]);
			
			ganador[6] = new JLabel();
			ganador[6].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/ganador.png")));
			ganador[6].setBounds(10, 186, 30, 30);
			ganador[6].setVisible(false);
			meta.add(ganador[6]);
			
			label[7] = new JLabel(" ");
			label[7].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
			label[7].setIconTextGap(-1);
			label[7].setBounds(10, 161, 45, 20);
			label[7].setVisible(true);
			pista.add(label[7]);
			
			ganador[7] = new JLabel();
			ganador[7].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/ganador.png")));
			ganador[7].setBounds(10, 161, 30, 30);
			ganador[7].setVisible(false);
			meta.add(ganador[7]);
			
			label[8] = new JLabel(" ");
			label[8].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
			label[8].setIconTextGap(-1);
			label[8].setBounds(10, 213, 45, 20);
			label[8].setVisible(true);
			pista.add(label[8]);
			
			ganador[8] = new JLabel();
			ganador[8].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/ganador.png")));
			ganador[8].setBounds(10, 213, 30, 30);
			ganador[8].setVisible(false);
			meta.add(ganador[8]);
			
//			label[9] = new JLabel(" ");
//			label[9].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
//			label[9].setIconTextGap(-1);
//			label[9].setBounds(10, 188, 45, 20);
//			label[9].setVisible(true);
//			pista.add(label[9]);
			
			label[9] = new JLabel(" ");
			label[9].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/car_2.gif")));
			label[9].setIconTextGap(-1);
			label[9].setBounds(10, 238, 45, 20);
			label[9].setVisible(true);
			pista.add(label[9]);
		
			ganador[9] = new JLabel();
			ganador[9].setIcon(new ImageIcon(CarRaceGUI.class.getResource("/car_race/ganador.png")));
			ganador[9].setBounds(10, 238, 30, 30);
			ganador[9].setVisible(false);
			meta.add(ganador[9]);
			
	}
}//end class
