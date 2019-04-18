package java.three;

import java.util.Stack;

/**
 * ClassName IsPopOrder01<br>
 * Function <br>
 * <P>
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序
 * 列的弹出序列。（注意：这两个序列的长度是相等的）
 * </p>
 * 思路<br>
 * 采用栈来模拟出入栈，查看结果是否匹配
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class IsPopOrder01 {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int pushLen = pushA.length;
        int popLen = popA.length;
        if (pushLen != popLen) {
            return false;
        }
        int i = 0, j = 0;
        stack.push(pushA[i++]);
        while (j < popLen) {
            while (stack.peek() != popA[j]) {
                //此时栈顶元素不匹配pop序列，且无元素再入栈
                if (i == pushLen) {
                    return false;
                }
                stack.push(pushA[i++]);
            }
            stack.pop();
            j++;
        }
        return true;
    }
}
