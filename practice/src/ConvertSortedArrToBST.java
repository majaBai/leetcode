/*
* Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree
* in which the depth of the two subtrees of every node never differ by more than 1.
* */

public class ConvertSortedArrToBST{

//    private static class TreeNode{
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(){}
//        TreeNode(int val) {
//            this.val = val;
//        }
//        TreeNode(int val, TreeNode left, TreeNode right){
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }

    public static TreeNode solution(int[] nums){
        return insert(nums, 0, nums.length-1);
    }

    public static TreeNode insert(int[] nums, int lo, int hi){
        if(lo > hi) return null;
        int mid = (lo + hi) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        if(lo != hi){
            node.left = insert(nums, lo, mid - 1);
            node.right = insert(nums, mid +1, hi);
        }
        return node;
    }


    public static void main(String[] args){

    }
}