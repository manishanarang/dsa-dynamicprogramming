class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int n = s.length(), count = 0;
        int[] dp = new int[3];
        dp[0] = 1;
        if (s.charAt(0) != '0') {
            dp[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i % 3] = 0;
            if (s.charAt(i - 1) != '0') dp[i % 3] = dp[(i - 1) % 3];
            if (s.charAt(i - 2) > '2' || s.charAt(i - 2) <= '0') continue;
            if (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') dp[i % 3] += dp[(i - 2) % 3];
            if (s.charAt(i - 2) == '1') dp[i % 3] += dp[(i - 2) % 3];
        }
        return dp[n % 3];
    }
}