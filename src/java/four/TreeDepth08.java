package java.four;

import gloabl.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName GetNumberOfK07<br>
 * Function <br>
 * <p>输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 * （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。</p>
 * 思路<br>
 * <p>采用层次遍历的方式，记录每层节点的数量，然后删除元素，
 * 直到删除当前层元素，层数加1，即count==lastNode</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class TreeDepth08 {
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int lastNode = 1;
        int count = 0;
        while (!queue.isEmpty()) {
            root = queue.poll();
            count++;
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
            if (count == lastNode) {
                lastNode = queue.size();
                count = 0;
                level++;
            }
        }
        return level;
    }

    public int treeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth1(root.left);
        int right = treeDepth1(root.right);
        return Math.max(left, right) + 1;
    }
}
