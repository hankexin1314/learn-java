package com.leetcode.jianzhioffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (helper(nums1, 0, nums2, 0, l) + helper(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private int helper(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int index1 = Math.min(nums1.length, i + k / 2)  -1;
        int index2 = Math.min(nums2.length, j + k / 2)  -1;
        int num1 = nums1[index1];
        int num2 = nums2[index2];
        if (num1 > num2) {
            return helper(nums1, i, nums2, index2 + 1, k - (index2 - j + 1));
        } else {
            return helper(nums1, index1 + 1, nums2, j, k - (index1 - i + 1));
        }
    }
}
