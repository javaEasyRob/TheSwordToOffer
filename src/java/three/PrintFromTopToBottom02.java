package java.three;

import datastructure.wheel.TreeNode;

import java.util.ArrayList;

/**
 * ClassName PrintFromTopToBottom02<br>
 * Function <br>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印<br>
 * 思路<br>
 * 使用层次遍历的思路，使用List模拟queue<br>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class PrintFromTopToBottom02 {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        while (queue.size() != 0) {
            root = queue.remove(0);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
            list.add(root.val);
        }
        return list;
    }
}
