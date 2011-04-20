#!/usr/bin/perl -w
# 2011-04-20 Uebung 3

# In einer Textdatei stehen ganze Zahlen, positive und negative, manchmal auch mehrere in einer
# Zeile, durch Leerzeichen getrennt. Schreiben Sie ein Programm, das die Summe aller Zahlen in
# der Datei ermittelt.

use strict;
use warnings;

print "Welche Datei soll durchsucht werden?\n";
chomp(my $file = <STDIN>);
if ('' eq $file)
{
	$file = "./Zahlen.data";
}

open IN, $file or die "$file nicht gefunden ($!)\n";
my @lines = <IN>;
close(IN);

my $summe = 0.00;
my $expression = "([+-]?\\d+(\\.\\d+)?)";

foreach my $line (@lines)
{
	while ($line =~ /$expression/g)
	{
		print "$1\n";
		$summe += $1;
	}
}

print "Die ermittelte Summe von $file ist $summe.\n";

