class Problem {
    public static ArrayList<Long> eat(long number, long need, long remaining) {


        long total = number;
        if (need < remaining) {
            total += need;
            remaining -= need;
        } else {
            total += remaining;
            remaining = 0;
        }
        return new ArrayList<Long>(Arrays.asList(total, remaining));
    }
}