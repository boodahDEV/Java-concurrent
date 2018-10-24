package fabrica;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class People extends JFrame implements Runnable {
	private Box caja;
	private int id,x,y;
	private JTextArea jta;
	private JLabel papel,buffer,bufferBox;
	private JPanel contentPane;
	
	
    public People(Box caja, int id, JLabel buffer,JLabel bufferBox){
    	setUndecorated(true);
    	init();
    	this.setLocationRelativeTo(null);
    	this.setVisible(true);
 		this.caja = caja;
 		this.buffer=buffer;
 		this.bufferBox=bufferBox;
    }//contructor normal
    
    public void init() {

  	    setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 250);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(65, 105, 225)));
		contentPane.setBackground(new Color(255,255,255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 		
 		papel = new JLabel("");
 		papel.addMouseListener(new MouseAdapter() {
 			public void mousePressed(MouseEvent a) {
 				x = a.getX();
 				y = a.getY();
 			}
 		});
 		papel.addMouseMotionListener(new MouseMotionAdapter() {
 			public void mouseDragged(MouseEvent a) {
 				int xx = a.getXOnScreen();
 				int yy = a.getYOnScreen();
 				setLocation(xx-x,yy-y);
 			}
 		});
 		papel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 		papel.setBounds(15, 1, 181, 147);
 		papel.setIconTextGap(-4);
 		papel.setIcon(new ImageIcon(People.class.getResource("/fabrica/papelN.gif")));
 		contentPane.add(papel);
 		
 		jta = new JTextArea();
 		JScrollPane jsp = new JScrollPane(jta);
 		jsp.setBorder(new MatteBorder(1,1,1,1, new Color(0,0,0)));
 		jsp.setBounds(5, 163, 190, 80);
 		contentPane.add(jsp);
    } //---END INIT

    public void run(){
  		int tiempo = 0;
  		
  	   	while(true){
			synchronized(caja){
  		     	while(!caja.isNoTengo()){
  			   		try{
	  				caja.wait(500);
   		   	   		}catch(Exception e){}
  			   		break;
  				}
       	  	}
	     	//Produce the paper
	 if (caja.getCantCajaActual() != caja.getMaxCantCajas()){
	  	try{
		
		tiempo = (int) (Math.random()* 100 + 1);
		Thread.sleep(tiempo);
	  	}catch(InterruptedException e){}

  if(caja.getCantPapelActual() < caja.getCantMaxPapel() && caja.getCantCajaActual() != caja.getMaxCantCajas()){
	  caja.setNoTengo(false);
	  buffer.setVisible(false);bufferBox.setVisible(true); 		//---LABELES SETEADOS
	  synchronized(caja)
	   {
  			addPapel();
  			jta.append("  My ID: "+ id + "  -->  "+ caja.getCantPapelActual()+"\n"); 			//--- ESTE ES EL QUE PEGA EN TEXTAREA DE PEOPLE
		  	System.out.println("Id: "+ id + " Puso papel: "+ caja.getCantPapelActual());		//--- ESTE ES EL CONTROL POR CONSOLA!
			caja.notifyAll();
		}
	}
} else {buffer.setVisible(true);bufferBox.setVisible(false);	break;}
      
} //fin del while
 return;
}//---END RUN

  public synchronized void addPapel()
    {
       caja.agregarPapel();
    }
  
}//END CLASS
