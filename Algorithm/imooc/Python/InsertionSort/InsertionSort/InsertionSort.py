import random
import time


def selection_sort(arr, n):
    for i in range(0, n):
        min_index = i
        j = i + 1
        for j in range(i+1, n):
            if (arr[j] < arr[min_index]):
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]
    return arr

def insertionSort1(arr, n):
    for i in range(n):
        j = i
        while j > 0 and arr[j - 1]:
            if (arr[j] < arr[j - 1]):
                arr[j], arr[j - 1] = arr[j - 1], arr[j]
                j -= 1
            else:
                break
    return arr

def insertionSort2(arr, n):
    for i in range(n):
        e = arr[i]
        j = i
        while j > 0 and arr[j - 1] > e:
            arr[j] = arr[j - 1]
            j -= 1
        arr[j] = e
    return arr

def bubble_sort(arr, n):
        for i in range(1, len(arr)):
            for j in range(0, len(arr) - i):
                if arr[j] > arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]
        return arr

def shell_sort(arr, n):
    gap = n / 5
    

if __name__ == '__main__':
    n = 1000
    arr1  = [None] * n   # 定义给定长度的空数组
    arr2 = [None] * n
    arr3 = [None] * n
    arr4 = [None] * n

    for i in range(n):
        arr1[i] = random.randint(0, n*10)
        arr2[i] = random.randint(0, n*10)
        arr3[i] = random.randint(0, n*10)
        arr4[i] = random.randint(0, n*10)

    time_start = time.time()
    print(insertionSort1(arr1, n))
    print("insertionSort_method1: " + str(time.time() - time_start) + " s")

    time_start = time.time()
    print(insertionSort2(arr2, n))
    print("insertionSort_method2: " + str(time.time() - time_start) + " s")

    time_start = time.time()
    print(selection_sort(arr3, n))
    print("selection_sort_method: " + str(time.time() - time_start) + " s")
    print(arr4)
    time_start = time.time()
    print(bubble_sort(arr4, n))
    print("bubble_sort_method: " + str(time.time() - time_start) + " s")
