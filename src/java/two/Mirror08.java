package java.two;

/**
 * ClassName Mirror08<br>
 * Function <br>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。<br>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class Mirror08 {
    public void mirror(TreeNode root) {
        TreeNode temp;
        if (root != null) {
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) {
                mirror(root.left);
            }
            if (root.right != null) {
                mirror(root.right);
            }
        }
    }
}
