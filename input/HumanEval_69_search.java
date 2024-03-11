class Problem {
    public static long search(ArrayList<Long> lst) {


        Map<Long, Long> map = new HashMap<>();
        for (long num : lst) {
            map.put(num, map.getOrDefault(num, 0l) + 1);
        }
        for (long num : lst) {
            if (map.get(num) >= num) {
                return num;
            }
        }
        return -1;
    }
}