class Problem {
    public static ArrayList<String> allPrefixes(String string) {


        ArrayList<String> prefixes = new ArrayList<String>();
        for (int i = 0; i < string.length(); i++) {
            prefixes.add(string.substring(0, i + 1));
        }
        return prefixes;
    }
}