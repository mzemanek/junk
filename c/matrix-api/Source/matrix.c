#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "matrix.h"

// Matrix Application Programming Interface (API) - Helper functions (not in matrix.h)
//
matrix_element scalar_product(matrix_element row[], matrix_element col[], size_t length)
{
	size_t i = 0;
	matrix_element result = matrix_element_zero;

	for (i = 0; i < length; i++)
	{
		result += row[i] * col[i];
	}

	return result;
}

// Matrix Application Programming Interface (API) - Implementation

matrix_status matrix_alloc(matrixPtr instance, const char *caption, size_t m, size_t n)
{
	// Validate input parameters.
	if ((NULL == instance) || (NULL == caption) || (0 == m) || (0 == n))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Initialize instance.
	instance->m = m;
	instance->n = n;
	instance->caption = strdup(caption);
	if (NULL == instance->caption)
	{
		// ERROR: strdup() failed.
		return matrix_status_failed;
	}

	// Initialize elements.
	instance->elementsPtr = (matrix_element*)calloc(m * n, sizeof(matrix_element));
	if (NULL == instance->elementsPtr)
	{
		// ERROR: calloc() failed.
		matrix_free(instance);

		return matrix_status_failed;
	}
	
	return matrix_status_succeeded;
}

matrix_status matrix_clone(matrixPtr instance, const char *caption, matrixPtr source)
{
	// Validate input parameters.
	if ((NULL == instance) || (NULL == caption) || (NULL == source))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	if (matrix_alloc(instance, caption, source->m, source->n))
	{
		size_t count = source->m * source->n;
		size_t i = 0;

		// Clone elements.
		for (i = 0; i < count; i++)
		{
			*(instance->elementsPtr + i) = *(source->elementsPtr + i);
		}

		return matrix_status_succeeded;
	}

	return matrix_status_failed;
}

matrix_status matrix_free(matrixPtr instance)
{
	// Validate input parameters.
	if (NULL == instance)
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Free any dynamically allocated resources.
	free(instance->caption);
	free(instance->elementsPtr);

	// Reinitialize instance.
	instance->caption = NULL;
	instance->elementsPtr = NULL;
	instance->m = 0;
	instance->n = 0;

	return matrix_status_succeeded;
}

matrix_status matrix_fprint(matrixPtr instance, FILE* file)
{
	size_t count = 0;
	int i = 0;

	// Validate input variables.
	if ((NULL == instance) || (NULL == instance->elementsPtr) || (NULL == file))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Print header.
	fprintf(file, "%s\n", instance->caption);
	fprintf(file, "%d x %d", instance->m, instance->n);

	// Print elements.
	count = instance->m * instance->n;
	for (i = 0; i < count; i++)
	{
		if (0 == i % instance->n)
		{
			fprintf(file, "\n");
		}

		fprintf(file, matrix_element_output, *(instance->elementsPtr + i));
	}

	fprintf(file, "\n");

	return matrix_status_succeeded;
}

matrix_status matrix_fread(matrixPtr instance, FILE *file)
{
	char buffer[BUFSIZ] = {0};
	char caption[BUFSIZ] = {0};
	int elements = 0;
	int i = 0;
	size_t m = 0;
	size_t n = 0;

	// Validate input parameters.
	if ((NULL == instance) || (NULL == file))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Read caption and strip \n.
	fgets(caption, BUFSIZ, file);
	for (i = 0; i < BUFSIZ; i++)
	{
		if ('\n' == caption[i])
		{
			caption[i] = '\0';
			break;
		}
	}
	
	// Read and parse dimensions.
	fgets(buffer, BUFSIZ, file);
	if (2 != sscanf(buffer, "%d x %d", &m, &n))
	{
		// ERROR: Invalid file format.
		return matrix_status_failed;
	}

	// Allocate matrix.
	if (!matrix_alloc(instance, caption, m, n))
	{
		// ERROR: matrix_alloc() failed.
		return matrix_status_failed;
	}

	// Read elements.
	elements = instance->m * instance->n;
	for (i = 0; i < elements; i++)
	{
		fscanf(file, matrix_element_input, instance->elementsPtr + i);
	}

	return matrix_status_succeeded;
}

matrix_status matrix_read(matrixPtr instance, const char* filename)
{
	FILE* file = NULL;
	matrix_status status = matrix_status_failed;

	// Validate input parameters.
	if ((NULL == instance) || (NULL == filename))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	file = fopen(filename, "rt");
	if (NULL != file)
	{
		status = matrix_fread(instance, file);
		fclose(file);
	}

	return status; 
}

