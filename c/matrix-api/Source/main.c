#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "matrix.h"
#include "matrix-tests.h"

// What is it what we are about to do:

// Interpret command lines:
// TODO: matrix [create] <filespec>
// TODO: matrix [edit] <filespec>
// TODO: matrix add <filespec> <filespec> [<filespec>]
// matrix gea <filespec> [<filespec>]
// matrix gjea <filespec> [<filespec>]
// matrix invert <filespec> [<filespec>]
// matrix multiply <filespec>|scalar> <filespec> [<filespec>]
// matrix subtract <filespec> <filespec> [<filespec>]
// matrix transpose <filespec> [<filespec>]

// Perform chained operations (recursive application calls)
// e.g. matrix <filespec> * transpose <filespec> + <filespec>

// Defines
//
#define ARGUMENTS_EMPTY {{0}, NULL, NULL, NULL, NULL}

// Typedefs.
//
typedef enum _bool { false = 0, true } bool;

typedef struct _arguments
{
	// Do not forget to adjust ARGUMENTS_EMPTY in case of changes!
	char dot[L_tmpnam];
	int (*exec)(const struct _arguments *);
	char *filespec_1st;
	char *filespec_2nd;
	char *filespec_out;
	char **remains;
} arguments;

// Declarations.
//
void clear_console(void);
void dump_arguments(int argc, char** argv);
int add(const arguments *args);
int E(const arguments *args);
int gea(const arguments *args);
int gjea(const arguments *args);
int invert(const arguments *args);
int multiply(const arguments *args);
int subtract(const arguments *args);
int transpose(const arguments *args);
bool parse_arguments(arguments *args, int argc, char *argv[]);

// Application entry point.
//
int main(int argc, char *argv[])
{
	char buffer[BUFSIZ];
	int status = 0;
	arguments args = ARGUMENTS_EMPTY;
 
	// Parse arguments.
	if (!parse_arguments(&args, argc, argv))
	{
		// Display usage info.
		printf("Usage info:\n\n");
		// TODO: Complement usage info.
		return 1;
	}

	// Execute action.
	if (NULL != args.exec)
	{
		status = args.exec(&args);
	}

	// Construct follow-up command line.
	if (!status && (NULL != args.remains) && (NULL != *args.remains))
	{
		char buffer[BUFSIZ];
		bool replacedFirstDot = false;

		strncpy(buffer, argv[0], BUFSIZ);
		while (NULL != *(args.remains))
		{
			strncat(buffer, " \"", BUFSIZ);
			// Replace first dot of remains with temp file name.
			if (!replacedFirstDot && (0 != strlen(args.dot)) && (0 == strcmp(".", *args.remains)))
			{
				strncat(buffer, args.dot, BUFSIZ);
				replacedFirstDot = true;
			}
			else
			{
				strncat(buffer, *(args.remains), BUFSIZ);
			}

			strncat(buffer, "\"", BUFSIZ);
			args.remains++;
		}

		// Recursive call to application.
		status = system(buffer);
	}

	// Delete temporary file if any.
	if (0 < strlen(args.dot))
	{
		printf("> Removing %s...\n", args.dot);
		remove(args.dot);
	}

   return status;
}

// Definitions.
//
void clear_console()
{
	if (system("cls"))
	{
		system("clear");
	}
}

void dump_arguments(int argc, char** argv)
{
	int i = 0;

	printf("> argv:");
	for (i = 0; i < argc; i++)
	{
		printf(" %s", argv[i]);
	}

	printf("\n");
}

bool parse_argument_output(arguments *args, int argc, char*argv[], int position)
{
	if (argc > position)
	{
		args->filespec_out = argv[position];
		args->remains = &(argv[position + 1]);

		// Replace . with temp file name.
		if ('.' == args->filespec_out[0])
		{
			if (NULL == tmpnam(args->dot))
			{
				printf("> tmpnam(...) failed.\n");
				return false;
			}

			args->filespec_out = args->dot;
		}
	}
	else
	{
		// Let arg->remains point to '\0'.
		args->remains = &(argv[position]);
	}

	return true;
}

