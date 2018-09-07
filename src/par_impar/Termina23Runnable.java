package par_impar;

public class Termina23Runnable implements Runnable{
 public int cont;
 
	public void run() {
		for(int i=1;i<=100;i++) {
			//if(i%2==10 || i%) No recuerdo bien lo que iba aqui!
				cont++;
			System.out.println(Thread.currentThread()+":"+cont);
		}
	}
}
