class Problem {
    public static long startsOneEnds(long n) {


        if (n == 1) {
            return 1;
        }
        long[][] dp = new long[(int)n][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (j == 1 || k == 1) {
                        dp[i][j] += dp[i-1][k];
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i < 10; i++) {
            res += dp[(int)n-1][i];
        }
        return res;
    }
}