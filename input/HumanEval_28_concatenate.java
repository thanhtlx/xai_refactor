class Problem {
    public static String concatenate(ArrayList<String> strings) {


        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }
}