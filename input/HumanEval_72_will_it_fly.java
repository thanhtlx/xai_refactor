class Problem {
    public static boolean willItFly(ArrayList<Long> q, long w) {


        long sum = q.stream().mapToLong(Long::longValue).sum();
        if (sum > w) {
            return false;
        }
        int start = 0;
        int end = q.size() - 1;
        while (start < end) {
            if (!q.get(start).equals(q.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}