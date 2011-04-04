#!/usr/bin/perl
# 2011-04-04 Uebung 5.1

# Schreiben Sie ein Perl-Programm, dass eine unbegrente Anzahl von Zahlen einliest und aus diesen ein
# paar statistische Berechnungen durchführt, wie in der Abbildung.
# Kapsel Sie alle Berechnungen in einer eigenen Subroutine.

use strict;
use warnings;

my @input;
my $line;

print "Uebung 5.1\n";
print "Bitte Werte eingeben.\n";

do
{
	chomp($line = <STDIN>);
	if ("" ne $line)
	{
		push(@input, int($line));
	}
}
while ("" ne $line);


print "Anzahl der eingegebenen Zahlen: " . anzahl(@input) . "\n";
print "Summe der Zahlen: " . summe(@input) . "\n";
print "Kleinste Zahl: " . kleinste_zahl(@input) . "\n";
print "Groesste Zahl: " . groesste_zahl(@input) . "\n";
print "Durchschnitt: " . durchschnitt(@input) . "\n";
print "Mittelwert: " . mittelwert(@input) . "\n";
zeichnen(@input);


sub anzahl
{
	scalar(@_);
}

sub summe
{
	my $sum = 0;
	for (@_)
	{
		$sum += $_;
	}
	
	return $sum;
}

sub kleinste_zahl
{
	my @min = sort(@_);
	
	return $min[0];
}

sub groesste_zahl
{
	my @max = reverse(sort(@_));
	
	return $max[0];
}

sub durchschnitt
{
	return summe(@_) / scalar(@_);
}

sub mittelwert
{
	my @sorted = sort(@_);
	
	return $sorted[scalar(@sorted)/2 - 1];
}

sub zeichnen
{

}
