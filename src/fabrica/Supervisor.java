package fabrica;
import javax.swing.*;

public class Supervisor extends Thread{
	private Box caja;
	private int id;
    private int i=0;
    protected FabricaGUI buffer;
    
    public Supervisor(Box caja, int id,FabricaGUI buffer){
 		this.caja = caja;
        this.id=id;
        this.buffer=buffer;
    }//END CONSTRUCTOR

    public void run(){
  	 while(true){
	   synchronized(caja){
  		  while(caja.isNoTengo()){
  			  			try{
  			  				System.out.println("Supervisor: " +id+" is waiting...");
  			  				caja.wait(1000);
  			  			}catch(InterruptedException e){}
  			  	break;
  		    }//end while
       } // end synchronized
	    
	   
	if( caja.getCantPapelActual() == caja.getCantMaxPapel()){
		 caja.setNoTengo(false);
		 synchronized(caja){
		   if (caja.getCantCajaActual() != caja.getMaxCantCajas()){
		  	  quitarCaja();
			  System.out.println("Supervisor: " + id+" Quita la Cajeta:" + caja.getCantCajaActual());
			  buffer.jtfsupervisor.setText(""+caja.getCantCajaActual()); // === SE MANDA EL NUMERO DE CAJAS QUE QUITO EL SUPERVISOR AL BUFFER!
			  		buffer.jtfbox.getText();							 // === 
			  		buffer.jtfbox.setText(""+(Integer.parseInt(buffer.jtfbox.getText())-1));  //--- PRUEBA!
			  buffer.jlbuffer.setVisible(false);						 
			  buffer.repaint();
		  	caja.notifyAll();
			caja.setNoTengo(true);
			}else{
				buffer.setVisible(true);
				  caja.notifyAll();
				  break;
				  }//end if
			   }//end syncronized
 		  }//end if main
 		}//end while main
   	}//end run

public synchronized void quitarCaja()
    {
       caja.setCantPapelActual(0);
       caja.setCantCajaActual(++i);
    }
 }
