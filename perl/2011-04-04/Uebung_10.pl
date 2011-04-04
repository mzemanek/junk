#!/usr/bin/perl
# 2011-04-04 Uebung 10

use strict;
use warnings;

sub anz_argumente
{
	print "Funktionsaufruf mit " . scalar(@_) . " Elementen.\n";
}

anz_argumente(1, 2, 3, 4);
