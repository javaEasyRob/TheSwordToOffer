package java.five;

/**
 * ClassName Sum07<br>
 * Function <br>
 * <p>
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/9 12:47
 */
public class Sum07 {
    public int sum(int n) {
        int sum = n;
        //采用短路代替if来终止递归。
        boolean ans = (n > 0) && ((sum += sum(n - 1)) > 0);
        return sum;
    }
}
