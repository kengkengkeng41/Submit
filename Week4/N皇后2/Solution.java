package submit.Week4.N皇后2;

// https://leetcode-cn.com/problems/n-queens-ii/description/
public class Solution {
    private int size;
    private int count;

    private void dfs(int row,int ld,int rd) {
        if (row == size) {  //传入时为0的位表示可放置
            count++;
            return;
        }  // size & 表示截取后n位   
        int pos = size & ( ~(row|ld|rd) ) ;  //冲突序列
        while (pos!=0) {   //仍有可放置位置
            int p = pos & (-pos) ;  //获取最后一位的1
            pos = pos - p ;    //将最后一位的1置0，以便后续的循环
            dfs(row|p , (ld|p)<<1 , (rd|p)>>1);
        }       //将当前位置产生的冲突加入冲突序列中
    }
    public int totalNQueens(int n) {
        count=0;
        size = (1<<n) - 1;  //获取低位n个1
        dfs(0,0,0);
        return count;
    }

    public static void main (String[] args) {   //4~15皇后的解法数
        Solution solu = new Solution();
        for (int i=4;i<=15;i++)
            System.out.println(i +":"+ solu.totalNQueens(i));
        return;
    }
}
