public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        // dp[i] represents the number of ways to decode the substring s[0:i]
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: Empty string can be decoded in 1 way
        dp[1] = 1; // First character can be decoded in 1 way

        for (int i = 2; i <= n; i++) {
            // Check if single digit is valid
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // Check if two digits is valid
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
