package java.seven;

import datastructure.wheel.TreeNode;

import java.util.Stack;

/**
 * ClassName KthNode02<br>
 * Function <br>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/15 20:55
 */
public class KthNode02 {
    TreeNode kThNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (!stack.isEmpty() || pRoot != null) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                count++;
                pRoot = stack.pop();
                if (count == k) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