matrix_status matrix_get(matrixPtr instance, size_t row, size_t col, matrix_element *valuePtr)
{
	// Validate input parameters.
	if ((NULL == instance) || (0 == row) || (0 == col) || (instance->m < row) || (instance->n < col))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	*valuePtr = *(instance->elementsPtr + (row - 1) * instance->n + (col - 1));
	
	return matrix_status_succeeded;
}

matrix_status matrix_get_col(matrixPtr instance, size_t col, matrix_element values[])
{
	matrix_element *elementPtr = NULL;
	int i = 0;

	// Validate input parameters.
	if ((NULL == instance) || (0 == col) || (instance->n < col))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Get a pointer to initial element.
	elementPtr = instance->elementsPtr + (col - 1);

	// Assign values.
	for (i = 0; i < instance->m; i++)
	{
		// Assign value.
		values[i] = *elementPtr;

		// Move to next row.
		elementPtr += instance->n;
	}

	return matrix_status_succeeded;
}

matrix_status matrix_get_row(matrixPtr instance, size_t row, matrix_element values[])
{
	matrix_element *elementPtr = NULL;
	int i = 0;

	// Validate input parameters.
	if ((NULL == instance) || (0 == row) || (instance->m < row))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Get a pointer to initial element.
	elementPtr = instance->elementsPtr + (row - 1) * instance->n;

	// Assign values.
	for (i = 0; i < instance->n; i++)
	{
		// Assign value.
		values[i] = *elementPtr;

		// Move to next column.
		elementPtr++;
	}

	return matrix_status_succeeded;
}

matrix_status matrix_set(matrixPtr instance, size_t row, size_t col, matrix_element value)
{
	// Validate input parameters.
	if ((NULL == instance) || (0 == row) || (0 == col) || (instance->m < row) || (instance->n < col))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Assign value.
	*(instance->elementsPtr + (row - 1) * instance->n + (col - 1)) = value;
 
	return matrix_status_succeeded;
}

matrix_status matrix_set_all(matrixPtr instance, matrix_element *values)
{
   size_t count = 0;
   size_t i = 0;

   // Validate input parameters.
   if ((NULL == instance) || (NULL == values))
   {
      // ERROR: Invalid parameter(s).
      return matrix_status_failed;
   }

   // Assign values.
   count = instance->m * instance->n;
   for (i = 0; i < count; i++)
   {
      *(instance->elementsPtr + i) = *(values + i);
   }

   return matrix_status_succeeded;
}

matrix_status matrix_set_col(matrixPtr instance, size_t col, matrix_element values[])
{
	int i = 0;
	matrix_element *element = NULL;

	// Validate input parameters.
	if ((NULL == instance) || (0 == col) || (instance->n < col))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Get a pointer to first column element.
	element = instance->elementsPtr + (col - 1);
	
	// Assign values.
	for (i = 0; i < instance->m; i++)
	{
		*element = values[i];
		element += instance->n;
	}

	return matrix_status_succeeded;
}

matrix_status matrix_set_row(matrixPtr instance, size_t row, matrix_element values[])
{
	size_t count = 0;
	int i = 0;
	matrix_element *element = NULL;

	// Validate input parameter(s).
	if ((NULL == instance) || (0 == row) || (row > instance->m) || (NULL == values))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Get a pointer to first element of the wanted row.
	element = instance->elementsPtr + ((row - 1) * instance->n);

	// Set values.
	for (i = 0; i < instance->n; element++, i++)
	{
		*element = values[i];
	}
		
	return matrix_status_succeeded;
}

