class Problem {
    public static boolean isSorted(ArrayList<Long> lst) {


        for (int i = 0; i < lst.size() - 1; i++) {
            if (lst.get(i) >= lst.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}