bool parse_arguments(arguments *args, int argc, char *argv[])
{
	// First argument holds command.
	// Check second argument for action to perform. 
	if (argc > 1)
	{
		// Determine operation to perform.
		if ((0 == strcmp("E", argv[1])) && (2 < argc))
		{
			// E <filespec> [<filespec>]
			args->exec = &E;
			args->filespec_1st = argv[2];
			return parse_argument_output(args, argc, argv, 3);
		}
		else if ((0 == strcmp("gea", argv[1])) && (2 < argc))
		{
			// gea <filespec> [<filespec>]
			args->exec = &gea;
			args->filespec_1st = argv[2];
			return parse_argument_output(args, argc, argv, 3);
		}
		else if ((0 == strcmp("gjea", argv[1])) && (2 < argc))
		{
			// gea <filespec> [<filespec>]
			args->exec = &gjea;
			args->filespec_1st = argv[2];
			return parse_argument_output(args, argc, argv, 3);
		}
		else if ((0 == strcmp("invert", argv[1])) && (2 < argc))
		{
			// invert <filespec> [<filespec>]
			args->exec = &invert;
			args->filespec_1st = argv[2];
			return parse_argument_output(args, argc, argv, 3);
		}
		else if ((0 == strcmp("multiply", argv[1])) && (3 < argc))
		{
			// multiply <filespec> <filespec> [<filespec>]
			args->exec = &multiply;
			args->filespec_1st = argv[2];
			args->filespec_2nd = argv[3];
			return parse_argument_output(args, argc, argv, 4);
		}
		else if ((0 == strcmp("subtract", argv[1])) && (3 < argc))
		{
			// subtract <filespec> <filespec> [<filespec>]
			args->exec = &subtract;
			args->filespec_1st = argv[2];
			args->filespec_2nd = argv[3];
			return parse_argument_output(args, argc, argv, 4);
		}
      else if (0 == strcmp("test", argv[1]))
      {
         // test [n]
         int n = (NULL == argv[2]) ? 0 : atoi(argv[2]);

         if ((1 > n) || (n > sizeof(test_functions) / sizeof(test_functions[0])))
         {
            const char **ptr = test_functionInfos;

            while (NULL != *ptr)
            {
               printf("> %s\n", *ptr);
               ptr++;
            }
         }
         else
         {
            test_functions[n-1](0, NULL);
         }

         return true;
       }
		else if ((0 == strcmp("transpose", argv[1])) && (2 < argc))
		{
			// transpose <filespec> [<filespec>]
			args->exec = &transpose;
			args->filespec_1st = argv[2];
			return parse_argument_output(args, argc, argv, 3);
		}
	}

	return false;
}

int add(const arguments *args)
{
	int status = 0;

	// Validate input parameters.
	if (NULL == args)
	{
		// ERROR: Invalid parameter(s).
		return 1;
	}

	// Add two matrices.
	if (0 == status)
	{
		// TODO: Implement.
	}
	
	return status;
}

int E(const arguments *args)
{
	int status = 0;

	// Validate input parameters.
	if ((NULL == args) || (NULL == args->filespec_1st))
	{
		// Invalid parameter(s).
		return 1;
	}

	// Write introduction to console.
	printf("> E \"%s\" \"%s\"\n", args->filespec_1st, args->filespec_out);

	// Create identity matrix.
	if (0 == status)
	{
		matrix A = {/*caption*/NULL, /*m*/0, /*n*/0, /*elementsPtr*/NULL};
		matrix result = {/*caption*/NULL, /*m*/0, /*n*/0, /*elementsPtr*/NULL};

		if (matrix_read(&A, args->filespec_1st))
		{
			matrix_fprint(&A, stdout);
			
			if (matrix_identity_matrix(&A, &result))
			{
				// Write to console.
				matrix_fprint(&result, stdout);
				// write to output file.
				if (NULL != args->filespec_out)
				{
					FILE * output = NULL;

					output = fopen(args->filespec_out, "wt");
					if (NULL != output)
					{
						matrix_fprint(&result, output);
						fclose(output);
					}
					else
					{
						// ERROR: Failed to write output.
						status = 4;
					}
				}

				matrix_free(&result);
			}
			else
			{
				// ERROR: matrix_get_identity_matrix(...) failed.
				status = 3;
			}

			matrix_free(&A);
		}
		else
		{
			// ERROR: Failed to load args->filespec_1st.
			status = 2;
		}
	}

	printf("> E %s.\n", (status) ? "failed" : "succeeded");
	return status;
}

