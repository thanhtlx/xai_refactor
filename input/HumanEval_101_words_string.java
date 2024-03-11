class Problem {
    public static ArrayList<String> wordsString(String s) {


        String[] words = s.replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
        return new ArrayList<String>(Arrays.asList(words));
    }
}