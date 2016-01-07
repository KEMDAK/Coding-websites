//#include<stdio.h>
//#include<algorithm>
//
//using namespace std;
//
//int main(){
//    int n;
//    scanf("%d", &n);
//
//    int r[n];
//
//    for(int i = 0; i < n; i++)
//        scanf("%d", &r[i]);
//
//    sort(r, r + n);
//
//    double acc, red;
//    acc = red = 0;
//
//    int mult = 0;
//
//    if(n % 2 != 0)
//        mult = 1;
//
//    for(int i = 0; i < n; i++){
//        double area = (3.1415926536 * (r[i] * r[i])) - acc;
//
//        acc += area;
//
//        red += area * mult;
//
//        mult++;
//        mult %= 2;
//    }
//
//    printf("%.4f", red);
//}
