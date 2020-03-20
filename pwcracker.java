import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class pwcracker {
    public static void main(String[] args) throws FileNotFoundException {
        String pw = "test";
        PrintWriter combs = new PrintWriter("pwcombinations.txt");
        int[] indexes = new int[pw.length()];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = 33;
        }
        while (! pw.equals(convert(indexes))) {
            indexes[0]++;
            int i = 0;
            while (indexes[i] == 126) {
                indexes[i] = 33;
                i++;
            } 
            indexes[i]++;
            combs.println(convert(indexes));
        }
        combs.println(convert(indexes));
        combs.close();
    }

    private static String convert(int[] indexes) {
        String ret = "";
        for (int i = 0; i < indexes.length; i++) {
            ret += (char) (indexes[i]);
        }
        return ret;
    }
}