package java.four;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ClassName FirstNotRepeatingChar04<br>
 * Function <br>
 * <p>在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回
 * 它的位置, 如果没有则返回 -1（需要区分大小写）.</p>
 * 思路<br>
 * <p>将字符串扫描一遍，使用linkedHashMap保证检索是否存在高效的同时，维护扫描顺序，然后取值判断。</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class FirstNotRepeatingChar04 {
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        int len = str.length();
        char letter;
        for (int i = 0; i < len; i++) {
            letter = str.charAt(i);
            if (map.containsKey(letter)) {
                map.put(letter, -1);
            } else {
                map.put(letter, 1);
            }
        }
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        Map.Entry<Character, Integer> entry;
        while (it.hasNext()) {
            entry = it.next();
            if (entry.getValue() == 1) {
                return str.indexOf(entry.getKey());
            }
        }
        return -1;
    }
}
