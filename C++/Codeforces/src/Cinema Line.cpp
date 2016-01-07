//#include<stdio.h>
//
//int main(){
//    int n;
//    scanf("%d", &n);
//
//    int money[2];
//
//    for(int i = 0; i < 2; i++)
//        money[i] = 0;
//
//    for(int i = 0; i < n; i++){
//        int bill;
//        scanf("%d", &bill);
//
//        if(bill == 25)
//            money[0]++;
//        else if(bill == 50){
//            money[1]++;
//
//            if(money[0] > 0)
//                money[0]--;
//            else{
//                printf("NO");
//                return 0;
//            }
//        }
//        else{
//            if(money[0] > 0 && money[1] > 0){
//                money[0]--;
//                money[1]--;
//            }
//            else if (money[0] > 2) {
//                money[0] -= 3;
//            }
//            else{
//                printf("NO");
//                return 0;
//            }
//        }
//    }
//
//    printf("YES");
//}
