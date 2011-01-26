// 2011-01-26
// package threading;

import java.io.*;

public final class Thread1 extends Thread
{
	public static void main(String args[])
	{	
		System.out.println("Main startet.");
		//new Thread(new InternalRunnable()).start();
		
		new Thread(
			new Runnable()
			{
				public void run()
				{
					for (int i = 0; i < 6; i++)
					{
						System.out.println("Ich bin's: " + i);
						//Thread.sleep(500);
					}
				}
			}
		).start();
		
		System.out.println("Main fertig");
	}


}
