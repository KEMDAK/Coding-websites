//#include<stdio.h>
//
//int main(){
//    long int n;
//    scanf("%d", &n);
//
//    long int prev;
//    scanf("%d", &prev);
//
//    long int start = -1;
//    long int firstE = prev;
//
//    for(long int i = 1; i < n; i++){
//        long int num;
//        scanf("%d", &num);
//
//        if(start == -1){
//            if(num < prev)
//                start = i;
//        }
//        else{
//            if(num < prev){
//                printf("%d", -1);
//                return 0;
//            }
//        }
//
//        prev = num;
//    }
//
//    if(prev > firstE && start != -1){
//        printf("%d", -1);
//                return 0;
//    }
//
//    if(start != -1)
//        printf("%d", n - start);
//    else
//        printf("%d", 0);
//}
