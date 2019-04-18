package java.two;

/**
 * ClassName HasSubTree<br>
 * Function <br>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）<br>
 * 思路<br>
 * 遍历所有结点，没找到一个值相同的结点，判断该结点是否为同一棵树，如果不是继续遍历。<br>
 *
 * @author 辛江勇<br>
 * @version 1.0.0
 */
public class HasSubTree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean flag = false;
        //先序遍历root1，找到root1的所有结点值和root2的值相等的结点，然后判断是否同一棵树。
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                flag = doesTree1HaveTree(root1, root2);
            }
            if (!flag) {
                flag = hasSubtree(root1.left, root2);
            }
            if (!flag) {
                flag = hasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    public boolean doesTree1HaveTree(TreeNode root1, TreeNode root2) {
        //注意顺序，在使用val之前应先判断是否为null
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HaveTree(root1.left, root2.left) && doesTree1HaveTree(root1.right, root2.right);
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}