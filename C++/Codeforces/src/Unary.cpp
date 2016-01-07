//#include<iostream>
//#include<string>
//#include<stdio.h>
//#define MOD 1000003
//
//using namespace std;
//
//int power(int base,int p)
//{
//    if (p == 0)
//        return 1;
//    return (base*power(base,p-1))%MOD;
//}
//
//string getbin(char c)
//{
//    switch(c)
//    {
//        case '>': return "1000";
//        case '<': return "1001";
//        case '+': return "1010";
//        case '-': return "1011";
//        case '.': return "1100";
//        case ',': return "1101";
//        case '[': return "1110";
//        case ']': return "1111";
//    }
//}
//
//int main()
//{
//    string line;
//    cin >> line;
//
//    int count = 0;
//    int prev = -1;
//    for(int i = line.length()-1; i >=0; i--)
//    {
//        string temp = getbin(line[i]);
//        for(int j = 3; j >= 0; j--)
//        {
//            if (temp[j] == '1') {
//                int num = power(2,count)%MOD;
//                if (prev != -1)
//                    num = (num + prev)%MOD;
//                prev = num;
//
//            }
//            count++;
//        }
//    }
//    printf("%i",prev);
//}
//
//
