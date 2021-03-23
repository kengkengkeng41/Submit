package submit.Week2.二叉树的最近公共祖先;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static TreeNode buildTree (int[] tree , int i) {  //二叉树建立函数
        if (i >= tree.length || tree[i] == -1)   //用数组值为-1来表示当前结点为空
            return null;
        TreeNode curr = new TreeNode(tree[i]);
        curr.left = buildTree(tree , i*2);
        curr.right = buildTree(tree , i*2+1);
        return curr;
    }

    public static TreeNode findNode (TreeNode root , int value) {   //查找值为value的结点，并返回其引用
        if (root==null) return null;
        if (root.val==value) return root;
        return findNode(root.left,value)!=null ? findNode(root.left,value) : findNode(root.right,value);
    }

    public static void preOrderPrint (TreeNode root) {   //先序遍历
        if (root == null)
            return;
        System.out.print(root.val+" ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }
}
