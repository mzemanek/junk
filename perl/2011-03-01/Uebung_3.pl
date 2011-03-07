#!/usr/bin/perl
# 2011-03-01
# Uebung 3

@monate = qw( April Mai Juni);
@werte = ( 12, 14, 8 );
$summe = 0;

foreach (0..$#werte)
{
	print "Niederschlag im $monate[$_]: $werte[$_]\n";
	$summe += $werte[$_];
}

print "Durchschnitt: " . $summe / @werte . "\n\n";
