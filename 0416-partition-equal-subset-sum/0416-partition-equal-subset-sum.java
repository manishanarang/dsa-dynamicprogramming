class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;

        for(int i = 0; i<nums.length; i++){
            target += nums[i];
        }
        if(target %2!=0) return false;

        return subsetSum(nums,target/2);
    }

    public boolean subsetSum(int[] nums, int sum){
        int n = nums.length;

        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i = 0; i<=n;i++){
            dp[i][0] = true;
        }
        for(int j = 1; j<=sum;j++){
            dp[0][j] = false;
        }

        for(int i = 1; i<=n;i++){
            for(int j = 1;j<=sum;j++){
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }
        return dp[n][sum];
    }
}