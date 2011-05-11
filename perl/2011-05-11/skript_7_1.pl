#!/usr/bin/perl -w
# 2011-05-11 Skript 7 Übung 1

use strict;
use warnings;

my $zahl = int(1 + rand 100);
my $eingabe;
my $versuch = 0;

print "Gesuchte Zahl ist $zahl\n\n";
while(++$versuch)
{
	print "Geben Sie eine Zahl zwischen 1 und 100 ein:";
	chomp($eingabe = <STDIN>);
#	$versuch++;
	print "Zu groß.\n" if ($zahl < int($eingabe));
	print "Zu klein.\n" if ($zahl > int($eingabe));
	print "Treffer beim $versuch"."ten Versuch.\n\n" and last if ($zahl == int($eingabe));
}
#until ($zahl == int($eingabe));

