class Problem {
    public static boolean belowThreshold(ArrayList<Long> l, long t) {


        for (Long num : l) {
            if (num >= t) {
                return false;
            }
        }
        return true;
    }
}