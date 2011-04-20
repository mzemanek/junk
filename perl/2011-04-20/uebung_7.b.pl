#!/usr/bin/perl -w
# 2011-04-20 Uebung 7 b

# Schreiben Sie ein Programm, das alle Zeilen einer Datei ausgibt, die alle 5 Vokale in der
# Reihenfolge a, e, i o und u enthalten. Dabei soll die Großschreibung keine Rolle spielen.
# Diesmal soll aber zwischen den Vokalen kein anderer Vokal erlaubt sein.

use strict;
use warnings;

print "Welche Datei soll durchsucht werden?\n";
chomp(my $filename = <STDIN>) or die "Ungueltiger Dateiname.\n";

open FILE, $filename or die "Fehler beim Zugriff auf '$filename' ($!).\n";
my @lines = <FILE>;
close FILE;

my @result;
my $row = 0;

foreach (@lines)
{
	$row++;
	if (/^[^aeiou]*a[^aeiou]*e[^aeiou]*i[^aeiou]*o[^aeiou]*u[^aeiou]*$/i)
	{
		push @result, "Zeile $row:\t$_";
	}
}

if (scalar @result)
{
	print @result;
}
else
{
	print "Keine Ergebnisse gefunden.\n";
}
