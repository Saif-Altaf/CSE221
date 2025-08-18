//import java.util.ArrayList;
//
//class Solution {
//
//public static int[]arr;
//    public static int size;
//    public int[] findMode(TreeNode root) {
//        findSize(root);
//        arr=new int[size];
//        findMode(root);
//        for (int i = 0; i < arr.length; i++) {
//
//        }
//    }
//
//    private void findSize(TreeNode root){
//        if(root==null){
//            return;
//        }
//        size++;
//        findSize(root.left);
//        findSize(root.right);
//    }
//
//    private void findMode(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        arr[root.val]=arr[root.val]++;
//        findMode(root.left);
//        findMode(root.right);
//    }
//
//}
