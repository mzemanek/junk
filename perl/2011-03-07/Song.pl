#! /usr/bin/perl
# 2011-03-07

use strict;
use warnings;

my @elements;
my @song = qw( They senteced me to twenty years of boredom );


print "Welche Elemente sollen angezeigt werden?\n";
chomp(@elements = <STDIN>);

print @song . "\n";

foreach (@elements)
{
	if (($_ < 0) || ($_ > $#song))
	{
		print "Index $_ ist kein gültiges Element.\n";
	}
	else
	{
		print "Index $_ hat den Inhalt: $song[$_]\n";
	}
}

