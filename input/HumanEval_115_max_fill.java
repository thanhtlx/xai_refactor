class Problem {
    public static long maxFill(ArrayList<ArrayList<Long>> grid, long capacity) {


        long count = 0;
        for (ArrayList<Long> row : grid) {
            for (Long well : row) {
                if (well == 1) {
                    count++;
                }
            }
        }
        return (count + capacity - 1) / capacity;
    }
}