package java.four;

/**
 * ClassName GetUglyNumber03<br>
 * Function <br>
 * <p>
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，
 * 但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * </p>
 * 思路<br>
 * <p>
 * 第一个丑数是1，后面的分别是1*2,1*3,1*5，我们发现在它们中间还存在着2*2，我们不难发现，所有丑数
 * 都是前面丑数乘以2、3、5，我们的目标是有序，不能重复，那么我们需要每次都是得到最小的丑数，
 * 我们每次都取最小的丑数分别乘以2、3、5当我们采用了当前的组合，如1*2时，那么我们下一次就使用
 * 2*2，同样的其他的数字也一样，所以我们需要维护三个指针，分别指向2、3、5的队列，我们还需要考虑
 * 重复的问题，所以每次需要同时判断三个序列是否能够生成新的丑数，如果可以，我们需要将所有满足条件
 * 的指针后移。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class GetUglyNumber03 {
    public int getUglyNumber(int index) {
        //前六个数都为丑数
        if (index < 7) {
            return index;
        }
        int[] numbers = new int[index];
        int newNumber = 1;
        numbers[0] = newNumber;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < index; i++) {
            newNumber = getMin(numbers[p2] * 2, numbers[p3] * 3, numbers[p5] * 5);
            numbers[i] = newNumber;
            if (newNumber == numbers[p2] * 2) {
                p2++;
            }
            if (newNumber == numbers[p3] * 3) {
                p3++;
            }
            if (newNumber == numbers[p5] * 5) {
                p5++;
            }
        }
        return numbers[index - 1];
    }

    public int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
