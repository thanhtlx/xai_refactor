class Problem {
    public static boolean anyInt(float x, float y, float z) {


        if (x == (int)x && y == (int)y && z == (int)z) {
            if (x == y + z || y == x + z || z == x + y) {
                return true;
            }
        }
        return false;
    }
}