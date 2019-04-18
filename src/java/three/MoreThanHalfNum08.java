package java.three;

/**
 * ClassName MoreThanHalfNum08<br>
 * Function <br>
 * <P>数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组
 * {1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。</P>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class MoreThanHalfNum08 {
    /**
     * 数组中元素只有一到9的数字
     */
    public class Solution {
        public int MoreThanHalfNum_Solution(int[] array) {
            int[] buckets = new int[10];
            int len = array.length;
            for (int anArray : array) {
                buckets[anArray]++;
            }
            int i = 0;
            for (; i < 10; i++) {
                if (buckets[i] > (len / 2)) {
                    return i;
                }
            }
            return 0;
        }
    }

    /**
     * 数组中的元素为任意整数
     */
    public int moreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int len = array.length;
        int count = 0;
        int result = array[0];
        for (int anArray : array) {
            if (count == 0) {
                result = anArray;
                count = 1;
            } else if (result == anArray) {
                count++;
            } else {
                count--;
            }
        }
        return checkMoreThanHalf(array, result);
    }

    public int checkMoreThanHalf(int[] numbers, int result) {
        int count = 0;
        int len = numbers.length;
        for (int number : numbers) {
            if (number == result) {
                count++;
            }
        }
        if (count > (len >> 1)) {
            return result;
        }
        return 0;
    }
}
