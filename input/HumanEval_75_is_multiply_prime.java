class Problem {
    public static boolean isMultiplyPrime(long a) {


        if (a < 2) {
            return false;
        }
        int count = 0;
        for (int i = 2; i <= a; i++) {
            while (a % i == 0) {
                a /= i;
                count++;
            }
        }
        return count % 2 == 0;
    }
}