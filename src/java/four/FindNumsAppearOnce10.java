package java.four;

/**
 * ClassName findnumsappearonce<br>
 * Function <br>
 * <p>一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/7 14:20
 */
public class FindNumsAppearOnce10 {
    public void findnumsappearonce(int[] array, int[] num1, int[] num2) {
        if (array == null || array.length < 2) {
            return;
        }
        int len = array.length;
        int myxor = 0;
        //将所有数字异或，则有两两成对的数字结果为0，则myxor等于两个只出现一次的异或
        for (int number : array) {
            myxor ^= number;
        }
        //找到异或结果的最低位1
        int flag = 1;
        while ((flag & myxor) == 0) {
            flag <<= 1;
        }
        //因为最低为1，则该位两个只出现一次的数字是不同的，据此将数组分为两组，组内其他数字两两成对，
        //异或为0，则最后只剩不同的数字
        for (int number : array) {
            if ((flag & number) == 0) {
                num1[0] ^= number;
            } else {
                num2[0] ^= number;
            }
        }
    }
}
