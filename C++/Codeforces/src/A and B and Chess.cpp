#include<stdio.h>
#include<iostream>

using namespace std;

int main(){
    int white = 0, black = 0;

    for(int i = 0; i < 8; i++){
        char s[8];
        scanf("%s", &s);

        for(int j = 0; j < 8; j++){
            if(s[j] == '.' || s[j] == 'K' || s[j] == 'k') continue;

            if(s[j] == 'Q') white += 9;
            if(s[j] == 'R') white += 5;
            if(s[j] == 'B') white += 3;
            if(s[j] == 'N') white += 3;
            if(s[j] == 'P') white += 1;
            if(s[j] == 'q') black += 9;
            if(s[j] == 'r') black += 5;
            if(s[j] == 'b') black += 3;
            if(s[j] == 'n') black += 3;
            if(s[j] == 'p') black += 1;
        }
    }

    if(white > black)
        printf("White");
    else if (black > white)
        printf("Black");
    else
        printf("Draw");
}
