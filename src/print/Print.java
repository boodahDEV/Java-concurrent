package print;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Print extends JFrame{

	protected JPanel contentPane,panel;
	protected JTextArea jta;
	protected JTextField jtfentrada;
	protected JButton ejecutar;
	protected JButton exit,git,clear;
	protected JLabel errores;
	protected int x,y;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
					Print frame = new Print();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
		
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			jta.setEditable(false);
			jsp.setBounds(10, 110, 254, 258);
		contentPane.add(jsp);
		
		jtfentrada = new JTextField();
		jtfentrada.setFont(new Font("Roboto Condensed Light", Font.PLAIN, 15));
		jtfentrada.setBounds(84, 50, 86, 25);
		contentPane.add(jtfentrada);
		jtfentrada.setColumns(10);
		
		ejecutar = new JButton("Ejecutar");
		ejecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				ejecutar.setEnabled(false);
				clear.setEnabled(false);
				try {
					int time = Integer.parseInt(jtfentrada.getText());
					Thread hilo = new Thread(new Procesos(jta,errores,ejecutar,clear,time));
					 hilo.start(); //Se inicia el hilo
					 errores.setForeground(new Color(255,0,0));
				}catch(Exception e) {
					errores.setVisible(true);
					jta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
					errores.setText("Parametro incorrecto!");
					ejecutar.setEnabled(true);
					clear.setEnabled(true);
				}
			}
		});
		ejecutar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ejecutar.setFocusable(false);
		ejecutar.setBounds(175, 50, 85, 25);
		contentPane.add(ejecutar);
		
		clear = new JButton("Limpiar");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jta.getText().isEmpty()==false || jtfentrada.getText().isEmpty()==false){
					jta.setText("");
					jtfentrada.setText("");
					ejecutar.setEnabled(true);
					errores.setVisible(true);
					errores.setForeground(new Color(50,205,50));
					errores.setText("Limpiado exitoso!!! ");
				
				}
				jta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				errores.setVisible(false);
			}
		});
		clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clear.setFocusable(false);
		clear.setBounds(175, 80, 85, 25);
		contentPane.add(clear);
		
		errores = new JLabel("");
		errores.setVisible(false);
		errores.setForeground(new Color(255, 0, 0));
		errores.setFont(new Font("Roboto Condensed", Font.BOLD | Font.ITALIC, 15));
		errores.setBounds(10, 91, 160, 14);
		contentPane.add(errores);
		
		git = new JButton("");
		git.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		git.setRolloverSelectedIcon(new ImageIcon(Print.class.getResource("/print/github2.png")));
		git.setRolloverIcon(new ImageIcon(Print.class.getResource("/print/github2.png")));
		git.setIcon(new ImageIcon(Print.class.getResource("/print/github.png")));
		git.setIconTextGap(-11);
		git.setFocusable(false);
		git.setContentAreaFilled(false);
		git.setBorderPainted(false);
		git.setBounds(1, 34, 30, 30);
		contentPane.add(git);
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent a) {
				x = a.getX();
				y = a.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent a) {
				int xx = a.getXOnScreen();
				int yy = a.getYOnScreen();
				
				setLocation(xx-x,yy-y);
			}
		});
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(1, 1, 273, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		exit = new JButton("");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				System.exit(0);
			}
		});
		exit.setRolloverSelectedIcon(new ImageIcon(Print.class.getResource("/print/exit2.png")));
		exit.setRolloverIcon(new ImageIcon(Print.class.getResource("/print/exit2.png")));
		exit.setIcon(new ImageIcon(Print.class.getResource("/print/exit.png")));
		exit.setIconTextGap(-11);
		exit.setFocusable(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.setBounds(245, 3, 25, 25);
		panel.add(exit);
	}
}
