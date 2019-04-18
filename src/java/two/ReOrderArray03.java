package java.two;

/**
 * ClassName ReOrderArray1<br>
 * Function <br>
 * 题目描述<br>
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2018/10/20 20:45
 */
public class ReOrderArray03 {
    /**
     * 奇数和偶数的位置可能发生变化
     */
    public int[] reOrderArray(int[] array) {
        int len = array.length;
        int start = 0, end = len - 1;
        int temp;
        while (start < end) {
            while (start < end && (array[start] & 1) == 0) {
                start++;
            }
            while (start < end && (array[end] & 1) == 1) {
                end--;
            }
            if (start < end) {
                temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        return array;
    }

    /**
     * 要求偶数和奇数的相对位置没有发生改变
     */
    public void reOrderArray1(int[] array) {
        int len = array.length;
        int t;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if ((array[j] & 1) == 0 && (array[j + 1] & 1) == 1) {
                    t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }
}