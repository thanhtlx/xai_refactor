class Problem {
    public static float median(ArrayList<Long> l) {


        Collections.sort(l);
        int size = l.size();
        if (size % 2 == 0) {
            return (float)(l.get(size / 2 - 1) + l.get(size / 2)) / 2;
        } else {
            return (float)l.get(size / 2);
        }
    }
}