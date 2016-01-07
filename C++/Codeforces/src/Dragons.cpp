//#include<iostream>
//#include<algorithm>
//#include<stdio.h>
//
//using namespace std;
//
//int main()
//{
//	long long s, n;
//
//	cin >> s >> n;
//
//    pair<long long, long long> dragons[n];
//
//    for(int i = 0; i < n; i++){
//        long long x, y;
//        cin >> x >> y;
//
//        dragons[i] = make_pair(x, y);
//    }
//
//    sort(dragons, dragons + n);
//    bool won = true;
//    for(int i = 0; i < n && won; i++){
//        if(s <= dragons[i].first){
//        	won = false;
//        }
//
//        s += dragons[i].second;
//    }
//    if (won)
//        printf("%s\n", "YES");
//	else
//		printf("%s\n", "NO");
//	return 0;
//}
