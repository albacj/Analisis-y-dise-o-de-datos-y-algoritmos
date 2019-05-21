#include<stdio.h>

int pascal(int n, int m){
	int suma = 1;

	if(m > n){
		suma = pascal(n-1, m) + pascal(n-1, m-1);

	}else if(m == 0 || n == m){
		suma = 1;
	}

	return suma;
}
