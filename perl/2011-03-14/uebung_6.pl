#!/usr/bin/perl
# 2011-03-14

use strict;
use warnings;

my @werte = ( 4, 5, 6);

print "Der Durchschnitt von @werte ist " . &durchschnitt(@werte) . ".\n";

sub durchschnitt
{
	my $durchschnitt = 0;
	my $summe = 0;
	
	foreach (@_)
	{
		$summe += $_;
	}
	
	return $summe / (1 + $#_);
}
