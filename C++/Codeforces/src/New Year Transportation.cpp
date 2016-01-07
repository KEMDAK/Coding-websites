//#include<stdio.h>
//
//int main(){
//    int n, t;
//    scanf("%d %d", &n, &t);
//
//    int cells[n];
//
//    for(int i = 1; i < n; i++)
//        scanf("%d", &cells[i]);
//
//    for(int i = 1; i < n; i += cells[i]){
//        if(i + cells[i] > t){
//            printf("NO");
//            return 0;
//        }
//
//        if(i + cells[i] == t){
//            printf("YES");
//            return 0;
//        }
//    }
//}
