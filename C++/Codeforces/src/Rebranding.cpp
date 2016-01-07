//#include<algorithm>
//#include<stdio.h>
//#include<iostream>
//
//using namespace std;
//
//int main()
//{
//    int n,m;
//    scanf("%i %i",&n,&m);
//
//    char s[n];
//    scanf("%s",&s);
//
//    char arr[26];
//
//    for(int i = 0; i < 26; i++)
//        arr[i] = '*';
//
//    while(m--)
//    {
//        char x,y;
//        cin >> x >> y;
//
//        int index = x - 'a';
//        char temp = ' ';
//        while(true)
//        {
//            if (arr[index] == '*' || arr[index] == x)
//            {
//                temp = arr[index];
//                arr[index] = y;
//                break;
//            }
//            index = arr[index] - 'a';
//        }
//
//        arr[index] = temp;
//        int index2 = y - 'a';
//        while(true)
//        {
//            if (arr[index2] == '*' || arr[index2] == y)
//            {
//                arr[index2] = x;
//                break;
//            }
//            index2 = arr[index2] - 'a';
//        }
//        arr[index] = y;
//    }
//
//    for(int i = 0; i < n; i++)
//    {
//        char res;
//        if (arr[s[i]-'a'] != '*')
//            res = arr[s[i]-'a'];
//        else
//            res = s[i];
//        printf("%c",res);
//    }
//}
