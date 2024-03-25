class Solution {
    public int longestPalindromeSubseq(String s) {
        int m = s.length();
        String text1 = s;
        StringBuilder s2 = new StringBuilder(s);
        String text2 = s2.reverse().toString();
        

        int dp[][] = new int[m+1][m+1];

        for(int i = 0; i<=m;i++){
            Arrays.fill(dp[i],0);
        }
        for(int i = 1;i<=m;i++){
            for(int j = 1; j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][m];
    }
}