//#include<stdio.h>
//#include<cmath>
//
//int main(){
//    int t;
//    scanf("%d", &t);
//
//    while(t-- > 0){
//        int l, r;
//        scanf("%d %d", &l, &r);
//
//        int sqrtR = sqrt(r) + 1;
//
//        if(sqrtR <= l){
//            bool Sprimes[sqrtR];
//            for(int i = 0; i < sqrtR; i++)
//                Sprimes[i] = true;
//            Sprimes[0] = Sprimes[1] = false;
//
//            bool primes[r - l + 1];
//            for(int i = 0; i < r - l + 1; i++)
//                primes[i] = true;
//
//            for(int i = 2; i * i <= sqrtR; i++){
//                if(Sprimes[i]){
//                    for(int m = i ; i * m < sqrtR; m++){
//                        Sprimes[i * m] = false;
//                    }
//                }
//            }
//
//            for(int i = 2; i < sqrtR; i++){
//                if(Sprimes[i]){
//                    int m = (l / i) * i;
//
//                    if(m < l)
//                        m += i;
//
//                    for(; m <= r; m += i){
//                        primes[m - l] = false;
//                    }
//                }
//            }
//
//            for(int i = 0; i < r - l + 1; i++){
//                if(primes[i])
//                    printf("%d\n", i + l);
//            }
//        }
//        else{
//            int size = ((r + 1) / 64) + 1;
//            long long primes[size];
//            for(int i = 0; i < size; i++)
//                primes[i] = 0;
//            primes[0] = primes[0] | (1 << 0);
//            primes[0] = primes[0] | (1 << 1);
//
//            for(int i = 2; i * i <= r; i++){
//                int index = i / 64;
//                int bit = i % 64;
//
//                if((primes[index] & ((long long) 1 << bit)) == 0){
//                    for(int m = i; i * m <= r; m++){
//                        index = (i * m) / 64;
//                        bit = (i * m) % 64;
//
//                        primes[index] = primes[index] | ((long long) 1 << bit);
//                    }
//                }
//
//            }
//
//            for(int i = l; i <= r; i++){
//                int index = i / 64;
//                int bit = i % 64;
//
//                if((primes[index] & ((long long) 1 << bit)) == 0){
//                    printf("%d\n", i);
//                }
//            }
//        }
//
//        printf("\n");
//    }
//}
