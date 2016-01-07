//#include<stdio.h>
//
//long long pow(int base,int p)
//{
//    if (p == 0)
//        return 1;
//
//    return ((base * pow(base, p-1)) % 1000000007 + 1000000007) % 1000000007;
//}
//
//int main(){
//    int n;
//    scanf("%d", &n);
//
//    int ans = ((pow(27, n)) - (pow(7, n)));
//
//    printf("%d", (ans >= 0)? ans : ans + 1000000007);
//}
