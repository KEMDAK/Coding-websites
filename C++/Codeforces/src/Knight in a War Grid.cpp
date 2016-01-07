//#include<stdio.h>
//#include<string>
//#include<iostream>
//#include<sstream>
//
//using namespace std;
//
//int R, C;
//
//bool valid(int i, int j){
//    return (i >= 0 && i < R && j >= 0 && j < C);
//}
//
//int main(){
//    int T;
//    scanf("%d", &T);
//
//    ostringstream output;
//
//    for(int cas = 1; cas <= T; cas++){
//        int M, N, W;
//        scanf("%d %d %d %d", &R, &C, &M, &N);
//
//        scanf("%d", &W);
//
//        long int field[R][C];
//
//        for(int i = 0; i < R; i++)
//            for(int j = 0; j < C; j++)
//                field[i][j] = 0;
//
//        for(int i = 0; i < W; i++){
//            int x, y;
//            scanf("%d %d", &x, &y);
//
//            field[x][y] = -1;
//        }
//
//        int even = 0;
//        int odd = 0;
//
//        for(int i = 0; i < R; i++){
//            for(int j = 0; j < C; j++){
//                if(field[i][j] != -1){
//                    int counter = 0;
//                    for(int l = -1; l < 2; l = l + 2){
//                        int a = i;
//                        for(int k = -1; k < 2; k = k + 2){
//                                int b = j ;
//
//                                int c = a + (N * l);
//                                int d = b + (M * k);
//
//                                if(valid(c, d) && field[c][d] != -1)
//                                    counter++;
//                        }
//                    }
//
//                    for(int l = -1; l < 2; l = l + 2){
//                        int a = i;
//                        for(int k = -1; k < 2; k = k + 2){
//                                int b = j ;
//
//                                int c = a + (M * l);
//                                int d = b + (N * k);
//
//                                if(valid(c, d) && field[c][d] != -1)
//                                    counter++;
//                        }
//                    }
//                    if(counter != 0){
//                        if(counter % 2 == 0 )
//                            even++;
//                        else
//                            odd++;
//                    }
//                }
//            }
//        }
//
//        if(cas < T)
//            output << "Case " <<  cas  << ": " << even << " " << odd << "\n";
//        else
//            output << "Case " <<  cas  << ": " << even << " " << odd;
//    }
//
//    cout << output.str();
//}
//
//
