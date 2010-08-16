#include <stdio.h>

#include "matrix.h"

// Test functions.
//
int test_1(int argc, char *argv[])
{
   matrix A = MATRIX_EMPTY;

	// Test case description.
	printf("test_1(...)\n");
	printf("> Allocate 4 x 4-matrix.\n");
	printf("> Set row 3 from array.\n");

	if (matrix_alloc(&A, "", 4, 4))
	{
      matrix_element elements[] = {3.1F, 3.2F, 3.3F, 3.4F};

		// Populate matrix.
		matrix_set_row(&A, 3, elements);

		// Print matrix to console.
		matrix_fprint(&A, stdout);

		// Release matrix.
		matrix_free(&A);
	}

	return 1;
}

int test_2(int argc, char *argv[])
{
   matrix_element elements[] = {1.1F, 2.1F};
	FILE *file = NULL;
   matrix x = {"Produktionsplan", 2, 1, elements};

	// Test case description.
	printf("test_2(...)\n");
   printf("> Save a given matrix to file.\n");

	matrix_fprint(&x, stdout);
	
	// Open file.
	file = fopen("./x.matrix", "wt");
	if (NULL != file)
	{
		matrix_fprint(&x, file);
		fclose(file);
	}

	return 1;
}

int test_3(int argc, char *argv[])
{
	FILE *file = NULL;
	matrix x = {NULL, 0, 0, NULL};

	// Test case description.
	printf("test_3(...)\n");
   printf("> Load a given matrix from file.\n");

	file = fopen("./x.matrix", "rt");
	if (NULL != file)
	{
		matrix_fread(&x, file);
		fclose(file);

		matrix_fprint(&x, stdout);
		matrix_free(&x);
	}

	return 1;
}

int test_4(int argc, char *argv[])
{
	matrix A = MATRIX_EMPTY;

   // Test case description.
	printf("test_4(...)\n");
	printf("> Allocate 4 x 4-matrix.\n");
	printf("> Set column 3 from array.\n");

	if (matrix_alloc(&A, "", 4, 4))
	{
      matrix_element elements[] = {3.1F, 3.2F, 3.3F, 3.4F};
		matrix_set_col(&A, 3, elements);
		matrix_fprint(&A, stdout);

		matrix_free(&A);
	}

	return 1;
}

int test_5(int argc, char *argv[])
{
	matrix A = MATRIX_EMPTY;
	
   // Test case description.
	printf("test_5(...)\n");
	printf("> Allocate and populate 4 x 4-matrix.\n");
	printf("> Get column 3 into an array.\n");

	if (matrix_alloc(&A, "", 4, 4))
	{
      matrix_element elements[4][4] = {{1.1F, 1.2F, 1.3F, 1.4F}, {2.1F, 2.2F, 2.3F, 2.4F}, {3.1F, 3.2F, 3.3F, 3.4F}, {4.1F, 4.2F, 4.3F, 4.4F}};
		matrix_element values[] = {0.0F, 0.0F, 0.0F, 0.0F};
		size_t i = 0;

		// Fill matrix.
		matrix_set_row(&A, 1, elements[0]);
		matrix_set_row(&A, 2, elements[1]);
		matrix_set_row(&A, 3, elements[2]);
		matrix_set_row(&A, 4, elements[3]);

		matrix_fprint(&A, stdout);

		// TEST: Retrieve row 3.
		if (matrix_get_row(&A, 3, values))
		{
			printf("Zeile 3:\n");
			for (i = 0; i < A.m; i++)
			{
				printf(matrix_element_output, values[i]);
			}
		}
		else
		{
			printf("> FAILED!");
		}

		// Final line break.
		printf("\n");

		matrix_free(&A);
	}

	return 1;
}

int test_6(int argc, char *argv[])
{
	matrix A = MATRIX_EMPTY;
	matrix AT = MATRIX_EMPTY;

   // Test case description.
	printf("test_6(...)\n");
	printf("> Transpose a given matrix.\n");

	if (matrix_alloc(&A, "Input matrix", 3, 2))
	{
      matrix_element elements[] = {1.1F, 2.1F, 3.1F, 1.2F, 2.2F, 3.2F};

		// Populate matrix.
      matrix_set_all(&A, elements);

		matrix_fprint(&A, stdout);
		printf("\n");

		if (matrix_math_transpose(&A, &AT))
		{			
			matrix_fprint(&AT, stdout);
			matrix_free(&AT);
		}
		else
		{
			printf("> matrix_transpose(...) failed.\n");
		}

		matrix_free(&A);
	}
	else
	{
		printf("> matrix_alloc(...) failed.\n");
	}

	return 1;
}

