#include <stdio.h>

int main()
{
	int i,j;
	while (true) {
		int n1;
		int n2;
		int n;
		scanf("%d%d%d",&n1,&n2,&n);
		if (n1==0 && n2==0 && n==0) {
			break;
		}
		int *max=new int[n1];
		int *min=new int[n2];
		for (i=0;i<n1;i++) {
			max[i]=-1;
		}
		for (i=0;i<n2;i++) {
			min[i]=100000005;
		}
		double sum=0;
		for (i=0;i<n;i++) {
			int number;
			scanf("%d",&number);
			sum+=number;
			if (number>max[n1-1]) {
				int pos=n1-1;
				while (pos>=0 && number>max[pos]) {
					pos--;
				}
				pos++;
				for (j=n1-2;j>=pos;j--) {
					max[j+1]=max[j];
				}
				max[pos]=number;
			}
			if (number<min[n2-1]) {
				int pos=n2-1;
				while (pos>=0 && number<min[pos]) {
					pos--;
				}
				pos++;
				for (j=n2-2;j>=pos;j--) {
					min[j+1]=min[j];
				}
				min[pos]=number;
			}
		}
		for (i=0;i<n1;i++) {
			sum-=max[i];
		}
		for (i=0;i<n2;i++) {
			sum-=min[i];
		}
		double average=sum/(n-n1-n2);
		printf("%.6lf\n",average);
		
		delete max;
		delete min;
	}
	return 0;
}