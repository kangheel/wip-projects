public class BenfordLaw {
    public static void main(String[] args) {
        int b = 2;
        int iterations = 10000;
        int[] count = new int[10];
        int z = 0;
        try {
            for (; z < iterations; z++) {
                String cur = ""+Math.pow(b,z);
                count[Integer.parseInt(cur.substring(0,1))]++;
            }
        }
        catch(Exception e) {

        }
        int i = 0;
        for (int c : count) {
            int draw = c*100/z;
            System.out.print(i + ": ");
            for (int j = 0; j < draw; j++) {
                System.out.print("*");
            }
            System.out.println();
            i++;
        }
    }
}