#include <stdio.h>

int main() {
	int i;
	int N;
	scanf("%d",&N);
	int *sum=new int[N];
	for (i=N-1;i>=0;i--) {
		getchar();
		int a=getchar()-'0';
		getchar();
		int b=getchar()-'0';
		sum[i]=a+b;
	}
	int carry=0;
	for (i=0;i<N;i++) {
		int temp=sum[i]+carry;
		sum[i]=temp%10;
		carry=temp/10;
	}
	for (i=N-1;i>=0;i--) {
		putchar(sum[i]+'0');
	}
	printf("\n");

	delete [] sum;
	return 0;
}