class Problem {
    public static boolean moveOneBall(ArrayList<Long> arr) {


        if (arr.size() == 0)
            return true;
        int count = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1))
                count++;
        }
        if (arr.get(arr.size() - 1) > arr.get(0))
            count++;
        return count <= 1;
    }
}