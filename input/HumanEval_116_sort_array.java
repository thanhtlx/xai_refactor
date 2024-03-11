class Problem {
    public static ArrayList<Long> sortArray(ArrayList<Long> arr) {


        return (ArrayList<Long>) arr.stream()
            .sorted(Comparator.comparing(Problem::countOnes).thenComparing(Long::longValue))
            .collect(Collectors.toList());
    }
}