#!/usr/bin/perl -W
# 2011-06-16

# Ersetzen von ä, ö, ü in &auml;, &ouml; und &uuml;
# uebung_1.pl FILE

use strict;
use warnings;

use constant HTML => 0;
use constant TEXT => 1;

my %replacements = (
	'Ä' => ['&Auml;', 'Ae'],
	'Ö' => ['&Ouml;', 'Oe'],
	'Ü' => ['&Uuml;', 'Ue'],
	'ä' => ['&auml;', 'ae'],
	'ö' => ['&ouml;', 'oe'],
	'ü' => ['&uuml;', 'ue']
	);

my @input = <>;

print &ersetze(TEXT, @input);
print &ersetze(HTML, @input);
print "\n\n";

sub ersetze()
{
	my ($index, @lines) = @_;

	foreach (@lines)
	{
		foreach my $key(keys %replacements)
		{
			s/$key/$replacements{$key}[$index]/g;
		}
	}
	
	return @lines;
}