// Matrix math.
//
matrix_status matrix_math_multiply(matrixPtr instanceA, matrixPtr instanceB, matrixPtr result)
{
	char caption[BUFSIZ] = {'\0'};

	// Validate input parameters.
	if ((NULL == instanceA) || (NULL == instanceB) || (NULL == result))
	{
		// ERROR: Invalid input parameter(s).
		return matrix_status_failed;
	}

	// Make sure that multiplication is even possible.
	if (instanceA->n != instanceB->m)
	{
		// ERROR: Invalid arguments.
		printf("! API: %d x %d * %d x %d is not possible.\n", instanceA->m, instanceA->n, instanceB->m, instanceB->n);
		return matrix_status_failed;
	}

	// Construct caption for result.
	strncpy(caption, instanceA->caption, BUFSIZ);
	strncat(caption, " * ", BUFSIZ);
	strncat(caption, instanceB->caption, BUFSIZ);

	// Allocate A->m x B->n matrix.
	if (!matrix_alloc(result, caption, instanceA->m, instanceB->n))
	{
		// ERROR: matrix_alloc(...) failed.
		return matrix_status_failed;
	}

	// Use Falk scheme to calculate values.
	// Matrix rows and cols are 1-based!
	{
		size_t i = 0;
		size_t j = 0;
		matrix_element *row = NULL;
		matrix_element *col = NULL;
		matrix_status status = matrix_status_succeeded;

      // Allocate memory.
      row = (matrix_element*)calloc(instanceA->n, sizeof(matrix_element));
      if (NULL != row)
      {
         // Allocate memory.
         col = (matrix_element*)calloc(instanceB->m, sizeof(matrix_element));
         if (NULL != col)
         {
            // Perform calculations.
		      for (i = 1; (matrix_status_succeeded == status) && (i <= result->m); i++)
		      {
			      status = matrix_get_row(instanceA, i, row);
			      for (j = 1; (matrix_status_succeeded == status) && (j <= result->n); j++)
			      {
				      status = matrix_get_col(instanceB, j, col);
				      if (status)
				      {
					      status = matrix_set(result, i, j, scalar_product(row, col, instanceA->n));
				      }
			      }
            }

            // Deallocate memory.
            free(col);
         }
         else
         {
            // ERROR: calloc(...) failed.
            status = matrix_status_failed;
         }

         // Deallocate memory.
         free(row);
      }
      else
      {
         // ERROR: calloc(...) failed.
         status = matrix_status_failed;
      }

		return status;
	}

	// This one is obsolete.
	//return matrix_status_succeeded;
}

matrix_status matrix_math_transpose(matrixPtr instance, matrixPtr result)
{
	char caption[BUFSIZ] = {'\0'};

	// Validate input parameters.
	if ((NULL == instance) || (NULL == result))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Extend instance caption by " (transposed)".
	{
		strncpy(caption, instance->caption, BUFSIZ);
		strncat(caption, " (transposed)", BUFSIZ);
	}

	// Allocate n x m matrix.
	if (!matrix_alloc(result, caption, instance->n, instance->m))
	{
		// ERROR: matrix_alloc(...) failed.
		return matrix_status_failed;
	}

	// Copy each element.
	{
		int i, j;

		for (i = 0; i < instance->m; i++)
		{
			for (j = 0; j < instance->n; j++)
			{
				*(result->elementsPtr + (j * result->n) + i) = *(instance->elementsPtr + (i * instance->n) + j);
			}
		}
	}

	return matrix_status_succeeded;
}

matrix_status matrix_gea_matrix(matrixPtr instance, matrixPtr result)
{
	char caption[BUFSIZ] = {'\0'};

	// Validate input parameters.
	if ((NULL == instance) || (NULL == result))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Construct new caption.
	strncpy(caption, instance->caption, BUFSIZ);
	strncat(caption, " (GEA'ed)", BUFSIZ);

	// Clone instance result.
	if (!matrix_clone(result, caption, instance))
	{
		// ERROR: matrix_alloc(...) failed.
		return matrix_status_failed;
	}

	// GEA implementation
	{
		size_t mark_col = 0;
		size_t mark_row = 0;
		matrix_element *markPtr = NULL;

		// Move diagonal over the matrix.
		printf("> 1st Sequence\n");
		for (mark_row = 0, mark_col = 0; (mark_row < result->m) && (mark_col < result->n - 1); mark_row++, mark_col++)
		{
			// Move marker to element.
			markPtr = result->elementsPtr + (mark_row * result->n) + mark_col;
			
			// mark is unbound in case its 0.
			if (matrix_element_zero == *markPtr)
			{
				printf("> Row %d: Unbound variable x%d!\n", mark_row + 1, mark_col + 1);

				// Reset row mark to continue on next column of same row.
				mark_row--;
				continue;
			}

			// Set mark to 1 and recalculate other row values.
			// Skip row in case mark is already 1.
			if (matrix_element_one != *markPtr)
			{
				size_t col = 0;
				matrix_element value = *markPtr;

				printf("> Row %d / " MATRIX_ELEMENT_FORMAT "\n", mark_row + 1, value);
				for (col = 0; mark_col + col < result->n; col++)
				{
					*(markPtr + col) = *(markPtr + col) / value;
				}
			}
			else
			{
				printf("> Row %d: Unchanged.\n", mark_row + 1);
			}

			// Set columns underneath to 0.
			{
				size_t col = 0;
				size_t row = 0;
				matrix_element value = matrix_element_zero;

				for (row = 1; mark_row + row < result->m; row++)
				{
					// Retrieve row modificator.
					value = *(markPtr + row * result->n);
					printf("> Row %d - Row %d * (" MATRIX_ELEMENT_FORMAT ")\n", mark_row + row + 1, mark_row + 1, value);

					// Recalculate other row values.
					for (col = 0; mark_col + col < result->n; col++)
					{
						*(markPtr + (row * result->n) + col) = *(markPtr + (row * result->n) + col) - *(markPtr + col) * value;
					}
				}	
			}

			matrix_fprint(result, stdout);
		}

		// Move diagonal over the matrix.
		printf("> 2nd Sequence\n");
		for (mark_row = result->m - 1, mark_col = result->n - 2; mark_row > 0; mark_row--, mark_col--)
		{
			// Move marker to element.
			markPtr = result->elementsPtr + (mark_row * result->n) + mark_col;
			
			// Set columns above to 0.
			{
				size_t col = 0;
				size_t row = 0;
				matrix_element value = matrix_element_zero;

				for (row = 1; (int)mark_row - (int)row >= 0; row++)
				{
					value = *(markPtr - row * result->n);
					printf("> Row %d - Row %d * (" MATRIX_ELEMENT_FORMAT ")\n", mark_row - row + 1, mark_row + 1, value);

					// Recalculate other row values.
					for (col = 0; mark_col + col < result->n; col++)
					{
						*(markPtr - (row * result->n) + col) = *(markPtr - (row * result->n) + col) - *(markPtr + col) * value;
					}
				}	
			}

			matrix_fprint(result, stdout);
		}
	}
	
	return matrix_status_succeeded;
}

