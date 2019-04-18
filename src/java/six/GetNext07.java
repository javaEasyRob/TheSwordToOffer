package java.six;

/**
 * ClassName GetNext<br>
 * Function <br>
 * <p>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，
 * 同时包含指向父结点的指针。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/13 19:53
 */
public class GetNext {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.parent != null) {
            if (pNode.parent.left == pNode) {
                return pNode.parent;
            }
            pNode = pNode.parent;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode parent;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
