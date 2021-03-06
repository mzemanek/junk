#ifndef MATRIX_TESTS_H
#define MATRIX_TESTS_H

typedef int (*test_functionPtr)(int, char *[]);

// Function Declarations.
int test_1(int argc, char *argv[]);
int test_2(int argc, char *argv[]);
int test_3(int argc, char *argv[]);
int test_4(int argc, char *argv[]);
int test_5(int argc, char *argv[]);
int test_6(int argc, char *argv[]);
int test_7(int argc, char *argv[]);
int test_8(int argc, char *argv[]);
int test_9(int argc, char *argv[]);
int test_10(int argc, char *argv[]);
int test_11(int argc, char *argv[]);
int test_12(int argc, char *argv[]);
int test_13(int argc, char *argv[]);

// Dictionary of test functions.
static const char *test_functionInfos[] =
{
   "1 - Allocate 4 x 4 matrix and populate third row from an array.",
   "2 - Save a matrix to a file (./x.matrix).",
   "3 - Load a matrix from a file (./x.matrix).",
   "4 - Allocate 4 x 4 matrix and populate third column from an array.",
   "5 - Allocate and populate 4 x 4-matrix. Get third column as array.",
   "6 - Transpose a given matrix.",
   "7 - Create identiy matrix for a given matrix.",
   "8 - Subtract a given matrix from identity matrix.",
   "9 - Run a given matrix through the Gauss' elemination algorithm.",
	"10- Invert a given matrix.",
	"11- Swap second and third columns of a given matrix.",
	"12- Swap second and third row of a given matrix.",
	"13- Cut a matrix out of a matrix.",
   NULL
};

static const test_functionPtr test_functions[] =
{
   &test_1,
   &test_2,
   &test_3,
   &test_4,
   &test_5,
   &test_6,
   &test_7,
   &test_8,
	&test_9,
	&test_10,
	&test_11,
	&test_12,
	&test_13
};

#endif