matrix_status matrix_identity_matrix(matrixPtr instance, matrixPtr E)
{
	size_t size = 0;
	size_t i = 0;
	size_t j = 0;
	char caption[BUFSIZ] = {'\0'};

	// Validate input parameters.
	if ((NULL == instance) || (NULL == E))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Construct new caption.
	strncpy(caption, "E (", BUFSIZ);
	strncat(caption, instance->caption, BUFSIZ);
	strncat(caption, ")", BUFSIZ);

	// Determine size of E.
	size = (instance->m > instance->n) ? instance->m : instance->n;

	// Allocate E.
	if (!matrix_alloc(E, caption, size, size))
	{
		// ERROR: matrix_alloc(...) failed.
		return matrix_status_failed;
	}

	// Assign values (matrix rows and cols are 1-based).
	for (i = 1; i <= size; i++)
	{
		for (j = 1; j <= size; j++)
		{
			matrix_set(E, i, j, (i == j) ? matrix_element_one : matrix_element_zero);
		}
	}

	return matrix_status_succeeded;
}

matrix_status matrix_math_subtract(matrixPtr instanceA, matrixPtr instanceB, matrixPtr result)
{
	char caption[BUFSIZ] = {'\0'};
	size_t col = 0;
	size_t row = 0;

	// Validate input parameters.
	if ((NULL == instanceA) || (NULL == instanceB) || (NULL == result))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Validate operands.
	if ((instanceA->m != instanceB->m) || (instanceA->n != instanceB->n))
	{
		printf("! Operands are not of same type.\n");
		// ERROR: Invalid operation.
		return matrix_status_failed;
	}

	// Construct new caption.
	strncpy(caption, instanceA->caption, BUFSIZ);
	strncat(caption, " - ", BUFSIZ);
	strncat(caption, instanceB->caption, BUFSIZ);

	// Calculate result fields.
	if (matrix_alloc(result, caption, instanceA->m, instanceA->n))
	{
		size_t col = 0;
		size_t row = 0;

		for (row = 1; instanceA->m >= row; row++)
		{
			for (col = 1; instanceA->n >= col; col++)
			{
				matrix_element valueA = matrix_element_zero;
				matrix_element valueB = matrix_element_zero;

				if (matrix_get(instanceA, row, col, &valueA) && matrix_get(instanceB, row, col, &valueB))
				{
					matrix_set(result, row, col, valueA - valueB);
				} 
			}
		}
	}
	else
	{
		// ERROR: matrix_alloc(...) failed.
		return matrix_status_failed;
	}

	return matrix_status_succeeded;
}

