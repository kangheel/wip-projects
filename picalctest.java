public class picalctest {
    public static void main(String[] args) {
        int m1 = (int) (Math.pow(100,3));
        double v1 = 1;
        int m2 = 1;
        double v2 = 0;

        collide(m1,v1,m2,v2);
        System.out.println(v1);
        System.out.println(v2);
    }

    private static void collide(int m1, double v1, int m2, double v2) {
        double ec = calculateEnergyConst(m1,v1,m2,v2);
        double mc = calculateMomentumConst(m1,v1,m2,v2);

        double tv1 = 0;
        double tv2 = 0;
        int layer = 2;
        while (true) { 
            double p1 = 0.5*tv1*(mc-m2*v2); // \frac{1}{2}m_1v_1^2=\frac{v_1}{2}\left(mc-m_2v_2\right)
            // ec = p1 + \frac{m_2v_2^2}{2}
            double p2 = ec-p1;
            tv2 = p2*2*m2;
            double tec = calculateEnergyConst(m1, tv1, m2, tv2);
            double tmc = calculateMomentumConst(m1, tv1, m2, tv2);
            System.out.println("Original Energy Const: " + ec + " Original Momentum Const: " + mc);
            System.out.println("Modified Energy Const: " + tec + " Modified Momentum Const: " + tmc);
            System.out.println();
            if (ec < tec) {
                tv1 -= Math.pow(0.5,layer);
            }
            else {
                break;
            }
            layer++;
        }
        v1 = tv1;
        v2 = tv2;
    }

    private static double calculateMomentumConst(int m1, double v1, int m2, double v2) {
        return m1*v1+m2*v2;
    }

    private static double calculateEnergyConst(int m1, double v1, int m2, double v2) {
        return 0.5*m1*Math.pow(v1,2)+0.5*m2*Math.pow(v2,2);
    }
}