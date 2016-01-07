//#include <bits/stdc++.h>
//
//using namespace std;
//
//int main()
//{
//    int n,r,avg;
//    scanf("%i %i %i", &n, &r, &avg);
//
//    long long sum = 0;
//    pair<int, int> arr[n];
//    for(int i = 0 ; i < n; i++)
//    {
//        int a,b;
//        scanf("%i %i",&a,&b);
//
//        sum += a;
//        arr[i] = make_pair(b,a);
//    }
//
//    sort(arr, arr + n);
//    long long x = ((long long)avg * n) - sum;
//    int index = 0;
//    long long ans = 0;
//    while(x > 0)
//    {
//        long long diff = r - arr[index].second;
//        if (diff >= x) {
//            ans += x * arr[index].first;
//            x = 0;
//        }
//        else {
//            ans += diff * arr[index].first;
//            x -= diff;
//        }
//        index++;
//    }
//
//    printf("%I64d",ans);
//}
