#include <iostream>
#include <stdio.h>

using namespace std;

struct Hi 
{
    int A = 1;
    char b = 'a';
};

int main()
{
    cout << "Hello World!" << endl;
    Hi test;
    cout << test.A << endl;
    cout << test.b << endl;
    int e = 1;
    int *a = &e;
    cout << a << endl;

    for(int i = 0; i < 12; i++){
        cout << "Hi" << endl;
    }


    int j = 0;
    while(j != 5){
        cout << j << endl;
        j++;
    }

    for(int k = 0; k <= 35; k++){
        cout << k << endl;
    }

    int l;
    for (l = 0; l < j; l++) {
        printf("%d\n", l);
    }

    return 0;
}

class hello {
    public:
        hello();
};
hello::hello() {
    printf("%d\n",5);
}

class bob {
    
    public:
        bob();
};
bob::bob() {
    std::cout << "HI" << std::endl;
}

