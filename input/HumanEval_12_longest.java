class Problem {
    public static Optional<String> longest(ArrayList<String> strings) {


        return strings.stream().max(Comparator.comparing(String::length));
    }
}