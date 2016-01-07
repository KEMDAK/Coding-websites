#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

int main(){
    int T;
    cin >> T;

    while(T-- > 0){
        string s1, s2;
        getline(cin, s1);
        getline(cin, s2);

        long int size = (s1.size() < s2.size())? s1.size() : s2.size();

        int bigger = (s1.size() < s2.size())? 1 : 2;

        long int c1 = 0;
        long int c2 = 0;

        string res;

        for(int i = 0; i < size; i++){
            if(s1[c1] < s2[c2]){
                res += s1[c1];
                c1++;
            }
            else{
                res += s2[c2];
                c2++;
            }
        }

        size = (bigger == 1)? s1.size() : s2.size();
        int c = (bigger == 1)? c1 : c2;

        for(; c < size; c++){
            if(bigger == 1)
                res += s1[c];
            else
                res += s2[c];
        }

        cout << res << endl;
    }
}
