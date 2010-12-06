// 2010-12-06
// package fatherandson;

public abstract class TestThem
{
	public static void main(String[] args)
	{
		Son subject[] = new Son[2];
		
		subject[0] = new Son(true);
		subject[0].iAmFather();
		subject[0].iAmAlsoFather();
		
		subject[1] = new Son(false);
		
		for (int i = 0; i < subject.length; i++)
		{
			if (i == 0)
			{
				subject[i].danger("danger");
			}
			else
			{
				subject[i].danger("lalala");
			}
		}
	}
}
