#!/usr/bin/perl
# 2011-03-01
# Rechnen

print "Geben Sie die erste Zahl ein:";
chomp($opl = <STDIN>);
print "Geben Sie die zweite Zahl ein:";
chomp($opr = <STDIN>);
print "Produkt = " . ($opl * $opr) . "\n\n";

print "Geben Sie den ersten Operator ein:";
chomp($opl = <STDIN>);
print "Geben Sie die Operation ein:";
chomp($op = <STDIN>);
print "Geben Sie den zweiten Operator ein:";
chomp($opr = <STDIN>);

if ($op eq '+')
{
	print "Summe: $opl + $opr = " . $opl + $opr . "\n";
}
elsif ($op eq '-')
{
	print "Differenz: $opl - $opr = " . $opl - $opr . "\n";
}
elsif ($op eq '*')
{
	print "Produkt: $opl * $opr = " . $opl * $opr . "\n";
}
elsif ($op eq '/')
{
	if ($opr == 0)
	{
		$opr = 1;
	}
	
	print "Quotient: $opl / $opr = " . $opl / $opr . "\n";
}
else
{
	print "Ausdruck $opl $op $opr ist ungültig.\n\n";
}
