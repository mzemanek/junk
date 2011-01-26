// 2011-01-19 Vorlesung
// package info;

import java.io.*;
import java.text.DateFormat;

public abstract class info
{
	public static void main(String[] args)
	{
		final String fileName = "./info.txt";
		
		DateFormat dfm = null;
		boolean exists = false;
		FileWriter writer = null;
	
		// Initialize scope.
		dfm = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		exists = check(fileName);
		try
		{
			writer = new FileWriter(fileName, true);
			if (!exists)
			{
				writer.write(getInfo());
			}
			
			writer.write(getTimestamp(dfm) + "\n");
			writer.flush();
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
		finally
		{
			if (null != writer)
			{
				try
				{
					writer.close();
				}
				catch (IOException e)
				{
					System.err.println(e);
				}
			}
		}
	}
	
	private static boolean check(String fileName)
	{
		File file = null;
		
		file = new File(fileName);
		return file.exists() && file.isFile();
	}
	
	private static String getInfo()
	{
		StringBuffer buffer = null;
		
		buffer = new StringBuffer();
		buffer.append(getProperty("user.name"));
		buffer.append(getProperty("user.language"));
		buffer.append(getProperty("user.home"));
		buffer.append(getProperty("os.name"));
		buffer.append(getProperty("java.version"));
		
		return buffer.toString();
	}
	
	private static String getProperty(String propertyName)
	{
		return propertyName + " = " + System.getProperty(propertyName) + "\n";
	}
	
	private static String getTimestamp(DateFormat dateFormat)
	{
		return dateFormat.format(new java.util.Date());
	}
}
