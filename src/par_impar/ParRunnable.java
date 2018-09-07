package par_impar;

public class ParRunnable implements Runnable {
 public int cont;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=100;i++) {
			if(i%2==0)
				cont++;
			System.out.println(Thread.currentThread()+":"+cont);
		}
	}

}
