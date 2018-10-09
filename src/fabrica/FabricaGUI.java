package fabrica;

import javax.swing.*;
import java.awt.*;
import utils.MaterialButton;
import java.awt.event.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.MatteBorder;



public class FabricaGUI extends JFrame {

	private JPanel contentPane;
	private MaterialButton cantcaja,materialButton_1,setProduc,setSuper,star;
	private JCheckBox setsuper;
	private JTextField cantCajas,cantPro,jtfsuper;
	private int s=1,p=1,c,cantPapel;
	private JLabel setpaper,paper,aviso2,jlcaja,aviso;
	private JSlider deslisar;
		protected People [] people;
		protected Supervisor [] supervisor;
		protected ThreadGroup group;
	public static void main(String[] args) {
					FabricaGUI frame = new FabricaGUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				
	}

	
	
	public FabricaGUI() {
		//setUndecorated(true);
		setTitle("FabricaV1.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		//contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 33, 160, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		cantCajas = new JTextField();
		cantCajas.setHorizontalAlignment(SwingConstants.CENTER);
		cantCajas.setFont(new Font("Century", Font.PLAIN, 15));
		cantCajas.setBounds(5, 22, 40, 30);
		panel.add(cantCajas);
		cantCajas.setColumns(10);
		
		cantPro = new JTextField();
		cantPro.setFont(new Font("Century", Font.PLAIN, 15));
		cantPro.setHorizontalAlignment(SwingConstants.CENTER);
		cantPro.setColumns(10);
		cantPro.setBounds(5, 60, 40, 30);
		panel.add(cantPro);
		
		cantcaja = new MaterialButton();
		cantcaja.setColorNormal(new Color(0,41,132));
		cantcaja.setColorHover(new Color(63,81,181));
		cantcaja.setColorPressed(new Color(117,125,232));
		cantcaja.setFocusable(false);
		cantcaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
				if(cantCajas.isEnabled() == true && cantCajas.getText().isEmpty() == false){
					
					aviso.setVisible(false);
					cantcaja.setEnabled(false);
					cantCajas.setEnabled(false);
					c = Integer.parseInt(cantCajas.getText().trim());
					
				}else {
					aviso.setVisible(true);
					aviso.setText("Entry error, try again.");
					}
				}catch(Exception e) {
				cantcaja.setEnabled(true);
				cantCajas.setEnabled(true);
				aviso.setVisible(true);
				aviso.setText("Entry error, try again.");}
			}
		});
		cantcaja.setBounds(55, 20, 79, 32);
		cantcaja.setText("Set box");
		panel.add(cantcaja);
		
		setProduc = new MaterialButton();
		setProduc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				try {
				if (cantPro.isEnabled() == true  && cantPro.getText().isEmpty() == false) {
					aviso.setVisible(false);
					cantPro.setEnabled(false);
					setProduc.setEnabled(false);
					p=Integer.parseInt(cantPro.getText().trim());
					
					}else {
					aviso.setVisible(true);
					aviso.setText("Entry error, try again.");
					}
				}catch(Exception e) {
					cantPro.setEnabled(true);
					setProduc.setEnabled(true);
				aviso.setVisible(true);
				aviso.setText("Entry error, try again.");}
			}
			
		});
		setProduc.setText("Set people");
		setProduc.setColorNormal(new Color(0,41,132));
		setProduc.setColorHover(new Color(63,81,181));
		setProduc.setColorPressed(new Color(117,125,232));
		setProduc.setFocusable(false);
		setProduc.setBounds(55, 60, 79, 30);
		panel.add(setProduc);
		
		aviso = new JLabel();
		aviso.setForeground(new Color(220, 20, 60));
		aviso.setFont(new Font("Tahoma", Font.PLAIN, 10));
		aviso.setBounds(5, 2, 150, 14);
		aviso.setVisible(false);
		panel.add(aviso);
		
		paper = new JLabel("");
		paper.setHorizontalAlignment(SwingConstants.CENTER);
		paper.setHorizontalTextPosition(SwingConstants.CENTER);
		paper.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		paper.setBounds(217, 91, 37, 35);
		paper.setVisible(true);
		contentPane.add(paper);
		
		deslisar = new JSlider(1,100);
		deslisar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				//System.out.println(deslisar.getValue());
				paper.setText(""+deslisar.getValue());
				cantPapel = deslisar.getValue();
			}
		});
		deslisar.setValue(1);
		deslisar.setBackground(new Color(255, 255, 255));
		deslisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deslisar.setFocusable(false);
		deslisar.setBounds(260, 33, 28, 101);
		contentPane.add(deslisar);
		deslisar.setOrientation(SwingConstants.VERTICAL);
		
		jlcaja = new JLabel("");
		jlcaja.setIcon(new ImageIcon(FabricaGUI.class.getResource("/fabrica/caja.png")));
		jlcaja.setIconTextGap(-2);
		jlcaja.setBounds(210, 44, 50, 50);
		contentPane.add(jlcaja);
		
		jtfsuper = new JTextField();
		jtfsuper.setColumns(10);
		jtfsuper.setHorizontalAlignment(SwingConstants.CENTER);
		jtfsuper.setFont(new Font("Century", Font.PLAIN, 15));
		jtfsuper.setBounds(325, 75, 35, 35);
		jtfsuper.setEnabled(false);
		contentPane.add(jtfsuper);
		
		setSuper = new MaterialButton();
		setSuper.setText("Add ");
		setSuper.setEnabled(false);
		setSuper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
				if(jtfsuper.isEnabled() == true && jtfsuper.getText().isEmpty() == false) {
					jtfsuper.setEnabled(false);
					setSuper.setEnabled(false);
					setsuper.setEnabled(false);
					aviso2.setVisible(false);
					s=Integer.parseInt(jtfsuper.getText().trim());
				}else {
					aviso2.setVisible(true);
					aviso2.setText("Entry error, try again.");
				}
				}catch(Exception e) {aviso2.setVisible(true);
				aviso2.setText("Entry error, try again.");}
			}
			
		});
		setSuper.setColorNormal(new Color(0,41,132));
		setSuper.setColorHover(new Color(63,81,181));
		setSuper.setColorPressed(new Color(117,125,232));
		setSuper.setFocusable(false);
		setSuper.setBounds(365, 75, 65, 35);
		contentPane.add(setSuper);
		
		setsuper = new JCheckBox("Set supervisor");
		setsuper.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent a){
				if(setSuper.isEnabled() == true  && jtfsuper.isEnabled() == true) {
					setSuper.setEnabled(false);
					jtfsuper.setEnabled(false);
				}else {
					setSuper.setEnabled(true);
					jtfsuper.setEnabled(true);
				}

			}
		});
		setsuper.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setsuper.setBackground(new Color(255,255,255));
		setsuper.setFocusable(false);
		setsuper.setBounds(323, 48, 110, 23);
		contentPane.add(setsuper);
		
		setpaper = new JLabel("Set amount of paper per box");
		setpaper.setFont(new Font("Tahoma", Font.PLAIN, 11));
		setpaper.setBounds(175, 20, 139, 14);
		contentPane.add(setpaper);
		
		aviso2 = new JLabel();
		aviso2.setVisible(false);
		aviso2.setForeground(new Color(220, 20, 60));
		aviso2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		aviso2.setBounds(325, 112, 105, 14);
		contentPane.add(aviso2);
		
		star = new MaterialButton();
		star.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
			if (cantPro.isEnabled() == false && cantCajas.isEnabled() == false && jtfsuper.isEnabled() == false) {
				setTitle("FabricaV1.0");
				contentPane.setBorder(null);
				deslisar.setEnabled(false);
				star.setEnabled(false);
				
				//*********************************//
				Box  caja = new Box(c,cantPapel);
				people = new People[p];
				supervisor = new Supervisor[s];
				Thread []persona = new Thread[people.length];
				for(int i=0;i<people.length ;i++) {
					people[i] = new People(caja, i+1);
					persona[i] = new Thread(people[i]);
				}
				for(int i=0;i<p;i++) {
					persona[i].start();
				}
				
				supervisor[0] = new Supervisor(caja,1);
				supervisor[0].setDaemon(true);
				supervisor[0].start();
				}else {
					contentPane.setBorder(new MatteBorder(2,2,2,2, new Color(220, 20, 60)));
					setTitle("Error, campos vacios!");
				}
			}
		});
		star.setColorNormal(new Color(0,41,132));
		star.setColorHover(new Color(63,81,181));
		star.setColorPressed(new Color(117,125,232));
		star.setFocusable(false);
		star.setText("Start to Manufacture");
		star.setBounds(300, 382, 150, 35);
		contentPane.add(star);
		
		
		
	}//end builder

}
