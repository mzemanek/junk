#!/usr/bin/perl -W
# 2011-06-16

# uebung_10.pl FILE

use strict;
use warnings;

my $score = 0;

while (<>)
{
	tr/;:,.!\-"?//; # Satzzeichen loswerden.
	for my $w(split)
	{
		if (/lorem/i)
		{
			$score++;
		}
	}
}

printf "$score Vorkommen des Wortes Hexe gefunden.\n\n";
