package com.zhongyu.hu;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 653. Two Sum IV - Input is a BST
 *
 * Given a Binary Search Tree and a target number, return true
 * if there exist two elements in the BST such that their sum
 * is equal to the given target.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 * Example 2:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 *
 *
 * 思路：
 * 先将BST转为list，遍历list查值
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/**
 * public class TwoSumIV {
 *
 *     public boolean findTarget(TreeNode root, int k) {
 *         List<Integer> list = new ArrayList();
 *         inorder(root, list);
 *         int i = 0, j = list.size() - 1;
 *         while(i < j) {
 *             int sum = list.get(i) + list.get(j);
 *             if(sum < k) {
 *                 i++;
 *             }else if(sum > k) {
 *                 j--;
 *             }else {
 *                 return true;
 *             }
 *         }
 *         return false;
 *     }
 *
 *     public void inorder(TreeNode root, List<Integer> list) {
 *         if(root == null) {
 *             return ;
 *         }
 *         inorder(root.left, list);
 *         list.add(root.val);
 *         inorder(root.right, list);
 *     }
 * }
 */

