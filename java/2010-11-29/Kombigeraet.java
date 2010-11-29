// 2010-11-29
// package geraete;

public final class Kombigeraet implements Drucker, Fax
{
	public void drucken(String druckRef)
	{
		System.out.println("Kombigeraet druckt: " + druckRef);
	}
	
	public void senden(String sendeRef)
	{
		System.out.println("Kombigeraet sendet: " + sendeRef);
	}
}
