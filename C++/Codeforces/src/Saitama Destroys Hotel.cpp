//#include<bits/stdc++.h>
//
//using namespace std;
//
//int main(){
//    int n, s;
//    scanf("%d %d", &n, &s);
//
//    pair<int, int> p[n];
//
//    for(int i = 0; i < n; i++){
//        int f, t;
//        scanf("%d %d", &f, &t);
//
//        p[i] = make_pair(f, t); /////
//    }
//
//    sort(p, p + n);
//
////    for(int i = n - 1; i >= 0; i--){
////        printf("(%d, %d)", p[i].first, p[i].second);
////    }
////
////    printf("\n");
//
//    int time = 0;
//    int prev = s;
//
//    for(int i = n - 1; i >= 0; i--){
//        time += prev - p[i].first;
//
//        if(time < p[i].second)
//            time += p[i].second - time;
//
//        prev = p[i].first;
//    }
//
//    time += p[0].first;
//
//    printf("%d", time);
//}
