package java.two;

import java.util.Stack;

/**
 * ClassName StackForMin10<br>
 * Function <br>
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1））。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class StackForMin10 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();


    public void push(int node) {
        //s1正常入栈，s2作为辅助栈，小的入栈。
        s1.push(node);
        if (s2.isEmpty()) {
            s2.push(node);
        } else if (node <= s2.peek()) {
            s2.push(node);
        }
    }


    public void pop() {
        //s1出栈，如果辅助栈中也有该元素，则一起同步出栈
        if (s1.peek().equals(s2.peek())) {
            s2.pop();
        }
        s1.pop();
    }

    public int top() {
        return s2.peek();
    }

    public int min() {
        return s2.peek();
    }
}
