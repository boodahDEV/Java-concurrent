package linea;

import javax.swing.JOptionPane;
public class TestLinea{
	public static void main(String arg[]){		
		Linea la=new Linea(new Punto(0.0,0.0),new Punto(1.0,1.0));
		Linea lb=new Linea(new Punto(0.0,0.0),new Punto(-1.0,1.0));
		 JOptionPane.showMessageDialog(null,"La linea es de: "+la.imprime_linea());
		 JOptionPane.showMessageDialog(null,"nLa linea es de: "+lb.imprime_linea());
		 Punto c=new Punto();
		 c=la.calcula_interseccion(lb);
		 JOptionPane.showMessageDialog(null,"La intereseccion es: "+c.display());
		 		
	}
	
}