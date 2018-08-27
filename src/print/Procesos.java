package print;

import javax.swing.*;

public class Procesos implements Runnable{
    boolean suspender; //Suspende un hilo cuando es true
    boolean pausar;    //Detiene un hilo cuando es true
    JTextArea jta;
    JPanel panel;
    Procesos(JTextArea jta,JPanel panel){
    	this.jta=jta;
    	this.panel=panel;
    }
    
    
	// ejecucion //
    public void run() {
    	
    }//run 

}
