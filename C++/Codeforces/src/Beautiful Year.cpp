//#include<stdio.h>
//
//bool isBeautiful(int x){
//    int mask = 0;
//
//    while(x > 0){
//        int digit = x % 10;
//
//        if(((1 << digit) & mask) != 0)
//            return false;
//
//        mask = mask | (1 << digit);
//
//        x /= 10;
//    }
//
//    return true;
//}
//
//int main(){
//    int year;
//    scanf("%d", &year);
//
//    year++;
//
//    while(!isBeautiful(year))
//        year++;
//
//    printf("%d", year);
//}
