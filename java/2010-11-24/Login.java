// 2010-11-24
// package login;

public final class Login
{
	private final static String userName = "root";
	private final static String password = "123";
	private boolean angemeldet = false;
	
	public void abmelden()
	{
		this.angemeldet = false;
	}
	
	public void anmelden(String benutzer, String passwort) throws ZugriffUngueltigException
	{
		if (!Login.userName.equals(benutzer) || !Login.password.equals(passwort))
		{
			throw new ZugriffUngueltigException("Ungueltiger Zugriff!");
		}
		
		this.angemeldet = true;
		System.out.println("Anmeldung erfolgreich.");
	}
	
	public void bearbeiten() throws KeineBerechtigungException
	{
		if (!this.angemeldet)
		{
			throw new KeineBerechtigungException("Sie sind nicht angemeldet.");
		}
		
		System.out.println("Bearbeiten wird ausgeführt.");
	}
}
