// 2011-02-07
// package Abenteuerspiel;

public abstract class Abenteuerspiel
{
	public static void main(String[] args)
	{
		Spielfigur monster = new Monster();
		monster.drohe();
		
		Spielfigur hustendesMonster = new Husten(monster);
		hustendesMonster.drohe();
		
		Spielfigur schniefendesMonster = new Schnupfen(monster);
		schniefendesMonster.drohe();
	}
}
