public class equationsolver {
    public static void main(String[] args) {
        double testval = 1;
        double increment = 0.5;
        boolean leftGreater = false;
        int i = 0;
        while (i < 50) {
            double lefteq = Math.pow(Math.E,testval);
            double rightEq = Math.pow(testval,2)+2*testval+2;
            if (lefteq < rightEq) {
                testval += increment;
                if (leftGreater) {
                    increment /= 2;
                }
                leftGreater = false;
            }
            else {
                testval -= increment;
                if (! leftGreater) {
                    increment /= 2;
                }
                leftGreater = true;
            }
            System.out.println("Testing: " + testval + " Left Eq: " + lefteq + " Right Eq: " + rightEq);
            i++;
        }
    }
}