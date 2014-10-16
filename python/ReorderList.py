#TLE

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param head, a ListNode
    # @return nothing
    def reorderList(self, head):
        if head == None: return
        len, p =0, head
        while p: #get the length of the list
            len = len + 1
            p = p.next
        if len % 2 == 0: s = len/2 + 2 #from which to move forward
        else: s = (len+1)/2 + 1
        c, tlen, i, m = 1, len, head, head
        #move to the start moving element
        while c < (s-1):
            m = m.next
            c = c+1
        #make the final last element points to None
        t = m
        m = m.next
        t.next = None
        c = c+1
        #start to move forward
        while c <= len:
            j, k = m, len-c
            while k > 0: j = j.next; k=k-1
            j.next = i.next
            i.next = j
            i = j.next
            len=len-1
        p, c=head, 1
        while c < tlen:
            c = c + 1
            p = p.next
        p = None
        return head

if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    head.next.next.next.next.next = ListNode(6)
    # head.next.next.next.next.next.next = ListNode(7)
    head=Solution().reorderList(head)
    while head:
        print head.val
        head=head.next
