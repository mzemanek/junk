#!/usr/bin/perl
# 2011-04-11 Uebung 1

use strict;
use warnings;

# sub declarations.
#
sub info;
sub sortiere;


# global variables.
#
my %coins = ('Nickel', 0.05, 'Dime', 0.1, 'HalfDollar', 0.5, 'Penny', 0.01, 'Quarter', 0.25);
my %keywords = ('EXIT', 0, 'SN', 1, 'SL', 2, 'A', 3, 'R', 4);
my $line;


# main functionality.
#
info();

do
{
	print "Ihre Eingabe: ";
	chomp($line = <STDIN>);
	$line = uc($line);

	if (!exists $keywords{$line})
	{
		info();
	}
	elsif (3 == $keywords{$line})
	{
		# Add a new element.
		chomp(my $key = <STDIN>);
		chomp(my $value = <STDIN>);
		if (!exists $coins{$key})
		{
			$coins{$key} = $value;
		}
	}
	elsif (4 == $keywords{$line})
	{
		chomp(my $key = <STDIN>);
		if (exists($coins{$key}))
		{
			delete($coins{$key});
		}
	}
	else
	{
		sortiere($keywords{$line});
	}
}
while ('EXIT' ne $line);


# sub definitions.
#
sub info
{
	print "Uebung 1\n";
	print "SL fuer lexikalisch sortierten Inhalt.\n";
	print "SN fuer numerisch sortierten Inhalt.\n";
	print "EXIT zum Beenden.\n";
	print "\n";
}

sub sortiere
{
	my %temp = ();
	
	if (1 == $_[0])
	{
		print "\n";
		print "Numerische Sortierung:\n";
		@temp{values(%coins)} = keys(%coins);
	}
	elsif (2 == $_[0])
	{
		print "\n";
		print "Lexikalische Sortierung:\n";
		@temp{keys(%coins)} = values(%coins);
	}

	foreach my $key (sort(keys(%temp)))
	{
		print "$key (=".$temp{$key}.")\n";
	}
	print "\n";
}
