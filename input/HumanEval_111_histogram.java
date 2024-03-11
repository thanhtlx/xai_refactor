class Problem {
    public static HashMap<String,Long> histogram(String test) {


        HashMap<String,Long> map = new HashMap<>();
        String[] words = test.split(" ");
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word, 1l);
            }
        }
        long max = Collections.max(map.values());
        return (HashMap<String,Long>) map.entrySet().stream()
            .filter(e -> e.getValue() == max)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}