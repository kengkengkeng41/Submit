package submit.Week2.二叉树的最近公共祖先;

// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class Solution {
    private TreeNode ans;
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);  //左子树是否包含p,q
        boolean rson = dfs(root.right, p, q); //右子树是否包含p,q
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson)))
            ans = root;  //当前结点为答案的情况：1.左右子树分别包含p,q ; 2.该结点为p或q

        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }


    public static void main(String [] args) {
        Solution s = new Solution();
        int[] input = {-1, 3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};  //下标为1的为树的第一个结点
        TreeNode curr = TreeNode.buildTree(input, 1);
        TreeNode p ,q;
        p = TreeNode.findNode(curr,5);
        q = TreeNode.findNode(curr,1);
        TreeNode ans = s.lowestCommonAncestor(curr,p,q);
        System.out.println(ans.val);
//        TreeNode.preOrderPrint(curr);

        return;
    }

}
