package com.leetcode;

/**
 * @author kexinhan
 * @date 2022/3/8 9:53
 */
public class P4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] nums = new int[m + n];
        while(i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i];
                i ++;
            }
            else {
                nums[k] = nums2[j];
                j ++;
            }
            k++;
        }
        if (i == m) {
            for (int index = j; index < n; index ++) {
                nums[k] = nums2[index];
                k ++;
            }
        }
        else {
            for (int index = i; index < m; index ++) {
                nums[k] = nums1[index];
                k ++;
            }
        }
        if ((n + m) % 2 == 0) {
            return  (nums[(m + n) / 2] + nums[(m + n) / 2 - 1]) / 2.0;
        }
        else {
            return nums[(m + n) / 2];
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // 合并奇偶数的情况
        int l = (m + n + 1) / 2 - 1;
        int r = (m + n) / 2;
        if (m == 0) {
            return (nums2[l] + nums2[r]) / 2.0;
        }
        if (n == 0) {
            return (nums1[l] + nums1[r]) / 2.0;
        }
        return (findKth(l, nums1, nums2, 0, 0) + findKth(r, nums1, nums2, 0, 0)) / 2.0;
    }

    public int findKth(int k, int[] nums1, int[] nums2, int start1, int start2) {
        int len1 = nums1.length - start1;
        int len2 = nums2.length - start2;
        if (len1 > len2) {
            return findKth(k, nums2, nums1, start2, start2);
        }
        if (len1 == 0) {
            return nums2[start2 + k];
        }
        if (k == 0) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(len1, k/2);
        int j = start2 + Math.min(len2, k/2);
        if (nums1[i] > nums2[j]) {
            return findKth(k - (j - start2 + 1), nums1, nums2, start1, j + 1);
        }
        else {
            return findKth(k - (i - start1 + 1), nums1, nums2, i + 1, start2);
        }

    }
}
