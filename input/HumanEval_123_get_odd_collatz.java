class Problem {
    public static ArrayList<Long> getOddCollatz(long n) {


        ArrayList<Long> collatz = new ArrayList<Long>();
        while (n != 1) {
            if (n % 2 != 0) {
                collatz.add(n);
            }
            n = n % 2 == 0 ? n / 2 : 3 * n + 1;
        }
        collatz.add(1l);
        Collections.sort(collatz);
        return collatz;
    }
}