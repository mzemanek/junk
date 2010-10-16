// C-Workshop 16.10.2010
//
// Schreiben Sie ein Programm das in der Lage ist, beliebige mathematische
// Ausdrücke der Grundrechenarten korrekt (!) zu berechnen.
//
// Beispiel: "2 + 3 * 4" = 14, nicht 20!
#include <stdio.h>

// Forward declarations.
//
void berechne(char* ausdruck);
int berechne_teilausdruck(char* buffer, char* operatoren);
void berechne_teilergebnis(char op, int a, int b, int* c);
int ist_operator(char zeichen);

// Globale Variablen.
//
int zeige_rechenweg = 0;

/*static*/ char* testcases[] =
{
	"2 + 3 * 4",
	"12/4*3",
	"7 + 8 + 15 -23 + 2 * 3",
	" 1 + 2*4 + 6/3 +7",
	// Ende des Arrays (für Abbruchbedingung).
	NULL
};

/*static*/ char* operatoren_rangfolge[] = 
{
	"*/",
	"+-",
	// Ende des Arrays (für Abbruchbedingung).
	NULL
};

// Application entry point.
int main(int argc, char* argv[])
{
	char** testcase = testcases;
	
	if (argc > 1)
	{
		zeige_rechenweg = (argc == 2) ? 0 : 1;
		berechne(argv[1]);
	}
	else
	{
		printf("Usage info:\n./Calculate \"<Ausdruck>\" [<zeige_rechenweg>]\n\n");
		
		// Testfälle abarbeiten.
		zeige_rechenweg = 1;
		while (*testcase != NULL)
		{
			printf("\nTestfall\n\t\"%s\"\n", *testcase);
			berechne(*testcase);
			testcase++;
		}	
	}
		
	// Signal success.
	return 0;
}

void berechne(char* ausdruck)
{
	char buffer[1024] = {0};
	char* buffer_ptr = buffer;
	char** operatoren_ptr = operatoren_rangfolge;
	
	// Ausdruck umkopieren, um ihn modifizieren zu können.
	do
	{
		*buffer_ptr = *ausdruck;
		ausdruck++;
		buffer_ptr++;
	}
	while (*ausdruck != '\0');
	
	// Alle Operatoren gemäss ihrer Rangfolge durchlaufen.
	while (*operatoren_ptr != NULL)
	{
		while(berechne_teilausdruck(buffer, *operatoren_ptr));
		operatoren_ptr++;
	}
	
	// Zeiger zurücksetzen.
	ausdruck -= buffer_ptr - buffer;
	
	// Ausgeben des Endergebnisses.
	printf("%s = %s\n", ausdruck, buffer);
}

int berechne_teilausdruck(char* buffer, char* operatoren)
{
	//[2][ ][+][ ][3][ ][*][ ][4][\0]
	char* buffer_ptr = buffer;
	
	// Suchzeichen finden.
	while (*buffer_ptr != '\0')
	{
		int found = 0;
		char* operator_ptr = operatoren;
		
		while (*operator_ptr != '\0')
		{
			if (*buffer_ptr == *operator_ptr)
			{
				found = 1;
				break;
			}
				
			operator_ptr++;
		}
		
		if (found)
		{
			break;
		}
		
		buffer_ptr++;
	}
	
	// Wenn Suchzeichen vorhanden.
	if ((*buffer_ptr != '\0') /*&& (buffer_ptr != buffer)*/)
	{
		int a = 0;
		char* a_ptr = buffer_ptr;
		int b = 0;
		char* b_ptr = buffer_ptr;
		int c = 0;
		char op = *buffer_ptr;
		
		// Operator durch Null-Terminator ersetzen.	
		*buffer_ptr = '\0';
		
		// Operand links isolieren.
		while (a_ptr >= buffer)
		{
			if (ist_operator(*a_ptr) || (a_ptr == buffer))
			{
				if (a_ptr != buffer)
				{
					a_ptr++;
				}
				
				a = atoi(a_ptr);
				break;
			}
			
			a_ptr--;
		}
		
		// Operand rechts isolieren.
		do
		{
			b_ptr++;

			if (ist_operator(*b_ptr) || (*b_ptr == '\0'))
			{
				char tmp = *b_ptr;
				
				*b_ptr = '\0';		
				b = atoi(buffer_ptr + 1);
				*b_ptr = tmp;
				break;
			}
		}
		while (*b_ptr != '\0');
				
		// Teilausdruck entfernen.
		buffer_ptr = a_ptr;
		while (buffer_ptr < b_ptr)
		{
			*buffer_ptr = ' ';
			buffer_ptr++;
		}
		
		// Teilergebnis berechnen.
		berechne_teilergebnis(op, a, b, &c);
		
		// Teilergebnis einfügen.
		sprintf(a_ptr, "%d", c);
		
		// Da sprintf mit \0 terminiert, muss das bereinigt werden.
		while (b_ptr > buffer)
		{
			b_ptr--;
			if (*b_ptr == '\0')
			{
				*b_ptr = ' ';
			}
		}
		
		// Zwischenausgabe.
		if (zeige_rechenweg)
		{
			printf("\t\"%s\"\n", buffer);
		}
		
		// Signal success.
		return 1;
	}
	
	// Signal failure.
	return 0;
}

void berechne_teilergebnis(char op, int a, int b, int* c)
{
	switch (op)
	{
	case '+':
		*c = a + b;
		break;
			
	case '-':
		*c = a - b;
		break;
		
	case '*':
		*c = a * b;
		break;
			
	case '/':
		*c = a / b;
		break;
	}
	
	// Zwischenausgabe.
	if (zeige_rechenweg)
	{
		printf("\t%d %c %d = %d\n", a, op, b, *c);
	}	
}

int ist_operator(char zeichen)
{
	char** operatoren = operatoren_rangfolge;
	
	while (*operatoren != NULL)
	{
		char* operator = *operatoren;
		
		while (*operator != '\0')
		{
			if (*operator == zeichen)
			{
				// Signal success.
				return 1;
			}
			
			operator++;
		}
		
		operatoren++;
	}
	
	// Signal failure.
	return 0;
}
