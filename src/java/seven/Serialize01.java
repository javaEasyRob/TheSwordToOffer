package java.seven;


import gloabl.TreeNode;

/**
 * ClassName Serialize01<br>
 * Function <br>
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/15 20:05
 */
public class Serialize01 {

    private int index = -1;

    String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serialize2(root, sb);
        return sb.toString();
    }

    private void serialize2(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        serialize2(root.left, sb);
        serialize2(root.right, sb);
    }

    TreeNode deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        String[] strs = str.split(",");
        return deserialize2(strs);
    }

    private TreeNode deserialize2(String[] strs) {
        index++;
        if (!"#".equals(strs[index])) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = deserialize2(strs);
            root.right = deserialize2(strs);
            return root;
        }
        return null;
    }
}
