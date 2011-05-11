#!/usr/bin/perl -w
# 2011-05-11 Übung 11

#  1. Das Wort Michael:
#		/\bMichael\b/

#  2. Das Wort Michael am Anfang einer Zeile:
#		/^Michael\b/

#  3. Das Wort Michael am Ende einer Zeile:
#		/\bMichael$/

#  4. Das Wort Michael oder michael:
#		/\b[Mm]ichael\b/

#  5. Ein Buchstabe, der entweder ein Leerzeichen oder ein Tablulator ist:
#		/\s/

#  6. Mindestens ein Leerzeichen oder Tabulator, vielleicht aber auch mehr, am Ende einer Zeile:
#		/\s+$/

#  7. Ein Zeichen, das entweder ein kleiner Buchstabe, eine Zahl, ein Größer- oder Kleiner-Zeichen oder ein Unterstrich ist:
#		/[a-z0-9><_]/

#  8. Die Zeichenkette bestehend aus 0- gefolgt von ein oder mehreren 9 gefolgt von -:
#		/0-9+-/

#  9. Ein Zeichen, das kein Buchstabe ist:
#		/[^a-zA-Z]/ oder /\W/

# 10. Entweder die Zeichenfolge abc oder die Zeichenfolge ab:
#		/abc|ab/

# 11. Ein Wort, das mit einem Vokal beginnt, auf den die beiden Buchstaben da folgen:
#		/\b[aeiou]da/

# 12. Ein Wort, das mit einem beliebigen Buchstaben beginnt, auf das die beiden Buchstaben da folgen:
#		/\b\wda/

# 13. Ein Wort, das mit einem beliebigen Zeichen beginnt, auf das die beiden Buchstaben da folgen:
#		/.da/

# 14. Eine leere Textzeile:
#		/^\r?\n?$/

# 15. Eine Textzeile mit genau drei Zeichen:
#		/^.{3}$/

