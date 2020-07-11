import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;

public class collatz {
    private static int iterations;

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("collatz.csv");
        int test = 100000;
        ArrayList<int[]> tmap = new ArrayList();
        for (int i = 1; i <= test; i++) {
            iterations = 1;
            if (i % 10000 == 0) {
                System.out.println("Testing " + i);
            }
            rcollatz(i);
            tmap.add(new int[] {iterations, i});
            // System.out.println();
        }
        for (int[] is : tmap) {
            pw.println(is[1]+","+(is[0]-2));
        }
        pw.close();
    }
    public static int rcollatz(int i) {
        // System.out.println(iterations + ": " + i);
        iterations++;
        if (i == 1) return 1;
        if (i % 2 == 0) return rcollatz(i/2);
        return rcollatz(3*i+1);
    }
}