class Problem {
    public static ArrayList<Pair<Long, Long>> getRow(ArrayList<ArrayList<Long>> lst, long x) {


        ArrayList<Pair<Long, Long>> result = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < lst.get(i).size(); j++) {
                if (lst.get(i).get(j) == x) {
                    result.add(Pair.with(i, j));
                }
            }
        }
        result.sort(Comparator.comparing(Pair::getValue0).thenComparing(Pair::getValue1, Comparator.reverseOrder()));
        return result;
    }
}