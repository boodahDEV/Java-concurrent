package timer_task;

import java.util.*;
import javax.swing.*;

public class ReminderTT_GUI extends TimerTask
{
	String message;
	JTextArea jta;
	JLabel alert;
	
	public ReminderTT_GUI(String message, JTextArea jta,JLabel alert)
	{
		this.message = message;
		this.jta=jta;
		this.alert = alert;
	}

	public void run()
	{
		jta.append(message+".\n");
		alert.setVisible(true);
	}
}