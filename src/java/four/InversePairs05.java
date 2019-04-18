package java.four;

import java.util.Arrays;

/**
 * ClassName inversepairs<br>
 * Function <br>
 * <p>在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数
 * 组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class InversePairs05 {
    public void inversepairs(int[] array) {
        if (array.length < 2) {
            return;
        }
        int[] copyArray = Arrays.copyOf(array, array.length);
        merger(array, copyArray, 0, array.length - 1);
    }

    public int merger(int[] array, int[] copyArray, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int leftCOunt = merger(array, copyArray, low, mid) % 1000000007;
        int rightCOunt = merger(array, copyArray, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid, j = high;
        int copyIndex = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copyArray[copyIndex--] = array[i--];
                count = count > 1000000007 ? (count % 1000000007) : count;
            } else {
                copyArray[copyIndex--] = array[j--];
            }
        }
        while (i >= low) {
            copyArray[copyIndex--] = array[i--];
        }
        while (j > mid) {
            copyArray[copyIndex--] = array[j--];
        }
        for (int k = low; k <= high; k++) {
            array[k] = copyArray[k];
        }
        return (leftCOunt + rightCOunt + count) % 1000000007;
    }
}
