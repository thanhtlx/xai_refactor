class Problem {
    public static long digits(long n) {


        long product = 1;
        boolean oddFound = false;
        while (n > 0) {
            long digit = n % 10;
            if (digit % 2 != 0) {
                product *= digit;
                oddFound = true;
            }
            n /= 10;
        }
        return oddFound ? product : 0;
    }
}