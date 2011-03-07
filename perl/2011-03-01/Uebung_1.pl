#!/usr/bin/perl
# 2011-03-01
# Uebung 2_1

$pi = 3.41;

print "Umfang für Radius ausgeben:\n";
print "Hardcoded:\n";
$r = 2;
$U = 2 * $pi * $r;
print "2 * \$pi * $r = $U\n\n";

do
{
	print "Bitte Radius eingeben:\n";
	chomp($r = <STDIN>);
	if ($r > 0)
	{
		$U = 2 * $pi * $r;
		print "2 * \$pi * $r = $U\n\n";
	}
	else
	{
		print "Ungültige Eingabe: $r\n\n";
		$r = 0;
	}
}
while ($r != 0);
