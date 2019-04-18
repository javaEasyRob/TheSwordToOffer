package java.one;

import java.util.HashMap;

/**
 * ClassName xx<br>
 * Function <br>
 * <p>输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入
 * 前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null) {
            return null;
        }
        int len = in.length;
        //方便查找前序遍历中元素在中序遍历中的索引位置
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1, map);

    }

    /**
     * 思路：递归思想
     * 前序序列的第一个元素即为根节点，根据根节点的值在中序序列找到根节点的位置假定为i
     * 则根据二叉树前序和中序的规律：
     * 前序序列索引1~i构成子数列为根节点左子树的前序序列，i+1~n1构成子数列为根节点右子树的前序序列（n1为前序序列的长度）；
     * 中序序列索引0~i-1构成子数列为根节点左子树的中序序列，i+1~n1构成子数列为根节点右子树的中序序列（n1为前序序列的长度）；
     * 根节点的左节点为左子树的根节点，根节点的右节点为右子树的根节点
     * 根据这样的规律一直递归下去，直到序列为空。
     */
    public TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        int index = map.get(pre[preStart]);
        TreeNode root = new TreeNode(pre[preStart]);
        int leftLength = index - inStart;
        root.left = reConstructBinaryTree(pre, preStart + 1, preStart + leftLength, in, inStart, index - 1, map);
        root.right = reConstructBinaryTree(pre, preStart + leftLength + 1, preEnd, in, index + 1, inEnd, map);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

