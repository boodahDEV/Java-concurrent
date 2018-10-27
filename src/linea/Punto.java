package linea;

public class Punto{
	double x;
	double y;
	
	Punto(double x,double y){
		this.x=x;
		this.y=y;
	} // constructor de dos entradas dobles
	
	public Punto(){
		this.x=0;
		this.y=0;
	}// constructor sin entrada
	
	public double getx(){
		return(x);
	} 
	public double gety(){
		return(y);
	}
	
	public String display(){
		return("("+x+" , "+y+" )");
	}
	
	public double distancia(Punto a){
		double c=Math.sqrt(Math.pow((this.y-a.y),2.0)+Math.pow((this.x-a.x),2.0));
		return (c);
	}
	
	public boolean equals(Punto a)
	{if(a.x==this.x && a.y == this.y)
	 return(true);
	 else
	 return(false);
	}
	
	public int eje_coordenadas(){
		if(this.x>=0&&this.y>=0)
		 return(1);//(x:positivo y:positivo)
		else if(this.x>=0&&this.y<=0)
		 return(4);//(x:positivo y:negativo)
		else if(this.x<=0&&this.y<=0)
		 return(3);//(x:negativo y:negativo)
		else if(this.x<=0&&this.y>=0)
		 return(2); //(x:negativo y:positivo)
	return(0);	//(nunca debe ocurrir este caso) 
	}
	
	
}