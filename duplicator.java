import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class duplicator {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("duplicated.txt");
        String str = "🐙🥑";
        int num = 10000000;
        for (int i = 1; i <= num; i++) {
            pw.print(str);
            if (i % 100 == 0) {
                pw.println();
            }
        }
        pw.close();
    }
}