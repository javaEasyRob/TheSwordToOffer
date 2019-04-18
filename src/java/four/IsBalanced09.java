package java.four;

import datastructure.wheel.TreeNode;

/**
 * ClassName IsBalanced09<br>
 * Function <br>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。<br>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/7 14:02
 */
public class IsBalanced09 {
    public boolean isbalancedSolution(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}
