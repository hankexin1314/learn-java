package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author kexinhan
 * @date 2022/3/9 10:40
 */
public class InsertSort {
    public void sort(int[] nums) {
        for(int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            int j = i;
            for (; j > 0; j--) {
                if (num < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                }
                else {
                    break;
                }
            }
            nums[j] = num;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 11, 3, 1, -1, 12, 9, 8, -3};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
