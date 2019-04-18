package java.five;

/**
 * ClassName ReverseSentence04<br>
 * Function <br>
 * <p>牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish
 * 写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来
 * 才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的
 * 翻转这些单词顺序可不在行，你能帮助他么？牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英
 * 文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂
 * 它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的
 * 句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/8 19:48
 */
public class ReverseSentence04 {
    public static String reverseSentence(String str) {
        if (str == null || str.length() < 2 || "".equals(str.trim())) {
            return str;
        }
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]).append(" ");
        }
        return result.substring(0, result.length() - 1);
    }

}
