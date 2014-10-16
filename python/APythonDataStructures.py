__author__ = 'hujiawei'


def test_counter():
    import re
    from collections import Counter

    li = ["Dog", "Cat", "Mouse", "Dog", "Cat", "Dog"]
    a = Counter(li)
    print a  # Counter({'Dog': 3, 'Cat': 2, 'Mouse': 1})
    print "{0} : {1}".format(a.values(), a.keys())  # [1, 3, 2] : ['Mouse', 'Dog', 'Cat']
    print(a.most_common(3))  # [('Dog', 3), ('Cat', 2), ('Mouse', 1)]

    string = """   Lorem ipsum dolor sit amet, consectetur
        adipiscing elit. Nunc ut elit id mi ultricies
        adipiscing. Nulla facilisi. Praesent pulvinar,
        sapien vel feugiat vestibulum, nulla dui pretium orci,
        non ultricies elit lacus quis ante. Lorem ipsum dolor
        sit amet, consectetur adipiscing elit. Aliquam
        pretium ullamcorper urna quis iaculis. Etiam ac massa
        sed turpis tempor luctus. Curabitur sed nibh eu elit
        mollis congue. Praesent ipsum diam, consectetur vitae
        ornare a, aliquam a nunc. In id magna pellentesque
        tellus posuere adipiscing. Sed non mi metus, at lacinia
        augue. Sed magna nisi, ornare in mollis in, mollis
        sed nunc. Etiam at justo in leo congue mollis.
        Nullam in neque eget metus hendrerit scelerisque
        eu non enim. Ut malesuada lacus eu nulla bibendum
        id euismod urna sodales.  """

    words = re.findall(r'\w+', string)  #This finds words in the document

    lower_words = [word.lower() for word in words]  #lower all the words

    word_counts = Counter(lower_words)  #counts the number each time a word appears
    print word_counts


def test_deque():
    import time
    from collections import deque

    num = 100000

    def append(c):
        for i in range(num):
            c.append(i)

    def appendleft(c):
        if isinstance(c, deque):
            for i in range(num):
                c.appendleft(i)
        else:
            for i in range(num):
                c.insert(0, i)

    def pop(c):
        for i in range(num):
            c.pop()

    def popleft(c):
        if isinstance(c, deque):
            for i in range(num):
                c.popleft()
        else:
            for i in range(num):
                c.pop(0)

    for container in [deque, list]:
        for operation in [append, appendleft, pop, popleft]:
            c = container(range(num))
            start = time.time()
            operation(c)
            elapsed = time.time() - start
            print "Completed {0}/{1} in {2} seconds: {3} ops/sec".format(
                container.__name__, operation.__name__, elapsed, num / elapsed)


def test_defaultdict():
    from collections import defaultdict

    s = "the quick brown fox jumps over the lazy dog"
    words = s.split()
    location = defaultdict(list)
    for m, n in enumerate(words):
        # print('m='+str(m)+' n='+n)
        location[n].append(m)
    print location

    s = "the quick brown fox jumps over the lazy dog"
    d = {}
    words = s.split()
    for key, value in enumerate(words):
        d.setdefault(value, []).append(key)
    print d


import array


def arraytest():
    a = array.array("i", [1, 2, 3, 4, 5])
    b = array.array(a.typecode, (2 * x for x in a))


def enumeratetest():
    a = array.array("i", [1, 2, 3, 4, 5])
    for i, x in enumerate(a):
        a[i] = 2 * x


def test_array():
    from timeit import Timer

    m = Timer("arraytest()", "from __main__ import arraytest")
    n = Timer("enumeratetest()", "from __main__ import enumeratetest")

    print m.timeit()  # 5.22479210582
    print n.timeit()  # 4.34367196717


