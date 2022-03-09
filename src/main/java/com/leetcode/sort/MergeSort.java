package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author kexinhan
 * @date 2022/3/9 11:21
 */
public class MergeSort {
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
        int mid = (r - l) / 2 + l;
        sort(nums, l, mid);
        sort(nums, mid + 1, r);
        if (nums[mid] > nums[mid + 1]) {
            merge(nums, l, r, mid);
        }
    }
    private void merge(int[] nums, int l, int r, int mid) {
         int[] aux = Arrays.copyOfRange(nums, l, r + 1);
         int i = l, j = mid + 1;
         for (int k = l; k <= r; k ++) {
             if (i > mid) {
                 nums[k] = aux[j - l];
                 j ++;
             }
             else if (j > r) {
                 nums[k] = aux[i - l];
                 i ++;
             }
             else if (aux[i - l] <= aux[j - l]) {
                 nums[k] = aux[i - l];
                 i ++;
             }
             else {
                 nums[k] = aux[j - l];
                 j ++;
             }
         }
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 11, 3, 1, -1, 12, 9, 8, -3};
        MergeSort insertSort = new MergeSort();
        insertSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
