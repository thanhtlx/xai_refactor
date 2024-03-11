class Problem {
    public static String findMax(ArrayList<String> words) {


        return words.stream()
            .max(Comparator.comparing(word -> {
                Set<Character> uniqueChars = new HashSet<>();
                for (char c : word.toCharArray()) {
                    uniqueChars.add(c);
                }
                return new Pair<>(uniqueChars.size(), word);
            }))
            .get()
            .getValue1();
    }
}