class Problem {
    public static ArrayList<Long> sortThird(ArrayList<Long> l) {


        ArrayList<Long> result = new ArrayList<Long>(l);
        ArrayList<Long> divisibleByThree = new ArrayList<Long>();
        for (int i = 0; i < l.size(); i++) {
            if (i % 3 == 0) {
                divisibleByThree.add(l.get(i));
            }
        }
        Collections.sort(divisibleByThree);
        for (int i = 0, j = 0; i < l.size(); i++) {
            if (i % 3 == 0) {
                result.set(i, divisibleByThree.get(j++));
            }
        }
        return result;
    }
}