#! /usr/bin/perl
# 2011-03-07

use strict;
use warnings;

my @input;

print "Ihre Eingabe:\n";
chomp(@input = <STDIN>);

print reverse(@input) . "\n";
