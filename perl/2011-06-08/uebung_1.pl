#!/usr/bin/perl -w
# 2011-06-08
#
# Legen Sie einen Hash an, in dem einige deutsch-englische Übersetzungen abgelegt werden.

use strict;
use warnings;

my %hash = (
	Der => 'the',
	Das => 'the',
	Haus => 'house',
	ist => 'is',
	weiss => 'white'
	);
	
	print %hash;
	print "\n";
	print "$hash{Haus}\n";
