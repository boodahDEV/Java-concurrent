package fabrica;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

public class People extends JFrame implements Runnable {
	private Box caja;
	private int id;
	private JTextArea jta;
	private JLabel papel;
	private JPanel contentPane;
	
    public People(Box caja, int id){
 		this.caja = caja;
 		this.id = id;
    }//contructor normal
    
    public People() {
  	    setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,255,255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
 		
 		papel = new JLabel("");
 		papel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 		papel.setBounds(15, 1, 181, 147);
 		papel.setIconTextGap(-4);
 		papel.setIcon(new ImageIcon(People.class.getResource("/fabrica/papel.gif")));
 		contentPane.add(papel);
 		
 		jta = new JTextArea();
 		jta.setBorder(new MatteBorder(1,1,1,1, new Color(0,0,0)));
 		jta.setBounds(1, 150, 181, 60);
 		contentPane.add(jta);
    } // metodo en sobrecarga

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
	 if (caja.getCantCajaActual() != caja.getMaxCantCajas())
       {
	  	try
	  	  {
		
		tiempo = (int) (Math.random()* 100 + 1);
		Thread.sleep(tiempo);
	  	}catch(InterruptedException e){}

  if(caja.getCantPapelActual() < caja.getCantMaxPapel() && caja.getCantCajaActual() != caja.getMaxCantCajas())
	{
	  caja.setNoTengo(false);
	  synchronized(caja)
	   {
  			addPapel();
  			jta.append("Id: "+ id + " --> "+ caja.getCantPapelActual());
		  	System.out.println("Id: "+ id + " Puso papel: "+ caja.getCantPapelActual());
			caja.notifyAll();
		}
	}
} else	break;
      
} //fin del while
 return;
}

  public synchronized void addPapel()
    {
       caja.agregarPapel();
    }
  
  public static void main(String args[]) {
	  People p = new People();
	  p.setLocationRelativeTo(null);
	  p.setVisible(true);
  }
}
