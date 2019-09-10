import java.util.Map;

/**
 * @author crecel
 */
public class BinarySearch {
    /**
     * 传送门：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
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
     * 传送门：https://leetcode.com/problems/sum-of-square-numbers/
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

    /**
     * 传送门https://leetcode.com/problems/valid-palindrome-ii/
     * 题解：二分，l和r分别指向0和字符串末尾，若s[l]，s[r]相等，则让l向前走，r向后走；反之，r不动让l向前走来忽略字符s[l]再继续检查s是否为回文，l不动让r向后走来忽略字符s[r]再继续检查s是否为回文。
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l, r-1) || isPalindrome(s, l+1, r);
            } else {
                l++;    r--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int ans[] = new int[m+n];
//        int j = 0;
//        for(int i = 0; i < n; i++) {
//            int l = 0;
//            int r = m-1;
//            while(l <= r) {
//                int mid = (l+r)/2;
//                if(nums1[mid] < nums2[i]) {
//                    l++;
//                } else if(nums1[mid] > nums2[i]){
//                    r--;
//                }
//            }
//            ans[j++] = ;
//            m++;
//        }
//
//    }

    /**
     * 传送门：https://leetcode.com/problems/linked-list-cycle/description/
     * 题解：双指针，用两个指针，初始化同时指向head，之后一个指针每次走一步，另一个指针每次走两步，若存在环，两个指针一定会相遇。
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode l1 = head;
        ListNode l2 = head;
        while(l1 != null &&  l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if(l1 == l2) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
