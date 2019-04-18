package java.six;

import gloabl.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ClassName PrintByRow10<br>
 * Function <br>
 * <p>
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/14 20:12
 */
public class PrintByRow10 {
    ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        int lastNode = 1, count = 0;
        q.add(pRoot);
        while (!q.isEmpty()) {
            pRoot = q.remove();
            temp.add(pRoot.val);
            count++;
            if (pRoot.left != null) {
                q.add(pRoot.left);
            }
            if (pRoot.right != null) {
                q.add(pRoot.right);
            }
            if (count == lastNode) {
                count = 0;
                result.add(new ArrayList<>(temp));
                temp.clear();
                lastNode = q.size();
            }
        }
        return result;
    }
}
