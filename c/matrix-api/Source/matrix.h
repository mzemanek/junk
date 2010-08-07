#ifndef MATRIX_H
#define MATRIX_H

// Matrix Application Programming Interface (API)

#define MATRIX_EMPTY {NULL, 0, 0, NULL}
#define MATRIX_ELEMENT_FORMAT "%5.2f"

// Define input and output format strings for matrix elements.
static const char *matrix_element_input = "%f";
static const char *matrix_element_output = "\t" MATRIX_ELEMENT_FORMAT;
static const float matrix_element_one = 1.0F;
static const float matrix_element_zero = 0.0F;

// Define type for matrix elements to be able to adopt data type requirements easily.
typedef float matrix_element;

// Define return values for matrix API functions.
typedef enum _matrix_status
{
	matrix_status_failed = 0,
	matrix_status_succeeded
} matrix_status;

// Define a type to represent m x n-matrices.
typedef struct _matrix
{
   // Do not forget to adjust MATRIX_EMPTY in case of changes!
	char *caption;
	size_t m;
	size_t n;
	matrix_element *elementsPtr;
} matrix, *matrixPtr;

// We want to be able to:
// Create a m x n-matrix from scratch.
matrix_status matrix_alloc(matrixPtr instance, const char *caption, size_t m, size_t n);
matrix_status matrix_clone(matrixPtr instance, const char *caption, matrixPtr source);
matrix_status matrix_free(matrixPtr instance);

// Print a m x n-matrix to file or console (using stdout) respectively.
matrix_status matrix_fprint(const matrixPtr instance, FILE *file);

// Read a m x n-matrix from file.
matrix_status matrix_fread(matrixPtr instance, FILE *file);
matrix_status matrix_read(matrixPtr instance, const char* filename);

// Get/set single value by row/column.
matrix_status matrix_get(matrixPtr instance, size_t row, size_t col, matrix_element *valuePtr);
matrix_status matrix_get_col(matrixPtr instance, size_t col, matrix_element values[]);
matrix_status matrix_get_row(matrixPtr instance, size_t row, matrix_element values[]);

matrix_status matrix_set(matrixPtr instance, size_t row, size_t col, matrix_element value);
matrix_status matrix_set_all(matrixPtr instance, matrix_element *values);
matrix_status matrix_set_col(matrixPtr instance, size_t col, matrix_element values[]);
matrix_status matrix_set_row(matrixPtr instance, size_t row, matrix_element values[]);

// Perform matrix math:
// Transpose a matrix
matrix_status matrix_math_transpose(matrixPtr instance, matrixPtr result);

// Multiply matrices.
matrix_status matrix_math_multiply(matrixPtr instanceA, matrixPtr instanceB, matrixPtr result);

// Add matrices.
matrix_status matrix_math_add(matrixPtr instanceA, matrixPtr instanceB, matrixPtr result);

// Subtract matrices.
matrix_status matrix_math_subtract(matrixPtr instanceA, matrixPtr instanceB, matrixPtr result);

// Gauss elemination algorithm.
matrix_status matrix_gea_matrix(matrixPtr instance, matrixPtr result);

// Create matrix E from a given matrix
matrix_status matrix_identity_matrix(matrixPtr instance, matrixPtr E);

// Scalar product of two vectors
#endif
