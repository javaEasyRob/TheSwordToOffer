package java.five;

/**
 * ClassName Duplicate10<br>
 * Function <br>
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数
 * 字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为
 * 7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/10 18:50
 */
public class Duplicate10 {
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
