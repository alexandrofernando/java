#include <stdio.h>
#include <string>
#include <algorithm>

using namespace std;

class Node {
public:
	string label;
	int priority;
	int parent;
	int leftChild;
	int rightChild;

	Node() {}

	void init(string theLabel,int thePriority) {
		this->label=theLabel;
		this->priority=thePriority;
		this->parent=-1;
		this->leftChild=-1;
		this->rightChild=-1;
	}

	bool operator <(Node another) {
		return this->label<another.label;
	}
};

int n;
Node *nodes;

void display(int p)
{
	printf("(");
	if (nodes[p].leftChild!=-1) {
		display(nodes[p].leftChild);
	}
	printf("%s/%d",nodes[p].label.c_str(),nodes[p].priority);
	if (nodes[p].rightChild!=-1) {
		display(nodes[p].rightChild);
	}
	printf(")");
}

int main()
{
	int i;
	while (true) {
		scanf("%d",&n);
		if (n==0) {
			break;
		}
		nodes=new Node[n];
		for (i=0;i<n;i++) {
			char str[50];
			scanf("%s",str);
			int pos=0;
			while (str[pos]!='/') {
				pos++;
			}
			str[pos]='\0';
			int temp;
			sscanf(&str[pos+1],"%d",&temp);
			nodes[i].init(str,temp);
		}
		sort(&nodes[0],&nodes[n]);
		int root=0;
		for (i=1;i<n;i++) {
			int pos=i-1;
			while (nodes[pos].parent>=0 && nodes[i].priority>nodes[pos].priority) {
				pos=nodes[pos].parent;
			}
			if (nodes[i].priority>nodes[pos].priority) {
				nodes[pos].parent=i;
				nodes[i].leftChild=pos;
				root=i;
			}
			else {
				if (nodes[pos].rightChild!=-1) {
					nodes[i].leftChild=nodes[pos].rightChild;
					nodes[nodes[pos].rightChild].parent=i;
				}
				nodes[pos].rightChild=i;
				nodes[i].parent=pos;
			}
		}
		display(root);
		printf("\n");

		delete[] nodes;
	}

	return 0;
}