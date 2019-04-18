package java.three;

/**
 * ClassName FindGreatestSumOfSubArray10<br>
 * Function <br>
 * <p>HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识
 * 别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应
 * 该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个
 * 开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class FindGreatestSumOfSubArray10 {
    public int findGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            //如果当前子列和，小于下一项则放弃当前和，从下一项开始求和
            sum = Math.max(sum + array[i], array[i]);
            //更新最大值
            max = Math.max(sum, max);
        }
        return max;
    }
}
