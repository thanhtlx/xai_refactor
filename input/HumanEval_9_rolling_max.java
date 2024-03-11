class Problem {
    public static ArrayList<Long> rollingMax(ArrayList<Long> numbers) {


        ArrayList<Long> result = new ArrayList<Long>();
        long max = Long.MIN_VALUE;
        for (long num : numbers) {
            max = Math.max(max, num);
            result.add(max);
        }
        return result;
    }
}