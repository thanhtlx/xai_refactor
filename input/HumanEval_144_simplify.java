class Problem {
    public static boolean simplify(String x, String n) {


        String[] xParts = x.split("/");
        String[] nParts = n.split("/");
        BigInteger xNum = new BigInteger(xParts[0]);
        BigInteger xDen = new BigInteger(xParts[1]);
        BigInteger nNum = new BigInteger(nParts[0]);
        BigInteger nDen = new BigInteger(nParts[1]);
        BigInteger crossProduct = xNum.multiply(nDen).multiply(xDen.multiply(nNum));
        BigInteger product = xDen.multiply(nDen);
        return crossProduct.compareTo(BigInteger.ZERO) == 0 && product.compareTo(BigInteger.ZERO) != 0;
    }
}