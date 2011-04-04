#!/usr/bin/perl
# 2011-03-14

use strict;
use warnings;

if (!open(IN, "<./uebung_3.data"))
{
	die "File not found ($!).";
}

while (defined(my $line = <IN>))
{
	my $temp;
	my @words;
	
	chomp($line);
	@words = split " ", $line;
	$temp = $words[$#words];
	$words[$#words] = $words[0];
	$words[0] = $temp;
	
	print "@words\n";
}

close IN;
