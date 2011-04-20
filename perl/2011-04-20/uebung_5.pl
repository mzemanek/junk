#!/usr/bin/perl -w
# 2011-04-20 Uebung 5

use strict;
use warnings;

print "Welche Datei soll verarbeitet werden?\n";
chomp(my $filename = <STDIN>) or die "Ungueltiger Dateiname.\n";

open FILE, $filename or die "$filename konnte nicht geoeffnet werden ($!).\n";
my @lines = <FILE>;
close FILE;

my $expr = "([\\+\\-]?\\d+(\\.\\d+)?)";

print "Ursprüngliche Daten:\n";
print "====================\n";
print @lines;
print "\n";

foreach (@lines)
{
#	print "alt:\t$_";
	s/$expr/1 + $1/ge;
#	print "neu:\t$_";
}

print "Modifizierte Daten:\n";
print "===================\n";
print @lines;
