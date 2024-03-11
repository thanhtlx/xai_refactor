class Problem {
    public static boolean isEqualToSumEven(long n) {


        if (n < 10) {
            return false;
        }
        long sum = 0;
        for (long i = 2; i <= n / 2; i += 2) {
            sum += i;
            if (sum == n) {
                return true;
            }
            if (sum > n) {
                return false;
            }
        }
        return false;
    }
}