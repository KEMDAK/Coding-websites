//#include<bits/stdc++.h>
//
//using namespace std;
//
//int main(){
//    int n, m, d;
//    scanf("%d %d %d", &n, &m, &d);
//
//    int arr[n * m];
//
//    for(int i = 0; i < n * m; i++)
//        scanf("%d", &arr[i]);
//
//    sort(arr, arr + n * m);
//
//    int target = arr[(n * m) / 2];
//
//    int total = 0;
//
//    for(int i = 0; i < n * m; i++){
//        if(abs(target - arr[i]) % d == 0){
//            total += abs(target - arr[i]) / d;
//        }
//        else{
//            printf("%d", -1);
//            return 0;
//        }
//    }
//
//    printf("%d", total);
//}
