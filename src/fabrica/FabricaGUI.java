package fabrica;

import javax.swing.*;
import java.awt.*;
import utils.MaterialButton;
import java.awt.event.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.MatteBorder;



public class FabricaGUI extends JFrame {

	protected JPanel contentPane,personas;
	protected MaterialButton cantcaja,setProduc,setSuper,star,stop;
	protected JCheckBox setsuper;
	protected JTextField cantCajas,cantPro,jtfsuper,jtfsupervisor,jtfbox;
	protected int s=1,p=1,c,cantPapel,CONT_PEOPLE;
	protected JLabel setpaper,paper,aviso2,jlcaja,aviso,jlpeoples[],bufferBox,jltext,jlbuffer,jlgestpeople,jlstaff,jlestatus,jltext1,jltext2;
	protected JSlider deslisar;
		protected People [] people;
		protected Supervisor [] supervisor;
		protected ThreadGroup group;
		protected Thread []persona;
		protected FabricaGUI buffer;
	protected JScrollPane jsp ;


	public static void main(String[] args) {
					FabricaGUI frame = new FabricaGUI();
					frame.setfabrica(frame); 				//=== TEDIOSA FORMA DE TENER ACCESO GLOBAL DE ESTA REFERENCIA EN PEOPLE Y SUPERVISOR
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				
	}//	=== main ===

	
	
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
		paper.setBounds(222, 91, 37, 35);
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
		deslisar.setBounds(265, 33, 28, 101);
		contentPane.add(deslisar);
		deslisar.setOrientation(SwingConstants.VERTICAL);
		
		bufferBox = new JLabel("");
		bufferBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		bufferBox.setIconTextGap(-200);
		bufferBox.setIcon(new ImageIcon(FabricaGUI.class.getResource("/fabrica/buffer.gif")));
		bufferBox.setBounds(129, 145, 249, 159);
		bufferBox.setVisible(false);
		
		jtfbox = new JTextField();
		jtfbox.setHorizontalAlignment(SwingConstants.CENTER);
		jtfbox.setFont(new Font("Century", Font.PLAIN, 15));
		jtfbox.setEnabled(false);
		jtfbox.setColumns(10);
		jtfbox.setBounds(342, 168, 35, 35);
		contentPane.add(jtfbox);
		contentPane.add(bufferBox);
		
		jlcaja = new JLabel("");
		jlcaja.setIcon(new ImageIcon(FabricaGUI.class.getResource("/fabrica/caja.png")));
		jlcaja.setIconTextGap(-2);
		jlcaja.setBounds(215, 44, 50, 50);
		contentPane.add(jlcaja);
		
		jtfsuper = new JTextField();
		jtfsuper.setColumns(10);
		jtfsuper.setHorizontalAlignment(SwingConstants.CENTER);
		jtfsuper.setFont(new Font("Century", Font.PLAIN, 15));
		jtfsuper.setBounds(342, 80, 35, 35);
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
		setSuper.setBounds(382, 80, 65, 35);
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
		setsuper.setBounds(340, 53, 110, 23);
		contentPane.add(setsuper);
		
		setpaper = new JLabel("Set amount of paper per box");
		setpaper.setFont(new Font("Tahoma", Font.PLAIN, 11));
		setpaper.setBounds(180, 20, 139, 14);
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
				persona = new Thread[people.length];
				for(int i=0;i<people.length ;i++) {
					people[i] = new People(caja, i+1,buffer);
					persona[i] = new Thread(people[i]);
				}
				for(int i=0;i<p;i++) {
					persona[i].start();
				}
				bufferBox.setVisible(true);
				
		//ESTO ES ESTETICO PARA DETERMINAR LA LISTA DE PERSONAS//
				personas = new JPanel();
				personas.setBackground(new Color(255, 255, 255));
				jsp.setViewportView(personas);
				personas.setLayout(new GridLayout(people.length,1, 10, 10));
				
