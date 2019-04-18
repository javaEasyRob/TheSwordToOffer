package java.two;

/**
 * ClassName MergeLink06<br>
 * Function <br>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。<br>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class MergeLink06 {
    public ListNode merge(ListNode list1, ListNode list2) {
        //新建一个头节点，用来存合并的链表。
        ListNode newList = new ListNode(-1);
        ListNode head = newList;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                //指向下一個
                newList.next = list1;
                //移动指针
                newList = list1;
                list1 = list1.next;
            } else {
                newList.next = list2;
                newList = list2;
                list2 = list2.next;
            }
        }
        //把未结束的链表连接到合并后的链表尾部
        if (list1 != null) {
            newList.next = list1;
        }
        if (list2 != null) {
            newList.next = list2;
        }
        return head.next;
    }
}
