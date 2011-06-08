#!/usr/bin/perl -W
# 2011-06-08

# Einfacher include-Prozessor.

use strict;
use warnings;

open IN, "./ipsum.txt" or die "$!\n";
perform(<IN>);
close(IN);

sub perform
{
	my @lines = @_;
	foreach my $line (@lines)
	{
		if ($line =~ /^#include \"([^\"]+)\"\r?$/i)
		{
			open INCLUDE, "./".$1 or die "$!\n";
			&perform(<INCLUDE>);
			close INCLUDE;
		}
		else
		{
			print $line . "\n";
		}
	}
}
