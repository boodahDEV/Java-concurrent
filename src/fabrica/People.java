package fabrica;

import javax.swing.*;

public class People extends JPanel implements Runnable {
	private Box caja;
	private int id;

    public People(Box caja, int id){
 		this.caja = caja;
 		this.id = id;
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
