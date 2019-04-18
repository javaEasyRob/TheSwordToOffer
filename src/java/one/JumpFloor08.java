package java.one;

/**
 * ClassName JumpFloor08<br>
 * Function <br>
 * <p>一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有
 * 多少种跳法（先后次序不同算不同的结果）。</p>
 * 思路<br>
 * 如果跳一级则还剩f(n-1)，同理跳两级还剩f(n-2)，故有f(n)=f(n-1)+f(n-2)<br>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class JumpFloor08 {
    public int jumpFloor(int target) {
        if (target < 1) {
            return -1;
        } else if (target <= 2) {
            return target;
        } else {
            return jumpFloor(target - 1) + jumpFloor(target - 2);
        }
    }
}
