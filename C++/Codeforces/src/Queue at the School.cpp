//#include<iostream>
//#include<string>
//
//using namespace std;
//
//int main(){
//    int n, t;
//    cin >> n >> t;
//
//    string s = "";
//    cin >> s;
//
//    int queue[n];
//
//    for(int i = 0; i < n; i++){
//        if(s[i] == 'B')
//            queue[i] = 1;
//        else
//            queue[i] = 0;
//    }
//
//    for(int j = 0; j < t; j++){
//        for(int i = 0; i < n - 1; i++){
//            if(queue[i] == 1 && queue[i + 1] == 0){
//                queue[i] = 0;
//                queue[i + 1] = 1;
//                i++;
//            }
//        }
//    }
//
//    string res = "";
//
//    for(int i = 0; i < n; i++){
//        if(queue[i] == 1)
//            res += 'B';
//        else
//            res += 'G';
//    }
//
//    cout << res << endl;
//}
