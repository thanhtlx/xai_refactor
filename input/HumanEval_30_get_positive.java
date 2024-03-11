class Problem {
    public static ArrayList<Long> getPositive(ArrayList<Long> l) {


        return (ArrayList<Long>) l.stream().filter(x -> x > 0).collect(Collectors.toList());
    }
}