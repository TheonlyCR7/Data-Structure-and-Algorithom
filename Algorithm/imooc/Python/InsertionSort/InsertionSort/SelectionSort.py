
import time
import random

def selection_sort(arr, n):
    for i in range(0, n):
        min_index = i
        j = i + 1
        for j in range(i+1, n):
            if (arr[j] < arr[min_index]):
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]


if __name__ == "__main__":
    n = 1000
    arr1 = [None] * n  # 定义给定长度的空数组
    arr2 = [None] * n  # 定义给定长度的空数组
    for i in range(n):
        arr1[i] = random.randint(0, n)
        arr2[i] = random.randint(0, n)

    time_start = time.time()
    selection_sort(arr1, n)
    print("selection_sort_method1: " + str(time.time() - time_start))

