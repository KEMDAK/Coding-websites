//#include<stdio.h>
//#include<algorithm>
//
//using namespace std;
//
//int main(){
//    int n;
//    scanf("%d", &n);
//
//    int occ[100001];
//
//    for(int i = 0; i < 100001; i++)
//        occ[i] = 0;
//
//    for(int  i = 0; i < n; i++){
//        int num;
//        scanf("%d", &num);
//
//        occ[num]++;
//    }
//
//    long long f[100001];
//
//    f[0] = 0;
//    f[1] = occ[1];
//
//    for(long long i = 2; i <= 100000; i++){
//        f[i] = max(f[i - 1], (f[i - 2] + (occ[i] * i)));
//    }
//
//    printf("%I64d", f[100000]);
//}
