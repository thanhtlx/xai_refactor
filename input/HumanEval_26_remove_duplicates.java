class Problem {
    public static ArrayList<Long> removeDuplicates(ArrayList<Long> numbers) {


        ArrayList<Long> result = new ArrayList<>();
        HashMap<Long, Integer> counts = new HashMap<>();
        for (Long number : numbers) {
            counts.put(number, counts.getOrDefault(number, 0) + 1);
        }
        for (Long number : numbers) {
            if (counts.get(number) == 1) {
                result.add(number);
            }
        }
        return result;
    }
}