
class array():

    def __init__(self, arr = None, capacity = 10):
        if isinstance(arr, list):
            self._data = arr[:]
            self._size = len(arr)

        self._data = [None] * capacity
        self._size = 0
        self._capacity = capacity

    def get_size(self):
        return self._size

    def get_capacity(self):
        return self._capacity

    def is_empty(self):
        return self._size == 0

    def add_last(self, value):
        self.add_index(self._size, value)

    def add_first(self, value):
        self.add_index(0, value)

    def find_value_index(self, value):
        for i in range(0, len(self._data)):
            if(self._data[i] == value):
                return i
        return -1

    def replace(self, index, value):
        if index < 0 or index >= len(self._data) - 1:
            raise ValueError(
                "replace is failed index is not illegal. "
            )
        self._data[index] = value
        self._size += 1

    def get_index_value(self, index):
        if index < 0 or index >= len(self._data) - 1:
            raise ValueError(
                "get_index_value is failed index is not illegal. "
            )
        return self._data[index]

    # 删除指定索引所在元素
    def delete_index(self, index):
        if index < 0 or index >= len(self._data) - 1:
            raise ValueError(
                "delete is failed index is not illegal. "
            )
        for i in range(index, len(self._data) - 1):
            self._data[i] = self._data[i + 1]
        self._size -= 1

    # 删除指定元素
    def delete_value(self, value):
        for i in range(0, len(self._data) - 1):
            if self._data[i] == value:
                for i in range(i, len(self._data) - 1):
                    self._data[i] = self._data[i + 1]
                self._size -= 1
                if self._size < self._capacity / 2:
                    self._data = self.trends_capacity(len(self._data) / 2)

        return "delete_value is failed. value is not exist."

    # 在指定位置添加元素
    def add_index(self, index, value):
        if index < 0 or index > len(self._data) - 1:
            raise ValueError(
                "add_index is failed index is not illegal. "
            )
        if(self._size == len(self._data)):
            self._data = self.trends_capacity(2 * len(self._data))

        for i in range(self._size, index - 1, -1):
            #print(self._data)
            self._data[i + 1] = self._data[i]
        self._data[index] = value
        self._size += 1

    # 实现动态容量   扩容 缩容
    def trends_capacity(self, new_capacity):
        new_data = [None] * new_capacity
        self._capacity = len(new_data)
        for i in range(0, len(self._data) - 1):
            new_data[i] = self._data[i]
        return new_data

    # 将数组以字符串的形式打印输出
    def __str__(self):
        return str('<chapter_02_Array.array.Array> : {},'
                   ' capacity: {}' ' size: {}'.format(self._data[:self._size], self.get_capacity(), self.get_size()))

    def __repr__(self):
        return self.__str__()