package red;

import java.net.*;
import java.io.*;
import java.util.Scanner;


public class TalkServer {

    private Socket server;
    private ServerSocket ss;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    
    Scanner s = new Scanner(System.in);
  




    public void datai() {
        String texto;
        try {
            do {
            	texto = (String) bufferDeEntrada.readUTF();
                System.out.println("\nUSER = " + texto);
                System.out.print("\nSERVER = ");
            } while (!texto.equals("exit"));
        } catch (Exception e) {
        	 try {
                 bufferDeEntrada.close();
                 bufferDeSalida.close();
                 server.close();
             } catch (Exception a) {
            	 System.out.println("Conversación finalizada....");
                 System.exit(0);
             }//end catch 2
        }//end catch 1
    }//end datai


    public void send(String text) {
        try {
            bufferDeSalida.writeUTF(text);
            bufferDeSalida.flush();
        } catch (Exception e) {
        	System.out.println("Error en el ENVIO!");
        }
    }//end send


    public void printData() {
    	String entrada;
    	// System.out.print("SERVERx = ");
        while (true) {
           
            entrada = s.nextLine();
            if(entrada.length() > 0)
                send(entrada);
        }//end while
    }//end printData


    public void startC(int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                    	ss = new ServerSocket(puerto);
                    	System.out.println("Waiting for connection to: " + String.valueOf(puerto) + "...");
                        server = ss.accept();
                        System.out.println("Established connection: " + server.getInetAddress().getHostName() + "\n\n\n");
                        	bufferDeEntrada = new DataInputStream(server.getInputStream());
                        	bufferDeSalida = new DataOutputStream(server.getOutputStream());
                        	bufferDeSalida.flush();
                        datai();
                    }catch(Exception a) {
                    	System.out.println("Error en la conexion!");
                    } finally {
                    	 try {
                             bufferDeEntrada.close();
                             bufferDeSalida.close();
                             server.close();
                         } catch (Exception a) {
                        	 System.out.println("Conversación finalizada....");
                             System.exit(0);
                         }//end catch 2
                    }// end finally
                }//end while
            }//end run
        });
        hilo.start();
    }//end startC

    public static void main(String[] args) throws IOException {
    	TalkServer s = new TalkServer();
        Scanner sc = new Scanner(System.in);

        System.out.println("Set Port: ");
        String puerto = sc.nextLine();
        if (puerto.length() < 0) puerto = "5050";
        
        s.startC(Integer.parseInt(puerto.trim()));
        s.printData();
    }//end main
}//end class