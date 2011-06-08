#!/usr/bin/perl -W
# 2011-06-08

# Wie viele Zeilen Programmtext müssen Sie schreiben, um einen Taschenrechner zu programmieren, der alle
# Formeln berechnen kann, die Perl in einem Programm auch versteht, vorausgesetzt, sie passen in eine Zeile?

use strict;
use warnings;
 
print eval($_ ). "\n" for(<>)
