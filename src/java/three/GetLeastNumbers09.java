package java.three;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName GetLeastNumbers09<br>
 * Function <br>
 * <p>
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class GetLeastNumbers09 {
    public ArrayList<Integer> getLeastNumbers(int[] input, int k) {
        if (k > input.length || k == 0) {
            return new ArrayList<>();
        }
        Integer[] maxHeap = new Integer[k + 1];
        //放置岗哨元素
        maxHeap[0] = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            offer(maxHeap, input[i], i + 1);
        }
        for (int i = k; i < input.length; i++) {
            if (maxHeap[1] > input[i]) {
                poll(maxHeap);
                offer(maxHeap, input[i], k);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(maxHeap));
        list.remove(0);
        return list;
    }

    public void offer(Integer[] maxHeap, int insertNumber, int loc) {
        for (; maxHeap[loc >> 1] < insertNumber; loc >>= 1) {
            maxHeap[loc] = maxHeap[loc >> 1];
        }
        maxHeap[loc] = insertNumber;
    }

    public void poll(Integer[] maxHeap) {
        //除去岗哨
        int size = maxHeap.length - 1;
        int temp = maxHeap[size--];
        int parent, child;
        for (parent = 1; (parent << 1) <= size; parent = child) {
            child = parent << 1;
            if ((child != size) && (maxHeap[child] < maxHeap[child + 1])) {
                child++;
            }
            if (temp >= maxHeap[child]) {
                break;
            } else {
                maxHeap[parent] = maxHeap[child];
            }
        }
        maxHeap[parent] = temp;
    }
}
