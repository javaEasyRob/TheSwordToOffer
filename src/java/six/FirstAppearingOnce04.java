package java.six;

/**
 * ClassName IsNumeric03<br>
 * Function <br>
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字
 * 符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/11 23:54
 */
public class FirstAppearingOnce04 {
    private int[] count = new int[256];
    //insert one char from stringstream
    private int index = 1;

    public void insert(char ch) {
        if (count[ch] == 0) {
            count[ch] = index++;
        } else {
            count[ch] = -1;
        }
    }

    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        int temp = Integer.MAX_VALUE;
        char ch = '#';
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0 && count[i] != -1 && count[i] < temp) {
                temp = count[i];
                ch = (char) i;
            }
        }
        return ch;
    }
}