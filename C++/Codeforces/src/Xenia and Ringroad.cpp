//#include<stdio.h>
//
//int main(){
//    long int n, m;
//    scanf("%d %d", &n, &m);
//
//    long long time = 0;
//
//    long int now = 1;
//
//    for(int i = 0; i < m; i++){
//        long int h;
//        scanf("%d", &h);
//
//        if(h >= now){
//            time += h - now;
//        }
//        else{
//            time += n - now + h;
//        }
//
//        now = h;
//    }
//
//    printf("%I64d", time);
//}
