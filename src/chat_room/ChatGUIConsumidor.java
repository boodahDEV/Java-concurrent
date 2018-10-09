package chat_room;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.MaterialButton;

public class ChatGUIConsumidor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					ChatGUIConsumidor  frame = new ChatGUIConsumidor ();
					frame.setTitle("ChatGUIConsumidorV1.0");
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
	}
	
	public ChatGUIConsumidor () {
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
		aceptar.setColorNormal(new Color(0,91,159));
		aceptar.setColorHover(new Color(1,136,209));
		aceptar.setColorPressed(new Color(94,184,255));
		aceptar.setText("Send");
		aceptar.setBounds(203, 384, 80, 25);
		aceptar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(jtfentrada.getText().isEmpty() == false) {
					jta.append(" #"+jtfentrada.getText() + "\n");
					jtfentrada.setText("");
				}else {
					jta.append("Error, JTextField esta vaio!!.\n");
				}

			}
			
		});
		
		jtfentrada.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent a) {
				if (a.getKeyCode() == KeyEvent.VK_ENTER) {
					if(jtfentrada.getText().isEmpty() == false) {
						jta.append(" #"+jtfentrada.getText() + "\n");
						jtfentrada.setText("");
					}else {
						jta.append("Error, JTextField esta vaio!!.\n");
					}
		          }//end if vk_enter
			}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
		});
		contentPane.add(aceptar);
		
		
		
	}
}
