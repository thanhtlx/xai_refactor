class Problem {
    public static String solve(long N) {


        String binary = Long.toBinaryString(N);
        int sum = 0;
        for (char c : binary.toCharArray()) {
            sum += c - '0';
        }
        return Integer.toBinaryString(sum);
    }
}