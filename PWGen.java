import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PWGen {
    static PrintWriter export;

    public static void main(String[] args) throws FileNotFoundException {
        export = new PrintWriter("PW.csv");
        int length = 20;
        int count = 0;
        for (; count < 100; count++) {
            String pw = "";
            for (int i = 1; i <= length; i++) {
                char temp = (char)((int) (Math.random()*94)+33);
                while (temp == ',') {
                    temp = (char)((int) (Math.random()*94)+33);
                }
                pw += temp;
            }
            export.printf("%s,%s\n",count,pw);
        }
        export.close();
    }
}