//#include<string>
//#include<iostream>
//
//using namespace std;
//
//int main(){
//    string s;
//    int k;
//
//    cin >> s >> k;
//
//    int max = 0;
//
//    int ws[26];
//
//    for(int i = 0; i < 26; i++){
//        int w;
//
//        cin >> w;
//
//        ws[i] = w;
//
//        if(w > max)
//            max = w;
//    }
//
//    long int res = 0;
//
//    for(int i = 0; i < s.size(); i++){
//        char c = s[i];
//
//        res += ws[c - 'a'] * (i + 1);
//    }
//
//    for(int i = s.size() + 1; i <= k + s.size(); i++)
//        res += i * max;
//
//    cout << res << endl;
//}
