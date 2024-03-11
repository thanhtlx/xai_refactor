class Problem {
    public static ArrayList<String> filterBySubstring(ArrayList<String> strings, String substring) {


        return (ArrayList<String>) strings.stream()
            .filter(s -> s.contains(substring))
            .collect(Collectors.toList());
    }
}