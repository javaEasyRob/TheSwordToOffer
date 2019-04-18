package java.four;

/**
 * ClassName GetNumberOfK07<br>
 * Function <br>
 * 统计一个数字在排序数组中出现的次数。<br>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/7 13:18
 */
public class GetNumberOfK07 {
    public int getNumberOfK(int[] array, int k) {
        int index = getIndex(array, k);
        if (index == -1) {
            return 0;
        }
        int before = index, after = index + 1;
        int count = 0, len = array.length;
        while (before >= 0 && array[before--] == k) {
            count++;
        }
        while (after <= len - 1 && array[after++] == k) {
            count++;
        }
        return count;
    }

    public int getIndex(int[] array, int k) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > k) {
                low = mid + 1;
            } else if (array[mid] < k) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
