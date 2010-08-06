CC = /usr/bin/gcc
CC_FLAGS = 

BIN = matrix
OBJ = ./Source/main.o ./Source/matrix.o ./Source/matrix-tests.o

# Default target.
build: clean $(OBJ)
	$(CC) $(CC_FLAGS) -o $(BIN) $(OBJ)

%.o: %.c
	$(CC) $(CC_FLAGS) -c -o $@ $<

.PHONY: clean
clean:
	rm -rf $(BIN) $(OBJ)
