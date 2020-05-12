#  Python  复现 UnionFind  并查集

# 导入模块 UF
from Unionfind1.base import UF

class Union__Find(UF):
    def __init__(self, size):
        # 私有变量
        self._id = [i for i in range(size)]
        self._rank = [i for i in range(size)]

        for i in range(size):
            self._id[i] = i
            self._rank[i] = 1

    def get_size(self):
        return len(self._id)

    def find(self, p):
        if(p < 0 or p >= len(self._id)):
            # 抛出异常
            raise ValueError('p is out of bound.')

    def is_connected(self, p, q):
        return self.find(p) == self.find(q)

    def union_elements(self, p, q):

        pRoot = self.find(p)
        qRoot = self.find(q)

        if(pRoot == qRoot):
            return

        if(self._rank[pRoot] < self._rank[qRoot]):
            self._id[pRoot] = qRoot
            self._rank[qRoot] += self._rank[pRoot]
        elif(self._rank[pRoot] > self._rank[qRoot]):
            self._id[qRoot] = pRoot
            self._rank[pRoot] += self._rank[qRoot]
        else:
            self._rank[qRoot] = pRoot
            self._rank[pRoot] += 1
