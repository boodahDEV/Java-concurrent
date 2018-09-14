package car_race;

public class CarRace extends Thread{
 public int finish;
 public String name;
 
	public CarRace(int finish, String name) {
		super();
		this.finish = finish;
		this.name = name;
	}

	public void run() {
		int time = (int) (Math.random() * 5000);
		for(int i=1;i<=finish;i++) {
			try {
				Thread.sleep(time);
			}catch(Exception e) {}
			System.out.println(name + " -> "+i);
		}//end for
		System.out.println(name + " finished!"+"\n");
	}//end run
}
