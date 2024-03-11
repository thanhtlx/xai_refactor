class Problem {
    public static ArrayList<Long> countUpTo(long n) {


        ArrayList<Long> primes = new ArrayList<Long>();
        for (long i = 2; i < n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
}