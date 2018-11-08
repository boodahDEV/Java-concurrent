package send_message;

import javax.swing.*;
public class Runner extends Thread {

	protected JTextArea jta1,jta2;
	protected JTextField buffer;
	protected String mensaje;
	
	public Runner(JTextArea jta1, JTextArea jta2, JTextField buffer, String mensaje) {
		this.jta1 = jta1;
		this.jta2 = jta2;
		this.buffer = buffer;
		this.mensaje = mensaje;
	}
	
	public void run() {
		while(true) {
			while(jta1.getText().isEmpty() || jta2.getText().isEmpty()) {
				try {
					wait();
					System.out.print(".");
				}catch(Exception e) {System.out.println("ERROR hilo no esperando!! ");}
				break;
			}//---=== END
			
			
		}
	}//---=== FIN METODO RUN
}
