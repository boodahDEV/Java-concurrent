package car_race;

import javax.swing.*;

public class Car_GUI extends Thread {
	String nombre;
	JLabel label;
	int finish, yy;
	
	
	public Car_GUI(String nombre, JLabel label, int finish, int yy) {
		this.nombre=nombre;
		this.label=label;
		this.finish=finish;
	}
	
	public void run() {
		int time = (int) (Math.random() * 5000);
		
		for(int i=1;i<=finish;i++) {
			
			try {
				Thread.sleep(time);
			}catch(Exception e) {}
			int yy = label.getY();
			label.setBounds(i*66,yy,45, 20);
			System.out.println(nombre + " -> "+i);
		}//end for
		System.out.println(nombre + " finished!"+"\n");
		DeterminaGanador.ganador(this.getName());
	}
}//end class
