//#include<stdio.h>
//#include<algorithm>
//
//using namespace std;
//
//int main(){
//    int n, m;
//    scanf("%d %d", &n, &m);
//
//    int correct[n];
//    int wrong[m];
//
//    for(int i = 0; i < n; i++)
//        scanf("%d", &correct[i]);
//
//    for(int i = 0; i < m; i++)
//        scanf("%d", &wrong[i]);
//
//    sort(correct, correct + n);
//    sort(wrong, wrong + m);
//
//    int TL = correct[n - 1];
//
//    if(TL >= wrong[0]){
//        printf("%d", -1);
//        return 0;
//    }
//
//    for(; TL < wrong[0]; TL++){
//        if(2 * correct[0] <= TL){
//            printf("%d", TL);
//            return 0;
//        }
//    }
//
//    printf("%d", -1);
//}
