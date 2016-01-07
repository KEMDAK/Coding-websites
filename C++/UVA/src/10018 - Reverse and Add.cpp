//#include<bits/stdc++.h>
//
//using namespace std;
//
//long pow(int x, int p){
//    if(p == 0)
//        return 1;
//
//    return x * pow(x, p - 1);
//}
//
//int main(){
//    int N;
//    scanf("%d", &N);
//
//    while(N--){
//        long long P;
//        cin >> P;
//
//        int i = 0;
//
//        while(true){
//            long long temp = P;
//            long long rev = 0;
//
//            int power = -1;
//
//            while(temp != 0){
//                temp /= 10;
//                power++;
//            }
//
//            temp = P;
//
//            while(temp != 0){
//                rev += (temp % 10) * pow(10, power);
//                temp /= 10;
//                power--;
//            }
//
//            if(P == rev && i > 0)
//                break;
//
//            P += rev;
//            i++;
//        }
//
//        cout << i << " " << P << endl;
//    }
//}
