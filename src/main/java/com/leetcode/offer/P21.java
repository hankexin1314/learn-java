package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/21 14:25
 */
public class P21 {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int l = 0, r = nums.length - 1;
        while (true) {
            while (l <= r && nums[l] % 2 == 1) {
                l ++;
            }
            while (r >= l && nums[r] % 2 == 0) {
                r --;
            }
            if (l > r) {
                break;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l ++;
            r --;
        }
        return nums;
    }
}
