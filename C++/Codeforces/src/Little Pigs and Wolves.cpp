//#include<stdio.h>
//
//int dx[] = {-1,0,1,0};
//int dy[] = {0,1,0,-1};
//
//int main(){
//    int n, m;
//    scanf("%d %d", &n, &m);
//
//    char map[n][m];
//
//    for(int i = 0; i < n; i++){
//        char s[m];
//        scanf("%s", &s);
//        for(int j = 0; j < m; j++){
//            map[i][j] = s[j];
//        }
//    }
//
//    int res = 0;
//
//    for(int i = 0; i < n; i++){
//        for(int j = 0; j < m; j++){
//            if(map[i][j] == 'W'){
//                for(int k = 0; k < 4; k++){
//                    int newI = i + dx[k];
//                    int newJ = j + dy[k];
//
//                    if(newI >= 0 && newI < n && newJ >= 0 && newJ < m && map[newI][newJ] == 'P'){
//                        map[i][j] = '.';
//                        map[newI][newJ] = '.';
//                        res++;
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//    printf("%d", res);
//}
