public class ncurve {
    public static void main(String[] args) {
        int bound = 10;
        int[] total = new int[bound];
        int iterations = 1000000;
        for (int i = 0; i < iterations; i++) {
            int random1 = (int) (Math.random()*bound);
            int random2 = (int) (Math.random()*bound);
            total[Math.abs((bound-1)-(random1+random2))]++;
        }
        int i = 0;
        for (int c : total) {
            System.out.println(i + ": " + c*100.0/iterations +"%");
            i++;
        }
    }
}