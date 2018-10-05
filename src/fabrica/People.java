package fabrica;

import javax.swing.*;
import java.awt.Cursor;

public class People extends JFrame implements Runnable {
	private Box caja;
	private int id;
	private JLabel papel;
    public People(Box caja, int id){
 		this.caja = caja;
 		this.id = id;
 		getContentPane().setLayout(null);
 		
 		papel = new JLabel("image");
 		papel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 		papel.setBounds(51, 24, 90, 73);
 		papel.setIconTextGap(-4);
 		papel.setIcon(new ImageIcon(People.class.getResource("/fabrica/papel.gif")));
 		getContentPane().add(papel);
 		
 		JTextArea jta = new JTextArea();
 		jta.setBounds(10, 126, 173, 113);
 		getContentPane().add(jta);
    }

    public void run(){
  		int tiempo = 0;
  	   	while(true){
			synchronized(caja){
  		     	while(!caja.isNoTengo()){
  			   		try{
	  				caja.wait(500);
   		   	   		}catch(Exception e){}
  			   		break;
  				}
       	  	}
	     	//Produce the paper
	 if (caja.getCantCajaActual() != caja.getMaxCantCajas())
       {
	  	try
	  	  {
		
		tiempo = (int) (Math.random()* 100 + 1);
		Thread.sleep(tiempo);
	  	}catch(InterruptedException e){}

  if(caja.getCantPapelActual() < caja.getCantMaxPapel() && caja.getCantCajaActual() != caja.getMaxCantCajas())
	{
	  caja.setNoTengo(false);
	  synchronized(caja)
	   {
  			addPapel();
		  	System.out.println("Id: "+ id + " Puso papel: "+ caja.getCantPapelActual());
			caja.notifyAll();
		}
	}
} else	break;
      
} //fin del while
 return;
}

  public synchronized void addPapel()
    {
       caja.agregarPapel();
    }
}
