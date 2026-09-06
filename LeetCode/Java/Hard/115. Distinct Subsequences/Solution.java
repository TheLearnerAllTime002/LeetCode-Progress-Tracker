class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length();

        // dp[j] = number of ways to form t.substring(0, j)
        long[] dp = new long[m + 1];
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Iterate backwards to avoid reusing the same character
            for (int j = m; j >= 1; j--) {
                if (ch == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return (int) dp[m];
    }
}