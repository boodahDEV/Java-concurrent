package linea;

import javax.swing.JOptionPane;
public class TestPunto{
	String punto_x;
	String punto_y;
	
	void toma_puntos(){
	 punto_x=JOptionPane.showInputDialog("Ingrese el punto x:");
	 punto_y=JOptionPane.showInputDialog("Ingrese el punto y:");
	}
	TestPunto(){
	toma_puntos();
	if(this.punto_x==null||this.punto_y==null){
    punto_x="0"; 	
    punto_x="0";}
	}
		
	public static void main(String args[]){	
	TestPunto a=new TestPunto();
	TestPunto b=new TestPunto();
	Punto c=new Punto(Integer.parseInt(a.punto_x),Integer.parseInt(a.punto_y));
	Punto d=new Punto(Integer.parseInt(b.punto_x),Integer.parseInt(b.punto_y));
	JOptionPane.showMessageDialog(null,"El primero punto es "+c.display()+"\nEl segundo punto es "+d.display(),"Punto Inicial",JOptionPane.INFORMATION_MESSAGE);
	JOptionPane.showMessageDialog(null,"La distancia es de: "+c.distancia(d),"Distancia",JOptionPane.INFORMATION_MESSAGE);
	System.exit(0);
	}
}