//#include<bits/stdc++.h>
//
//using namespace std;
//
//int main(){
//    int n, k;
//    scanf("%d %d", &n, &k);
//
//    int arr[n];
//
//    for(int i = 0; i < n; i++)
//        scanf("%d", &arr[i]);
//
//    int minimum = 100000001;
//    int index = 0;
//
//    for(int i = 0; i < k; i++){
//        int sum = 0;
//        for(int j = i; j < n; j = j + k){
//            sum += arr[j];
//        }
//
//        if(minimum > sum){
//            minimum = sum;
//            index = i;
//        }
//    }
//
//    printf("%d", index + 1);
//}
