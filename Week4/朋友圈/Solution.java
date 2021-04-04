package submit.Week4.朋友圈;
// https://leetcode-cn.com/problems/number-of-provinces/
public class Solution {
    class UnionFind {
        private int count;
        private int[] parent;
        public UnionFind (int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i=0;i<n;i++) 
                parent[i] = i;
        }
        public int find (int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union (int p, int q) {
            int rp = find(p);
            int rq = find(q);
            if (rp==rq) return;
            parent[rp] = rq;
            count--;
        }
        public int count(){
            return count;
        }
    }
    public int findCircleNum (int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i=0;i<n-1;i++) {
            for (int j=i+1;j<n;j++) {
                if (M[i][j]==1) uf.union(i,j);
            }
        }
        return uf.count;
    }
    public static void main (String[] args) {
        Solution solu = new Solution();
        int [][] M = {  {1 , 1 , 1 , 0 , 0 },
                        {1 , 1 , 0 , 0 , 0 } ,
                        {1 , 0 , 1 , 0 , 0 } ,
                        {0 , 0 , 0 , 1 , 1 } ,
                        {0 , 0 , 0 , 1 , 1 } };
        System.out.println(solu.findCircleNum(M));
        return;
    }
}
