import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;

public class sampling {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("samples.txt");
        for (int a = 0; a < 100; a++) {
            int maxsize = 500000;
            int randsize = (int) (Math.random()*maxsize);
            while (randsize <= maxsize/10) {
                randsize = (int) (Math.random()*maxsize);
            }
            int[] population = new int[randsize];
            pw.println("Real size:" + population.length);
            HashSet<Integer> checked = new HashSet<>();
            int s = maxsize/100; // number of animals marked and released
            for (int i = 0; i < s; i++) {
                int random = (int) (Math.random()*maxsize);
                while (random >= population.length || checked.contains(random)) {
                    random = (int) (Math.random()*maxsize);
                }
                
                checked.add(random);
                population[random] = 1;
            }

            int count = 0; // marked animals captured 2nd sampling
            int n = Math.min(population.length-1,maxsize/10); // total numbers captured 2nd time
            for (int i = 0; i < n; i++) {
                int random = (int) (Math.random()*maxsize);
                while (random >= population.length) {
                    random = (int) (Math.random()*maxsize);
                }
                
                if (population[random] == 1) {
                    count++;
                }
            }
            pw.println("Estimated population: " + s*n/count);
            pw.println("Absolute Difference: " + Math.abs(population.length-s*n/count));
            pw.println("Percent Difference: " + Math.round(10000.0*Math.abs(population.length-s*n/count)/population.length)/100.0 + "%");
            pw.println();
        }
        pw.close();
    }
}