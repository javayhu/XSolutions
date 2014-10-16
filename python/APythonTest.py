# # coding=utf-8
# import os
# def tree(top):
#     #path,folder list,file list
#     for path, names, fnames in os.walk(top):
#         for fname in fnames:
#             yield os.path.join(path, fname)
#
# for name in tree(os.getcwd()):
#     print name
#
# import time
# from functools import wraps
#
# def timethis(func):
#     '''
#     Decorator that reports the execution time.
#     '''
#     @wraps(func)
#     def wrapper(*args, **kwargs):
#         start = time.time()
#         result = func(*args, **kwargs)
#         end = time.time()
#         print(func.__name__, end-start)
#         return result
#     return wrapper
#
# @timethis
# def countdown(n):
#     while n > 0:
#         n -= 1
#
# countdown(100000)
#
# class demo(object):
#     pass
#
# obj = demo()
#
# print "Class of obj is {0}".format(obj.__class__)
# print "Class of obj is {0}".format(demo.__class__)
# # Class of obj is <class '__main__.demo'>
# # Class of obj is <type 'type'>
# # print(obj.__metaclass__) #
#
# def temp(x):
#     return x+2
#
# print(temp.func_code)
#
# import dis
# print([ord(b) for b in temp.func_code.co_code])
# dis.dis(temp.func_code)
#
# #写一个程序，打印数字1到100，3的倍数打印“Fizz”来替换这个数，5的倍数打印“Buzz”，
# #对于既是3的倍数又是5的倍数的数字打印“FizzBuzz”。
# for x in range(101):
#     #4 is string length
#     print "fizz"[x%3*4::]+"buzz"[x%5*4::] or x
#
# class decorator(object):
#
#     def __init__(self, f):
#         print("inside decorator.__init__()")
#         # f() # Prove that function definition has completed
#         self.f=f
#
#     def __call__(self):
#         print("inside decorator.__call__() begin")
#         self.f()
#         print("inside decorator.__call__() end")
#
# @decorator
# def function():
#     print("inside function()")
#
# print("Finished decorating function()")
#
# function()
#
# # inside decorator.__init__()
# # Finished decorating function()
# # inside decorator.__call__() begin
# # inside function()
# # inside decorator.__call__() end

import os
def tree(top):
    #path,folder list,file list
    for path, names, fnames in os.walk(top):
        for fname in fnames:
            # yield os.path.join(path, fname)
            yield fname

for name in tree(os.getcwd()):
    print name

for name in tree('/Users/hujiawei/Desktop/csu/'):
        print '![image](http://hujiaweibujidao.github.io/images/pics/'+name+')'

if __name__ == '__main__':

    pass



