//#include<stdio.h>
//
//int main(){
//    long int n;
//    scanf("%d", &n);
//
//    int max = 0;
//    int count = 1;
//
//    long int arr[n];
//
//    for(int  i = 0; i < n; i++)
//        scanf("%d", &arr[i]);
//
//    for(int  i = 0; i < n - 1; i++){
//        if(arr[i] <= arr[i + 1])
//            count++;
//        else{
//            if(count > max)
//                max = count;
//            count = 1;
//        }
//    }
//
//    if(count > max)
//        max = count;
//
//    printf("%d", max);
//
//}
