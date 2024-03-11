class Problem {
    public static Pair<Float, Float> findClosestElements(ArrayList<Float> numbers) {


        Collections.sort(numbers);
        float minDifference = Float.MAX_VALUE;
        float minNumber1 = 0, minNumber2 = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            float difference = numbers.get(i + 1) - numbers.get(i);
            if (difference < minDifference) {
                minDifference = difference;
                minNumber1 = numbers.get(i);
                minNumber2 = numbers.get(i + 1);
            }
        }
        return Pair.with(minNumber1, minNumber2);
    }
}