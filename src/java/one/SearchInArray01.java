package java.one;

/**
 * ClassName SearchInArray01<br>
 * Function <br>
 * <p>在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右
 * 递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class SearchInArray01 {
    public boolean find(int target, int[][] array) {
        int len = array.length;
        if (len == 0) {
            return false;
        }
        int i = 0;
        while (len > 0 && i < array[0].length) {
            if (array[len][i] < target) {
                i++;
            } else if (array[len][i] > target) {
                len--;
            } else {
                return true;
            }
        }
        return false;
    }
}