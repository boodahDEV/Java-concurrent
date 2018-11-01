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
    	private Double distancia;
	  public static void main(String[] args){
		  Thread s = new Server();
		    		s.start();
		  	
	  }	//---=== MAIN 

	  public void run() {
		  
	    try {

	      serverSocket = new ServerSocket(7219); 									//---=== ESTABLECE EL PUERTO!
	      System.out.println(new Date() + ": Start a new server\n"); 				//---=== Debo imprimir el inicio del servidor 

	      //while (true) {
	        socket = serverSocket.accept();
	        System.out.println("A client at " +socket.getInetAddress().getHostAddress() + " connected\n");
		      
				     in = new ObjectInputStream(socket.getInputStream());
				    // out = new ObjectOutputStream(socket.getOutputStream());
				      
				      
				      p1  = (Punto)in.readObject();
				      System.out.println("El servidor recibio el punto #1");
				      //out.flush();
//				      p2  = (Punto) in.readObject();
//				      System.out.println("El servidor recibio el punto #2");
				      
				      
			// AQUI ES DONDE DEBO EMPEZAR A MANIPULAR LOS PUNTOS
//				if(p1 instanceof Punto && p2 instanceof Punto)						//---=== VERIFICO SI EL OBJETO OBTENIDO ES UNA INSTANCIA DE PUNTO
//					linea = new Linea(p1,p2);
//				      System.out.println("El servidor envia al Cliente la linea");
//				      out.writeObject(linea); 										//---=== ENVIA LA LINEA AL CLIENTE
//				    distancia = (p1.distancia(p2));									//---=== ENCAPSULA EL VALOR DE LA DISTANCIA DEL PUNTO1 AL PUNTO2 DENTRO DE LA ROPERCLASS
//				      System.out.println("El servidor envia al Cliente la distancia del Punto#1 al Punto#2");
//				      out.writeObject(distancia);									//---=== ENVIA LA DISTANCIA AL CLIENTE
				      
			        
				
	      //}//---=== END WHILE
	    }catch (Exception ex) {
	      System.out.println("ERROR! SERVER...\n\n"+ex);
	    }
	    
	    
	  } //---=== FIN DE  RUN

	  
	}//---=== END CLASS