#include <iostream>
#include <algorithm>
#include <string>
#include "Student.h"
#include "SortTestHelper.h";
using namespace std;

// 泛型
template <typename T>
void selectionSort(T arr[], int n){

    for(int i = 0 ; i < n ; i ++){
        // 寻找[i, n)区间里的最小值
        int minIndex = i;
        for( int j = i + 1 ; j < n ; j ++ )
            if( arr[j] < arr[minIndex] )
                minIndex = j;

        swap( arr[i] , arr[minIndex] );
    }
}

int main() {

    int a[10] = {10,9,8,7,6,5,4,3,2,1};
    selectionSort(a,10);
    for( int i = 0 ; i < 10 ; i ++ )
        cout<<a[i]<<" ";
    cout<<endl;

    Student d[4] = {{"d", 90},
                    {"c", 100},
                    {"b", 95},
                    {"a", 95}};
    for(int i = 0; i < 4; i ++)
        cout<<d[i];
    cout<<endl;

    int n = 100000;
    int *arr = SortTestHelper::generateRandomArray(n, 0, n);
//    selectionSort(arr, n);
//    SortTestHelper::printArray(arr, n);
    SortTestHelper::testSort("Selection Sort", selectionSort, arr, n);
    for(int i = 0; i < n; i ++)
        cout<<d[i]<<" ";
    cout<<endl;

    // 释放空间
    delete[] arr;

    system("pause");
    return 0;
}