/*
Problem: Partition Equal Subset Sum
Leetcode: 416
Difficulty: Medium

Approach:
- Convert to subset sum problem
- Target = totalSum / 2
- Use DP (0/1 Knapsack)

Time Complexity: O(n * target)
Space Complexity: O(target)
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[target];
    }
}