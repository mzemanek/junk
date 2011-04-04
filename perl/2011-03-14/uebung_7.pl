#!/usr/bin/perl
# 2011-03-14

use strict;
use warnings;

my $a = "a";
my $b = "b";

print "Vorher: a=$a;b=$b\n";
&swap($a, $b);
#&swap2($a, $b);
print "Nachher: a=$a;b=$b\n";

sub swap
{
	if (2 != @_)
	{
		die "Call to swap failed.\n";
	}
	
	my $temp = $_[0];
	$_[0] = $_[1];
	$_[1] = $temp;
}

sub swap2
{
	return reverse @_;
}
