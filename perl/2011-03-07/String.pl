#! /usr/bin/perl
# 2011-03-07

use strict;
use warnings;

my $wort;

print "Geben Sie ein Wort ein: ";
chomp($wort = <STDIN>);

for (1..length($wort))
{
	print $wort."\n";
}
