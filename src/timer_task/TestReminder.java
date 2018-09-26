package timer_task;

import java.util.*;

public class TestReminder
{
	public static void main(String [] args)
	{
		Timer timer = new Timer();
		Remainder meeting = new Remainder("Meeting with Ann");
		Remainder dentist = new Remainder("Dr. Moler, cavity filled");
		Remainder date = new Remainder("Dinner with Matt and Ann");

		timer.schedule(meeting, 0);
		timer.schedule(dentist, 30000);
		timer.schedule(date, 120000);
	}
}