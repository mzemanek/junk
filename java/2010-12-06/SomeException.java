// 2010-12-06
// package fatherandsond;

public final class SomeException extends Exception
{
	public SomeException(String message)
	{
		super(message);
		
		System.out.println("Ausnahme: " + message);
	}
	
}
