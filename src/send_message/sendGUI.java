package send_message;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sendGUI extends JFrame {

	private JPanel contentPane, panel1,panel2,panel3;
	private JTextField buffer,jtf1,jtf2;; 
	private JButton start, pause,resume,stop;
	private JTextArea jta1,jta2;
	private JButton limpiar;
	protected Thread hilo;


	public static void main(String[] args) {
					sendGUI frame = new sendGUI();
					frame.setVisible(true);
	}

	public sendGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 413);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel1 = new JPanel();
		panel1.setBounds(10, 11, 211, 328);
		contentPane.add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		jta1 = new JTextArea();
		jta1.setEditable(false);
		JScrollPane jsp1 = new JScrollPane(jta1);
		panel1.add(jsp1, BorderLayout.CENTER);
		
		panel2 = new JPanel();
		panel2.setBounds(348, 11, 211, 328);
		contentPane.add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));
		
		jta2 = new JTextArea();
		jta2.setEditable(false);
		JScrollPane jsp2 = new JScrollPane(jta2);
		panel2.add(jsp2, BorderLayout.CENTER);
		
		panel3 = new JPanel();
		panel3.setBounds(231, 11, 107, 363);
		contentPane.add(panel3);
		panel3.setLayout(null);
		
		start = new JButton("Inicio");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				
			}
		});
		start.setBounds(10, 11, 89, 23);
		panel3.add(start);
		
		stop = new JButton("Detener");
		stop.setBounds(10, 45, 89, 23);
		panel3.add(stop);
		
		pause = new JButton("Pausar");
		pause.setBounds(10, 79, 89, 23);
		panel3.add(pause);
		
		resume = new JButton("Reanudar");
		resume.setBounds(10, 113, 89, 23);
		panel3.add(resume);
		
		buffer = new JTextField();
		buffer.setBounds(0, 332, 107, 30);
		panel3.add(buffer);
		buffer.setColumns(10);
		
		limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				jta1.setText("");jta2.setText("");
				jtf1.setText("");jtf2.setText("");
				
			}
		});
		limpiar.setBounds(10, 298, 89, 23);
		panel3.add(limpiar);
		
		jtf1 = new JTextField();
		jtf1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent a) {
				if (a.getKeyCode() == KeyEvent.VK_ENTER) {
					jta1.append("   - "+jtf1.getText()+"\n");
					jtf1.setText("");
				}
			}
		});//---=== ESCUCHA DEL TECLADO~DEL TEXTIELD1
		jtf1.setBounds(10, 343, 211, 30);
		contentPane.add(jtf1);
		jtf1.setColumns(10);
		
		jtf2 = new JTextField();
		jtf2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent a) {
				if(a.getKeyCode() == KeyEvent.VK_ENTER) {
					jta2.append("   + "+jtf2.getText()+"\n");
					jtf2.setText("");
				}
			}
		});
		jtf2.setColumns(10);
		jtf2.setBounds(348, 343, 211, 30);
		contentPane.add(jtf2);
	}
}
