#!/usr/bin/perl -w
# 2011-05-11 Übung 9 (1)

# Eine Bankleitzahl besteht aus drei mal drei Ziffern, getrennt durch -.

use strict;
use warnings;

my @strings = qw ( 123-456-789 123-abc-456 );

print "Übung 9\n";

foreach (@strings)
{
	if (/\d{3}\-\d{3}\-\d{3}/)
	{
		print "$_ ist eine Bankleitzahl.\n";
	}
	else
	{
		print "$_ ist keine Bankleitzahl.\n";
	}
}
