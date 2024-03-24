class Solution {
    public int maxProfit(int[] prices) {
        int dp [][][] = new int[prices.length][2][3];

        for(int i = 0; i<prices.length;i++){
            for(int buy=0;buy<2;buy++){
                Arrays.fill(dp[i][buy], -1);
            }
        }
        return solve(prices, dp, 0,1,2);
    }

    public int solve(int[]prices, int[][][]dp, int i, int buy, int cap){
        if(i >= prices.length || cap == 0){
            return 0;
        }

        if(dp[i][buy][cap]!=-1){
            return dp[i][buy][cap];
        }

        int profit = 0;

        if(buy==1){
            int buyProfit = -prices[i] + solve(prices, dp, i+1, 0,cap);
            int notBuyProfit = solve(prices, dp, i+1, 1,cap);
            profit += Math.max(buyProfit, notBuyProfit);
        }
        else{
            int sellProfit = prices[i] + solve(prices, dp, i+1, 1, cap-1);
            int notSellProfit = solve(prices, dp, i+1, 0,cap);
            profit += Math.max(sellProfit, notSellProfit);
        }
        
        dp[i][buy][cap] = profit;
        return dp[i][buy][cap];

    }
}