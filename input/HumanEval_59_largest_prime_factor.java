class Problem {
    public static long largestPrimeFactor(long n) {


        long largest = -1;

        while (n % 2 == 0) {
            largest = 2;
            n >>= 1;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                largest = i;
                n = n / i;
            }
        }

        if (n > 2)
            largest = n;

        return largest;
    }
}