package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kexinhan
 * @date 2022/3/7 10:00
 */
public class P1 {
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num) && map.get(target - num) != i) {
                res[0] = i;
                res[1] = map.get(target - num);
                return res;
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey((target - num))) {
                res[0] = i;
                res[1] = map.get(target - num);
                return res;
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
