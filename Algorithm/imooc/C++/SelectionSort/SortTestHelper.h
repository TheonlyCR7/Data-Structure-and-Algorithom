//
// Created by just it on 2020/5/7.
//

#ifndef SELECTIONSORT_SORTTESTHELPER_H
#define SELECTIONSORT_SORTTESTHELPER_H

#include <ostream>
#include <cassert>
#include <assert.h>

using namespace std;

namespace SortTestHelper{
    // 生成有 n 个元素的随机数组，每个元素的随即范围为[rangel, rangeR]
    int* generateRandomArray(int n, int rangel, int rangeR){

        assert( rangel <= rangeR);
        int *arr = new int[n];
        srand(time(NULL));
        for(int i = 0; i < n; i ++)
            // 随机数
            arr[i] = rand() % (rangeR - rangel + 1) + rangel;
        return arr;
    }

    template<typename T>
    void printArray(T arr[], int n){
        for (int i = 0; i < n; i++)
            cout << arr[i] << " ";
        cout << endl;   // 回车
        return;
    }

    // 判断数组是否有序
    template <typename T>
    bool isSorted(T arr[], int n){
        for(int i = 0; i < n - 1; i ++)
            if(arr[i] > arr[i + 1])
                return false;
        return true;
    }

    // 时间
    template<typename T>
    void testSort(string sortName, void(*sort)(T[], int), T arr[], int n){
        clock_t startTime = clock();
        sort(arr, n);
        clock_t endTime = clock();
        cout << sortName << ": " << double(endTime - startTime) / CLOCKS_PER_SEC << " s" << endl;
    }

}
#endif //SELECTIONSORT_SORTTESTHELPER_H
