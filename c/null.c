#include <stdio.h>
#ifndef __SIZE_T
#define __SIZE_T
typedef unsigned int size_t;
#endif

int main(void){
    size_t sizet = 5;
    printf("%zu\n",sizet);                         // Prints 5
    printf("%zu\n",sizet);                         // Prints 5
    printf("Size of *char: %zu\n", sizeof(char*)); // Prints the size a char takes

    return 0;
}
