package par_impar;

public class TestParImpar {
	public static void main(String arg[]) {
		Thread p = new ParesThread("Pares-");
		Thread i = new ImparesThread("Impares-");
		p.start();
		i.start();
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {}
		System.out.println("main() ending...");
	}
}
