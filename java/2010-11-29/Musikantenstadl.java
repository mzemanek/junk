// 2010-11-29
// package musikantenstadl;

public abstract class Musikantenstadl
{
	public static void main(String[] args)
	{
		Musikinstrument[] instrumente = new Musikinstrument[2];
		
		instrumente[0] = new Trommel();
		instrumente[1] = new Trompete();
		
		for (Musikinstrument instrument: instrumente)
		{
			instrument.spieleInstrument();
		}
	}
}
