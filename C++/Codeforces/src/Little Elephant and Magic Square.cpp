//#include<stdio.h>
//
//int main(){
//    int max = -1;
//
//    int square[3][3];
//
//    for(int i = 0; i < 3; i++){
//        int sum = 0;
//        for(int j = 0; j < 3; j++){
//            int num;
//            scanf("%d", &num);
//
//            square[i][j] = num;
//
//            if(j != i)
//                sum += num;
//        }
//
//        if(sum > max)
//            max = sum;
//    }
//
//    max++;
//
//    for(int i = 0; i < 3; i++){
//        int sum = 0;
//        for(int j = 0; j < 3; j++){
//            if(i != j)
//                sum += square[i][j];
//        }
//
//        square[i][i] = max - sum;
//    }
//
//    int sum = square[0][0] + square[1][1] + square[2][2];
//
//    int i = 0;
//
//    while(sum != max){
//        sum +=3;
//        max++;
//        i++;
//    }
//
//    square[0][0] += i;
//    square[1][1] += i;
//    square[2][2] += i;
//
//    for(int i = 0; i < 3; i++){
//        for(int j = 0; j < 3; j++){
//            printf("%d ", square[i][j]);
//        }
//        printf("\n");
//    }
//}
