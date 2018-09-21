package car_race;

import javax.swing.JPanel;

public class DeterminaGanador {
CarRaceGUI gui;
static String ganador[] = new String[10];
	public DeterminaGanador(CarRaceGUI gui) {
		this.gui=gui;
	}
public static void ganador(String nombre) {
	for(int i = 0;i<3;i++) {
	ganador[i]=nombre;
	}
}

public void imprimir() {
	for(int i = 0;i<3;i++) {
		//System.out.println(ganador[i]);
		}
}
}
