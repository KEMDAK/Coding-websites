//#include<stdio.h>
//#include<algorithm>
//
//using namespace std;
//
//int main(){
//    int n,k;
//    scanf("%i %i",&n,&k);
//
//    int maximum;
//    scanf("%i",&maximum);
//    int minimum = maximum;
//
//    int arr[n];
//    arr[0] = maximum;
//    for(int i = 1; i < n; i++)
//    {
//        int a;
//        scanf("%i",&a);
//        maximum = max(maximum,a);
//        minimum = min(minimum,a);
//        arr[i] = a;
//    }
//
//    if (maximum - k > minimum)
//        printf("NO");
//    else{
//        printf("YES\n");
//
//        for(int i = 0; i < n; i++){
//                int count = 1;
//            for(int j = 1; j <= arr[i]; j++)
//            {
//                if (count > k) count = 1;
//                printf("%i ",count);
//                count++;
//            }
//            printf("\n");
//        }
//    }
//
//}
