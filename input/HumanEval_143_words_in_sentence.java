class Problem {
    public static String wordsInSentence(String sentence) {


        String[] words = sentence.split(" ");
        List<String> primeWords = new ArrayList<>();
        for (String word : words) {
            if (isPrime(word.length())) {
                primeWords.add(word);
            }
        }
        return String.join(" ", primeWords);
    }
}