package submit.Week2.子集;

import java.util.List;
import java.util.ArrayList;

public class Solution2 {   //递归 DFS
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
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
