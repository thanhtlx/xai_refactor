class Problem {
    public static long greatestCommonDivisor(long a, long b) {


        if (b == 0) {
            return a;
        } else {
            return greatestCommonDivisor(b, a % b);
        }
    }
}