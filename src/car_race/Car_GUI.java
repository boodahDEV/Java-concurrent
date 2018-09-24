package car_race;

import javax.swing.*;

public class Car_GUI extends Thread {
	String nombre;
	JLabel label, ganador;
	JTextArea jta;
	int finish, yy,xxpanel, corrida,x;
	
	
	public Car_GUI(String nombre, JLabel label, int finish, int yy, JLabel ganador, int xxpanel,JTextArea jta,int x) {
		super(nombre);
		this.nombre=nombre;
		this.label=label;
		this.finish=finish;
		this.ganador=ganador;
		this.xxpanel=xxpanel;
		this.jta=jta;
		this.x=x;
	}
	
	public void run() {
		int time = (int) (Math.random() * 5000);
	
		for(int i=1;i<=finish;i++) {
			
			try {
				Thread.sleep(time);
			}catch(Exception e) {}
			
			int yy = label.getY();
			corrida = i*66;
			
			if(corrida <= xxpanel) {
			label.setBounds(corrida,yy,45, 20);
			System.out.println(nombre + " -> "+i);
			}else {
				ganador.setVisible(true);
				System.out.println("BREAK-----"+currentThread());
				break;
			}
		}//end for
		ganador.setVisible(true);
		jta.setCaretPosition(jta.getDocument().getLength());
		jta.append((x+1) + "-"+ currentThread().getName() + " finished!\n");
		System.out.println(nombre + " finished!"+"\n");
		
	}
}//end class
