package java.one;

/**
 * ClassName Fibonacci07<br>
 * Function <br>
 * 斐波那契数列
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class Fibonacci07 {
    public int fibonacci(int n) {
        int a = 0, b = 1;
        while (n-- > 0) {
            b += a;
            a = b - a;
        }
        return a;
    }
}
