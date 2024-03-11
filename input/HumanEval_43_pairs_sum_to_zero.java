class Problem {
    public static boolean pairsSumToZero(ArrayList<Long> l) {


        HashSet<Long> s = new HashSet<Long>();
        for (long i : l) {
            if (s.contains(-i)) {
                return true;
            }
            s.add(i);
        }
        return false;
    }
}