package java.one;

/**
 * ClassName MinNumberInRotateArray06<br>
 * Function <br>
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排
 * 序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}
 * 的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，
 * 请返回0。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class MinNumberInRotateArray06 {
    public int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        //当旋转数组旋转0个元素时，直接返回第一个元素，因此将mid设置为0
        //旋转过后依然是两个非递减数组，以最小元素为分界线
        int low = 0, mid = 0, high = len - 1;
        while (array[low] >= array[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }
            //负奇数>>1和/2不一样
            mid = low + (high - low) / 2;
            if (array[low] == array[mid] && array[mid] == array[high]) {
                return findMin(array, low, high);
            }
            if (array[mid] >= array[high]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return array[mid];
    }

    private int findMin(int[] numbers, int low, int high) {
        for (; high > low; high--) {
            if (numbers[high - 1] > numbers[high]) {
                break;
            }
        }
        return numbers[high];
    }

    public static void main(String[] args) {
        MinNumberInRotateArray06 min = new MinNumberInRotateArray06();
        min.minNumberInRotateArray(new int[]{3, 4, 5, 1, 2});
    }
}
