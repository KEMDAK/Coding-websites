//#include<stdio.h>
//
//int main(){
//    int n, t;
//    scanf("%d %d", &n, &t);
//
//    int books[n];
//
//    for(int i = 0; i < n; i++){
//        scanf("%d", &books[i]);
//    }
//
//    int max = 0;
//
//    int start = 0;
//
//    for(int i = 0; i < n; i++){
//
//        if(t - books[i] < 0){
//            if(i - start > max)
//                max = i - start;
//
//            t+= books[start];
//            start++;
//            i--;
//        }
//        else{
//            t -= books[i];
//        }
//    }
//
//    if(n - start > max)
//        max = n - start;
//
//    printf("%d", max);
//}
