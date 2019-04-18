package java.five;

/**
 * ClassName LeftRotateString03<br>
 * Function <br>
 * <p>汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于
 * 一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左
 * 移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！</p>
 * 思路<br>
 * <p>将字符串拼接一份，如abc，拼接成abcabc，如果需要循环左移1位则，取字符串第一位到第一位加上字符串长
 * 度，即bca，将循环左移的量模以字符串长度，得到通用解。</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/8 18:18
 */
public class LeftRotateString03 {
    public String leftRotateString(String str, int n) {
        if (str.length() == 0) {
            return "";
        }
        int len = str.length();
        int start = n % len;
        str += str;
        return str.substring(start, start + len);
    }
}
