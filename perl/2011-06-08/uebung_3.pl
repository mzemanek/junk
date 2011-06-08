#!/usr/bin/perl -W
# 2011-06-08

# Schreiben Sie ein Programm, das eine sortierte Liste aller Wörter ausgibt, die in einem Text doppelt vorkommen.
# Damit ist gemeint, dass zweimal das gleice Wort unmittelbar nacheinander geschrieben wurde.

# Optional: Die Liste soll Wortlaut und Anzahl der Wiederholungen in jeweils einer Zeile anzeigen und absteigend sortiert sein.

use strict;
use warnings;

my %hash = ();

print "Welche Datei soll durchsucht werden?\n";
chomp(my $file = <STDIN>);
if ('' eq $file)
{
	$file = "./doppelte.txt";
}

open IN, $file or die "$file nicht gefunden ($!)\n";
my @lines = <IN>;
close(IN);

foreach (@lines)
{
	for (/\b([^\b]+?)\b)\1/gi)
	{
		print "[$1]\n";
		$hash{$1} += 1;
	}
}

print "\n";
