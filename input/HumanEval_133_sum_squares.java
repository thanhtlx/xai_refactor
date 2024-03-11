class Problem {
    public static long sumSquares(ArrayList<Float> lst) {


        return lst.stream().mapToLong(value -> Math.round(value + 0.5)).map(value -> value * value).sum();
    }
}