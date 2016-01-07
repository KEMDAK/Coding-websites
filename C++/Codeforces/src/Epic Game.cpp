//#include<stdio.h>
//
//int gcd(int x, int y){
//    if(x == 0)
//        return y;
//    if(y == 0)
//        return x;
//    while(x != y){
//        if(x > y)
//            x = x - y;
//        else
//            y = y - x;
//    }
//
//    return x;
//}
//
//int main(){
//   int a, b, n;
//   scanf("%d %d %d", &a, &b, &n);
//
//   int player = 0;
//
//   while (true){
//    if(player == 0){
//        int stones = gcd(a, n);
//
//        if(stones > n){
//            printf("%d", 1);
//            return 0;
//        }
//
//        n -= stones;
//
//        player = 1;
//    }
//    else{
//        int stones = gcd(b, n);
//
//        if(stones > n){
//            printf("%d", 0);
//            return 0;
//        }
//
//        n -= stones;
//
//        player = 0;
//    }
//   }
//}
