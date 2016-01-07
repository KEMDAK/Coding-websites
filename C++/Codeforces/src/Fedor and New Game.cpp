//#include<stdio.h>
//
//bool isFriend(long int x);
//
//int n, k;
//long int fedor;
//
//int main(){
//    int m;
//    scanf("%d %d %d", &n, &m, &k);
//
//    long int players[m];
//
//    for(int i = 0; i < m; i++)
//        scanf("%d", &players[i]);
//
//    scanf("%d", &fedor);
//
//    int res = 0;
//
//    for(int i = 0; i < m; i++)
//        if(isFriend(players[i]))
//            res++;
//
//    printf("%d", res);
//}
//
//bool isFriend(long int x){
//    long int res = x ^ fedor;
//
//    int diff = 0;
//
//    for(int i = 0; i < n; i++){
//        if((res & (1 << i)) != 0)
//           diff++;
//
//        if(diff > k)
//            return false;
//    }
//
//    return true;
//}
