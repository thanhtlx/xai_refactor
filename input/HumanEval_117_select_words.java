class Problem {
    public static ArrayList<String> selectWords(String s, long n) {


        ArrayList<String> words = new ArrayList<String>(Arrays.asList(s.split(" ")));
        ArrayList<String> result = new ArrayList<String>();
        for (String word : words) {
            long count = word.chars().filter(ch -> "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf((char)ch) >= 0).count();
            if (count == n) {
                result.add(word);
            }
        }
        return result;
    }
}