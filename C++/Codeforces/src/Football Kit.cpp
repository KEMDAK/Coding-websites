//#include<stdio.h>
//#include<algorithm>
//#include<cstring>
//
//using namespace std;
//
//int main(){
//    int n;
//    scanf("%d", &n);
//
//    int away[n];
//    int occ[100005];
//
//    memset(occ,0,sizeof occ);
//
//    pair<int, int> res[n];
//
//
//    for(int i = 0; i < n; i++){
//        int h, a;
//        scanf("%d %d", &h, &a);
//
//        away[i] = a;
//
//        occ[h]++;
//
//        res[i] = make_pair(n-1, n-1);
//    }
//
//    for(int i = 0; i < n; i++){
//        res[i].first += occ[away[i]];
//        res[i].second -= occ[away[i]];
//    }
//
//    for(int i = 0; i < n; i++){
//        printf("%d %d\n", res[i].first, res[i].second);
//    }
//}
