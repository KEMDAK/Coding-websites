//#include<stdio.h>
//#include<algorithm>
//
//using namespace std;
//
//int main(){
//    int n, m;
//    scanf("%d %d", &n, &m);
//
//    int dirty[m];
//
//    for(int i = 0; i < m; i++)
//        scanf("%d", &dirty[i]);
//
//    sort(dirty, dirty + m);
//
//    if(dirty[0] == 1 || dirty[m - 1] == n)
//        printf("NO");
//    else{
//        int cons = 1;
//        for(int i = 1; i < m; i++){
//            if(dirty[i] == dirty[i-1] + 1)
//                cons++;
//            else
//                cons = 1;
//
//            if(cons == 3){
//                printf("NO");
//                return 0;
//            }
//        }
//
//        printf("YES");
//    }
//}
