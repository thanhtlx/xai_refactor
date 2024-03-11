class Problem {
    public static Pair<Long, Long> evenOddPalindrome(long n) {


        long even = 0, odd = 0;
        for (long i = 1; i <= n; i++) {
            if (isPalindrome(i)) {
                if (i % 2 == 0)
                    even++;
                else
                    odd++;
            }
        }
        return new Pair<Long, Long>(even, odd);
    }
}