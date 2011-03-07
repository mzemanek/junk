#! /usr/bin/perl
# 2011-03-07 Vorlesung
# Während einer sonderaktin wird ein Rabatt von 10% auf alle Einkäufe mit einem Gesamtbetrag von mehr als $10.00 gewährt.
# Schreiben Sie ein Programm, das nach dem Gesamtbetrag fragt und den Discountpreis berechnet.
# Der Gesamtbetrag wird in Cent (als Ganzzahl) eingegeben.

# Geben Sie den Gesambtbetrag ein: 2000
# Discountpreis: 1800

print "Geben Sie den Gesamtbetrag ein: ";
chomp($cent = <STDIN>);
if (1000 < $cent)
{
	print "Discountpreis: " . ($cent * 0.9) ."\n";
}
else
{
	print "Discount nur ab 1000 cent.\n";
}
