#include <stdio.h>
#include <algorithm>

using namespace std;

int main() {
	int i;
	int N;
	scanf("%d",&N);
	int *x=new int[N];
	for (i=0;i<N;i++) {
		scanf("%d",&x[i]);
	}
	sort(&x[0],&x[N]);
	int *y=new int[N];
	for (i=0;i<N;i++) {
		scanf("%d",&y[i]);
	}
	sort(&y[0],&y[N]);
	int *signX=new int[N];
	int *signY=new int[N];
	for (i=0;i<N;i++) {
		int region;
		scanf("%d",&region);
		if (region==1 || region==4) {
			signX[i]=1;
		}
		else {
			signX[i]=-1;
		}
		if (region==1 || region==2) {
			signY[i]=1;
		}
		else {
			signY[i]=-1;
		}
	}
	int sX=signX[N-1];
	int sY=signY[N-1];
	for (i=N-1;i>=0;i--) {
		if (sX==-1) {
			x[i]=-x[i];
		}
		if (sY==-1) {
			y[i]=-y[i];
		}
		sX=-sX;
		sY=-sY;
	}
	int startX=0;
	int endX=N-1;
	int startY=0;
	int endY=N-1;
	int *resultX=new int[N];
	int *resultY=new int[N];
	for (i=N-1;i>=0;i--) {
		if (i==0) {
			resultX[i]=x[startX];
			resultY[i]=y[startY];
		}
		else {
			if (signX[i-1]*x[endX]>0) {
				resultX[i]=x[startX];
				startX++;
			}
			else {
				resultX[i]=x[endX];
				endX--;
			}
			if (signY[i-1]*y[endY]>0) {
				resultY[i]=y[startY];
				startY++;
			}
			else {
				resultY[i]=y[endY];
				endY--;
			}
		}
	}
	for (i=0;i<N;i++) {
		printf("%+d %+d\n",resultX[i],resultY[i]);
	}
	delete [] x;
	delete [] y;
	delete [] signX;
	delete [] signY;
	delete [] resultX;
	delete [] resultY;
	return 0;
}