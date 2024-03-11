class Problem {
    public static ArrayList<Long> orderByPoints(ArrayList<Long> nums) {


        return nums.stream()
            .sorted(Comparator.comparing(Problem::getDigitSum).thenComparing(nums::indexOf))
            .collect(Collectors.toCollection(ArrayList::new));
    }
}