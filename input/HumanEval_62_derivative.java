class Problem {
    public static ArrayList<Long> derivative(ArrayList<Long> xs) {


        ArrayList<Long> result = new ArrayList<Long>();
        for (int i = 1; i < xs.size(); i++) {
            result.add(xs.get(i) * i);
        }
        return result;
    }
}