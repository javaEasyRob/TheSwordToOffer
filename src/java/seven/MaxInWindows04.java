package java.seven;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * ClassName MaxInWindows04<br>
 * Function <br>
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/16 22:56
 */
public class MaxInWindows04 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty()) {
                q.add(i);
            } else if (begin > q.peekFirst()) {
                q.pollFirst();
            }

            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i]) {
                q.pollLast();
            }
            q.add(i);
            if (begin >= 0) {
                res.add(num[q.peekFirst()]);
            }
        }
        return res;
    }
}
