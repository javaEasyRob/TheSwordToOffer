package java.four;

/**
 * ClassName NumberOf1Between1AndN01<br>
 * Function <br>
 * <p>求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中
 * 包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,
 * 并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class NumberOf1Between1AndN01 {
    public int numberOf1Between1AndN(int n) {
        String str;
        char[] chars;
        int count = 0;
        while (n > 0) {
            str = String.valueOf(n--);
            chars = str.toCharArray();
            for (char aChar : chars) {
                if (aChar == '1') {
                    count++;
                }
            }
        }
        return count;
    }
}