				jlpeoples = new JLabel[people.length];
				for(int i=0;i<jlpeoples.length;i++) {
					jlpeoples[i] = new JLabel("PEOPLE: "+(i+1));
					jlpeoples[i].setBackground(new Color(255, 255, 255));
					jlpeoples[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						CONT_PEOPLE=i;//Guardo el indice del label de la 
						
					jlpeoples[i].addMouseListener(new MouseAdapter() {		//------
						public void mouseClicked(MouseEvent a) {			//---
							//persona[CONT_PEOPLE]=null; 					//= ESTA SECCION DEBERIA QUE AL DARLE CLICK PUDIERA DETENER AL HILO!
							//System.out.println();							//=
						}													//---
					});														//------
					personas.add(jlpeoples[i]);	
				}
		//ESTO ES ESTETICO PARA DETERMINAR LA LISTA DE PERSONAS//
				
					supervisor[0] = new Supervisor(caja,1,buffer);		//--
					supervisor[0].setDaemon(true);				//----- ESTE SUPERVISOR ES DIRECTO, SOLO HAY UNO PERO EXISTE LA POSIBILIDAD DE HABER MAS PONIENDO 's'
					supervisor[0].start();						//--
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
		star.setBounds(297, 382, 153, 35);
		contentPane.add(star);
		
		jsp = new JScrollPane();
		jsp.setBackground(new Color(255, 255, 255));
		jsp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(65, 105, 225)));
		jsp.setBounds(10, 172, 160, 100);
		contentPane.add(jsp);
		
		jltext = new JLabel("Total Boxes produced");
		jltext.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jltext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jltext.setBounds(215, 155, 131, 23);
		contentPane.add(jltext);
		
		jlbuffer = new JLabel();
		jlbuffer.setVisible(false);
		jlbuffer.setIcon(new ImageIcon(FabricaGUI.class.getResource("/fabrica/buffer.jpg")));
		jlbuffer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlbuffer.setBounds(220, 175, 120, 100);
		contentPane.add(jlbuffer);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		separator.setForeground(Color.GRAY);
		separator.setBounds(10, 137, 437, 1);
		contentPane.add(separator);
		
		
		jlgestpeople = new JLabel("Display people in the factory.");
		jlgestpeople.setFont(new Font("Tahoma", Font.PLAIN, 11));
		jlgestpeople.setBounds(10, 155, 160, 14);
		contentPane.add(jlgestpeople);
		
		jlstaff = new JLabel("Staff configuration");
		jlstaff.setBounds(10, 20, 160, 14);
		contentPane.add(jlstaff);
		jlstaff.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		jlestatus = new JLabel("Supervisor status");
		jlestatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlestatus.setBounds(10, 300, 160, 14);
		contentPane.add(jlestatus);
		
		jtfsupervisor = new JTextField();
		jtfsupervisor.setHorizontalAlignment(SwingConstants.CENTER);
		jtfsupervisor.setFont(new Font("Century", Font.PLAIN, 15));
		jtfsupervisor.setEnabled(false);
		jtfsupervisor.setColumns(10);
		jtfsupervisor.setBounds(10, 316, 35, 35);
		contentPane.add(jtfsupervisor);
		
		jltext1 = new JLabel("Boxes that the supervisor ");
		jltext1.setToolTipText("");
		jltext1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		jltext1.setBounds(10, 354, 139, 14);
		contentPane.add(jltext1);
		
		jltext2 = new JLabel("to retired.");
		jltext2.setToolTipText("");
		jltext2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		jltext2.setBounds(10, 368, 75, 14);
		contentPane.add(jltext2);
		
//== BOTON STOP TIENE FALLAS AL DETENER EL HILO, VERIFICAR		
					stop = new MaterialButton();
					stop.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent a) {
							for(int i=0;i<people.length;i++) {
								people[i] = null;
							}//end for
							
						supervisor[0] = null;
						cantCajas.setText("");
						cantPro.setText("");
						jtfsupervisor.setText("");
						jtfbox.setText("");
						}
					});
					stop.setColorNormal(new Color(0,41,132));
					stop.setColorHover(new Color(63,81,181));
					stop.setColorPressed(new Color(117,125,232));
					stop.setFocusable(false);
					stop.setText("Reset factory");
					stop.setBounds(343, 342, 105, 35);
					stop.setVisible(false);  								//---- SET VISIBLE FALSE ! 
					contentPane.add(stop);
//== BOTON STOP TIENE FALLAS AL DETENER EL HILO, VERIFICAR			
	
	}//end builder
	
	public void setfabrica(FabricaGUI buffer) {
		this.buffer=buffer;
	}
}//END CLASS
