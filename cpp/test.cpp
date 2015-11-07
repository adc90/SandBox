#include <iostream>
#include <stdio.h>

using namespace std;

struct Hi
{
    int A;
    char b;
};

int main() 
{
    cout << "Hello World!" << endl;
    Hi test;
    test.A = 1;
    int e = 1;
    int *a = &e;
    cout << a << endl;

    for(int i = 0; i < 12; i++)
    {
        cout << "Hi" << endl;
    }


    int j = 0;
    while(j != 5)
    {
        cout << j << endl;
        j++;
    }

    for(int k = 0; k <= 35; k++)
    {
        cout << k << endl;
    }

    int l;
    for (l = 0; l < j; l++) 
    {
        printf("%d\n", l);
    }

    return 0;
}

class hello 
{
    public:
        hello();
        void goodbye();
};

hello::hello() 
{
    printf("%d\n",5);
}

void hello::goodbye()
{
    printf("%d\n",8);
}

class bob 
{
    public:
        bob();
        void greg();
};

bob::bob() 
{
    std::cout << "HI" << std::endl;
}

void bob::greg()
{
  std::cout << "Greg" << std::endl;
}

