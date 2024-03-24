class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int i = 0;i<n;i++){
            total+=nums[i];
        }

        if((total-target)<0 || (total-target)%2!=0){
            return 0;
        }

        int sum = (total-target)/2;
        int dp[][] = new int[n+1][sum+1];
    
        for(int i = 0; i<=n;i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j<=sum;j++){
            dp[0][j]=0;
        }
        for(int i = 1; i<=n;i++){
            for(int j = 0; j<=sum;j++){
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}