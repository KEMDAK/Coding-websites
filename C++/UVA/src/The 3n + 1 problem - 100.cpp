//#include<stdio.h>
//
//int main(){
//    int i, j;
//
//    while(scanf("%d %d", &i, &j) != EOF){
//
//        printf("%d %d ", i, j);
//
//        if (i > j){
//            int temp = j;
//            j = i;
//            i = temp;
//        }
//
//        int max = 0;
//
//        while(i <= j){
//            int count = 0;
//
//            int n = i;
//
//            while(true){
//                count++;
//
//                if(n == 1)
//                    break;
//
//                if(n % 2 == 1)
//                    n = 3 * n + 1;
//                else
//                    n = n / 2;
//            }
//
//            if(count > max)
//                max = count;
//
//            i++;
//        }
//
//         printf("%d\n", max);
//    }
//}
