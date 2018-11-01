package linea;

import java.io.*;
import java.net.Socket;
import java.util.*;

import javax.swing.JOptionPane;

public class Client extends Thread{
	
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    	private Punto p1, p2;														//---=== CREO UN ARREGLO DE PUNTOS CON UN MAXIMO DE 10 PUNTOS POR ENTRADA
    	private Linea linea;
    	private Double dist;
    	private double distancia;
    	private String texto="Error en la transferencia de la linea.";
    	private Scanner s = new Scanner(System.in);
	 
    public static void main(String[] args){
		  Thread c = new Client();
		  		c.start();
		  	
	  }	//---=== MAIN 

	  public void run() {
		  double n1,n2;																//---=== VARIABLES DE LOS PARAMETROS DE ENTRADA
	    try {

	      socket = new Socket ("localhost",7219);									//---=== ESTABLECE EL PUERTO DEL SERVIDOR!
	      System.out.println(new Date() + ": Start a new client \n"); 				//---=== Debo imprimir el inicio del servidor 

	     // while (true) {
		    /* //n1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el punto #1 x:"));
		     	System.out.println("Ingrese el punto #1 x:");
		     		n1 = s.nextDouble();
		     	System.out.println("Ingrese el punto #1 y:");
		     		n2 = s.nextDouble();
		     //n2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el punto #2 y:"));
		     
		      p1 = new Punto(n1,n2);										//---=== SE DEFINE EL OBJETO PUNTO#1!
		      n1=0;n2=0;
		      
		     //n1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el punto #2 x:"));
		     	System.out.println("Ingrese el punto #2 x:");
		     		n1 = s.nextDouble();
		     	System.out.println("Ingrese el punto #2 y:");
		     		n2 = s.nextDouble();
		     //n2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el punto #2 y:"));
		      
		      p2 = new Punto(n1,n2);											//---=== SE DEFINE EL OBJETO PUNTO#2!
			*/
			
	    	  p1 = new Punto(1.0,2.5);p2 = new Punto(3.0,6.0);
	    	  
				     out = new ObjectOutputStream(socket.getOutputStream());
				     //in = new ObjectInputStream(socket.getInputStream());
				     
				     p1 = new Punto(1.0,2.5);
				      out.writeObject(p1);
				      System.out.println("El cliente envia el punto #1");
				      out.flush();
//				      out.writeObject(p2);
//				      System.out.println("El cliente envia el punto #2");
				      
				      
//				      linea =(Linea)in.readObject();								//---=== RECIBO EL OBJETO LINEA
//				      dist = (Double) in.readObject();
//				      distancia = dist.doubleValue();
//				      
//				if(linea instanceof Linea) {
//					 texto = linea.imprime_linea();
//				}
//				      System.out.println("\nLa linea es: "+texto);
//				      System.out.println("\nLa distancia del punto#1 al punto#2 es:  "+distancia);
//		

	        
	     // }//---=== END WHILE
	    }catch (Exception ex) {
	      System.out.println("ERROR! CLIENT...");
	    }
	    
	    
	  } //---=== FIN DE  RUN

	  
}
