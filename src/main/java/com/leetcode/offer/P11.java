package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/16 15:51
 */
public class P11 {

    public int minArray(int[] numbers) {
        if(numbers == null || numbers.length == 0) {
            return -1;
        }
        int l = 0, r = numbers.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int num = numbers[mid];
            if (num > numbers[r]) {
                l = mid + 1;
            }
            else if (num == numbers[r]) {
                r --;
            }
            else {
                r = mid - 1;
            }
        }
        return numbers[l];
    }
}
