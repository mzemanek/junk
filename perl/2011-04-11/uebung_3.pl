#!/usr/bin/perl
# 2011-04-11 Uebung 3

use strict;
use warnings;

print "Was soll gesucht werden?\n";
chomp(my $expression = <STDIN>) or die "Ungueltiger Ausdruck.\n";

print "In welcher Datei soll gesucht werden?\n";
chomp(my $filename = <STDIN>) or die "Ungueltiger Dateiname.\n";

open FILE, $filename or die $!;
my @lines = <FILE>;
close FILE;

my $row = 0;

foreach (@lines)
{
	$row++;
	if (/\b$expression\b/i)
	{
		print $_;
		print "Zeile $row: $&\n";
	}
}
