package fabrica;

public class Box {
	   boolean noTengo=false;
	    private static int cantPapelActual;
	    private static int cantCajaActual;
	    private static int cantMaxCaja;
	    private static int cantMaxPapel;

	    public Box(int cantMaxCaja,int cantMaxPapel )
	    {
	    	this.cantMaxCaja= cantMaxCaja;
	    	this.cantMaxPapel= cantMaxPapel;
	    }

	    public synchronized boolean isNoTengo()
	    {
	       return noTengo;
	    }

	    public synchronized void setNoTengo(boolean b)
	    {
	       noTengo = b;
	    }

	    public synchronized void agregarPapel()
	    {
	       cantPapelActual++;
	    }

	    public synchronized int getCantPapelActual()
	    {
	       return(cantPapelActual);
	    }

	     public synchronized void setCantPapelActual(int cant)
	    {
	       cantPapelActual=cant;
	    }

	     public synchronized int getCantMaxPapel()
	    {
	       return(cantMaxPapel);
	    }

	     public synchronized void setCantMaxPapel(int cant)
	    {
	       cantMaxPapel=cant;
	    }
	    public synchronized int getCantCajaActual()
	    {
	       return(cantCajaActual);
	    }

	    public synchronized void setCantCajaActual(int cant)
	    {
	       cantCajaActual=cant;
	    }

	     public synchronized int getMaxCantCajas()
	    {
	       return(cantMaxCaja);
	    }

	    public synchronized void setMaxCantCajas(int cant)
	    {
	       cantMaxCaja=cant;
	    }
	    
	    public synchronized void setCajaTerminada() {
	    	cantCajaActual++;
	    }

}
