package timer_task;

import java.util.Timer;

public class TestReminder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer t1 = new Timer();
		Remainder a1 = new Remainder("Hola");
		Remainder a2 = new Remainder("mundo");
		Remainder a3 = new Remainder(":v");
		t1.schedule(a1, 5000, 2000);
		t1.schedule(a2, 10000, 2000);
		t1.schedule(a3, 15000, 2000);
	}

}
