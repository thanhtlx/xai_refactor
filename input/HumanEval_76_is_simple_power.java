class Problem {
    public static boolean isSimplePower(long x, long n) {


        if (n == 1) {
            return x > 1;
        }
        if (n == 0) {
            return x == 0;
        }
        if (x == 1) {
            return true;
        }
        if (x == 0) {
            return false;
        }
        long i = 2;
        while (i <= x) {
            if (BigInteger.valueOf(n).pow((int) i).equals(BigInteger.valueOf(x))) {
                return true;
            }
            i++;
        }
        return false;
    }
}