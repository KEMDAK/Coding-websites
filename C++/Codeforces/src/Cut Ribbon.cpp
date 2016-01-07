//#include<stdio.h>
//#include<cmath>
//
//int a, b, c;
//int dp[4001];
//
//int ribbons(int n){
//    if(n < 0)
//        return -5000;
//    if(n == 0)
//        return 0;
//    if(dp[n] != -1)
//        return dp[n];
//
//    int c1 = ribbons(n - a) + 1;
//    int c2 = ribbons(n - b) + 1;
//    int c3 = ribbons(n - c) + 1;
//
//    dp[n] = fmax(fmax(c1, c2), c3);
//    return dp[n];
//}
//
//int main(){
//    int n;
//    scanf("%d %d %d %d", &n, &a, &b, &c);
//
//    for(int i = 0; i <= n; i++)
//        dp[i] = -1;
//
//    printf("%d", ribbons(n));
//}
