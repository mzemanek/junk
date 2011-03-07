#! /usr/bin/perl
# 2011-03-07

use strict;
use warnings;

my $stars = 7;

print "Anfangszahl der Sterne: $stars\n";
print "\n";

while ($stars > 0)
{
	for (1..$stars)
	{
		print "*";
	}

	print "\n";		
	$stars--;
}

print "\n";
