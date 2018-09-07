package par_impar;

public class ImparesThread extends Thread{
 public int cont;
	public ImparesThread(String arg0) {
		super(arg0);
	}//contructor
	
	public ImparesThread() {
	}
	
	public void run() {
		for(int i=1;i<=100;i++) {
			if(i%2!=0)
				cont++;
			System.out.println(Thread.currentThread()+":"+cont);
		}
	}

}
