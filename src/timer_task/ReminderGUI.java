package timer_task;

import java.util.Timer;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.event.*;
import java.net.URI;

import utils.MaterialButton;

public class ReminderGUI extends JFrame {

	private JPanel contentPane,title,display,component;
	private JTextField jtfmensaje,jtftiempo;
	private JTextArea jta;
	private int x,y;
	private JButton exit;
	private MaterialButton setmessage, settiempo,start;
	private JLabel alert;
	private JButton git;
	
	public static void main(String[] args) {
					ReminderGUI frame = new ReminderGUI();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ReminderGUI() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 367);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(75,0,115)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		title = new JPanel();
		title.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent a) {
				int xx = a.getXOnScreen();
				int yy = a.getYOnScreen();
				setLocation(xx-x,yy-y);
			}
		});
		title.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent a) {
				x=a.getX();
				y=a.getY();
			}
		});
		title.setBackground(new Color(75,0,115));
		title.setBounds(1, 1, 357, 40);
		contentPane.add(title);
		title.setLayout(null);
		
		exit = new JButton("");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.setBorderPainted(false);
		exit.setBorder(null);
		exit.setDisplayedMnemonicIndex(-1);
		exit.setRolloverSelectedIcon(new ImageIcon(ReminderGUI.class.getResource("/timer_task/exit.png")));
		exit.setRolloverIcon(new ImageIcon(ReminderGUI.class.getResource("/timer_task/exit.png")));
		exit.setIcon(new ImageIcon(ReminderGUI.class.getResource("/timer_task/exit2.png")));
		exit.setIconTextGap(-1);
		exit.setFocusable(false);
		exit.setContentAreaFilled(false);
		exit.setBounds(330, 9, 20, 20);
		title.add(exit);
		
		JLabel titulo = new JLabel("ReminderV1.0");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titulo.setBounds(10, 0, 228, 40);
		title.add(titulo);
		
		component = new JPanel();
		component.setBackground(new Color(255, 255, 255));
		component.setBounds(1, 270, 357, 95);
		contentPane.add(component);
		component.setLayout(null);
		
		jtfmensaje = new JTextField();
		jtfmensaje.setHorizontalAlignment(SwingConstants.CENTER);
		jtfmensaje.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtfmensaje.setBounds(5, 5, 149, 35);
		component.add(jtfmensaje);
		jtfmensaje.setColumns(10);
		
		jtftiempo = new JTextField();
		jtftiempo.setHorizontalAlignment(SwingConstants.CENTER);
		jtftiempo.setColumns(10);
		jtftiempo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtftiempo.setBounds(5, 45, 149, 35);
		component.add(jtftiempo);
		
		setmessage = new MaterialButton();
		setmessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (jtfmensaje.getText().isEmpty() == false) {
					titulo.setText("ReminderV1.0");
					title.setBackground(new Color(75,0,115));
					jtfmensaje.setEnabled(false);
					setmessage.setEnabled(false);
				}else {
					title.setBackground(new Color(220, 20, 60));
					//jtfmensaje.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(220, 20, 60)));
					titulo.setText("Entry error, try again");
				}
			}
		});
		setmessage.setText("Set Text");
		setmessage.setFocusable(false);
		setmessage.setColorNormal(new Color(75,0,115));
		setmessage.setColorHover(new Color(174,82,212));
		setmessage.setColorPressed(new Color(123,31,162));
		setmessage.setBounds(159, 5, 75, 35);
		component.add(setmessage);
		
		settiempo = new MaterialButton();
		settiempo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (jtftiempo.getText().isEmpty() == false && Integer.parseInt(jtftiempo.getText().trim()) > 0) {
						titulo.setText("ReminderV1.0");
						title.setBackground(new Color(75,0,115));
						jtftiempo.setEnabled(false);
						settiempo.setEnabled(false);
					}else {
						title.setBackground(new Color(220, 20, 60));
						titulo.setText("Entry error, try again");
					}
				}catch(Exception e) {
					title.setBackground(new Color(220, 20, 60));
					titulo.setText("Entry error, try again");
					}
			}//end actionperformed
		});
		settiempo.setText("Set Time");
		settiempo.setFocusable(false);
		settiempo.setColorNormal(new Color(75,0,115));
		settiempo.setColorHover(new Color(174,82,212));
		settiempo.setColorPressed(new Color(123,31,162));
		settiempo.setBounds(159, 45, 75, 35);
		component.add(settiempo);
		
		start = new MaterialButton();
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtfmensaje.isEnabled() == false && jtftiempo.isEnabled() == false) {
					titulo.setText("ReminderV1.0");
					title.setBackground(new Color(75,0,115));
					
					/*New del Reminder*/
					Timer time = new Timer();
					ReminderTT_GUI r = new ReminderTT_GUI(jtfmensaje.getText(),jta,alert);
					time.schedule(r, (Integer.parseInt(jtftiempo.getText().trim())*1000));
					/*New del Reminder*/
					
					jtftiempo.setEnabled(true);jtftiempo.setText("");
					settiempo.setEnabled(true);
					jtfmensaje.setEnabled(true);jtfmensaje.setText("");
					setmessage.setEnabled(true);
					
				}else {
					title.setBackground(new Color(220, 20, 60));
					titulo.setText("Fields not selected.");
				}
			}
		});
		start.setText("Start");
		start.setFocusable(false);
		start.setColorNormal(new Color(75,0,115));
		start.setColorHover(new Color(174,82,212));
		start.setColorPressed(new Color(123,31,162));
		start.setBounds(275, 55, 75, 35);
		component.add(start);
		
		git = new JButton("");
		git.setBounds(293, 10, 40, 40);
		component.add(git);
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
		git.setRolloverSelectedIcon(new ImageIcon(ReminderGUI.class.getResource("/timer_task/github2.png")));
		git.setRolloverIcon(new ImageIcon(ReminderGUI.class.getResource("/timer_task/github2.png")));
		git.setIcon(new ImageIcon(ReminderGUI.class.getResource("/timer_task/github.png")));
		git.setIconTextGap(-10);
		git.setFocusable(false);
		git.setContentAreaFilled(false);
		git.setBorderPainted(false);
		
		display = new JPanel();
		display.setBackground(new Color(255, 255, 255));
		display.setBounds(1, 45, 357, 220);
		contentPane.add(display);
		display.setLayout(null);
		
		jta = new JTextArea();
		jta.setFont(new Font("Monospaced", Font.PLAIN, 15));
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setBorder(null);
		jta.setEditable(false);
		jsp.setBounds(10, 11, 259, 198);
		display.add(jsp);
		
		alert = new JLabel(" ");
		alert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent a) {
				jta.setText("");
				alert.setVisible(false);
			}
		});
		alert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		alert.setVisible(false);
		alert.setIcon(new ImageIcon(ReminderGUI.class.getResource("/timer_task/alarma.png")));
		alert.setBounds(290, 83, 50, 50);
		display.add(alert);
	}
}
