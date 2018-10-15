package chat_room;

import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import javax.swing.*;
import javax.swing.border.*;
import utils.MaterialButton;



public class ChatGUIConsumidor extends JFrame implements Runnable{

	protected JPanel contentPane;
	protected JButton git,connections,activo;
	protected JTextField jtfentrada;
	protected JTextArea jta;
	protected String temporal[];
	protected int cont =0;
	protected Buffer buffer;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		

	}//end main
	
	public ChatGUIConsumidor(Buffer buffer) {
		this.buffer= buffer;
		temporal= new String[20];

		
		setTitle("ChatGUIConsumerV1.0");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBounds(1, 30, 282, 336);
		jta.setEditable(false);
		jsp.setVisible(true);
		contentPane.add(jsp);
		
		jtfentrada = new JTextField();
		jtfentrada.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
		jtfentrada.setFont(new Font("Century", Font.PLAIN, 17));
		jtfentrada.grabFocus(); 
		jtfentrada.setBounds(1, 370, 200, 38);
		contentPane.add(jtfentrada);
		
		MaterialButton aceptar = new MaterialButton();
		aceptar.setColorNormal(new Color(0,91,159));
		aceptar.setColorHover(new Color(1,136,209));
		aceptar.setColorPressed(new Color(94,184,255));
		aceptar.setText("Send");
		aceptar.setBounds(205, 370, 75, 38);
		aceptar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(jtfentrada.getText().isEmpty() == false) {
					cont++;
					jtfentrada.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
					jta.append(" ME: "+jtfentrada.getText() + "\n");
					obtenerTexto(jtfentrada.getText(),cont);
					jtfentrada.setText("");
				}else {
					jtfentrada.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(239,83,80)));
				}

			}//end actionperformed
			
		});
		
		jtfentrada.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent a) {
				if (a.getKeyCode() == KeyEvent.VK_ENTER) {
					if(jtfentrada.getText().isEmpty() == false) {
						cont++;
						jtfentrada.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
						jta.append(" ME: "+jtfentrada.getText() + "\n");
						obtenerTexto(jtfentrada.getText(),cont);
						jtfentrada.setText("");
					}else {
						jtfentrada.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(239,83,80)));	
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
		
		activo = new JButton("");
				activo.setToolTipText("Thread start!");
		activo.setRolloverSelectedIcon(new ImageIcon(ChatGUI.class.getResource("/chat_room/act_thread2.png")));
		activo.setRolloverIcon(new ImageIcon(ChatGUI.class.getResource("/chat_room/act_thread2.png")));
		activo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		activo.setIconTextGap(-10);
		activo.setIcon(new ImageIcon(ChatGUI.class.getResource("/chat_room/act_thread.png")));
		activo.setFocusable(false);
		activo.setBorder(null);
		activo.setContentAreaFilled(false);
		activo.setBounds(254, 1, 25, 25);
		activo.setVisible(false);
		contentPane.add(activo);
		
		connections = new JButton("");
				connections.setToolTipText("Conectado");
		connections.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		connections.setRolloverSelectedIcon(new ImageIcon(ChatGUI.class.getResource("/chat_room/connection2.png")));
		connections.setRolloverIcon(new ImageIcon(ChatGUI.class.getResource("/chat_room/connection2.png")));
		connections.setIcon(new ImageIcon(ChatGUI.class.getResource("/chat_room/connection.png")));
		connections.setIconTextGap(-10);
		connections.setFocusable(false);
		connections.setContentAreaFilled(false);
		connections.setBorder(null);
		connections.setBounds(220, 1, 25, 25);
		connections.setVisible(false);
		contentPane.add(connections);
		
	}//end contructor

	@Override
	public void run() {	// este hilo debe ser daemon// este hilo debe ser daemon
		System.out.println("HILO2");
		activo.setVisible(true);
		
		while(true) {
			if(buffer.estaVacio() == true) {  // Tomar en cuenta el buffer  -> && buffer.j.getText().isEmpty() == true 		//esto es sobre la recepcion de mensajes 
				try {
					System.out.println("wait2");
					wait();
				}catch(Exception e) {}
			}
			break;
		}// end while

		if(buffer.estaVacio() == true) {
			for(int i=0;i<temporal.length;i++) {

				if(buffer.estaVacio() == true) {
					buffer.b.setText("USER: "+temporal[i]);
					System.out.println("E2");
				
					//temporal[i]="";
					buffer.setvacio(false);
				}
			}//end for
		}// end if		
		
			//System.out.println("Dentro else");
		synchronized(buffer) {
			if(buffer.estaVacio()==false) {
				System.out.println("pegando2 ");
				jta.append(""+buffer.b.getText()+"\n");
				buffer.b.setText("");
				buffer.setvacio(true);
			}
			buffer.setvacio(true);
		}
		
//end while
	}//end run
	
	public synchronized void obtenerTexto(String texto, int cont) {
		temporal[cont - 1]=texto;
		System.out.println("Seteado : "+temporal[cont - 1] +" 	->"+cont);
	}//end obtenerTexto
}
