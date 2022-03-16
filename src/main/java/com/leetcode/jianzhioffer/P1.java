package com.leetcode.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

public class P1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                res[0] = i;
                res[1] = map.get(target - num);
                return res;
            }
            map.put(num, i);
        }
        return null;
    }
}
