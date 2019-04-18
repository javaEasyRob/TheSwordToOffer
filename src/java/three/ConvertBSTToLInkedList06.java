package java.three;

import datastructure.wheel.TreeNode;

import java.util.Stack;

/**
 * ClassName ConvertBSTToLInkedList06<br>
 * Function <br>
 * <P>输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的
 * 双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。</P>
 * 思路<br>
 * <p>二叉搜索树中左子树<根节点<右子树，故可使用中序遍历，每次找到最小的。
 * 使用left域指向小的，right域指向大的。</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class ConvertBSTToLInkedList06 {

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode currentNode = pRootOfTree;
        TreeNode preNode = null;
        TreeNode root = null;
        Stack<TreeNode> stack = new Stack<>();
        boolean isFirst = true;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
                continue;
            }
            currentNode = stack.pop();
            if (isFirst) {
                //寻找最小结点，标记为起点。
                root = currentNode;
                preNode = currentNode;
                isFirst = false;
            } else {
                preNode.right = currentNode;
                currentNode.left = preNode;
                preNode = currentNode;
            }
            currentNode = currentNode.right;
        }
        return root;
    }
}
