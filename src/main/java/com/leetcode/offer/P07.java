package com.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kexinhan
 * @date 2022/3/16 15:15
 */
public class P07 {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        map = new HashMap<>(inorder.length);
        for(int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, 0, preorder.length - 1, inorder.length - 1);
    }

    private TreeNode buildTree(int[] pre, int[] in, int preL, int inL, int preR, int inR) {
        if (preL > preR) {
            return null;
        }
        TreeNode head = new TreeNode(pre[preL]);
        int index = map.get(pre[preL]);
        int lLen = index - inL;
        int rLen = inR - index;
        head.left = buildTree(pre, in, preL + 1, inL, preL + lLen, index - 1);
        head.right = buildTree(pre, in, preL + lLen + 1, index + 1, preR, index + rLen);
        return head;
    }
}
