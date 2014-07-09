#include <iostream>

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

	return 0;
}
