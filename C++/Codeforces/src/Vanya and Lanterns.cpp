//#include<stdio.h>
//#include<algorithm>
//
//using namespace std;
//
//int main(){
//    long int n, l;
//    scanf("%d %d", &n, &l);
//
//    long int lanterns[n];
//
//    for(int i = 0; i < n; i++)
//        scanf("%d", &lanterns[i]);
//
//    sort(lanterns, lanterns + n);
//
//    double minRadius = lanterns[0];
//
//    for (int i = 0; i < n - 1; i++)
//        if((lanterns[i + 1] - lanterns[i]) / (2 * 1.0) > minRadius)
//            minRadius = (lanterns[i + 1] - lanterns[i]) / (2 * 1.0);
//
//    if(lanterns[n - 1] != l && (l - lanterns[n - 1]) > minRadius)
//        minRadius = (l - lanterns[n - 1]);
//
//    printf("%.10f", minRadius);
//}
