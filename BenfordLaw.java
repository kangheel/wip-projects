public class BenfordLaw {
    public static void main(String[] args) {
        int b = 2;
        int iterations = 1000;
        int[] count = new int[10];
        try {
            for (int i = 0; i < iterations; i++) {
                String cur = ""+Math.pow(b,i);
                count[Integer.parseInt(cur.substring(0,1))]++;
            }
        }
        catch(Exception e) {

        }
        int i = 0;
        for (int c : count) {
            System.out.println(i + ": " + c*100.0/iterations +"%");
            i++;
        }
    }
}