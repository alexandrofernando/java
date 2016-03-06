#include <stdio.h>
#include <stdlib.h>

struct Number {
	int value;
	unsigned index;
};

int compare(const void *a,const void *b)
{
	return ((const Number *)a)->value-((const Number *)b)->value;
}

Number numbers[100001];

int main()
{
	int i;
	int n,m;
	unsigned I,J,K;
	int count;

	scanf("%d%d",&n,&m);
	
	for (i=0;i<n;i++) {
		scanf("%d",&numbers[i].value);
		numbers[i].index=i+1;
	}
	qsort(numbers,n,sizeof(*numbers),compare);
	for (i=0;i<m;i++) {
		scanf("%u%u%u",&I,&J,&K);
		unsigned len = J - I;
		count=0;
		Number *p=numbers;
		while (true) {
			if (p->index-I<=len) {
				count++;
				if (count==K) {
					printf("%d\n",p->value);
					break;
				}
			}
			p++;
		}
	}

	return 0;
}