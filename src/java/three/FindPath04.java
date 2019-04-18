package java.three;

import gloabl.TreeNode;

import java.util.ArrayList;

/**
 * ClassName FindPath04<br>
 * Function <br>
 * <p>输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所
 * 有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class FindPath04 {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrs = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        findPath(root, target, arrs, arr);
        return arrs;
    }

    /**
     * 采用递归的方式遍历二叉树，寻找合适的路径
     *
     * @param root   二叉树的根节点
     * @param target 所需的路径和
     * @param arrs   存放所有路径
     * @param arr    存放当前路径
     */
    public void findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> arrs, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        target -= root.val;
        arr.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            arrs.add(new ArrayList<>(arr));
            //移除当前结点，返回上一层的递归继续查找
            arr.remove(arr.size() - 1);
            return;
        }
        findPath(root.left, target, arrs, arr);
        findPath(root.right, target, arrs, arr);
        arr.remove(arr.size() - 1);

    }

    /**
     * 测试,
     */
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(3);
        TreeNode node33 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node9 = new TreeNode(9);
        node1.left = node9;
        node1.right = node2;
        node2.left = node4;
        node4.right = node31;
        node2.right = node32;
        node32.right = node33;
        node33.right = node11;
        FindPath04 findPath = new FindPath04();
        ArrayList<ArrayList<Integer>> arrs = findPath.findPath(node1, 10);
        for (ArrayList<Integer> arr : arrs) {
            System.out.print("[");
            for (Integer integer : arr) {
                System.out.print(integer);
            }
            System.out.print("]");
            System.out.println();
        }

    }
}