int gea(const arguments *args)
{
	int status = 0;

	// Validate input parameters.
	if ((NULL == args) || (NULL == args->filespec_1st))
	{
		// Invalid parameter(s).
		return 1;
	}

	// Write introduction to console.
	printf("> gea \"%s\" \"%s\"\n", args->filespec_1st, args->filespec_out);

	// Gauss' elimination algorithmn.
	if (0 == status)
	{
		matrix A = MATRIX_EMPTY;
		matrix result = MATRIX_EMPTY;

		if (matrix_read(&A, args->filespec_1st))
		{
			matrix_fprint(&A, stdout);
			
			if (matrix_gea_matrix(&A, &result))
			{
				// Write to console.
				matrix_fprint(&result, stdout);
				// write to output file.
				if (NULL != args->filespec_out)
				{
					FILE * output = NULL;

					output = fopen(args->filespec_out, "wt");
					if (NULL != output)
					{
						matrix_fprint(&result, output);
						fclose(output);
					}
					else
					{
						// ERROR: Failed to write output.
						status = 4;
					}
				}

				matrix_free(&result);
			}
			else
			{
				// ERROR: matrix_gea_matrix(...) failed.
				status = 3;
			}

			matrix_free(&A);
		}
		else
		{
			// ERROR: Failed to load args->filespec_1st.
			status = 2;
		}
	}

	printf("> gea %s.\n", (status) ? "failed" : "succeeded");
	return status;
}

int gjea(const arguments *args)
{
	int status = 0;

	// Validate input parameters.
	if ((NULL == args) || (NULL == args->filespec_1st))
	{
		// Invalid parameter(s).
		return 1;
	}

	// Write introduction to console.
	printf("> gjea \"%s\" \"%s\"\n", args->filespec_1st, args->filespec_out);

	// Gauss-Jordan Elimination algorithmn.
	if (0 == status)
	{
		matrix A = MATRIX_EMPTY;
		matrix result = MATRIX_EMPTY;

		if (matrix_read(&A, args->filespec_1st))
		{
			matrix_fprint(&A, stdout);
			
			if (matrix_transform_gjea(&A, &result))
			{
				// Write to console.
				matrix_fprint(&result, stdout);
				// write to output file.
				if (NULL != args->filespec_out)
				{
					FILE * output = NULL;

					output = fopen(args->filespec_out, "wt");
					if (NULL != output)
					{
						matrix_fprint(&result, output);
						fclose(output);
					}
					else
					{
						// ERROR: Failed to write output.
						status = 4;
					}
				}

				matrix_free(&result);
			}
			else
			{
				// ERROR: matrix_transform_gjea(...) failed.
				status = 3;
			}

			matrix_free(&A);
		}
		else
		{
			// ERROR: Failed to load args->filespec_1st.
			status = 2;
		}
	}

	printf("> gjea %s.\n", (status) ? "failed" : "succeeded");
	return status;
}

int invert(const arguments *args)
{
	int status = 0;

	// Validate input parameters.
	if ((NULL == args) || (NULL == args->filespec_1st))
	{
		// Invalid parameter(s).
		return 1;
	}

	// Write introduction to console.
	printf("> invert \"%s\" \"%s\"\n", args->filespec_1st, args->filespec_out);

	// Invert matrix.
	if (0 == status)
	{
		matrix A = MATRIX_EMPTY;
		matrix result = MATRIX_EMPTY;

		if (matrix_read(&A, args->filespec_1st))
		{
			matrix_fprint(&A, stdout);
			
			if (matrix_transform_invert(&A, &result))
			{
				// Write to console.
				matrix_fprint(&result, stdout);
				// write to output file.
				if (NULL != args->filespec_out)
				{
					FILE * output = NULL;

					output = fopen(args->filespec_out, "wt");
					if (NULL != output)
					{
						matrix_fprint(&result, output);
						fclose(output);
					}
					else
					{
						// ERROR: Failed to write output.
						status = 4;
					}
				}

				matrix_free(&result);
			}
			else
			{
				// ERROR: matrix_transform_invert(...) failed.
				status = 3;
			}

			matrix_free(&A);
		}
		else
		{
			// ERROR: Failed to load args->filespec_1st.
			status = 2;
		}
	}

	printf("> invert %s.\n", (status) ? "failed" : "succeeded");
	return status;
}

