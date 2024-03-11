class Problem {
    public static long specialFilter(ArrayList<Long> nums) {


        return nums.stream()
            .filter(n -> n > 10)
            .filter(n -> {
                String strN = String.valueOf(Math.abs(n));
                char first = strN.charAt(0);
                char last = strN.charAt(strN.length() - 1);
                return (first == '1' || first == '3' || first == '5' || first == '7' || first == '9') &&
                    (last == '1' || last == '3' || last == '5' || last == '7' || last == '9');
            })
            .count();
    }
}