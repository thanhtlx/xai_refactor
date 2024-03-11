class Problem {
    public static String exchange(ArrayList<Long> lst1, ArrayList<Long> lst2) {


        long oddCount1 = lst1.stream().filter(n -> n % 2 != 0).count();
        long oddCount2 = lst2.stream().filter(n -> n % 2 != 0).count();
        if (oddCount1 > oddCount2) {
            return "NO";
        } else {
            return "YES";
        }
    }
}