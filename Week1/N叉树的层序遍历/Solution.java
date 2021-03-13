public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>(); //每层的列表
            int n = queue.size();
            for (int i=0;i<n;i++) {
                Node curr = queue.poll();
                level.add(curr.val);
                queue.addAll(curr.children);
            }
            res.add(level);
        }
        return res;
    }
}
