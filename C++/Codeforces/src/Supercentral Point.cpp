//#include<stdio.h>
//#include<algorithm>
//
//using namespace std;
//
//int main(){
//    int n;
//    scanf("%d", &n);
//
//    pair<int, int> points[n];
//
//    for(int i = 0; i < n; i++){
//        int x, y;
//        scanf("%d %d", &x, &y);
//
//        points[i] = make_pair(x, y);
//    }
//
//    int res = 0;
//
//    for(int i = 0; i < n; i++){
//        bool up, down, left, right;
//        up = down = left = right = false;
//
//        for(int j = 0; j < n; j++){
//            if(j != i){
//                if(points[j].first > points[i].first && points[j].second == points[i].second)
//                    right = true;
//                else if(points[j].first < points[i].first && points[j].second == points[i].second)
//                    left = true;
//                else if(points[j].first == points[i].first && points[j].second < points[i].second)
//                    down = true;
//                else if(points[j].first == points[i].first && points[j].second > points[i].second)
//                    up = true;
//            }
//        }
//
//        if(up && down && left && right)
//            res++;
//    }
//
//    printf("%d", res);
//}
