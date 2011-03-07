#! /usr/bin/perl
# 2011-03-07

use strict;
use warnings;

my $start;
my $end;

print "Startwert: ";
chomp($start = <STDIN>);

print "Endwert: ";
chomp($end = <STDIN>);

for ($start..$end)
{
	print "$_\n";
}
