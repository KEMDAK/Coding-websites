//#include<stdio.h>
//
//int main(){
//    long int n, s, t;
//    scanf("%d %d %d", &n, &s, &t);
//
//    long int glasses[n + 1];
//
//    for(int i = 1; i <= n; i++)
//        scanf("%d", &glasses[i]);
//
//    long int res = 0;
//
//    while(s != t){
//        if(glasses[s] == -1){
//            printf("%d", -1);
//            return 0;
//        }
//
//        long int temp = s;
//
//        s = glasses[s];
//
//        glasses[temp] = -1;
//
//        res++;
//    }
//
//    printf("%d", res);
//}
