#! /usr/bin/perl
# 2011-03-07

use strict;
use warnings;

my @song = qw ( they sentenced me to twenty years of boredom );
my @sorted = sort @song;

print "@song\n";
print "@sorted\n";


my @input;
my @reversed;

print "Bitte Zeilen eingeben und mit STRG+D beenden:\n";
chomp(@input = <STDIN>);
@sorted = sort @input;
@reversed = reverse @sorted;

print "@input\n";
print "@sorted\n";
print "@reversed\n";

