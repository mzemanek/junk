#!/usr/bin/perl -W
# 2011-06-16

# Aus einer gegebenen Datei alle Zeichen der Länge 4.

use strict;
use warnings;

print "Dateiname:\t";
chomp(my $file = <>) or die "Ungültige Zeichenkette ($!)\n";

open FILE, $file or die "$!\n";
my @lines = <FILE>;
close FILE;

print "@lines";
foreach (@lines)
{
	$_ =~ s/[\.,;!?:"]//g;
	foreach (/[^\b\s]{4}/g)
	{
		print "$_\t";
	}
}

print "\n\n";
