class Problem {
    public static boolean validDate(String date) {


        if (date.isEmpty()) {
            return false;
        }
        String[] parts = date.split("-");
        if (parts.length != 3) {
            return false;
        }
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if (month == 2 && day > 29) {
            return false;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            return false;
        }
        if (month == 2 && day == 29 && (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))) {
            return false;
        }
        return true;
    }
}