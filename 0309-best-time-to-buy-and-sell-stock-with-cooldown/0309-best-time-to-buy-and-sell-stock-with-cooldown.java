class Solution {
    public int maxProfit(int[] prices) {
        int dp [][] = new int[prices.length][2];

        for(int i = 0; i<prices.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(prices, dp, 0,1);
    }

    public int solve(int[]prices, int[][]dp, int i, int buy){
        if(i >= prices.length){
            return 0;
        }

        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }

        int profit = 0;

        if(buy==1){
            int buyProfit = -prices[i] + solve(prices, dp, i+1, 0);
            int notBuyProfit = solve(prices, dp, i+1, 1);
            profit += Math.max(buyProfit, notBuyProfit);
        }
        else{
            int sellProfit = prices[i] + solve(prices, dp, i+2, 1);
            int notSellProfit = solve(prices, dp, i+1, 0);
            profit += Math.max(sellProfit, notSellProfit);
        }
        
        dp[i][buy] = profit;
        return dp[i][buy];

    }
}