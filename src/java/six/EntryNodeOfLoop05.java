package java.six;


/**
 * ClassName EntryNodeOfLoop<br>
 * Function <br>
 * <p>
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * </p>
 * 解题思路<br>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/12 21:01
 */
public class EntryNodeOfLoop {
    public ListNode meetingNode(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        /////先判断有没有环
        while (fast != slow) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                //没有环,返回
                return null;
            }
        }
        //循环出来的话就是有环，且此时fast==slow.
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
