class Problem {
    public static ArrayList<String> filterByPrefix(ArrayList<String> strings, String prefix) {


        return (ArrayList<String>) strings.stream()
            .filter(s -> s.startsWith(prefix))
            .collect(Collectors.toList());
    }
}