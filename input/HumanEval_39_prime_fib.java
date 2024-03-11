class Problem {
    public static long primeFib(long n) {


        long fib1 = 1, fib2 = 1, fib3 = 2;
        long primeCount = 2;
        while (primeCount < n) {
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib1 + fib2;
            if (isPrime(fib3)) {
                primeCount++;
            }
        }
        return fib3;
    }
}