class Problem {
    public static long modp(long n, long p) {


        if (n == 0) {
            return 1;
        }
        long res = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                res = (res * 2) % p;
            }
            n >>= 1;
            if (n > 0) {
                res = (res * res) % p;
            }
        }
        return res;
    }
}