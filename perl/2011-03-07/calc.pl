#! /usr/bin/perl
# 2011-03-07

use strict;
use warnings;

my $n;
my $quadrat = 0;
my $kubik = 0;

print "Geben Sie n ein: ";
chomp($n = <STDIN>);

for (0..$n)
{
	$quadrat += $_**2;
	$kubik += $_**3;
}

print "Die Quadratsumme ist: " . $quadrat . "\n";
print "Die Kubiksumme ist: " . $kubik . "\n";
print "\n";
