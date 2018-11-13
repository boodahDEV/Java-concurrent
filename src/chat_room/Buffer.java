package chat_room;

import javax.swing.*;
import java.awt.Color;

public class Buffer extends JFrame{
	protected  JTextField b;
	//protected  JTextField j;
	protected boolean bandera;
	public Buffer() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("BufferV1.0");
		setResizable(false);
		setSize(325,188);
		getContentPane().setLayout(null);
		
		b = new JTextField("");
		b.setEnabled(false);
		b.setBounds(10, 11, 287, 38);
		getContentPane().add(b);
		

	}
	
	public synchronized boolean bestaVacio() {
		if(b.getText().isEmpty() == true) {
		return true;
		}else {
			return false;
		}
	}
	
	public void setvacio(boolean valor) {
		bandera = valor;
	}
	
	public boolean estaVacio() {
		return bandera;
	}

}
