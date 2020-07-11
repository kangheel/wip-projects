public class testequationsolver {
    public static void main(String[] args) {
        int lowerX = -100;
        int highX = 100;
        double val1 = evaluateEquation1(lowerX);
        double val2 = evaluateEquation2(highX);
        while (true) {
            boolean rightpos = val1 > 0;
            boolean leftpos = val2 > 0;
            if (rightpos && leftpos) {
                if (Math.abs(val1) > Math.abs(val2)) {
                    lowerX += (Math.abs(lowerX)+Math.abs(highX))/2;
                }
                else {
                    highX -= (Math.abs(lowerX)+Math.abs(highX))/2;
                }
            }
            else {
                lowerX += (Math.abs(lowerX)+Math.abs(highX))/2;
                highX -= (Math.abs(lowerX)+Math.abs(highX))/2;
            }
            if (Math.abs(val1) <= 1) {
                System.out.println(lowerX);
                System.out.println(val1);
                break;
            }
            else if (Math.abs(val2) <= 1) {
                System.out.println(highX);
                System.out.println(val2);
                break;
            }
            val1 = evaluateEquation1(lowerX);
            val2 = evaluateEquation2(highX);
        }
    }

    private static double evaluateEquation1(double start) {
        return Math.pow(start,2)-4;
    }

    private static double evaluateEquation2(double start) {
        return start; // f(x) = x
    }
    
}