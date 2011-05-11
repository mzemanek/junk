#!/usr/bin/perl -w
# 2011-05-11 Übung 9 (2)

# Gleitkommazahl

use strict;
use warnings;

my @daten = qw ( 123 123.456 123a456 123.2E+34 123e-8 1e25 );

foreach (@daten)
{
	if (/^[+\-]?[0-9]+([\.][0-9]+([eE][+\-]?[0-9]+)?)?$/)
	{
		print "$_ ist eine Gleitkommazahl.\n";
	}
	else
	{
		print "$_ ist keine Gleitkommazahl.\n";
	}
}
