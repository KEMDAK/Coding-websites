//#include<iostream>
//#include<string>
//
//using namespace std;
//
//int main(){
//    string s;
//    cin >> s;
//
//    int ab = -1;
//    int ba = -1;
//
//    int n = s.length();
//    for(int i = 0; i < n - 1; i++){
//        if(s[i] == 'A' && s[i + 1] == 'B'){
//            if(i + 2 < n && s[i + 2] == 'A'){
//                ab++;
//                if (ab == 2)
//                    ab = 1;
//                ba++;
//                if (ba == 2)
//                    ba = 1;
//                i+=2;
//            }
//            else {
//                ab = 1;
//                i++;
//            }
//        }
//        if(s[i] == 'B' && s[i + 1] == 'A'){
//            if(i + 2 < n && s[i + 2] == 'B'){
//                ab++;
//                if (ab == 2)
//                    ab = 1;
//                ba++;
//                if (ba == 2)
//                    ba = 1;
//                i+=2;
//            }
//            else {
//                ba = 1;
//                i++;
//            }
//        }
//    }
//
//    int ans = ab+ba;
//    if (ans > 0)
//        cout << "YES" << endl;
//    else
//        cout << "NO" << endl;
//}
