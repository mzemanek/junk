#!/usr/bin/perl
# 2011-04-04

use strict;
use warnings;

sub bilde_summe
{
	my $summe = 0;
	
	for (@_)
	{
		$summe += int($_);
	}
	
	return $summe;
}

my @list = (1, 2, 3, 4, 5);

print "Die Summe von @list ist " . bilde_summe(@list) . "\n";
