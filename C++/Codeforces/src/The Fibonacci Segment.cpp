//#include<stdio.h>
//
//int main()
//{
//    int n;
//    scanf("%i",&n);
//
//    if (n == 1)
//    {
//        printf("%i",1);
//        return 0;
//    }
//    int max = 2;
//    int cur = max;
//    int prev1;
//    int prev2;
//
//    scanf("%i %i",&prev1,&prev2);
//
//    for(int i = 2; i < n; i++)
//    {
//        int a;
//        scanf("%i",&a);
//
//        if (a == prev1+prev2)
//            cur++;
//        else
//            cur = 2;
//
//        if(cur > max)
//            max = cur;
//
//        prev1 = prev2;
//        prev2 = a;
//    }
//
//    printf("%i", max);
//}
