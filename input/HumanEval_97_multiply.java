class Problem {
    public static long multiply(long a, long b) {


        long a_unit_digit = Math.abs(a % 10);
        long b_unit_digit = Math.abs(b % 10);
        return a_unit_digit * b_unit_digit;
    }
}