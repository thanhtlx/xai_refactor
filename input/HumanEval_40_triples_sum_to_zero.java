class Problem {
    public static boolean triplesSumToZero(ArrayList<Long> l) {


        HashSet<Long> set = new HashSet<>();
        for (long num : l) {
            set.add(num);
        }
        for (long i : set) {
            for (long j : set) {
                if (set.contains(-i-j)) {
                    if (i != -i-j && i != j) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}