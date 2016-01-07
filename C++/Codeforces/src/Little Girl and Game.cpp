//#include<iostream>
//#include<string>
//
//using namespace std;
//
//int main(){
//    string s;
//    cin >> s;
//
//    int occ[26];
//
//    for(int i = 0; i < 26; i++)
//        occ[i] = 0;
//
//    for(int i = 0; i < s.size(); i++)
//        occ[s[i] - 'a']++;
//
//    int odds = 0;
//
//    for(int i = 0; i < 26; i++){
//        if(occ[i] % 2 == 1)
//            odds++;
//    }
//
//    if(odds % 2 == 1 || odds == 0)
//        cout << "First";
//    else if(odds % 2 == 0)
//        cout << "Second";
//}
