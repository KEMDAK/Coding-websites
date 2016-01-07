//#include<stdio.h>
//#include<algorithm>
//
//using namespace std;
//
//int main(){
//    long int n;
//    scanf("%d", &n);
//
//    long int arr[n];
//    long int temp[n];
//
//    for(int i = 0; i < n; i++){
//        long int x;
//        scanf("%d", &x);
//        arr[i] = x;
//        temp[i] = x;
//    }
//
//    sort(arr, arr + n);
//
//    int startIndex = -1;
//    int endIndex = -1;
//
//    for(int i = 0; i < n; i++){
//         if(arr[i] != temp [i]){
//            if(startIndex == -1){
//                startIndex = i;
//            }
////            else if(endIndex != -1){
////                printf("no");
////                return 0;
////            }
//            else{
//                endIndex = i;
//            }
//         }
//    }
//
//    if(startIndex == -1, endIndex == -1){
//        printf("yes\n%d %d", startIndex + 2, endIndex + 2);
//        return 0;
//    }
//
//    int j = endIndex;
//
//    for(int i = startIndex; i <= endIndex; i++){
//        if(arr[i] != temp[j]){
//            printf("no");
//                return 0;
//        }
//        j--;
//    }
//
//    printf("yes\n%d %d", startIndex + 1, endIndex + 1);
//}
