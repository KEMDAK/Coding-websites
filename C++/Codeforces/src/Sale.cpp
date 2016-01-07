//#include<stdio.h>
//#include<algorithm>
//
//using namespace std;
//
//int main(){
//    int n, m;
//    scanf("%d %d", &n, &m);
//
//    int tvs[n];
//
//    for(int i = 0; i < n; i++)
//        scanf("%d", &tvs[i]);
//
//    sort(tvs, tvs + n);
//
//    int res = 0;
//
//    for(int i = 0; i < m; i++){
//        int price = tvs[i];
//
//        if(price >= 0)
//            break;
//
//        res += (price * -1);
//    }
//
//    printf("%d", res);
//}
