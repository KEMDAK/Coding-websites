//#include<stdio.h>
//
//long int modulo(long int x){
//        return (((x % 1000000007) + 1000000007) % 1000000007);
//}
//
//int main(){
//
//    long int x, y;
//    scanf("%d %d", &x, &y);
//
//    long int z = y - x;
//
//    long int n;
//    scanf("%d", &n);
//
//    int factor;
//
//    if((n % 3) == 0){
//        if((n / 3) % 2 == 0)
//            factor = -1;
//        else
//            factor = 1;
//    }
//    else if(((n / 3) + 1) % 2 == 0)
//            factor = -1;
//        else
//            factor = 1;
//
//    long int res;
//
//    if(n % 3 == 0)
//        res = factor * z;
//    else if(n % 3 == 1)
//        res = factor * x;
//    else
//        res = factor * y;
//
//    printf("%d", modulo(res));
//}
