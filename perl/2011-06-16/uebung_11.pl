#!/usr/bin/perl -W
# 2011-06-16

# uebung_11.pl FILE

use strict;
use warnings;

my %hash;
my $chars = 0;
my $words = 0;
my $max = 0;
while (<>)
{
	tr/.,;:!?"\-//;
	for (split)
	{
		$hash{length($_)}++;
		$chars += length($_);
		$words++;
		$max = length($_) if ($max < length($_));
	}
}

for (sort(keys %hash))
{
	print "Zeichen: $_\tWörter: $hash{$_}\n";
}

print "1 .. $max\t".scalar(keys %hash)."\n";
print "Zeichen: $chars\tWörter: $words\tDurchschnitt: ".$chars / $words."\n\n";
