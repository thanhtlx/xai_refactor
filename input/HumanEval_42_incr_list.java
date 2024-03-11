class Problem {
    public static ArrayList<Long> incrList(ArrayList<Long> l) {


        return (ArrayList<Long>) l.stream().map(x -> x + 1).collect(Collectors.toList());
    }
}