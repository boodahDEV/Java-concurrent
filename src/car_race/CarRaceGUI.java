package car_race;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import utils.MaterialButton;

public class CarRaceGUI extends JFrame {

	private JPanel contentPane,pista,meta,display;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					CarRaceGUI frame = new CarRaceGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

	}

	/**
	 * Create the frame.
	 */
	public CarRaceGUI() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 365);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(8,127,35)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pista = new JPanel();
		pista.setBounds(10, 85, 377, 269);
		contentPane.add(pista);
		pista.setLayout(null);
		
		meta = new JPanel();
		meta.setBounds(397, 85, 98, 269);
		contentPane.add(meta);
		meta.setLayout(null);
		
		display = new JPanel();
		//display.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(8,127,35)));
		display.setBackground(new Color(8,127,35));
		display.setBounds(0, 0, 632, 35);
		contentPane.add(display);
		display.setLayout(null);
		
		MaterialButton materialButton = new MaterialButton();
		materialButton.setBounds(505, 85, 117, 35);
		materialButton.setColorNormal(new Color(8,127,35));
		materialButton.setColorHover(new Color(76,175,80));
		materialButton.setColorPressed(new Color(118,210,117));
		contentPane.add(materialButton);
	}
}
