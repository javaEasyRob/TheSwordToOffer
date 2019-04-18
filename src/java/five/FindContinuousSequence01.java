package java.five;

import java.util.ArrayList;

/**
 * ClassName FindContinuousSequence01<br>
 * Function <br>
 * <p>
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出
 * 所有和为S的连续正数序列? Good Luck!
 * </p>
 * 思路<br>
 * <p>
 * 采用双指针，相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/8 18:00
 */
public class FindContinuousSequence01 {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1, high = 2;
        int cur;
        while (low < high) {
            cur = (low + high) * (high - low + 1) >> 1;
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                low++;
            } else if (cur < sum) {
                high++;
            } else {
                low++;
            }
        }
        return result;
    }
}
