class Problem {
    public static String antiShuffle(String s) {


        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.chars()
                    .sorted()
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString());
            result.append(" ");
        }
        return result.toString().trim();
    }
}