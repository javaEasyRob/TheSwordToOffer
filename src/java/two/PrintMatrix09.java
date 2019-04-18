package java.two;

import java.util.ArrayList;

/**
 * ClassName PrintMatrix09<br>
 * Function <br>
 * <p>输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4, 5 6 7 8, 9 10 11 12 ,13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class PrintMatrix09 {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        while (cols > start * 2 && rows > start * 2) {
            printMatrix1(matrix, start, rows, cols, list);
            start++;
        }
        return list;
    }

    public static void printMatrix1(int[][] matrix, int start, int rows, int cols, ArrayList<Integer> list) {
        int endX = cols - start - 1;
        int endY = rows - start - 1;
        //从左到右
        for (int i = start; i <= endX; i++) {
            list.add(matrix[start][i]);
        }
        //从上到下
        if (start < endY) {
            for (int j = start + 1; j <= endY; j++) {
                list.add(matrix[j][endX]);
            }
        }
        //从右到左
        if (start < endY && start < endX) {
            for (int j = endX - 1; j >= start; j--) {
                list.add(matrix[endY][j]);
            }
        }
        //从下到上
        if (start < endX && start < endY - 1) {
            for (int j = endY - 1; j > start; j--) {
                list.add(matrix[j][start]);
            }
        }
    }

    public static void main(String[] args) {
        printMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {6, 7, 8, 9}, {10, 11, 12, 13}});
    }
}
