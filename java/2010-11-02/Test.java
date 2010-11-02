// 2010-11-02
// package Uebung;

public abstract class Test
{
	public static void main(String[] args)
	{
		System.out.println("Objektorientierte Programmiertechnik");
		System.out.println("2010-11-02");
		System.out.println();
		
		// Test functions.
		//
		Test.test_kurs();
		//Test.test_mitarbeiter();
		//Test.test_person();
		//Test.test_student();
	}
	
	private static void test_kurs()
	{
		Kurs subject = null;
		Student teilnehmer[] = 
		{
			new Student("Mira", "Mar", 1234, null),
			new Student("Alfred", "Mustermann", 1235, null),
			new Student("Karin", "Muster", 1236, new Bankverbindung("Deutsche Bank", "302 00 408", "12345 7890"))
		};
		
		Mitarbeiter dozent = null;
		
		System.out.println("test_kurs()");
		
		subject = new Kurs("Java-Kurs");
		subject.set_dozent(new Mitarbeiter("Max", "Mustermann", 1234));
		subject.set_teilnehmer(teilnehmer);
		subject.print();
		
		System.out.println();
	}
	
	private static void test_mitarbeiter()
	{
		Mitarbeiter subject = null;
		
		System.out.println("test_mitarbeiter()");
		
		subject = new Mitarbeiter("Gerald", "Prof. Dr. Mann", 75);
		System.out.println(subject);
		System.out.println();
	}
	
	private static void test_person()
	{
		Person subject = null;
		
		System.out.println("test_person()");
		
		subject = new Person("Michael", "Zemanek");
		System.out.println(subject);
		System.out.println();
	}
	
	private static void test_student()
	{
		Student subject = null;
		
		System.out.println("test_student()");
		
		subject = new Student("Michael", "Zemanek", 258167, new Bankverbindung("Postbank München", "700 100 80", "1234 56 809"));
		System.out.println(subject);
		System.out.println(subject.get_bankverbindung());
		System.out.println();
	}
}
