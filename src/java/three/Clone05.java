package java.three;

/**
 * ClassName Clone<br>
 * Function <br>
 * <p>输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class Clone {
    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode currentNode = pHead;
        RandomListNode nextNode;
        RandomListNode cloneNode;
        //复制链表将链表变为A->A1->B->B1->C->C1
        while (currentNode != null) {
            cloneNode = new RandomListNode(currentNode.label);
            nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }
        currentNode = pHead;
        //将random结点复制，注意新的链表中不能包含原来的结点引用。
        while (currentNode != null) {
            if (currentNode.random != null) {
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;
        }
        currentNode = pHead;
        RandomListNode cloneHead = pHead.next;
        //拆分链表
        while (currentNode != null) {
            cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            if (cloneNode.next != null) {
                cloneNode.next = cloneNode.next.next;
            }
            currentNode = currentNode.next;

        }
        return cloneHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
