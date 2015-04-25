/**
 * hujiawei 15/4/23
 * <p/>
 * 链表
 * <p/>
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        System.out.println(new AddTwoNumbers_2().addTwoNumbers(l1, l2).val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum, v1 = 0, v2 = 0;
        //带有链表头，结果是表头或者表头下一个节点，而处理过程是需要从表头开始移动这种类型的代码
        //先定义链表头，然后让一个指针指向它，之后移动的话只移动那个指针
        ListNode head = new ListNode(0);//null node
        ListNode pointer = head;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 == null) {
                v1 = 0;
            } else {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                v2 = 0;
            } else {
                v2 = l2.val;
                l2 = l2.next;
            }
            sum = v1 + v2 + carry;//with carry
            carry = sum / 10;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;//null node
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
