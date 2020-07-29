/*
* Given a binary tree, return the inorder traversal of its nodes' values.
* Follow up: Recursive solution is trivial, could you do it iteratively?
* */

import java.util.ArrayList;
import java.util.Stack;

public class BTInorderTraversal{

//    recursion
    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> r = new ArrayList<>();
        return traversal(r, root);
    }
    public  static ArrayList<Integer> traversal(ArrayList<Integer> r, TreeNode n){
        if(n == null) return r;
        traversal(r, n.left);
        r.add(n.val);
        traversal(r, n.right);
        return r;
    }

//    iteration
    public static ArrayList<Integer> solution2(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !st.isEmpty()){
            while(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    public static void main(String[] args){

    }
}