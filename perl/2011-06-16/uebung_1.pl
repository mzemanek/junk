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

for (keys %replacements)
{
	print "key=$_;HTML=".$replacements{$_}[0].";TEXT=".$replacements{$_}[TEXT]."\n";
}
print "\n\n";

my @input = <>;
print &ersetze(TEXT, @input)."\n\n";
print &ersetze(HTML, @input)."\n\n";

#my test = "<html><head><title>Übung mit äusserst öffentlichen Änderungen</title></head><body></body></html>";
	
sub ersetze()
{
	my ($index, @lines) = @_;
	foreach (@lines)
	{
		foreach my $key(keys %replacements)
		{
			tr/$key/$replacements{$key}[$index]/;
		}
	}
	
	print "@lines\n";
	return @lines;
}
