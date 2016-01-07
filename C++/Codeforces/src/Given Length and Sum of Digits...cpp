#include <bits/stdc++.h>

using namespace std;

bool can (int m, int s){
    return s >= 0 && s <= m * 9;
}

int main(){
    int m, s;
    scanf("%d %d", &m, &s);

    if(!can(m, s)){
        printf("-1 -1");
        return 0;
    }

    string minimum = "";
    string maximum = "";

    int sum = s;
    for(int i = 1; i <= m; i++){
        for(int j = 0; j < 10; j++){
            if((i > 1 || j > 0 || (m == 1 && j == 0)) && can(m - i, sum - j)){
                minimum += (j + '0');
                sum -= j;
                break;
            }
        }
    }

    sum = s;
    for(int i = 1; i <= m; i++){
        for(int j = 9; j > -1; j--){
            if((i > 1 || j > 0 || (m == 1 && j == 0)) && can(m - i, sum - j)){
                maximum += (j + '0');
                sum -= j;
                break;
            }
        }
    }

    if(maximum.length() != m || minimum.length() != m){
        printf("-1 -1");
        return 0;
    }

    cout << minimum << " " << maximum << endl;
}
