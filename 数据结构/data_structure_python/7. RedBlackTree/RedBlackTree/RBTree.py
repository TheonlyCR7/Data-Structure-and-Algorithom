
RED = True
BLACK = False

class RBTree():
    class Node():
        value, left, right = None
        color = RED
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.left = None
            self.right = None
            self.color = RED

    def __init__(self):
        self._root = None
        self._size = 0

    def get_size(self):
        return self._size

    def is_empty(self):
        return self._size == 0

    def is_red(self, node):
        if node == None:
            return BLACK
        return node.color




