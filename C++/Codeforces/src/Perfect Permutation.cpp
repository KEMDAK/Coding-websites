//#include<stdio.h>
//
//int main(){
//    int n;
//    scanf("%d", &n);
//
//    bool numbers[n];
//
//    int result[n];
//
//    for(int i = 0; i < n; i++){
//        numbers[i] = false;
//        result[i] = -1;
//    }
//
//    for(int i = 0; i < n; i++){
//        if(result[i] == -1){
//            for(int j = 0; j < n; j++){
//                if(!numbers[j]){
//                    if(j != i){
//                        result[i] = j + 1;
//                        result[j] = i + 1;
//                        numbers[j] = true;
//                        numbers[i] = true;
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//    for(int i = 0; i < n; i++){
//        if(!numbers[i]){
//            printf("%d", -1);
//            return 0;
//        }
//    }
//
//    int i;
//
//    for(i = 0; i < n - 1; i++)
//        printf("%d ", result[i]);
//
//    printf("%d", result[i]);
//
////
////    if(n == 1){
////        printf("%d", -1);
////        return 0;
////    }
////
////    int counter = n;
////
////    for(int i = 1; i <= n; i++){
////        if(i != counter)
////            printf("%d ", counter);
////        else{
////            printf("%d %d ", counter - 1, counter);
////            counter--;
////            i++;
////        }
////        counter--;
////    }
//}
