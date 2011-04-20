#!/usr/bin/perl -w
# 2011-04-20

# Schreiben Sie ein Programm, das alle Worte ausgibt, die in einem Text zweimal unmittelbar
# hintereinander, nur durch Whitespace getrennt, erscheinen. Hier haben Sie Testdaten:

use strict;
use warnings;

print "Welche Datei soll durchsucht werden?\n";
chomp(my $filename = <STDIN>) or die "Ungueltiger Dateiname.\n";

open FILE, $filename or die "Fehler beim Zugriff auf '$filename' ($!).\n";
my @lines = <FILE>;
close FILE;

my $row = 0;
foreach (@lines)
{
	$row++;
	chomp($_);
	if (/\b(\w+)\s+\1\b/g)
	{
		print "Zeile $row: $1 (".(defined($`) ? $` : "")."[$&]".(defined($') ? $' : "").")\n";
	}
}
