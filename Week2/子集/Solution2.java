import java.awt.List;

public class Solution2 {   //递归
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> and = new ArrayList<List<Integer>>();
    public List<List<Integer>> sbusets(int[] nums) {
        dfs(0,nums);
        return ans;
    }
    public void dfs(int curr,int[] nums) {
        if (curr == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[curr]);
        dfs(curr+1,nums);
        t.remove(t.size()-1);
        dfs(curr+1,nums);
    }
}
