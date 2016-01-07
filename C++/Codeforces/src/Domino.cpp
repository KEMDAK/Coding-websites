//#include<stdio.h>
//
//int main(){
//    int n;
//    scanf("%d", &n);
//
//    int o1 = 0;
//    int o2 = 0;
//    int diff = 0;
//
//    for(int i = 0; i < n; i++){
//        int x, y;
//        scanf("%d %d", &x, &y);
//
//        if(x % 2 == 1)
//            o1++;
//        if(y % 2 == 1)
//            o2++;
//        if((x + y) % 2 == 1)
//            diff++;
//    }
//
//    if(o1 % 2 == 0 && o2 % 2 == 0)
//        printf("%d", 0);
//    else if((o1 % 2 == 1 && o2 % 2 == 1) && (o1 != o2 || (o1 == o2 && diff > 0)))
//        printf("%d", 1);
//    else
//        printf("%d", -1);
//}
