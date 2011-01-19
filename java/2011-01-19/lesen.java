// 2011-01-19 Vorlesung.
// package lesen;

import java.io.*;

public abstract class lesen
{
	public static void main(String[] args)
	{
		final String fileName = "./einmaleins.txt";
		
		FileReader reader = null;
		
		try
		{
			int buffer = 0;
			StringBuffer data = null;
			
			reader = new FileReader(fileName);
			
			System.out.println("===============================================================");
			do
			{
				if (null == data)
				{
					data = new StringBuffer();
				}
				
				buffer = reader.read();
				if (-1 != buffer)
				{
					data.append((char)buffer);
					if ('\n' == buffer)
					{
						System.out.println("Zeile:");
						System.out.print(data);
						data = null;
					}
				}
			}
			while (-1 != buffer);
			
			System.out.println("===============================================================");			
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		finally
		{
			if (reader != null)
			{
				try
				{
					reader.close();
				}
				catch (IOException e)
				{
					System.err.println(e);
				}
			}
		}
	}
}
