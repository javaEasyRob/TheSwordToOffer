package java.four;

/**
 * ClassName FindFirstCommonNode<br>
 * Function <br>
 * <p>输入两个链表，找出它们的第一个公共结点。</p>
 * 思路<br>
 * 两个链表因为有公共点，那么在有公共点后的长度肯定是一致的，所以
 * 公共点只可能出现在后半等长的链表中。
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class FindFirstCommonNode06 {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int count1 = getLength(pHead1);
        int count2 = getLength(pHead2);
        ListNode longer, shorter;
        int flag = count1 - count2;
        if (flag < 0) {
            longer = pHead2;
            shorter = pHead1;
            flag = -flag;
        } else {
            longer = pHead1;
            shorter = pHead2;
        }
        while (flag > 0) {
            longer = longer.next;
            flag--;
        }
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return shorter;
    }

    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
