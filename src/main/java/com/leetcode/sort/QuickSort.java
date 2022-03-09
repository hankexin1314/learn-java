package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author kexinhan
 * @date 2022/3/9 11:33
 */
public class QuickSort {
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
        int p = partition(nums, l, r);
        sort(nums, l, p - 1);
        sort(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        swap(nums, l, (int)(Math.random() * (r - l + 1) + l));
        int val = nums[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && nums[i] < val) {
                i ++;
            }
            while (j >= l && nums[j] > val) {
                j --;
            }
            if (i > j) {
                break;
            }
            swap(nums, i, j);
            i ++;
            j --;
        }
        swap(nums, l, j);
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 11, 3, 1, -1, 12, 9, 8, -3};
        QuickSort insertSort = new QuickSort();
        insertSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
