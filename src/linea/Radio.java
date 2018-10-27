package linea;

public class Radio{
	public final int MAXWATT = 300;
	public final float MAXFM = 107.0f;
	public final float MINFM = 88.0f;
	public final float MAXAM = 2000.0f;
	public final float MINAM = 1000.0f;
	public final int MAXVOL = 10;
	public final int MINVOL = 0;
	public int volumen;
	public float tuning;
	public char banda;
	public boolean estereomono;
	public boolean onoff;
	
	public void turnOn(int v,float t,char b){
	if(onoff==false){
	onoff=true;
	estereomono=true;
	setVolumen(v);
	setBand(b);
	setTuning(t);
	setEstereoMono();
	System.out.println("Estado del radio: " +despliegaValores());}
	else
	 System.out.println("\nLa radio ya esta encendida");	
	}
	public String despliegaValores(){
	 if(onoff)
	   return("\nVolumen: "+getVolume()+"\nEmisora: "+getTuning()+"\nEstereo: "+estereomono+"\nBanda: "+getBand());
	 else
	   return("\nRadio Encendida: "+onoff);	 	  
	}
       public void turnOff(){
	 if(onoff)
	    onoff=false;
	 else
	System.out.println("\nLa radio esta ya apagada");	 
	}
	public void setVolumen(int v){
	if(onoff)
         volumen=v;		 
	else
	System.out.println("\nLa radio esta ya apagada");			  		
	}
	public void setBand(char b){
		if(onoff){
		switch(b){
		          case 'f':banda='F';
			  break;
			  case 'm':banda='M';
			  break;
			  default:
			     System.out.println("\nError, Am por default");
			     banda='M';
		}}
	else
	System.out.println("\nLa radio esta ya apagada");			  		
	}
	public void setTuning(float t){
	if(onoff)
          tuning=t;		 
	else
	System.out.println("\nLa radio esta ya apagada");			  		
	}
	public void setEstereoMono(){
	if(onoff)
	if(estereomono){	
	estereomono=false;
	System.out.println("\n Mono");
	}
	else{
	estereomono=true;
	System.out.println("\n Estereo");} 	
	else
	System.out.println("\nLa radio esta ya apagada");			  		
	}
	
	public void turnUpVolumen(){
	if(onoff){
         if(volumen<MAXVOL)
	    volumen++;
	 else
	System.out.println("\nMaximo volumen");}	            		 
	else
	 System.out.println("\nLa radio esta ya apagada");
	}
	public void turnDownVolumen(){
	if(onoff){
         if(volumen>MINVOL)
	    volumen--;
	 else
	System.out.println("\nMinimo volumen");}	            		 
	else
	 System.out.println("\nLa radio esta ya apagada");
	}	
	public float getTuning(){
	return(tuning);
	}
	public int getVolume(){
	return(volumen);
	}
	public char getBand(){
	return(banda);
	}
	
	public void turningDown(){
	 switch(banda){
		          case 'F':
			           if(tuning>MINFM)
					tuning--;
			  break;
			  case 'M':if(tuning>MINAM)
					tuning--;
			  break;			  
		}	   
	}
	public void turningUp(){
	 switch(banda){
		          case 'F':
			           if(tuning<MAXFM)
					tuning++;
			  break;
			  case 'M':if(tuning<MAXAM)
					tuning++;
			  break;			  
		}	   
	}
	
}


