//#include<stdio.h>
//
//int main(){
//    int n;
//    scanf("%d", &n);
//
//    int lastSeen[100001];
//    int diff[100001];
//
//    for(int i = 0; i < 100001; i++){
//        lastSeen[i] = -1;
//        diff[i] = 0;
//    }
//
//    for(int i = 0; i < n; i++){
//        int x;
//        scanf("%d", &x);
//
//        if(lastSeen[x] == -1){
//            lastSeen[x] = i;
//        }
//        else{
//            if(diff[x] == 0){
//                diff[x] = i - lastSeen[x];
//                lastSeen[x] = i;
//            }
//            else if(diff[x] != -1){
//                if(i - lastSeen[x] != diff[x])
//                    diff[x] = -1;
//                else
//                    lastSeen[x] = i;
//            }
//        }
//    }
//
//    int res = 0;
//
//    for(int i = 0; i < 100001; i++){
//        if(lastSeen[i] != -1 && diff[i] != -1)
//            res++;
//    }
//
//    printf("%d\n", res);
//
//    for(int i = 0; i < 100001; i++){
//        if(lastSeen[i] != -1 && diff[i] != -1)
//            printf("%d %d\n", i, diff[i]);
//    }
//
//}
