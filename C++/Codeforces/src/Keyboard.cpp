//#include<iostream>
//#include<string>
//
//using namespace std;
//
//int main(){
//    string keyboard = "qwertyuiopasdfghjkl;zxcvbnm,./";
//
//    char shift;
//    cin >> shift;
//
//    string input;
//    cin >> input;
//
//    string output = "";
//
//    for(int i = 0; i < input.size(); i++){
//        char cur = input[i];
//        int index = 0;
//
//        for(int j = 0; j < keyboard.size(); j++){
//            if(keyboard[j] == cur){
//                index = j;
//                break;
//            }
//        }
//
//        output += (shift == 'R') ? keyboard[index - 1] : keyboard[index + 1];
//    }
//
//    cout << output;
//}
