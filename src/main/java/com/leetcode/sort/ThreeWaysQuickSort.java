package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author kexinhan
 * @date 2022/3/9 15:15
 */
public class ThreeWaysQuickSort {

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }


    private void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int val = nums[l];
        int lt = l; // [l + 1, lt] < val
        int gt = r + 1; // [gt, r] > val
        int i = l + 1; // [lt + 1, i] == val
        while(i < gt) {
            if (nums[i] < val) {
                swap(nums, i, lt + 1);
                lt ++;
                i ++;
            }
            else if (nums[i] > val) {
                swap(nums, i, gt - 1);
                gt --;
            }
            else {
                i ++;
            }
        }
        swap(nums, lt, l);
        sort(nums, l, lt - 1);
        sort(nums, gt, r);
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 11, 3, 1, -1, 12, 9, 8, -3};
        ThreeWaysQuickSort insertSort = new ThreeWaysQuickSort();
        insertSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
