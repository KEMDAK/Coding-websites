//#include<stdio.h>
//#include<string>
//#include<iostream>
//
//using namespace std;
//
//int main(){
//    int n, m;
//    scanf("%d %d", &n, &m);
//
//    int book[n][m];
//
//    for(int i = 0; i < n; i++){
//        string s;
//        cin >> s;
//        for(int j = 0; j < m; j++)
//            book[i][j] = s[j] - '0';
//    }
//
//    int max[m];
//
//    for(int j = 0; j < m; j++){
//        int tempMax = book[0][j];
//        for(int i = 1; i < n; i++){
//            if(book[i][j] > tempMax)
//                tempMax = book[i][j];
//        }
//        max[j] = tempMax;
//    }
//
//    int res = 0;
//
//    for(int i = 0; i < n; i++){
//        for(int j = 0; j < m; j++){
//            if(book[i][j] == max[j]){
//                res++;
//                break;
//            }
//        }
//    }
//
//    printf("%d", res);
//}
