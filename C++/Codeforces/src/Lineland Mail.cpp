//#include<stdio.h>
//#include<algorithm>
//
//using namespace std;
//
//int main(){
//    int n;
//    scanf("%d", &n);
//
//    int arr[n + 2];
//
//    for(int i = 1; i <= n; i++)
//        scanf("%d", &arr[i]);
//
//    for(int i = 1; i <= n; i++){
//        int minimum = 0;
//        if(i == n)
//            minimum = abs(arr[i] - arr[i - 1]);
//        else if (i == 1)
//            minimum = abs(arr[i] - arr[i + 1]);
//        else
//            minimum = min(abs(arr[i] - arr[i - 1]), abs(arr[i] - arr[i + 1]));
//        int maximum = max(abs(arr[i] - arr[1]), abs(arr[i] - arr[n]));
//
//        printf("%d %d\n", minimum, maximum);
//    }
//}
