class Problem {
    public static long smallestChange(ArrayList<Long> arr) {


        int n = arr.size();
        long changes = 0;
        for (int i = 0; i <= n / 2; i++) {
            if (arr.get(i) != arr.get(n - 1 - i)) {
                changes++;
            }
        }
        return changes;
    }
}