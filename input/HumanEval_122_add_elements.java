class Problem {
    public static long addElements(ArrayList<Long> arr, long k) {


        long sum = 0;
        for (int i = 0; i < k; i++) {
            if (String.valueOf(arr.get(i)).length() <= 2) {
                sum += arr.get(i);
            }
        }
        return sum;
    }
}