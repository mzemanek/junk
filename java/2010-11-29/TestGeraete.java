// 2010-11-29
// package geraete;

public class TestGeraete{
	public static void main(String[] args){
		Laserdrucker laser = new Laserdrucker();
		Faxgeraet fax = new Faxgeraet();
		Kombigeraet superTeil = new Kombigeraet ();
		laser.drucken("Dinge raushauen");
		fax.senden("Kram verschicken");
		superTeil.drucken("Superdinge raushauen");
		superTeil.senden("Superkram verschicken");
		Drucker d = superTeil;
		d.drucken("via Interface gedruckt");
		Fax f = superTeil;
		f.senden("via Interface gefaxt");
	}
}
