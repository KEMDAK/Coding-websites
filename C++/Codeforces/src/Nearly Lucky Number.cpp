//#include<stdio.h>
//
//
//bool isLucky(long long x){
//    if(x == 0)
//        return false;
//
//    while(x > 0){
//        if(!(x % 10 == 4 || x % 10 == 7))
//            return false;
//
//        x /= 10;
//    }
//
//    return true;
//}
//
//bool isNearlyLucky(long long x){
//    int counter = 0;
//
//    while(x > 0){
//        if((x % 10 == 4 || x % 10 == 7))
//            counter++;
//
//        x /= 10;
//    }
//
//    return isLucky(counter);
//}
//
//int main(){
//    long long number;
//    scanf("%I64d", &number);
//
//    if(isNearlyLucky(number))
//        printf("YES");
//    else
//        printf("NO");
//}
