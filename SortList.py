# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def sortList(self, head):
        pointer=head
        len=0
        while pointer: #calculate the length
            len=len+1
            pointer=pointer.next
        head=self.mergesort(head,len)
        pointer=head
        while len>1:
            pointer=pointer.next
            len=len-1
        if pointer:
            pointer.next=None
        return head

    def mergesort(self,node,len):
        if len<= 1:
            return node
        mid=len//2
        pointer=node
        fh=node #fisrt head
        fl=mid #first len
        t=mid
        while t>0:
            t=t-1
            pointer=pointer.next
        #fisrt: mid (head to mid) second: len-mid (mid+1 to tail)
        sh=pointer #second head
        sl=len-mid #second len
        fh=self.mergesort(fh,fl)
        sh=self.mergesort(sh,sl)
        newlist=ListNode(0) #
        pointer=newlist
        while fl>0 and sl>0: #do not use `fh and sh`, fh.next is not None!
            if fh.val < sh.val:
                pointer.next=fh
                pointer=pointer.next
                fh=fh.next
                fl=fl-1
            else:
                pointer.next=sh
                pointer=pointer.next
                sh=sh.next
                sl=sl-1
        while fl>0:
            pointer.next=fh
            pointer=pointer.next
            fh=fh.next
            fl=fl-1
        while sl>0:
            pointer.next=sh
            pointer=pointer.next
            sh=sh.next
            sl=sl-1
        if newlist.next:
            return newlist.next
        else:
            return None

if __name__=='__main__':
    head=ListNode(4)
    head.next=ListNode(3)
    head.next.next=ListNode(5)
    head.next.next.next=ListNode(2)
    head=Solution().sortList(head)
    while head:
        print(head.val)
        head=head.next
    pass
