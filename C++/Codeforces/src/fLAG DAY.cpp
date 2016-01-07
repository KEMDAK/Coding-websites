#include <bits/stdc++.h>

using namespace std;

int main(){
    int n, m;
    scanf("%d %d", &n, &m);

    int dependsOn[n];
    int colors[n];

    for(int i = 0; i < n; i++)
        dependsOn[i] = -1;

    for(int i = 0; i < n; i++)
        colors[i] = 0;

    for(int i = 0; i < m; i++){
        int a, b, c;
        scanf("%d %d %d", &a, &b, &c);

        dependsOn[b - 1] = a - 1;
        dependsOn[c - 1] = b - 1;
    }

    for(int i = 0; i < n; i++){
        printf("%d ", dependsOn[i]);
    }
    printf("\n");

    for(int i = 0; i < n; i++){
        if(dependsOn[i] == -1)
            colors[i] = 1;
    }

    for(int i = 0; i < n; i++){
        int cur = i;
        int d = 0;

        while(colors[cur] == 0 && dependsOn[cur] != -1){
            cur = dependsOn[cur];
            d++;
        }

        colors[i] = colors[cur] + d;

        if(colors[i] > 3)
            colors[i] -= 3;
    }

    for(int i = 0; i < n; i++)
        printf("%d ", colors[i]);

}
