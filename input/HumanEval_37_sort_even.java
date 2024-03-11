class Problem {
    public static ArrayList<Long> sortEven(ArrayList<Long> l) {


        ArrayList<Long> evenIndices = new ArrayList<Long>();
        ArrayList<Long> oddIndices = new ArrayList<Long>();
        for (int i = 0; i < l.size(); i++) {
            if (i % 2 == 0) {
                evenIndices.add(l.get(i));
            } else {
                oddIndices.add(l.get(i));
            }
        }
        Collections.sort(evenIndices);
        ArrayList<Long> result = new ArrayList<Long>();
        for (int i = 0; i < l.size(); i++) {
            if (i % 2 == 0) {
                result.add(evenIndices.get(i / 2));
            } else {
                result.add(oddIndices.get(i / 2));
            }
        }
        return result;
    }
}