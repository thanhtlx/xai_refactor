class Problem {
    public static ArrayList<Long> intersperse(ArrayList<Long> numbers, long delimeter) {


        ArrayList<Long> result = new ArrayList<Long>();
        for (int i = 0; i < numbers.size(); i++) {
            result.add(numbers.get(i));
            if (i < numbers.size() - 1) {
                result.add(delimeter);
            }
        }
        return result;
    }
}