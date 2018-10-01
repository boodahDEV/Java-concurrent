package fabrica;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import utils.MaterialButton;
import java.awt.event.*;



public class FabricaGUI extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField cantCajas;
	private JTextField cantPapel;

	public static void main(String[] args) {
					FabricaGUI frame = new FabricaGUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				
	}

	
	
	public FabricaGUI() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 57, 184, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		cantCajas = new JTextField();
		cantCajas.setBounds(5, 22, 86, 35);
		panel.add(cantCajas);
		cantCajas.setColumns(10);
		
		cantPapel = new JTextField();
		cantPapel.setColumns(10);
		cantPapel.setBounds(5, 60, 86, 30);
		panel.add(cantPapel);
		
		MaterialButton cantC = new MaterialButton();
		cantC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cantC.setBounds(95, 22, 79, 35);
		cantC.setText("Set box");
		panel.add(cantC);
		
		MaterialButton materialButton = new MaterialButton();
		materialButton.setBounds(95, 60, 79, 35);
		panel.add(materialButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 436, 456, 20);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JSlider deslisar = new JSlider(1,100);
		deslisar.setBounds(269, 57, 28, 101);
		contentPane.add(deslisar);
		deslisar.setOrientation(SwingConstants.VERTICAL);
		
		JLabel jlcaja = new JLabel("");
		jlcaja.setIcon(new ImageIcon(FabricaGUI.class.getResource("/fabrica/caja.png")));
		jlcaja.setIconTextGap(-2);
		jlcaja.setBounds(217, 83, 50, 50);
		contentPane.add(jlcaja);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
