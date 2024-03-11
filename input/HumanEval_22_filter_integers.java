class Problem {
    public static ArrayList<Long> filterIntegers(ArrayList<Object> values) {


        ArrayList<Long> result = new ArrayList<Long>();
        for (Object value : values) {
            if (value instanceof Long) {
                result.add((Long)value);
            }
        }
        return result;
    }
}