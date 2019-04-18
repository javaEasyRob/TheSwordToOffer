package java.six;

/**
 * ClassName DeleteDuplication06<br>
 * Function <br>
 * <p>
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，
 * 链表1->2->3->3->4->4->5 处理后为 1->2->5
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/12 22:09
 */
public class DeleteDuplication06 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode p = pHead;
        ListNode n = new ListNode(0);
        ListNode pre = n;
        n.next = pHead;
        while (p != null) {
            ListNode q = p.next;
            if (q == null) {
                break;
            }
            if (q.val == p.val) {
                while (q != null && q.val == p.val) {
                    q = q.next;
                }
                pre.next = q;
                p = q;
            } else {
                pre = p;
                p = q;
            }
        }
        return n.next;
    }
}
