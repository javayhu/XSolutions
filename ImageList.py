# coding=utf-8

__author__ = 'hujiawei'
__doc__ = ''

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
