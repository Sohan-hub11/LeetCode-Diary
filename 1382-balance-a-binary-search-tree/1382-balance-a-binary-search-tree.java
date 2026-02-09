
 //Definition for a binary tree node.
 public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();

        //Step 1: Inorder Traversal.
        inOrder(root, list);

        //Step 2: Convert to Balanced BST.
        return createBST(list, 0, list.size()-1);
    }

    public void inOrder(TreeNode root, ArrayList<TreeNode> list){
        if(root == null){
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    public TreeNode createBST(ArrayList<TreeNode> list, int st, int end){
        if(st > end){
            return null;
        }
        int mid = (st + end)/2;
        TreeNode root = list.get(mid);

        root.left = createBST(list, st, mid-1);
        root.right = createBST(list, mid+1, end);
        return root;
    }
}