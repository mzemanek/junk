#!/usr/bin/perl -W
# 2011-06-16

# Konsonaten- und Vokalkombinationen

use strict;
use warnings;

my $all = "abcdefghijklmnopqrstuvwxyz";

for my $c ($all =~ /[^aeiou]/g)
{
	for ($all =~ /[aeiou]/g)
	{
		print "$c$_ ";
	}
}

print "\n\n";

