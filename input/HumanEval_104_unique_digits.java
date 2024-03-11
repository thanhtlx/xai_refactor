class Problem {
    public static ArrayList<Long> uniqueDigits(ArrayList<Long> x) {


        ArrayList<Long> result = new ArrayList<Long>();
        for (Long num : x) {
            if (!hasEvenDigit(num)) {
                result.add(num);
            }
        }
        Collections.sort(result);
        return result;
    }
}