def test_heapq():
    import heapq

    portfolio = [
        {'name': 'IBM', 'shares': 100, 'price': 91.1},
        {'name': 'AAPL', 'shares': 50, 'price': 543.22},
        {'name': 'FB', 'shares': 200, 'price': 21.09},
        {'name': 'HPQ', 'shares': 35, 'price': 31.75},
        {'name': 'YHOO', 'shares': 45, 'price': 16.35},
        {'name': 'ACME', 'shares': 75, 'price': 115.65}
    ]
    cheap = heapq.nsmallest(3, portfolio, key=lambda s: s['price'])
    expensive = heapq.nlargest(3, portfolio, key=lambda s: s['price'])

    print cheap

    # [{'price': 16.35, 'name': 'YHOO', 'shares': 45},
    # {'price': 21.09, 'name': 'FB', 'shares': 200}, {'price': 31.75, 'name': 'HPQ', 'shares': 35}]

    print expensive

    # [{'price': 543.22, 'name': 'AAPL', 'shares': 50}, {'price': 115.65, 'name': 'ACME',
    # 'shares': 75}, {'price': 91.1, 'name': 'IBM', 'shares': 100}]


import heapq


class Item:
    def __init__(self, name):
        self.name = name

    def __repr__(self):
        return 'Item({!r})'.format(self.name)


class PriorityQueue:
    def __init__(self):
        self._queue = []
        self._index = 0

    def push(self, item, priority):
        heapq.heappush(self._queue, (-priority, self._index, item))
        self._index += 1

    def pop(self):
        return heapq.heappop(self._queue)[-1]


def test_heapq2():
    q = PriorityQueue()
    q.push(Item('foo'), 1)
    q.push(Item('bar'), 5)
    q.push(Item('spam'), 4)
    q.push(Item('grok'), 1)

    print q.pop()  # Item('bar')
    print q.pop()  # Item('spam')
    print q.pop()  # Item('foo')
    print q.pop()  # Item('grok')


def test_bisect():
    import bisect

    a = [(0, 100), (150, 220), (500, 1000)]

    bisect.insort_right(a, (250, 400))
    bisect.insort_right(a, (399, 450))
    print a  # [(0, 100), (150, 220), (250, 400), (500, 1000)]

    print bisect.bisect(a, (550, 1200))  # 5


def test_weakref():
    import weakref
    import gc

    class MyObject(object):
        def my_method(self):
            print 'my_method was called!'

    obj = MyObject()
    r = weakref.ref(obj)

    gc.collect()
    assert r() is obj  #r() allows you to access the object referenced: it's there.

    obj = 1  #Let's change what obj references to
    gc.collect()
    assert r() is None  #There is no object left: it was gc'ed.


def test_copy():
    import copy

    a = [1, 2, 3]
    b = [4, 5]
    c = [a, b]
    # Normal Assignment
    d = c
    print id(c) == id(d)  # True - d is the same object as c
    print id(c[0]) == id(d[0])  # True - d[0] is the same object as c[0]

    # Shallow Copy
    d = copy.copy(c)

    print id(c) == id(d)  # False - d is now a new object
    print id(c[0]) == id(d[0])  # True - d[0] is the same object as c[0]

    # Deep Copy
    d = copy.deepcopy(c)

    print id(c) == id(d)  # False - d is now a new object
    print id(c[0]) == id(d[0])  # False - d[0] is now a new object

def test_copy2():
    import weakref, copy

    class Graph(object):
        def __init__(self, manager=None):
            self.manager = None if manager is None else weakref.ref(manager)
        def __deepcopy__(self, memodict):
            manager = self.manager()
            return Graph(memodict.get(id(manager), manager))

    class Manager(object):
        def __init__(self, graphs=[]):
            self.graphs = graphs
            for g in self.graphs:
                g.manager = weakref.ref(self)

    a = Manager([Graph(), Graph()])
    b = copy.deepcopy(a)

    if [g.manager() is b for g in b.graphs]:
        print True # True

    if copy.deepcopy(a.graphs[0]).manager() is a:
        print True # True

def test_pprint():
    import pprint

    matrix = [ [1,2,3], [4,5,6], [7,8,9] ]
    a = pprint.PrettyPrinter(width=20)
    a.pprint(matrix)

if __name__ == '__main__':
    test_pprint()
