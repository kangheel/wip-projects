import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Encoder {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter export = new PrintWriter("encoded.txt");
        String message = "Added new files 3/27/20";
        export.println(encode(message, 3));
        export.close();
    }
    public static String encode(String message, int times) {
        if (times == 0) {
            return message;
        }
        String ret = "";
        for (char character : message.toCharArray()) {
            int intAppend = character;
            String append = Integer.toString(intAppend);
            if (intAppend < 100) append = "0"+append;
            ret += append;
        }
        return encode(flip(ret),times-1);
    }
    private static String flip(String message) {
        String ret = "";
        for (int i = message.length()-1; i >= 0; i--) {
            ret += message.charAt(i);
        }
        return ret;
    }
}