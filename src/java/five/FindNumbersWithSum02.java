package java.five;

import java.util.ArrayList;

/**
 * ClassName FindNumbersWithSum02<br>
 * Function <br>
 * <p>输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/8 18:15
 */
public class FindNumbersWithSum02 {
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int low = 0, high = array.length - 1;
        while (low < high) {
            if (array[low] + array[high] == sum) {
                result.add(array[low]);
                result.add(array[high]);
                return result;
            } else if (array[low] + array[high] < sum) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }
}
