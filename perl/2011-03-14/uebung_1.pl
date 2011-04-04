#!/usr/bin/perl
# 2011-03-14

# Schreiben Sie ein Programm, das alle Zeilen einer Textdatei ausgibt, die mehr als 20 Zeichen enthalten.

use strict;
use warnings;

if (!open(IN, "<./uebung_1.pl"))
{
	die "Failed to open file ($!)";
}

while (defined(my $line = <IN>))
{
#	print length($line).":$line\n";
	chomp($line);
	if (int(length($line)) > 20)
	{
		print "$line\n";
	}
}

close IN;
