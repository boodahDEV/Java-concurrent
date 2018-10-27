package talk_server_client;


import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TalkClient {
	
    private Socket client;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner s = new Scanner(System.in);
    

    public void send(String s) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
        } catch (Exception e) {
        	System.out.println("ERROR al enviar en cliente");
        }
    }//end send

    public void startC(String ip, int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                	client = new Socket(ip, puerto);
                   	  System.out.print("Conectado a :" + client.getInetAddress().getHostName());
                    	bufferDeEntrada = new DataInputStream(client.getInputStream());
                    	bufferDeSalida = new DataOutputStream(client.getOutputStream());
                    	bufferDeSalida.flush();
                    datai(); // daat entrada!
                } catch(Exception e) {
                	 System.out.println("ERROR al levantar conexión");
                     try {
						bufferDeEntrada.close();
	                     bufferDeSalida.close();
	                     client.close();
                     }catch (Exception e1) {}
                }finally {
                System.exit(0);
                }
            }//end run
        });
        hilo.start();
    }//end startC

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
       // System.out.print("USERx = ");
        while (true) {
            
            entrada = s.nextLine();
            if(entrada.length() > 0)
                send(entrada);
        }
    }//end printData

    public static void main(String[] argumentos) {
        TalkClient cliente = new TalkClient();
        Scanner ss = new Scanner(System.in);
        String ip = "localhost";
        
        	//System.out.println("Ingresa la IP: [localhost por defecto] ");
        	//String ip = escaner.nextLine();
        	//if (ip.length() <= 0) ip = "localhost";

        System.out.println("Set Port: ");
        String puerto = ss.nextLine();
        if (puerto.length() < 0) puerto = "5050";
        
        cliente.startC(ip, Integer.parseInt(puerto.trim()));
        cliente.printData();
    }//end main
}//end class
