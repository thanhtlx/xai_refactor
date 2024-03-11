class Problem {
    public static long doAlgebra(ArrayList<String> op, ArrayList<Long> operand) {


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < operand.size(); i++) {
            sb.append(operand.get(i));
            if (i < op.size()) {
                sb.append(op.get(i));
            }
        }
        return (long) new BigInteger(sb.toString(), 16, new java.math.BigInteger("10")).longValue();
    }
}