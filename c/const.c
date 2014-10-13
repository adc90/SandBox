#include <stdio.h>
#include <stdint.h>

int main(void)
{
    int numA = 5;
    int numB;
    numA = 8;
    int *const cpt = &numA;
    // The cpt pointer can't point to a differnt address
    // cpt = &numB; 
    printf("%d\n",*cpt);

    int numC = 4;
    intptr_t *pi = (intptr_t*) &numC;
    uintptr_t *pu = (uintptr_t*)&numC;

    int limit  = 500;
    const int *const cpci = &limit;  // Constant pointer
    const int *const *pcpci = &cpci; // Constant pointer to a pointer

    printf("%d\n", *cpci);
    pcpci = &cpci;
    printf("%d\n", **pcpci);


    return 0;
}
