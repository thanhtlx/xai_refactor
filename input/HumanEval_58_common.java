class Problem {
    public static ArrayList<Long> common(ArrayList<Long> l1, ArrayList<Long> l2) {


        ArrayList<Long> result = new ArrayList<Long>();
        HashSet<Long> set1 = new HashSet<Long>(l1);
        HashSet<Long> set2 = new HashSet<Long>(l2);
        for (Long l : set1) {
            if (set2.contains(l)) {
                result.add(l);
            }
        }
        Collections.sort(result);
        return result;
    }
}