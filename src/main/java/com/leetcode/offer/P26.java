package com.leetcode.offer;

/**
 * @author kexinhan
 * @date 2022/3/21 15:47
 */
public class P26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        else if (A == null) {
            return false;
        }
        else if (A.val == B.val) {
            return dfs(A.left, B.left) && dfs(A.right, B.right);
        }
        else {
            return false;
        }
    }
}
