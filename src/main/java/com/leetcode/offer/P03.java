package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/16 14:56
 */
public class P03 {
    public int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while(num != i) {
                int tmp = nums[num];
                if (tmp == num) {
                    return num;
                }
                nums[num] = num;
                nums[i] = tmp;
                num = nums[i];
            }
        }
        return -1;
    }
}
