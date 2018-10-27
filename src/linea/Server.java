package linea;

import java.io.*;
import java.net.*;
import java.util.Date;

public class Server extends Thread{
    private Socket socket;
    private ServerSocket serverSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    	private Punto p1, p2;														//---=== CREO UN ARREGLO DE PUNTOS CON UN MAXIMO DE 10 PUNTOS POR ENTRADA
    	private Linea linea;
	  public static void main(String[] args){
		  
		  	
	  }	//---=== MAIN 

	  public void run() {
		  
	    try {

	      serverSocket = new ServerSocket(7219); 									//---=== ESTABLECE EL PUERTO!
	      System.out.println(new Date() + ": Start a new server\n"); 				//---=== Debo imprimir el inicio del servidor 

	      while (true) {
	        socket = serverSocket.accept();
	        System.out.println(new Date() + ": A client at " +socket.getInetAddress().getHostAddress() + " connected\n");
		      
				try{
				     in = new ObjectInputStream(socket.getInputStream());
				     out = new ObjectOutputStream(socket.getOutputStream());
				     
				      p1  = (Punto)in.readObject();
				      System.out.println("El servidor recibio el punto #1");
				      p2  = (Punto) in.readObject();
				      System.out.println("El servidor recibio el punto #2");
		      
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

	  
	}//---=== END CLASS