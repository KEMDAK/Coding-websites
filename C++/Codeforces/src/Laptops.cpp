//#include<algorithm>
//#include<stdio.h>
//#include<limits.h>
//
//using namespace std;
//
//int main()
//{
//	long int n;
//	scanf("%d", &n);
//
//	pair<long int, long int> laptops[n];
//
//	for(int i = 0; i < n; i++){
//        long int a, b;
//        scanf("%d %d", &a, &b);
//
//        laptops[i] = make_pair(a, b);
//	}
//
//	sort(laptops, laptops + n);
//
//    long int prev = laptops[0].second;
//    for(int i = 1; i < n; i++){
//        if(laptops[i].second < prev){
//            printf("%s", "Happy Alex");
//            return 0;
//        }
//
//        prev = laptops[i].second;
//    }
//
//	printf("%s", "Poor Alex");
//}
//