matrix_status matrix_transform_invert(matrixPtr instance, matrixPtr result)
{
	matrix E = MATRIX_EMPTY;
	matrix EA = MATRIX_EMPTY;
	matrix AE = MATRIX_EMPTY;

	// Validate input parameters.
	if ((NULL == instance) || (NULL == result))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// PREREQUISITE: Only quadratic matrices can be inverted.
	if (instance->m != instance->n)
	{
		printf("! Matrix has to be quadratic to be invertable.\n");
		// ERROR: Invalid operation.
 		return matrix_status_failed;
	}

	// Extend matrix by its identiy matrix.
	if (!matrix_identity_matrix(instance, &E))
	{
		printf("! matrix_identity_matrix(...) failed.\n");
		// ERROR: matrix_identity_matrix(...) failed.
		return matrix_status_failed;
	}

	matrix_fprint(&E, stdout);

	if (!matrix_transform_hmerge(instance, &E, &AE))
	{
		printf("! matrix_transform_hmerge(...) failed.\n");

		// Free already allocated resources.
		matrix_free(&E);

		// ERROR: matrix_transform_hmerge(...) failed.
		return matrix_status_failed;
	}

	matrix_fprint(&AE, stdout);

	// Run extended matrix through GEA.
	if (!matrix_gea_matrix(&AE, &EA))
	{
		printf("! matrix_gea_matrix(...) failed.\n");

		// Free already allocated resources.
		matrix_free(&AE);
		matrix_free(&E);

		// ERROR: matrix_gea_matrix(...) failed.
		return matrix_status_failed;
	}

	matrix_fprint(&EA, stdout);

	// Extract inverted matrix.

	// Clean up.
	matrix_free(&EA);
	matrix_free(&AE);
	matrix_free(&E);

	// TODO: Implement.
	return matrix_status_failed;
}

matrix_status matrix_transform_hmerge(matrixPtr instanceA, matrixPtr instanceB, matrixPtr result)
{
	char caption[BUFSIZ] = {'\0'};
	size_t cols = 0;

	// Validate input paramters.
	if ((NULL == instanceA) || (NULL == instanceB) || (NULL == result))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Both matrices have to have same row count.
	if (instanceA->m != instanceB->m)
	{
		printf("! Row count does not match.\n");
		// ERROR: Invalid operation.
		return matrix_status_failed;
	}

	// Construct new caption.
	strncpy(caption, instanceA->caption, BUFSIZ);
	strncat(caption, " | ", BUFSIZ);
	strncat(caption, instanceB->caption, BUFSIZ);
	
	// Allocate result.
	cols = instanceA->n + instanceB->n;
	if (!matrix_alloc(result, caption, instanceA->m, cols))
	{
		printf("! matrix_alloc(...) failed.\n");
		// ERROR: matrix_alloc(...) failed.
		return matrix_status_failed;
	}
	
	// Copy values, keep in mind that matrix get() and set() are 1-based!
	{
		size_t r = 0;
		size_t c = 0;
		matrix_element value = matrix_element_zero;

		// Copy values.
		for (r = 1; r <= instanceA->m; r++)
		{
			// Copy values from first instance.
			for (c = 1; c <= instanceA->n; c++)
			{
				matrix_get(instanceA, r, c, &value);
				matrix_set(result, r, c, value);
			}

			// Copy values from second instance.
			for (c = 1; c <= instanceB->n; c++)
			{
				matrix_get(instanceB, r, c, &value);
				matrix_set(result, r, c + instanceA->n, value);
			}
		}
	}
		
	return matrix_status_succeeded;
}

matrix_status matrix_swap_cols(matrixPtr instance, size_t swap, size_t with)
{
	// Validate input parameters.
	if ((NULL == instance) || (0 == swap) || (0 == with) || (swap > instance->n) || (with > instance->n))
	{
		// ERROR: Invalid parameter(s).
		return matrix_status_failed;
	}

	// Check if anything has to be done at all.
	if (swap == with)
	{
		return matrix_status_succeeded;
	}

	// Since we use pointers, 0-base input variables.
	swap--;
	with--;

	// Swap values.
	{
		size_t i = 0;
		size_t offset = 0;
		matrix_element temp = matrix_element_zero;
		matrix_element *swapPtr = NULL;
		matrix_element *withPtr = NULL;

printf("! ");
		swapPtr = instance->elementsPtr + swap;
		withPtr = instance->elementsPtr + with;
		for (i = 0, offset = 0; i < instance->m; i++, offset = i * instance->n)
		{
printf("\t%d-%d", i, offset);
			// Move value pointers.
			swapPtr += offset;
			withPtr += offset;

			temp = *swapPtr;
			*swapPtr = *withPtr;
			*withPtr = temp;
		}
printf("\n");
	}

	return matrix_status_succeeded;
}

matrix_status matrix_swap_rows(matrixPtr instance, size_t swap, size_t with)
{
	// TODO: Implement.
	return matrix_status_failed;
}
