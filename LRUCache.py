# Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
#
# get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
# set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

#

class LRUCache:

    # @param capacity, an integer
    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0
        self.contents = {}
        self.lru = []

    # @return an integer
    def get(self, key):
        if key not in self.contents: return -1
        else: self.lru.remove(key); self.lru.append(key)
        return self.contents[key]

    # @param key, an integer
    # @param value, an integer
    # @return nothing
    def set(self, key, value):
        if key in self.contents:
            self.contents[key]=value
            self.lru.remove(key);
            self.lru.append(key)
        else: #not exist the key
            self.size = self.size + 1
            self.contents[key]=value
            self.lru.append(key)
            if self.size > self.capacity:#remove one
                dk = self.lru.pop(0)
                del self.contents[dk]
                self.size = self.capacity

if __name__ == '__main__': #2,[set(2,1),set(1,1),set(2,3),set(4,1),get(1),get(2)]
    cache = LRUCache(2)
    cache.set(2,1)
    cache.set(1,1)
    cache.set(2,3)
    cache.set(4,1)
    print cache.get(1)
    print cache.get(2)
