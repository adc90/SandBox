#include <stdio.h>

void add_func(int x, int y){
    printf("%d\n" ,x + y);
}

void mult_func(int x, int y){
    printf("%d\n" ,x * y);
}


int main(int argc, char const* argv[])
{
    int x = 5;
    int y = 6;

    void (*foo)(int,int); 
    foo = &add_func;
    foo(x,y);
    foo = &mult_func;
    foo(x,y);
}
