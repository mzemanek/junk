#!/usr/bin/perl
# 2011-03-14

use strict;
use warnings;

if (!open(IN, "<./uebung_2.data"))
{
	die "Failed to open file ($!).";
}

while (defined(my $line = <IN>))
{
	my @words;
	
	chomp($line);
	@words = split " ", $line;
	print $words[0]."\n";
}

close IN;
