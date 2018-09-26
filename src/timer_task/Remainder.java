package timer_task;

import java.util.*;

public class Remainder extends TimerTask
{
	String message;

	public Remainder(String message)
	{
		this.message = message;
	}

	public void run()
	{
		System.out.println(message);
	}
}