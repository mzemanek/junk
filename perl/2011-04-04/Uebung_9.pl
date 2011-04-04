#!/usr/bin/perl
# 2011-04-04 Uebung 9

# Caesarian Encryption

use strict;
use warnings;

sub encrypt
{
	my @plain = split("", $_[0]);
	my $offset = $_[1];
	my $encrypted = "";
	
	for (@plain)
	{
		my $ord = ord($_);
		
		# Upper-case letters.
		if ($ord >= 65 && $ord <= 90)
		{
			$ord += $offset;
			$ord -= 65;
			if ($ord > 25)
			{
				$ord = $ord % 26;
			}
			
			#$encrypted .= chr(ord($_) + $offset);
			$encrypted .= chr(65 + $ord);
		}
		# Lower-case letters.
		elsif ($ord >= 97 && $ord <= 122)
		{
			$ord += $offset;
			$ord -= 97;
			if ($ord > 25)
			{
				$ord = $ord % 26;
			}
			
			#$encrypted .= chr(ord($_) + $offset);
			$encrypted .= chr(97 + $ord);
		}
		# Don't touch.
		else
		{
			$encrypted .= $_;
		}
	}
	
	return $encrypted;
}

print encrypt("Ha12llo We34lt", 1) . "\n";
print encrypt("Ha.ll0o Wel#t", 2) . "\n";

print "abcdefghijklmnopqrstuvwxyz\n";
print encrypt("abcdefghijklmnopqrstuvwxyz", 1) . "\n";
print encrypt("abcdefghijklmnopqrstuvwxyz", 2) . "\n";
print encrypt("abcdefghijklmnopqrstuvwxyz", 3) . "\n";
print encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1) . "\n";
print encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 2) . "\n";
print encrypt("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 3) . "\n";
