class Problem {
    public static long specialFactorial(long n) {


        long result = 1;
        for (long i = n; i > 0; i--) {
            result *= factorial(i);
        }
        return result;
    }
}