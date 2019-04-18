package java.two;

/**
 * ClassName FindKthToTail<br>
 * Function <br>
 * 题目描述<br>
 * 输入一个链表，输出该链表中倒数第k个结点。<br>
 * 解题思路<br>
 * <p>
 * 两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，
 * 到达第k个节点。然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点
 * 所在位置就是倒数第k个节点了。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k) {
                q = q.next;
            }
            p = p.next;
        }
        return i < k ? null : q;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
