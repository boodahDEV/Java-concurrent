package linea;

import java.io.*;
import java.net.Socket;
import java.util.Date;

import javax.swing.JOptionPane;

public class Client extends Thread{
	
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    	private Punto p1, p2;														//---=== CREO UN ARREGLO DE PUNTOS CON UN MAXIMO DE 10 PUNTOS POR ENTRADA
    	private Linea linea;
    	private Double dist;
    	private double distancia;
	  public static void main(String[] args){
		  Thread s = new Client();
		  		s.start();
		  	
	  }	//---=== MAIN 

	  public void run() {
		  int n1,n2;
	    try {

	      socket = new Socket ("localhost",7219);									//---=== ESTABLECE EL PUERTO DEL SERVIDOR!
	      System.out.println(new Date() + ": Start a new client \n"); 				//---=== Debo imprimir el inicio del servidor 

	      while (true) {
	    	  
				try{
				     in = new ObjectInputStream(socket.getInputStream());
				     out = new ObjectOutputStream(socket.getOutputStream());
				     
				     n1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el punto #1 x:"));
				     n2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el punto #1 y:"));
				     
				      p1 = new Punto(n1,n2);										//---=== SE DEFINE EL OBJETO PUNTO#1!
				      n1=0;n2=0;
				      
				     n1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el punto #2 x:"));
				     n2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el punto #2 y:"));
				      
				     p2 = new Punto(n1,n2);											//---=== SE DEFINE EL OBJETO PUNTO#2!
				      
				      out.writeObject(p1);
				      System.out.println("El cliente envia el punto #1");
				      out.writeObject(p2);
				      System.out.println("El cliente envia el punto #2");
				      
				      linea =(Linea)in.readObject();								//---=== RECIBO EL OBJETO LINEA
				      distancia = dist.doubleValue();
				      
				if(linea instanceof Linea) {
					 
				}
				      
		      
			// AQUI ES DONDE DEBO EMPEZAR A MANIPULAR LOS PUNTOS
		      
				      System.out.println("El servidor envia al Cliente la linea");   
				      out.writeObject(this); //---=== ENVIA LA LINEA AL IGUAL QUE LA DISTANCIA
				      
				      
				  }catch(IOException ex) {
				        System.out.println("ERROR! en los object");
				     }
			        
	        
	      }//---=== END WHILE
	    }catch (Exception ex) {
	      System.out.println("ERROR!...");
	    }
	    
	    
	  } //---=== FIN DE  RUN

	  
}
