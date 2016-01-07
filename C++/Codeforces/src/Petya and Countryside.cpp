#include <bits/stdc++.h>

using namespace std;

int main(){
    int n;
    scanf("%d", &n);

    int garden[n];

    for(int i = 0; i < n; i++)
        scanf("%d", &garden[i]);

    int maximum = 0;

    for(int i = 0; i < n; i++){
        int j, k;
        j = i - 1;
        k = i + 1;
        int c = 1;

        while(j >= 0 && garden[j] <= garden[j + 1]){
            j--;
            c++;
        }

        while(k < n && garden[k] <= garden[k - 1]){
            k++;
            c++;
        }

        if(maximum < c)
            maximum = c;
    }

    printf("%d", maximum);
}

