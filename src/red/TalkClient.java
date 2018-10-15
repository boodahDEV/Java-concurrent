package red;


import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TalkClient {
	
    private Socket server;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner s = new Scanner(System.in);
    

    public void send(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (IOException e) {
        	System.out.println("IOException on enviar");
        }
    }

    public void startC(String ip, int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server = new Socket(ip, puerto);
                   	  System.out.println("\nConectado a :" + server.getInetAddress().getHostName());
                    	bufferDeEntrada = new DataInputStream(server.getInputStream());
                    	bufferDeSalida = new DataOutputStream(server.getOutputStream());
                    	bufferDeSalida.flush();
                    datai(); // daat entrada!
                } catch(Exception e) {
                	 System.out.println("ERROR al levantar conexión");
                     try {
						bufferDeEntrada.close();
	                     bufferDeSalida.close();
	                     server.close();
                     }catch (Exception e1) {}
                }finally {
                System.exit(0);
                }
            }//end run
        });
        hilo.start();
    }

    public void datai() {
        String texto;
        try {
            do {
                texto = (String) bufferDeEntrada.readUTF();
                System.out.println("\nSERVER = " + texto);
                System.out.print("\nUSER = ");
            } while (!texto.equals("exit")); //todo mientras se el texto de entrada sea diferente a exit!
        } catch (Exception e) {}
    }//end datai

    public void printData() {
        String entrada;
        while (true) {
            System.out.print("USER = ");
            entrada = s.nextLine();
            if(entrada.length() > 0)
                send(entrada);
        }
    }

    public static void main(String[] argumentos) {
        TalkClient cliente = new TalkClient();
        Scanner escaner = new Scanner(System.in);
        String ip = "localhost";
        
        	//System.out.println("Ingresa la IP: [localhost por defecto] ");
        	//String ip = escaner.nextLine();
        	//if (ip.length() <= 0) ip = "localhost";

        System.out.println("Puerto [Debe ser mayor a 5000]: ");
        String puerto = escaner.nextLine();
        if (puerto.length() < 0) puerto = "5050";
        
        cliente.startC(ip, Integer.parseInt(puerto));
        cliente.printData();
    }
}
