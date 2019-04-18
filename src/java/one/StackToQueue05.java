package java.one;

import java.util.Stack;

/**
 * ClassName StackToQueue05<br>
 * Function <br>
 * 使用栈实现队列。<br>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class StackToQueue05 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    /**
     * <p>利用堆栈先进后出的原则，在出栈时将堆栈中的元素push进另一个栈恢复原来顺序
     * 出栈后，在放入原堆栈中</p>
     */
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        //此时stack2栈顶的就是stack1栈底元素，即第一个元素
        int first = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return first;
    }
}
