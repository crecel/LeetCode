import java.util.Map;

/**
 * @author crecel
 */
public class BinarySearch {
    /**
     * 传送门：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
     * 题解：二分，l,r分别指向数组头尾，若sum = numbers[l] + numbers[r]的结果小了，则让l向前走，来增加sum的值，反之，则让r向前走，来减小sum的值，直到sum = target。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while(l < r) {
            int sum = numbers[l] + numbers[r];
            if(sum == target)
                return new int[] {l + 1, r + 1};
            else if(sum < target)
                l++;
            else if(sum > target)
                r--;
        }
        return null;
    }

    /**
     * 传送门：https://leetcode.com/problems/sum-of-square-numbers/description/
     * 题解：二分，l,r分别指向0和c的平方根，若mid = l*l + r*r的结果小了，则让l向前走，来增加mid的值，反之，则让r向前走，来减小mid的值，直到mid = c。
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        int l = 0;//可以为0
        int r  = (int)Math.sqrt(c);
        while(l <= r) {//可以相等
            int mid = l * l + r * r;
            if(mid == c)
                return true;
            else if(mid < c)
                l++;
            else if(mid > c)
                r--;
        }
        return false;
    }
}