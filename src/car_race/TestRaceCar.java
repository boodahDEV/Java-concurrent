package car_race;

public class TestRaceCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread c1 = new CarRace(5,"Nissan");
		Thread c2 = new CarRace(5,"lada");
		Thread c3 = new CarRace(5,"bugati");
		c1.start();
		c3.start();
		c2.start();
	}

}
