#!/usr/bin/perl -w
# 2011-04-20 Uebung 4

# Schreiben Sie ein Programm, das prüft, wie of ein übergebenes Wort in einer Datei vorkommt.
# Das Wort kann auch mehrfach in einer Zeile vorkommen.

use strict;
use warnings;

# Wort einlesen.
print "Nach welchem Wort soll gesucht werden?\n";
chomp(my $word = <STDIN>) or die "Ungueltiger Ausdruck.\n";

print "In welcher Datei soll gesucht werden?\n";
chomp(my $filename = <STDIN>) or die "Ungueltiger Dateiname.\n";

open FILE, $filename or die $!;
my @lines = <FILE>;
close FILE;


my $count = 0;
my $row = 0;

foreach (@lines)
{
	$row++;
	if (/\b$word\b/g)
	{
		$count++;
		print "Zeile $row:\t$_";
	}
}

print "Der Ausdruck $word kommt $count mal in der Datei $filename vor.\n";
