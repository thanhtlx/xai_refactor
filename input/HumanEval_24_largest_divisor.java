class Problem {
    public static long largestDivisor(long n) {


        for (long i = n - 1; i > 0; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return -1;
    }
}