package chat_room;

import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import javax.swing.*;
import javax.swing.border.*;
import utils.MaterialButton;



public class ChatGUI extends JFrame implements Runnable{

	private JPanel contentPane;
	private JButton git;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					ChatGUI frame = new ChatGUI();
					frame.setTitle("ChatGUIV1.0");
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
	}
	
	public ChatGUI() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBounds(1, 30, 283, 350);
		jta.setEditable(false);
		jsp.setVisible(true);
		contentPane.add(jsp);
		
		JTextField jtfentrada = new JTextField();
		//jtfentrada.setHorizontalAlignment(SwingConstants.SOUTH);
		jtfentrada.setFont(new Font("Century", Font.PLAIN, 15));
		jtfentrada.setBounds(1, 385, 200, 25);
		contentPane.add(jtfentrada);
		
		MaterialButton aceptar = new MaterialButton();
		aceptar.setColorNormal(new Color(92,0,122));
		aceptar.setColorHover(new Color(142,36,170));
		aceptar.setColorPressed(new Color(193,88,220));
		aceptar.setText("Send");
		aceptar.setBounds(203, 384, 80, 25);
		aceptar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(jtfentrada.getText().isEmpty() == false) {
					jta.append(" *"+jtfentrada.getText() + "\n");
					jtfentrada.setText("");
				}else {
					jta.append("	Error, JTextField esta vaio!!.\n");
				}

			}
			
		});
		
		jtfentrada.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent a) {
				if (a.getKeyCode() == KeyEvent.VK_ENTER) {
					if(jtfentrada.getText().isEmpty() == false) {
						jta.append(" *"+jtfentrada.getText() + "\n");
						jtfentrada.setText("");
					}else {
						jta.append("	Error, JTextField esta vaio!!.\n");
					}
		          }//end vk_Enter
			}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
		});
		contentPane.add(aceptar);
		
		git = new JButton("");
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
		git.setRolloverSelectedIcon(new ImageIcon(ChatGUI.class.getResource("/chat_room/github2.png")));
		git.setRolloverIcon(new ImageIcon(ChatGUI.class.getResource("/chat_room/github2.png")));
		git.setIcon(new ImageIcon(ChatGUI.class.getResource("/chat_room/github.png")));
		git.setIconTextGap(-11);
		git.setFocusable(false);
		git.setContentAreaFilled(false);
		git.setBorderPainted(false);
		git.setBounds(-5, -5, 35, 35);
		git.setVisible(true);
		contentPane.add(git);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
