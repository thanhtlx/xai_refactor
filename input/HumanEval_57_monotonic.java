class Problem {
    public static boolean monotonic(ArrayList<Long> l) {


        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < l.size() - 1; i++) {
            if (l.get(i) > l.get(i + 1)) {
                increasing = false;
            }
            if (l.get(i) < l.get(i + 1)) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }
}