#include <stdio.h>

int main(void)
{
    int vector[] = {28, 41, 7};
    int *pi = vector;

    int *p0 = vector;
    int *p1 = vector + 1;
    int *p2 = vector + 2;

    printf("%d\n",sizeof(vector));

    char *titles[] = {"A tale of Two Cities",
                      "Withering Heights",
                      "Don Quixote",
                      "Odyssey",
                      "Moby-Dick",
                      "Hamlet",
                      "Gulliver's Travels"};

    char **bestBooks[3];
    char **englishBooks[4];

    bestBooks[0] = &titles[0];
    bestBooks[1] = &titles[3];
    bestBooks[2] = &titles[5];

    englishBooks[0] = &titles[0];
    englishBooks[1] = &titles[1];
    englishBooks[2] = &titles[5];
    englishBooks[3] = &titles[6];

    printf("%s\n", *englishBooks[1]);


    return 0;
}
