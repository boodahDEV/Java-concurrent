package print;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Print extends JFrame {

	private JPanel contentPane;
	private JTextField jtfentrada;
	private JButton ejecutar;
	private JPanel panel;
	private JButton exit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					Print frame = new Print();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Print() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 375);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea jta = new JTextArea();
		jta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		jta.setText("ok");
		jta.setBounds(10, 110, 254, 258);
		contentPane.add(jta);
		
		jtfentrada = new JTextField();
		jtfentrada.setFont(new Font("Roboto Condensed Light", Font.PLAIN, 15));
		jtfentrada.setBounds(84, 50, 86, 25);
		contentPane.add(jtfentrada);
		jtfentrada.setColumns(10);
		
		ejecutar = new JButton("Ejecutar");
		ejecutar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ejecutar.setFocusable(false);
		ejecutar.setBounds(175, 50, 85, 25);
		contentPane.add(ejecutar);
		
		JButton clear = new JButton("Limpiar");
		clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clear.setFocusable(false);
		clear.setBounds(175, 80, 85, 25);
		contentPane.add(clear);
		
		JLabel errores = new JLabel("Error");
		errores.setBounds(10, 91, 160, 14);
		contentPane.add(errores);
		
		panel = new JPanel();
		panel.setBounds(1, 1, 273, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		exit = new JButton(" ");
		exit.setIcon(new ImageIcon(this.getClass().getResource("exit.png")));
		exit.setIconTextGap(-100);
		exit.setFocusable(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.setBounds(245, 3, 25, 25);
		panel.add(exit);
	}
}
