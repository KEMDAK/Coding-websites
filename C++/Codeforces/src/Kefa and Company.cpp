//#include<stdio.h>
//#include<algorithm>
//
//using namespace std;
//
//int main(){
//    long int n, d;
//    scanf("%d %d", &n, &d);
//
//    pair<long int, long int> friends[n];
//
//    for(int i = 0; i < n; i++){
//        long int m, s;
//        scanf("%d %d", &m, &s);
//
//        friends[i] = make_pair(m, s);
//    }
//
//    sort(friends, friends + n);
//    reverse(friends, friends + n);
//
//    long long max = friends[0].second;
//    long long cur = max;
//    long int maxI = 0;
//
//    for(int i = 1; i < n; i++){
//        if(friends[maxI].first - friends[i].first >= d){
//
//            if(cur > max)
//                max = cur;
//
//            cur -= friends[maxI].second;
//
//            maxI++;
//            i--;
//        }
//        else{
//            cur += friends[i].second;
//        }
//    }
//
//    if(cur > max)
//        max = cur;
//
//    printf("%I64d", max);
//}
