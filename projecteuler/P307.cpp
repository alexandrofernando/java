#include<cstdio>
#include<cmath>
#include<iostream>
using namespace std;

long double p(int k, int n)
{
	long double sum = 0;
	long double totalLog = k * logl(n);
	long double pLog1 = 0;
	for (int i = n; i > n - k; i--) {
		pLog1 += logl(i);
	}
	long double cLog = 0;
	long double pLog2 = 0;
	long double powerLog = 0;
	for (int i = 0; i * 2 <= k; i++) {
		long double log = pLog1 + cLog + pLog2 - powerLog - totalLog;
		long double a = expl(log);
		sum += a;
		pLog1 -= logl(n - i) + logl(n - i - (k - i * 2) + 1);
		cLog += logl(n - i) - logl(i + 1);
		pLog2 += logl(k - i * 2) + logl(k - i * 2 - 1);
		powerLog += logl(2);
	}
	return 1 - sum;
}

int main()
{
	long double result = p(20000, 1000000);
	printf("%.10Lf\n", result);
	return 0;
}
