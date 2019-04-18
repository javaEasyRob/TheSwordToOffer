package java.three;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * ClassName permutation<br>
 * Function <br>
 *<p>输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串
 * abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。</p>
 * 每次固定一个位置，然后考虑剩余的位置，每次第一个位置的可以和后面的位置互换。
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class Permutation07 {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> strs = new ArrayList<>();
        if (str != null && str.length() != 0) {
            TreeSet<String> temp = new TreeSet<>();
            permutationHelper(temp, str.toCharArray(), 0);
            strs.addAll(temp);
        }
        return strs;
    }

    public void permutationHelper(TreeSet<String> strs, char[] chars, int begin) {
        int len = chars.length;
        if (begin == len - 1) {
            strs.add(String.valueOf(chars));
            return;
        }
        for (int i = begin; i < len; i++) {
            swap(chars, begin, i);
            permutationHelper(strs, chars, begin + 1);
            //换回来进行下一轮置换。
            swap(chars, begin, i);
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
