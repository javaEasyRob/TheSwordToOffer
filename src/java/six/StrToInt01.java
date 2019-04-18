package java.six;

/**
 * ClassName StrToInt01<br>
 * Function <br>
 * <p>
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/10 12:55
 */
public class StrToInt01 {
    public static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int plusmins = 1;
        if (str.charAt(0) == '+') {
            str = str.substring(1);
        } else if (str.charAt(0) == '-') {
            str = str.substring(1);
            plusmins = -1;
        }
        char[] letters = str.toCharArray();
        int len = letters.length;
        long result = 0, number, base = len - 1;
        for (char letter : letters) {
            number = letter - '0';
            if (number > 9 || number < 0) {
                return 0;
            }
            result = result * 10 + number;
        }
        return (int) result * plusmins;
    }
}
