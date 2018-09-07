package par_impar;

public class Termina23 extends Thread {
 public int cont;
	public Termina23() {
		// TODO Auto-generated constructor stub
	}

	public Termina23(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public void run() {
		for(int i=1;i<=100;i++) {
			//if(i%2==10 || i%) No recuerdo bien lo que iba aqui!
				cont++;
			System.out.println(Thread.currentThread()+":"+cont);
		}
	}
}
