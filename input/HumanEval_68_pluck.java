class Problem {
    public static ArrayList<Long> pluck(ArrayList<Long> arr) {


        long min = Long.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 == 0 && arr.get(i) < min) {
                min = arr.get(i);
                index = i;
            }
        }
        if (index == -1) {
            return new ArrayList<>();
        } else {
            return new ArrayList<>(Arrays.asList(min, (long)index));
        }
    }
}