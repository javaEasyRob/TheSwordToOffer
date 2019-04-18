package java.six;

import datastructure.wheel.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ClassName PrintReverseIntervalRow09<br>
 * Function <br>
 * <p>
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层
 * 按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/14 19:33
 */
public class PrintReverseIntervalRow09 {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(pRoot);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            if (!s1.isEmpty()) {
                while (!s1.isEmpty()) {
                    pRoot = s1.pop();
                    if (pRoot.left != null) {
                        s2.add(pRoot.left);
                    }
                    if (pRoot.right != null) {
                        s2.add(pRoot.right);
                    }
                    list.add(pRoot.val);
                }
            } else {
                while (!s2.isEmpty()) {
                    pRoot = s2.pop();
                    if (pRoot.right != null) {
                        s1.add(pRoot.right);
                    }
                    if (pRoot.left != null) {
                        s1.add(pRoot.left);
                    }
                    list.add(pRoot.val);
                }
            }
            result.add(list);
        }
        return result;
    }
}
