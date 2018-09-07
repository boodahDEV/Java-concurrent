package par_impar;

public class ParesThread extends Thread {
 public int cont;
	public ParesThread(String arg0) {
		super(arg0);
	}//contructor
	
	public ParesThread() {
	}
	
	public void run() {
		for(int i=1;i<=100;i++) {
			if(i%2==0)
				cont++;
			System.out.println(Thread.currentThread()+":"+cont);
		}
	}
}
