class Problem {
    public static String getClosestVowel(String word) {


        String vowels = "aeiouAEIOU";
        for (int i = word.length() - 2; i > 0; i--) {
            if (vowels.contains(Character.toString(word.charAt(i))) &&
                !vowels.contains(Character.toString(word.charAt(i - 1))) &&
                !vowels.contains(Character.toString(word.charAt(i + 1)))) {
                return Character.toString(word.charAt(i));
            }
        }
        return "";
    }
}