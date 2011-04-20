#!/usr/bin/perl -w
# 2011-04-20 Uebung 7 a

# Schreiben Sie ein Programm, das alle Zeilen einer Datei ausgibt, die alle 5 Vokale in der
# Reihenfolge a, e, i o und u enthalten. Dabei soll die Großschreibung keine Rolle spielen.

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
	if (/^.*a.*e.*i.*o.*u.*$/i)
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
