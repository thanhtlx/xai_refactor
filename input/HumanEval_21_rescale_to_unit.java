class Problem {
    public static ArrayList<Float> rescaleToUnit(ArrayList<Float> numbers) {


        float min = Collections.min(numbers);
        float max = Collections.max(numbers);
        float range = max - min;
        return (ArrayList<Float>) numbers.stream()
            .map(n -> (n - min) / range)
            .collect(Collectors.toList());
    }
}