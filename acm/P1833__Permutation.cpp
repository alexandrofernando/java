#include <stdio.h>

int main()
{
	int t,i,j;
	int test;
	scanf("%d",&test);
	for (t=1;t<=test;t++) {
		int n;
		int K;
		scanf("%d%d",&n,&K);
		int *numbers=new int[n];
		for (i=0;i<n;i++) {
			scanf("%d",&numbers[i]);
		}
		for (i=0;i<K;i++) {
			bool power=false;
			for (j=n-2;j>=0;j--) {
				if (numbers[j]<numbers[j+1]) {
					int pos=0;
					int bottom=j+1;
					int top=n-1;
					while (bottom<=top) {
						pos=(bottom+top)/2;
						if (numbers[pos]<numbers[j]) {
							top=pos-1;
						}
						else {
							bottom=pos+1;
						}
					}
					if (numbers[pos]<numbers[j]) {
						pos--;
					}
					int temp=numbers[pos];
                    numbers[pos]=numbers[j];
                    numbers[j]=temp;
                    int pos1=j+1;
                    int pos2=n-1;
                    while (pos1<pos2) {
                        temp = numbers[pos1];
                        numbers[pos1] = numbers[pos2];
                        numbers[pos2] = temp;
                        pos1++;
                        pos2--;
                    }
                    power=true;
                    break;
				}
			}
			if (power==false) {
                for (int j=0;j<n;j++) {
                    numbers[j]=j+1;
                }
            }
		}
		for (i=0;i<n;i++) {
			if (i!=0) {
				printf(" ");
			}
			printf("%d",numbers[i]);
		}
		printf("\n");
		delete numbers;
	}

	return 0;
}