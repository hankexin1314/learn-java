package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author kexinhan
 * @date 2022/3/9 10:36
 */
public class BubbleSort {

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 11, 3, 1, -1, 12, 9, 8, -3};
        BubbleSort insertSort = new BubbleSort();
        insertSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
