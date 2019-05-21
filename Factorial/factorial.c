#include <stdio.h>


int main()
{
    int n;
    int r;
    printf("Introduzca el valor para la entrada: ");
	fflush(stdout);
    scanf("%d", &n);
    r = factorial(n);
    printf("El resultado para la entrada %d es %d",n,r);
	return 0;
}
