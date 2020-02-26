import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Decode_Module {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("encoded.txt"));
        PrintWriter export = new PrintWriter("decoded.txt");
        String encoded = input.nextLine();
        encoded = repeatDecode(encoded);
        export.println(encoded);
        export.close();
    }

    public static String repeatDecode(String encoded) {
        String ret = new String(encoded);
        while (! Character.isAlphabetic(ret.charAt(0))) {
            ret = decode(ret);
        }
        return ret;
    }

    public static String decode(String encoded) {
        String flipped = flip(encoded);
        String ret = "";
        for(int i = 0; i < encoded.length(); i += 3) {
            char cur = (char) (Integer.parseInt(flipped.substring(i, i+3)));
            ret += cur;
        }
        return ret;
    }

    private static String flip(String message) {
        String ret = "";
        for (int i = message.length()-1; i >= 0; i--) {
            ret += message.charAt(i);
        }
        return ret;
    }
}