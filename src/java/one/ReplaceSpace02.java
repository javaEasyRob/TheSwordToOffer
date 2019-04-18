package java.one;

/**
 * ClassName ReplaceSpace02<br>
 * Function <br>
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class ReplaceSpace02 {
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        char temp;
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < len; i++) {
            temp = str.charAt(i);
            if (temp == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(temp);
            }
        }
        return newStr.toString();
    }
}
