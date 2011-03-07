#! /usr/bin/perl
# 2011-03-01
# Cent-Eingabe

print "Geben Sie Cent ein:";
chomp($cent = <STDIN>);

print "Das ergibt " . int($cent / 100) . " Dollar und " . ($cent % 100) . " Cent.";
