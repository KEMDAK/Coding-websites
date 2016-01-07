//#include <stdio.h>
//
//int main() {
//	long int n;
//	scanf("%d", &n);
//
//	long int prev;
//
//	long int time = 0;
//
//	scanf("%d", &prev);
//
//	long int height = 0;
//
//	for(int i = 1; i <= n; i++){
//		long int h;
//		scanf("%d", &h);
//
//		if(prev > height){
//			time += (prev - height) + 1;
//			height += (prev - height);
//		}
//		else if(prev == height)
//			time ++;
//
//		if(i !=n){
//		if(h >= height)
//			time++;
//		else if(h < height){
//			time += (height - h) + 1;
//			height += (h - height);
//		}
//		}
//
//		prev = h;
//	}
//
//	printf("%d", time);
//
//	return 0;
//}
