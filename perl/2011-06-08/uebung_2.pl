#!/usr/bin/perl -W
# 2011-06-08

use strict;
use warnings;

my %Woerterbuch = (
	BETREFF => 'Beschwerde',
	ABSENDER => 'Ich',
	ADRESSAT => 'Der Prof'
	);
	
print "Welche Datei soll durchsucht werden?\n";
chomp(my $file = <STDIN>);
if ('' eq $file)
{
	$file = "./uebung_2.input";
}

open IN, $file or die "$file nicht gefunden ($!)\n";
my @lines = <IN>;
close(IN);

print "Input:\n@lines\n\n";

for my $key (keys %Woerterbuch)
{
#	my $key = $_;
	foreach (@lines)
	{
		$_ =~ s/$key/$Woerterbuch{$key}/;

	}
}

open OUT, ">$file.out" or die "$!\n";
print OUT @lines;
close(OUT);
print "Output:\n@lines\n\n";
