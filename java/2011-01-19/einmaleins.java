// 2011-01-19 Vorlesung
// package einmaleins;

import java.io.*;

public abstract class einmaleins
{
	public static void main(String[] args)
	{
		int max = 0;
		int maxProduct = 0;
		FileWriter writer = null;
		
		if (args.length != 1)
		{
			System.out.println("\tUsage:");
			System.out.println("\tjava einmaleins <n>");
			
			return;
		}
		
		max = new Double(Math.sqrt(new Double(args[0]).doubleValue())).intValue() + 1;
		System.out.println(max);
		maxProduct = Integer.parseInt(args[0]);
		
		try
		{
			//final int max = 10;
			
			writer = new FileWriter("./einmaleins.txt");
			for (int z = 0; z < max; z++)
			{
				for (int s = 0; s < max; s++)
				{
					if (0 == z) 
					{
						writer.write("\t" + (s + 1));
					}
					else if (0 == s)
					{
						writer.write("\t" + (z + 1));
					}
					else
					{
						writer.write("\t" + ((z + 1) * (s + 1)));
					}
				}
				
				writer.write("\n");
			}
			
			writer.flush();
		}
		catch (IOException ex)
		{
			System.err.println(ex);
		}
		finally
		{
			if (null != writer)
			{
				try
				{
					writer.close();
				}
				catch (IOException ex)
				{
					System.err.println(ex);
				}
			}
		}		
	}
}
