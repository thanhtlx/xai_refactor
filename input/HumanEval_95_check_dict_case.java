class Problem {
    public static boolean checkDictCase(HashMap<String,String> dict) {


        if (dict.isEmpty()) {
            return false;
        }
        boolean allLower = true;
        boolean allUpper = true;
        for (String key : dict.keySet()) {
            if (!key.equals(key.toLowerCase())) {
                allLower = false;
            }
            if (!key.equals(key.toUpperCase())) {
                allUpper = false;
            }
            if (!allLower && !allUpper) {
                break;
            }
        }
        return allLower || allUpper;
    }
}