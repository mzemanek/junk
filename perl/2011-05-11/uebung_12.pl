#!/usr/bin/perl -w
# 2011-05-11 Übung 12

# 16. Eine Textzeile, die nur aus Leerzeichen besteht:
#		/^ +$/

# 17. Eine Textzeile, die mit einem Punkt beginnt:
#		/^\..*$/

# 18. Eines der wörter sechs oder sieben oder acht:
#		/sechs|oder|sieben|acht/

# 19. Ein Wort, das mit Haus beginnt. Das Wort soll nur aus Buchstaben bestehen.
#		/\bHaus[a-zA-Z]+/

# 20. Ein Zeichen, das entweder der Buchstabe a, ein Minuszeichen oder ein d ist:
#		/[a\-d]/

# 21. ab gefolgt von beliebig vielen exemplaren des Buchstaben C:
#		/abC*/

# 22. Ein a am Zeilenanfang oder ein b irgendwo:
#		/^a|b/

# 23. Ein a oder ein b am Zeilenanfang:
#		/^[ab]/

# 24. Als erstes Zeichen ein a oder b, als zweites Zeichen c oder d:
#		/[ab][cd]/

# 25. Beliebig viele aber mindestens eine, Wiederholung der drei Buchstaben abc:
#		/(abc)\1+/

# 26. Ein a gefolgt von beliebig vielen Exemplaren des Buchstaben b (eventuell auch keinem b):
#		/ab*/

# 27. Zweimal dasselbe Wort. Dabei ist ein Wort eine Folge von Buchstaben und es sind beliebige Whitespaces dazwischen erlaubt:
#		/\([a-zA-Z]+)s+\1/

# 28. Eine Zeile, die nur aus Wiederholungen der gleichen Zeichenfolge (ohne Whitespaces) besteht.
#		Zwischen und vor der Zeichenfolge sollen Whitespaces stehen (z. B. A? A? A?)
#		/^(\S+)(\s+\1)*$/

# 29. Fünfmal der Inhalt der Variablen $text
#		/($text){5}/

# 30. Drei beliebige Zeichen, wobei das Zeichen auch ein Zeilenende sein darf:
#		/.../s oder (.|\n){3}

# 31. Beliebig viele Backslashes, mindestens aber einer, gefolgt von beliebig vielen Sternen (eventuell auch keinem):
#		/\\+\**/

