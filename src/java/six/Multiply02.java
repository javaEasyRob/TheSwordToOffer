package java.six;

/**
 * ClassName Multiply02<br>
 * Function <br>
 * <p>
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * </p>
 * <pre>
 *   b0     1 a1 a2......
 *   b1     a0 1 a2....
 *   ..
 *   bn-2   a0 ... 1 an-1
 *   bn-1   a0 ..an-2 1
 * </pre>
 * <p>
 * 先计算下三角，则b0=1，b1=1*a1-1，即bi=bi-1 * ai-1
 * 在计算上三角，然后两数相乘，bn-1不用管，temp *= ai+1即bni = b[i](下三角的值)*temp（上三角的值）
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 * @date 2019/4/10 19:33
 */
public class Multiply02 {
    public int[] multiply(int[] numbersA) {
        int len = numbersA.length;
        int[] numbersB = new int[len];
        if (len == 0) {
            return numbersB;
        }
        numbersB[0] = 1;
        for (int i = 1; i < len; i++) {
            numbersB[i] = numbersB[i - 1] * numbersA[i - 1];
        }
        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= numbersA[i + 1];
            numbersB[i] *= temp;
        }
        return numbersB;
    }
}
