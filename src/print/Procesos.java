package print;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class Procesos implements Runnable{
   JTextArea jta;
   JButton ejecutar,limpiar;
   JLabel errores;
   int time,temp;
    Procesos(JTextArea jta,JLabel errores ,JButton ejecutar,JButton limpiar,int time){
    	this.jta=jta;
    	this.time=time;
    	this.errores=errores;
    	this.ejecutar=ejecutar;
    	this.limpiar = limpiar;
    }
    
    
	// ejecucion //
    public void run() {
    	jta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(50, 205, 50)));
    	try {
    		errores.setVisible(false);
    		temp=1;
    	while(temp != (time/1000)+1){
    		jta.append("   "+temp+".\n");
    		Thread.sleep(1000);
    		temp++;
    	}

    	}catch(Exception e) {
    		errores.setVisible(true);
    		errores.setText("Error en el hilo!");
    	}
    jta.append("\n\n   End run().");
    jta.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		errores.setVisible(true);
		errores.setForeground(new Color(50,205,50));
		errores.setText("main() is ending");
		//ejecutar.setEnabled(true);
		limpiar.setEnabled(true);
		
    }//run 

}
