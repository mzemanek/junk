#!/usr/bin/perl
# 2011-03-14

use strict;
use warnings;

if (!open(IN, "<./uebung_5.data"))
{
	die "Failed to load data ($!)\n";
}

my $sum = 0.00;

while (defined(my $line = <IN>))
{
	my @words;
	
	chomp($line);
	@words = split " ", $line;
	
	$sum += $words[2];
}

close IN;

print "Die Summe der dritten Spalte ist $sum.\n";
