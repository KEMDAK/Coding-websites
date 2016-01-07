#include<bits/stdc++.h>

using namespace std;

int main(){
    while(true){
        int n, m;
        scanf("%d %d", &n, &m);

        if(n == 0 && m == 0)
            break;

        int seats[n];
        for(int i = 0; i < n; i++)
            seats[i] = i;

        int t1[m];
        int t2[m];
        int c[m];

        for(int i = 0; i < m; i++)
            scanf("%d %d %d", &t1[i], &t2[i], &c[i]);

        int res = 0;

        do{
            bool valid = true;
            for(int i = 0; i < m; i++){
                int teen1 = t1[i];
                int teen2 = t2[i];
                int dist = c[i];

                int t1p = 0;
                int t2p = 0;
                for(int j = 0; j < n; j++){
                    if(seats[j] == teen1)
                        t1p = j;
                    if(seats[j] == teen2)
                        t2p = j;
                }

                if(dist > 0){
                    if(!(abs(t1p - t2p) <= abs(dist))){
                        valid = false;
                        break;
                    }
                }
                else{
                    if(!(abs(t1p - t2p) >= abs(dist))){
                        valid = false;
                        break;
                    }
                }
            }

            if(valid)
                res++;
        }while(next_permutation(seats, seats + n));

        printf("%d\n", res);
    }
}