int test_7(int argc, char *argv[])
{
	matrix A = MATRIX_EMPTY;
	matrix E = MATRIX_EMPTY;

   // Test case description.
	printf("test_7()\n");
	printf("> Create identiy matrix for a given matrix.\n");

	if (matrix_alloc(&A, "Input matrix", 3, 2))
	{
      matrix_element elements[] =
      {
         1.1F, 1.2F,
         2.1F, 2.2F,
         3.1F, 3.2F
      };

		// Populate matrix.
      matrix_set_all(&A, elements);

		matrix_fprint(&A, stdout);
		printf("\n");

		if (matrix_identity_matrix(&A, &E))
		{			
			matrix_fprint(&E, stdout);
			matrix_free(&E);
		}
		else
		{
			printf("> matrix_identity_matrix(...) failed.\n");
		}

		matrix_free(&A);
	}
	else
	{
		printf("> matrix_alloc(...) failed.\n");
	}

	return 1;
}

int test_8(int argc, char *argv[])
{
	matrix A = MATRIX_EMPTY;
	matrix E = MATRIX_EMPTY;

	// Test case description.
	printf("test_8()\n");
	printf("> Subtract a given matrix from identity matrix.\n");

	if (matrix_alloc(&A, "Input matrix", 3, 3))
	{
      matrix_element elements[] =
      {
         1.1F, 1.2F, 1.3F,
         2.1F, 2.2F, 2.3F,
         3.1F, 3.2F, 3.3F
      };

		// Populate matrix.
      matrix_set_all(&A, elements);

		if (matrix_identity_matrix(&A, &E))
		{
			matrix result = MATRIX_EMPTY;
		
			matrix_fprint(&E, stdout);
			matrix_fprint(&A, stdout);
			if (matrix_math_subtract(&E, &A, &result))
			{
				matrix_fprint(&result, stdout);
				matrix_free(&result);
			}
			else
			{
				printf("> matrix_math_subtract(...) failed.\n");
			}

			matrix_free(&E);
		}
		else
		{
			printf("> matrix_identity_matrix(...) failed.\n");
		}

		matrix_free(&A);
	}
	else
	{
		printf("> matrix_alloc(...) failed.\n");
	}

	return 1;
}

int test_9(int argc, char *argv[])
{
   matrix A = MATRIX_EMPTY;

	// Test case description.
	printf("test_9(...)\n");
	printf("> Allocate 3 x 4-matrix.\n");
	printf("> Run it through Gauss' elemination algorithm.\n");

	if (matrix_alloc(&A, "Sample matrix", 3, 4))
	{
		matrix result = MATRIX_EMPTY;
      matrix_element elements[] =
		{
			1.0F, -2.0F, 3.0F, 7.0F,
			-1.0F, -3.0F, 1.0F, -2.0F,
			2.0, 4.0, -1.0, 3.0F
		};

		// Populate matrix.
		matrix_set_all(&A, elements);

		// Print matrix to console.
		matrix_fprint(&A, stdout);

		// Run it through GEA.
		if (matrix_gea_matrix(&A, &result))
		{
			matrix_fprint(&result, stdout);
			matrix_free(&result);
		}
		else
		{
			printf("> matrix_gea_matrix(...) failed.\n");
		}

		matrix_free(&A);
	}
	else
	{
		printf("> matrix_alloc(...) failed.\n");
	}

	return 1;
}

