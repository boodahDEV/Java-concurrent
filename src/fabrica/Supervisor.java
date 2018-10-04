package fabrica;


public class Supervisor extends Thread{
	private Box caja;
	private int id;
    private int i=0;

    public Supervisor(Box caja, int id){
 		this.caja = caja;
        this.id=id;
    }

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
		  	caja.notifyAll();
			caja.setNoTengo(true);
			}else{
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
