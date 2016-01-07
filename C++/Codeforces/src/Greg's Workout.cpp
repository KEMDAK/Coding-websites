//#include<stdio.h>
//
//int main() {
//    int n, c, bi, ba;
//
//    scanf("%d", &n);
//
//    c = 0;
//    bi = 0;
//    ba = 0;
//
//    int ex = 0;
//
//    for(int i = 0; i < n; i++){
//        int t;
//        scanf("%d", &t);
//
//        if(ex == 0)
//            c += t;
//        else if(ex == 1)
//            bi += t;
//        else
//            ba += t;
//
//        ex++;
//        ex = ex % 3;
//    }
//
//    if(c > bi && c > ba)
//        printf("chest");
//    else if(bi > c && bi > ba)
//        printf("biceps");
//    else
//        printf("back");
//}
