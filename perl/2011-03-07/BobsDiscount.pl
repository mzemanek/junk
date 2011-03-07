#! /usr/bin/perl
# 2011-03-07

use strict;
use warnings;

my @dinge = qw( Schraube Mutter Unterlegscheibe );
my @preise = ( 5, 3, 1 );
my @anzahl = ( 0, 0, 0 );
my $betrag = 0;

print "Bob's Schrauben Discount\n";

foreach (0..$#dinge)
{
	print "$dinge[$_]: ";
	chomp($anzahl[$_] = <STDIN>);
	
	$betrag += $anzahl[$_] * $preise[$_];
}

if ($anzahl[0] > $anzahl[1])
{
	print "Kontrollieren Sie Ihre Bestellung!\n";
}
else
{
	print "Die Bestellung ist okay.\n";
}

print "Gesamtbetrag: $betrag\n\n";
