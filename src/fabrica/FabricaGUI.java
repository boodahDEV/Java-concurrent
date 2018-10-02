package fabrica;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import utils.MaterialButton;
import java.awt.event.*;



public class FabricaGUI extends JFrame implements Runnable{

	private JPanel contentPane,control;
	private JLabel jlcaja;
	private MaterialButton cantcaja,materialButton_1,setProduc,setSuper;
	private JCheckBox setsuper;
	private JTextField cantCajas,cantPro,jtfsuper;
	private int s=1,p=1,c,cantPapel;
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
		panel.setBounds(10, 57, 160, 101);
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
				if(cantcaja.isEnabled() == true ) {
					cantcaja.setEnabled(false);
					cantcaja.setEnabled(false);
				}
			}
		});
		cantcaja.setBounds(55, 20, 79, 32);
		cantcaja.setText("Set box");
		panel.add(cantcaja);
		
		setProduc = new MaterialButton();
		setProduc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				
			}
			
		});
		setProduc.setText("Set people");
		setProduc.setColorNormal(new Color(0,41,132));
		setProduc.setColorHover(new Color(63,81,181));
		setProduc.setColorPressed(new Color(117,125,232));
		setProduc.setFocusable(false);
		setProduc.setBounds(55, 60, 79, 30);
		panel.add(setProduc);
		
		control = new JPanel();
		control.setBounds(10, 436, 456, 20);
		contentPane.add(control);
		control.setLayout(null);
		
		JSlider deslisar = new JSlider(1,100);
		deslisar.setBackground(new Color(255, 255, 255));
		deslisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deslisar.setFocusable(false);
		deslisar.setBounds(247, 57, 28, 101);
		contentPane.add(deslisar);
		deslisar.setOrientation(SwingConstants.VERTICAL);
		
		jlcaja = new JLabel("");
		jlcaja.setIcon(new ImageIcon(FabricaGUI.class.getResource("/fabrica/caja.png")));
		jlcaja.setIconTextGap(-2);
		jlcaja.setBounds(197, 84, 50, 50);
		contentPane.add(jlcaja);
		
		jtfsuper = new JTextField();
		jtfsuper.setColumns(10);
		jtfsuper.setHorizontalAlignment(SwingConstants.CENTER);
		jtfsuper.setFont(new Font("Century", Font.PLAIN, 15));
		jtfsuper.setBounds(347, 84, 35, 35);
		jtfsuper.setEnabled(false);
		contentPane.add(jtfsuper);
		
		setSuper = new MaterialButton();
		setSuper.setText("Add ");
		setSuper.setEnabled(false);
		setSuper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(jtfsuper.isEnabled() == true) {
					jtfsuper.setEnabled(false);
					setSuper.setEnabled(false);
					setsuper.setEnabled(false);
					s=Integer.parseInt(jtfsuper.getText().trim());
				}
			}
			
		});
		setSuper.setColorNormal(new Color(0,41,132));
		setSuper.setColorHover(new Color(63,81,181));
		setSuper.setColorPressed(new Color(117,125,232));
		setSuper.setFocusable(false);
		setSuper.setBounds(382, 84, 69, 35);
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
		setsuper.setBounds(345, 57, 110, 23);
		contentPane.add(setsuper);
		
	}//end builder

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
