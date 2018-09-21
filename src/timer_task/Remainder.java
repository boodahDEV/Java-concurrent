package timer_task;

import java.util.TimerTask;

public class Remainder extends TimerTask {
String mensaje;
public Remainder(String mensaje) {
	this.mensaje=mensaje;
}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(mensaje);
	}

}
