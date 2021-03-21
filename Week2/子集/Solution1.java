import java.util.Collections;

import org.graalvm.util.CollectionsUtil;

public class Solution1 {   //迭代
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for (int i=0;i<nums.length;i++) {
            int n = res.size();
            for (int j=0;j<n;j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
