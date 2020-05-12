import random
from time import time

from Unionfind1 import UnionFind

def test_UF(uf, m):

    size = uf.get_size()
    start_time = time()

    for _ in range(m):
        a = random.randint(0, size - 1)
        b = random.randint(0, size - 1)
        uf.union_elements(a, b)

    end_time = time()
    return (end_time - start_time)

if __name__ == '__main__':
    m = 10000
    size = 100000

    uf = UnionFind.Union__Find(size)
    print(test_UF(uf, m))



