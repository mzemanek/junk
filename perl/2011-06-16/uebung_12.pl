#!/usr/bin/perl -W
# 2011-06-16

# Wörter mit doppelten Buchstaben finden.

# uebung_12.pl FILE

while (<>)
{
	print "$1\t" if (/\b([\w']*(\w)\2[\w']*)\b/);
#	if (/\b([\w']*(\w)\2[\w']*)\b/)
#	{
#		print "$1\t";
#	}
}

print "\n\n";
