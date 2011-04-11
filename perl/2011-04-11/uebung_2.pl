#!/usr/bin/perl
# 2011-04-11 Uebung 2

use strict;
use warnings;

print "Wonach soll gesucht werden?\n";
chomp(my $expression = <STDIN>);
if ('' eq $expression)
{
	die "Verarbeitung wird abgebrochen.\n";
}

print "Welche Datei soll durchsucht werden?\n";
chomp(my $file = <STDIN>);
if ('' eq $file)
{
	die "Verarbeitung wird abgebrochen.\n";
}

open IN, $file or die "$file nicht gefunden ($!)\n";
my @lines = <IN>;
close(IN);

my $row = 0;

foreach my $line (@lines)
{
	$row++;
	if ($line =~ /$expression/)
	{
		print "\n";
		
		if ('' ne $`)
		{
			print "Davor: $`\n";
		}
		
		print "Zeile $row: $&\n";

		if ('' ne $')
		{
			print "Dahinter: $'\n";
		}
	}
}

print "> ".scalar(@lines)." Zeilen!\n";
print "> ".scalar(split(' ', join(' ', @lines)))." Worte!\n";
