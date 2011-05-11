#!/usr/bin/perl -w
# 2011-05-11 Übung 10

# Wer passt zu wem?

#	Muster				1			2			3			4						5
#	a:aus					Haus		Aus		laust		auseinander			a us
#	b:aus+				Hau		auss		aUss		Hausseingang		ausau
#	c:aus*				Hau		auss		aUss		Hausseingang		a
#	d:a*					aaa		xyz		xax		ABC					bab
#	e:\baus				aus		Haus		auss		Hausseingang		aUss
#	f:[Tim|Tom|Tam]	Tim		|			zom		mat					Tom

# a:	1 3 4
# b:	2 3 5
# c:	1 2 4
# d: 
# e:
# f:


use strict;
use warnings;

my @daten = qw ( Tim | zom mat Tom );

foreach (@daten)
{
	if (/[Tim|Tom|Tam]/)
	{
		print "$_ matched!\n";
	}
	else
	{
		print "$_ failed!\n";
	}
}
