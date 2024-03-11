class Problem {
    public static ArrayList<Long> factorize(long n) {


        ArrayList<Long> factors = new ArrayList<Long>();
        for (long i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }
}