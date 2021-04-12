
#include <iostream>
#include <conio.h>
#include <string>
#include <math.h>
using namespace std;

typedef struct {
	int count;
	int index;
} sign;

void swap(sign *a, sign *b) {
	sign t = *a;
	*a = *b;
	*b = t;
}

int main() {
	int k;
	cin >> k;

	int minValue = INT_MAX;
	int maxValue = INT_MIN;
	int minIndex = -1;
	int maxIndex = -1;
	sign *signs = new sign[k];

	for (int i = 0; i < k; i++) {
		cin >> signs[i].count;
		signs[i].index = i + 1;
		if (signs[i].count >= maxValue) {
			maxValue = signs[i].count;
			maxIndex = i;
		}
		if (signs[i].count < minValue) {
			minValue = signs[i].count;
			minIndex = i;
		}
	}

	while (minIndex != maxIndex && minValue != INT_MAX) {
		printf("%i %i ", signs[maxIndex].index, signs[minIndex].index);
		signs[maxIndex].count--;
		signs[minIndex].count--;
		maxValue = INT_MIN;
		minValue = INT_MAX;
		for (int i = 0; i < k; i++) {
			if (signs[i].count != 0 && signs[i].count >= maxValue) {
				maxValue = signs[i].count;
				maxIndex = i;
			}
			if (signs[i].count != 0 && signs[i].count < minValue) {
				minValue = signs[i].count;
				minIndex = i;
			}
		}
	}
	for (int i = 0; i < maxValue; i++) {
		printf("%i ", signs[maxIndex].index);
	}
	// system("pause");
	return 0;
}