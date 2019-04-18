package java.three;

/**
 * ClassName VerifySquenceOfPost03<br>
 * 题目描述<br>
 * <p>输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。</p>
 * 思路<br>
 * <p>二叉搜索树中，右子树所有结点大于根节点，左子树所有结点小于根节点,而后序遍历
 * 顺序是左子树所有结点，然后右子树所有结点，最后为根节点。</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class VerifySquenceOfPost03 {
    /**
     * 非递归写法
     *
     * @param sequence 后序遍历序列
     * @return 是否是二叉搜索树的后序遍历序列
     */
    public boolean verifySquenceOfBST(int[] sequence) {
        int len = sequence.length;
        if (0 == len) {
            return false;
        }
        int i = 0;
        while (--len != 0) {
            while (sequence[i] < sequence[len]) {
                i++;
            }
            while (sequence[i] > sequence[len]) {
                i++;
            }
            if (i < len) {
                return false;
            }
            i = 0;
        }
        return true;
    }

    /**
     * 递归写法，分别判断左右子树，直到为叶子结点或者为空结点
     *
     * @param sequence 后序遍历序列
     * @return 是否是二叉搜索树的后序遍历序列
     */
    public boolean verifySquenceOfBST1(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return isTreeBST(sequence, 0, sequence.length - 1);
    }

    public boolean isTreeBST(int[] sequence, int start, int end) {
        //相等时为左子树只有一结点，为叶结点，小于时，说明左子树为空
        if (end <= start) {
            return true;
        }
        int i = start;
        //寻找左子树边界
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                break;
            }
        }
        //查看右子树中是否所有结点满足条件
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        //继续递归左子树和右子树，直到为空或者为叶子节点
        return isTreeBST(sequence, start, i - 1) && isTreeBST(sequence, i, end - 1);
    }
}
