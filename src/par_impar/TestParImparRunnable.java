package par_impar;

public class TestParImparRunnable {
	public static void main(String arg[]) {
		Thread p = new Thread(new ParRunnable(),"ParesR-");
		Thread i = new Thread(new ImparRunnable(),"ImparesR-");
		p.start();
		i.start();
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {}
		System.out.println("main() ending...");
	}
}
