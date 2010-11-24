// 2010-11-24
// package login;

public abstract class LoginTest
{
	public static void main(String[] args)
	{
		Login gut = new Login();
		Login schlecht = new Login();
		
		System.out.println();
		System.out.println("Login.anmelden(...)");
			
		try
		{
			gut.anmelden("root", "123");
			schlecht.anmelden("Hans", "Wurst");
		}
		catch (ZugriffUngueltigException ex)
		{
			ex.printStackTrace(System.out);
		}
		
		System.out.println();
		System.out.println("Login.bearbeiten(...)");

		try
		{
			gut.bearbeiten();
			schlecht.bearbeiten();
		}
		catch (KeineBerechtigungException ex)
		{
			ex.printStackTrace(System.out);
		}
	}
}
