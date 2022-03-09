package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author kexinhan
 * @date 2022/3/9 10:40
 */
public class SelectSort {
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int max = nums.length - 1 - i;
            int min = i;
            if (nums[max] < nums[min]) {
                swap(nums, min, max);
            }
            for (int j = i; j < nums.length - i; j++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
            swap(nums, nums.length - 1 - i, max);
        }
    }

    public void sort2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 11, 3, 1, -1, 12, 9, 8, -3};
        SelectSort insertSort = new SelectSort();
        insertSort.sort2(nums);
        System.out.println(Arrays.toString(nums));

    }
}
