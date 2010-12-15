// 2010-12-06
// package fatherandson;

public abstract class TestThem
{
	public static void main(String[] args)
	{
		Son subjects[] = new Son[2];
		
		subjects[0] = new Son(true);
		System.out.println(subjects[0].iAmFather("test 1"));
		System.out.println(subjects[0].iAmAlsoFather("test 2"));
		
		subjects[1] = new Son(false);
		
		//for (Son subject : subjects)
		for (int i = 0; i < subjects.length; i++)
		{
			Son subject = subjects[i];
			try
			{
				if (i == 0)
				{
					subject.danger("danger");
				}
				else
				{
					subject.danger("lalala");
				}
			}
			catch (SomeException ex)
			{
				System.out.println(ex.getMessage());
			}
		}
	}
}
