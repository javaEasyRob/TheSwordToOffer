package java.six;

import datastructure.wheel.TreeNode;

/**
 * ClassName IsSymmetrical08<br>
 * Function <br>
 * <p>
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/13 20:12
 */
public class IsSymmetrical08 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val
                && isSymmetrical(root1.left, root2.right)
                && isSymmetrical(root1.right, root2.left);
    }
}
