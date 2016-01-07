//#include<stdio.h>
//
//int main(){
//    int n;
//
//    scanf("%d", &n);
//
//    int holds[n];
//
//    for(int i = 0; i < n; i++){
//        scanf("%d", &holds[i]);
//    }
//
//    int min = 3000;
//
//    for(int i = 1; i < n - 1; i++){
//            int max = -1;
//        for(int j = 0; j < n - 1; j++){
//            if(j == i)
//                continue;
//            if(j + 1 != i){
//                if(holds[j + 1] - holds[j] > max)
//                    max = holds[j + 1] - holds[j];
//            }
//            else{
//                if(holds[j + 2] - holds[j] > max)
//                    max = holds[j + 2] - holds[j];
//            }
//        }
//
//        if (max < min && max != -1)
//            min = max;
//    }
//
//    printf("%d", min);
//}
