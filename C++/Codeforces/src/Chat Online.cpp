//#include<iostream>
//#include<algorithm>
//#include<stdio.h>
//
//using namespace std;
//
//int main()
//{
//    int p,q,l,r;
//    scanf("%d %d %d %d",&p,&q,&l,&r);
//
//    pair<int,int> arr[p];
//    pair<int,int> arr2[q];
//
//    for(int i = 0; i < p; i++)
//    {
//        int a,b;
//        scanf("%d %d",&a,&b);
//        arr[i] = make_pair(a,b);
//    }
//
//    for(int i = 0; i < q; i++)
//    {
//        int c,d;
//        scanf("%d %d",&c,&d);
//        arr2[i] = make_pair(c,d);
//    }
//
//    int ans = 0;
//    for(int i = l; i <= r; i++)
//    {
//        bool found = false;
//        for(int j = 0; j < q && !found; j++)
//        {
//            pair<int,int> cur = arr2[j];
//            for(int k = 0; k < p && !found; k++)
//            {
//                if (!(cur.second + i < arr[k].first || cur.first + i > arr[k].second)) {
//                        ans++;
//                        found = true;
//                     }
//            }
//        }
//    }
//
//    printf("%d",ans);
//}