int multiply(const arguments *args)
{
	int status = 0;

	// Validate input parameters.
	if ((NULL == args) || (NULL == args->filespec_1st) || (NULL == args->filespec_2nd))
	{
		// ERROR: Invalid parameter(s).
		return 1;
	}

	printf("> multiply \"%s\" \"%s\" \"%s\"\n", args->filespec_1st, args->filespec_2nd, args->filespec_out);
	// Multiply two matrices.
	{
		matrix A = {/*caption*/NULL, /*m*/0, /*n*/0, /*elementsPtr*/NULL};
		matrix B = {/*caption*/NULL, /*m*/0, /*n*/0, /*elementsPtr*/NULL};
		matrix result = {/*caption*/NULL, /*m*/0, /*n*/0, /*elementsPtr*/NULL};

		if (matrix_read(&A, args->filespec_1st))
		{
			matrix_fprint(&A, stdout);
			if (matrix_read(&B, args->filespec_2nd))
			{
				matrix_fprint(&B, stdout);
				if (matrix_math_multiply(&A, &B, &result))
				{
					// Write to console.
					matrix_fprint(&result, stdout);
					// write to output file.
					if (NULL != args->filespec_out)
					{
						FILE * output = NULL;

						output = fopen(args->filespec_out, "wt");
						if (NULL != output)
						{
							matrix_fprint(&result, output);
							fclose(output);
						}
						else
						{
							// ERROR: Failed to write output.
							status = 5;
						}
					}

					matrix_free(&result);
				}
				else
				{
					// ERROR: Multiplication failed.
					status = 4;
				}

				matrix_free(&B);
			}
			else
			{
				// ERROR: Failed to load args->filespec_2nd.
				status = 3;
			}

			matrix_free(&A);
		}
		else
		{
			// ERROR: Failed to load args->filespec_1st.
			status = 2;
		}
	}

	printf("> multiply %s.\n", (status) ? "failed" : "succeeded");
	return status;
}

int subtract(const arguments *args)
{
	int status = 0;

	// Validate input parameters.
	if (NULL == args)
	{
		// ERROR: Invalid parameter(s).
		return 1;
	}

	printf("> subtract \"%s\" \"%s\" \"%s\"\n", args->filespec_1st, args->filespec_2nd, args->filespec_out);
	// Subtract two matrices.
	{
		matrix A = MATRIX_EMPTY;
		matrix B = MATRIX_EMPTY;
		matrix result = MATRIX_EMPTY;

		if (matrix_read(&A, args->filespec_1st))
		{
			matrix_fprint(&A, stdout);
			if (matrix_read(&B, args->filespec_2nd))
			{
				matrix_fprint(&B, stdout);
				if (matrix_math_subtract(&A, &B, &result))
				{
					// Write to console.
					matrix_fprint(&result, stdout);
					// write to output file.
					if (NULL != args->filespec_out)
					{
						FILE * output = NULL;

						output = fopen(args->filespec_out, "wt");
						if (NULL != output)
						{
							matrix_fprint(&result, output);
							fclose(output);
						}
						else
						{
							// ERROR: Failed to write output.
							status = 5;
						}
					}

					matrix_free(&result);
				}
				else
				{
					// ERROR: Subtraction failed.
					status = 4;
				}

				matrix_free(&B);
			}
			else
			{
				// ERROR: Failed to load args->filespec_2nd.
				status = 3;
			}

			matrix_free(&A);
		}
		else
		{
			// ERROR: Failed to load args->filespec_1st.
			status = 2;
		}
	}

	printf("> subtract %s.\n", (status) ? "failed" : "succeeded");
	return status;
}

int transpose(const arguments *args)
{
	int status = 0;

	// Validate input parameters.
	if (NULL == args)
	{
		// ERROR: Invalid parameter(s).
		status = 1;
	}

	// Perform action.
	if ((0 == status) && (NULL != args->filespec_1st))
	{
		FILE *input = NULL;

		printf("> transpose \"%s\" \"%s\"\n", args->filespec_1st, args->filespec_out);

		// Initialize status to error.
		// ERROR: Something went wrong.
		status = 2;

		input = fopen(args->filespec_1st, "rt");
		if (NULL != input)
		{
			matrix x = {NULL, 0, 0, NULL};
			if (matrix_fread(&x, input))
			{
				matrix xT = {NULL, 0, 0, NULL};

				matrix_fprint(&x, stdout);
				if (matrix_math_transpose(&x, &xT))
				{
					// Print to console.
					matrix_fprint(&xT, stdout);

					// Print to output.
					if (status = (NULL == args->filespec_out) ? 0 : status)
					{
						FILE *out = NULL;

						out = fopen(args->filespec_out, "wt");
						if (NULL != out)
						{
							matrix_fprint(&xT, out);
							fclose(out);
						}

						// Set status to signal success.
						status = 0;
					}

					// Free allocated resources.
					matrix_free(&xT);
				}

				matrix_free(&x);			
			}
		
			fclose(input);
		}
	}
 
	printf("> transpose %s.\n", (status) ? "failed" : "succeeded");
	return status;
}
