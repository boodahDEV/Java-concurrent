package chat_room;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import utils.MaterialButton;

public class ChatGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					ChatGUI frame = new ChatGUI();
					ChatGUIConsumidor  frameC = new ChatGUIConsumidor ();
					frameC.setTitle("ChatGUIConsumidorV1.0");
					frame.setTitle("ChatGUIV1.0");
					frameC.setLocationRelativeTo(null);
					frame.setLocationRelativeTo(null);
					frameC.setVisible(true);
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
		jta.setBounds(1, 1, 299, 380);
		jta.setEditable(false);
		jta.setVisible(true);
		contentPane.add(jta);
		
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
					jta.append(jtfentrada.getText() + "\n");
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
						jta.append(jtfentrada.getText() + "\n");
						jtfentrada.setText("");
					}else {
						jta.append("Error, JTextField esta vaio!!.\n");
					}
		          }//end vk_Enter
			}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
		});
		contentPane.add(aceptar);
		
		
		
	}

}
