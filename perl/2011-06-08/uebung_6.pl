#!/usr/bin/perl -W
# 2011-06-07

# Path parsing.

use strict;
use warnings;

my $path = "das/ist/mein/Pfad/datei1.txt";
my $backslashpath = "das\\ist\\der\\zweite\\Pfad\\datei1.txt";

&make_path($path);# or die "$path";
#&make_path($backslashpath);# or die "$backslashpath";

open my $datei, ">", $path or die "$backslashpath:$!\n";

sub make_path
{
	my ($input, @rest) = @_;
	my $pathtomake = "";
	
	print "make_path: $input\n";
	for ($input =~ m!([^\\/]+)[\\/]!g)
	{
		print "$_\n";
		$pathtomake .= "$_";
		mkdir("$pathtomake", 0777) || die $!;
		$pathtomake .= "/";
	}
}
