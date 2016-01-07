//#include<iostream>
//#include<string>
//
//using namespace std;
//
//int main(){
//    string a, b;
//    cin >> a;
//    cin >> b;
//
//    int size = b.size();
//    int j = 0;
//
//    if(size > a.size()){
//        cout << "need tree";
//        return 0;
//    }
//
//    for(int i = 0; i < a.size(); i++){
//        if(a[i] == b[j])
//            j++;
//        if(j == size){
//            cout << "automaton";
//            return 0;
//        }
//    }
//
//    bool array = true;
//
//    for(int i = 0; i < size; i++){
//        for(j = 0; j < a.size(); j++){
//            if(b[i] == a[j]){
//                a[j] = '*';
//                break;
//            }
//        }
//
//        if(j == a.size()){
//            array = false;
//            break;
//        }
//    }
//
//    if(!array)
//        cout << "need tree";
//    else if(a.size() == size)
//        cout << "array";
//    else
//        cout << "both";
//}
