package java.two;

/**
 * ClassName ReverseList05<br>
 * Function <br>
 * 题目描述<br>
 * 输入一个链表，反转链表后，输出新链表的表头。<br>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class ReverseList05 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next ;
        ListNode pre = null;
        while (head != null) {
            //暂存当前元素的下一个结点
            next = head.next;
            //将当前元素得指向反向
            head.next = pre;
            //记录当前元素
            pre = head;
            //移动元素
            head = next;
        }
        return pre;
    }
}
