#!/usr/bin/perl
# 2011-04-04 Uebung 8

# Schreiben Sie eine Funktion ist_schaltjahr.
# Die Funktion hat als Parameter eine Jahreszahl und liefert einen Warheitswert.
# Dabei soll 1 bedeuten, dass das angegebene Jahr ein Schaltjahr ist.
# Ein Jahr ist ein Schaltjahr, wenn es durch 4 teilbar ist, aber nicht durch 100.
# Zusätzlich sind alle Jahre Schaltjahre, die durch 400 teilbar sind.

use strict;
use warnings;

sub ist_schaltjahr
{
	my $jahr = int($_[0]);
	return ($jahr % 400 == 0) || ($jahr %4 == 0 && $jahr %100 != 0);
}

print "1900 war " . (ist_schaltjahr(1900) == 0 ? "kein" : "ein") . " Schaltjahr.\n";
print "1996 war " . (ist_schaltjahr(1996) == 0 ? "kein" : "ein") . " Schaltjahr.\n";
print "2000 war " . (ist_schaltjahr(2000) == 0 ? "kein" : "ein") . " Schaltjahr.\n";
