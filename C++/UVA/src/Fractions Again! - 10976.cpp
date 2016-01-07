//#include<stdio.h>
//#include<iostream>
//#include<string>
//#include<sstream>
//
//#define SSTR( x ) dynamic_cast< std::ostringstream & >( \
//        ( std::ostringstream() << std::dec << x ) ).str()
//
//using namespace std;
//
//int main(){
//    int k;
//
//    while(cin >> k){
//        int y = k + 1;
//
//        int counter = 1;
//
//        int size = 0;
//
//        string res = "";
//
//        int x = (y * k) / counter;
//
//        while(y <= 2 * k){
//            x = (y * k) / counter;
//
//            if((k * y) % counter == 0){
////                printf("1/%d = 1/%d + 1/%d", k, x, y);
//                res = res + "1/" + SSTR(k) + " = " + "1/" + SSTR(x) + " + " + "1/" + SSTR(y) + "\n";
//                size++;
//            }
//
//            counter++;
//            y++;
//        }
//
//        cout << size << endl << res;
//    }
//}
