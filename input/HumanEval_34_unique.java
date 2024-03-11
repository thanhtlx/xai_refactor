class Problem {
    public static ArrayList<Long> unique(ArrayList<Long> l) {


        Set<Long> s = new TreeSet<Long>(l);
        return new ArrayList<Long>(s);
    }
}