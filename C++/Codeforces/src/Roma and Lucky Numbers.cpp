//#include<stdio.h>
//
//int luckyDigits(long int x){
//    int c  = 0;
//
//    while(x != 0){
//        if(x % 10 == 4 || x % 10 == 7)
//            c++;
//
//        x /= 10;
//    }
//
//    return c;
//}
//
//int main(){
//    int n, k;
//    scanf("%d %d", &n, &k);
//
//    int res = 0;
//
//    for(int i = 0; i < n; i++){
//        long int x;
//        scanf("%d", &x);
//
//        if(luckyDigits(x) <= k)
//            res++;
//    }
//
//    printf("%d", res);
//}
