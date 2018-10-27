package linea;


public class Linea{
	Punto p1;
	Punto p2;
	public double m;
	public boolean existe;
	public Linea(Punto p1, Punto p2){
		this.p1=p1;
		this.p2=p2;
		existe=false;
		m=calcula_pendiente();				
	}
	
	public Linea(Punto p1,double m){
	 this.p1=p1;
	 this.m=m;
	 existe=true;	
	} 
	
	public double calcula_pendiente(){
		if(p1.equals(p2)!=true){
		 existe=true;
		 return((p2.y-p1.y)/(p2.x-p1.y));	
		}
	    else
	    {
	    System.out.println("No existe la pendiente");	
	    return(0);	
	    } 
		
	}
	public String imprime_linea(){
		return("y = "+this.m+"x + b : "+p1.display()+" - "+p2.display());
	}
	
	public String simprime_linea(){
		return("y = "+this.m+"x + b :"+p1.display());
	}
	public Punto calcula_interseccion(Linea a){
		Punto temp=new Punto();
		temp.y=(-(a.p2.x-a.p1.x)*((-(this.p2.y-this.p1.y)-this.m)/(this.p2.x-this.p1.x))-a.m)/(a.p2.y-a.p1.y);
		temp.x=(-(a.p2.y-a.p1.y)*((-(this.p2.x-this.p1.x)-this.m)/(this.p2.y-this.p1.y))-a.m)/(a.p2.x-a.p1.x);
		return(temp);
	}
	
	
    	
}