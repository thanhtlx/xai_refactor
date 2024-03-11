class Problem {
    public static ArrayList<String> byLength(ArrayList<Long> arr) {


        ArrayList<String> result = new ArrayList<String>();
        String[] names = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        for (Long num : arr) {
            if (num >= 1 && num <= 9) {
                result.add(names[(int)num]);
            }
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
}