int test_10(int argc, char *argv[])
{
matrix A = MATRIX_EMPTY;

	// Test case description.
	printf("test_10(...)\n");
	printf("> Allocate and invert a 3 x 3-matrix.\n");

	if (matrix_alloc(&A, "Sample matrix", 3, 3))
	{
		matrix result = MATRIX_EMPTY;
      matrix_element elements[] =
		{
			 3.0F,	 0.0F,	-6.0F,
			 0.0F,	 0.0F,	 1.0F,
			 3.0F,	 1.0F,	-1.0F
		};

		// Populate matrix.
		matrix_set_all(&A, elements);

		// Print matrix to console.
		matrix_fprint(&A, stdout);

		// Invert matrix.
		if (matrix_transform_invert(&A, &result))
		{
			matrix_fprint(&result, stdout);
			matrix_free(&result);
		}
		else
		{
			printf("> matrix_transform_invert(...) failed.\n");
		}

		matrix_free(&A);
	}
	else
	{
		printf("> matrix_alloc(...) failed.\n");
	}

	return 1;
}

int test_11(int argc, char *argv[])
{
	matrix A = MATRIX_EMPTY;

	// Test case description.
	printf("test_11(...)\n");
	printf("> Allocate and swap second and third column of a 4 x 4-matrix.\n");

	if (matrix_alloc(&A, "Sample matrix", 4, 4))
	{
      matrix_element elements[] =
		{
			 1.1F,	 1.2F,	 1.3F,	 1.4F,
			 2.1F,	 2.2F,	 2.3F,	 2.4F,
			 3.1F,	 3.2F,	 3.3F,	 3.4F,
			 4.1F,	 4.2F,	 4.3F,	 4.4F
		};

		// Populate matrix.
		matrix_set_all(&A, elements);

		// Print matrix to console.
		matrix_fprint(&A, stdout);

		// Swap second and third row.
		if (matrix_swap_cols(&A, 2, 3))
		{
			matrix_fprint(&A, stdout);
		}
		else
		{
			printf("> matrix_swap_cols(...) failed.\n");
		}

		matrix_free(&A);
	}
	else
	{
		printf("> matrix_alloc(...) failed.\n");
	}

	return 1;
}

int test_12(int argc, char *argv[])
{
	matrix A = MATRIX_EMPTY;

	// Test case description.
	printf("test_12(...)\n");
	printf("> Allocate and swap second and third row of a 4 x 4-matrix.\n");

	if (matrix_alloc(&A, "Sample matrix", 4, 4))
	{
      matrix_element elements[] =
		{
			 1.1F,	 1.2F,	 1.3F,	 1.4F,
			 2.1F,	 2.2F,	 2.3F,	 2.4F,
			 3.1F,	 3.2F,	 3.3F,	 3.4F,
			 4.1F,	 4.2F,	 4.3F,	 4.4F
		};

		// Populate matrix.
		matrix_set_all(&A, elements);

		// Print matrix to console.
		matrix_fprint(&A, stdout);

		// Swap second and third row.
		if (matrix_swap_rows(&A, 2, 3))
		{
			matrix_fprint(&A, stdout);
		}
		else
		{
			printf("> matrix_swap_rows(...) failed.\n");
		}

		matrix_free(&A);
	}
	else
	{
		printf("> matrix_alloc(...) failed.\n");
	}

	return 1;
}

int test_13(int argc, char *argv[])
{
	matrix A = MATRIX_EMPTY;

	// Test case description.
	printf("test_13(...)\n");
	printf("> Cut columns two to three out off a 4 x 4-matrix.\n");

	if (matrix_alloc(&A, "Sample matrix", 4, 4))
	{
		matrix result = MATRIX_EMPTY;
      matrix_element elements[] =
		{
			 1.1F,	 1.2F,	 1.3F,	 1.4F,
			 2.1F,	 2.2F,	 2.3F,	 2.4F,
			 3.1F,	 3.2F,	 3.3F,	 3.4F,
			 4.1F,	 4.2F,	 4.3F,	 4.4F
		};

		// Populate matrix.
		matrix_set_all(&A, elements);

		// Print matrix to console.
		matrix_fprint(&A, stdout);

		// Swap second and third row.
		if (matrix_transform_hcut(&A, &result, 2, 3))
		{
			matrix_fprint(&result, stdout);
			matrix_free(&result);
		}
		else
		{
			printf("> matrix_swap_rows(...) failed.\n");
		}

		matrix_free(&A);
	}
	else
	{
		printf("> matrix_alloc(...) failed.\n");
	}

	return 1;
}
