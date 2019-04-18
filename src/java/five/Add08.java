package java.five;

/**
 * ClassName Add08<br>
 * Function <br>
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/9 12:57
 */
public class Add08 {
    public int add(int num1, int num2) {
        int temp;
        //直到没有进位
        while (num2 != 0) {
            //两数相加
            temp = num1 ^ num2;
            //两数的进位
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
