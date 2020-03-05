import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Encode_Module {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("message.txt"));
        PrintWriter export = new PrintWriter("encoded.txt");
        while (input.hasNextLine()) {
            String message = input.nextLine();
            int layers = 3;
            String encoded = encode(message,layers);
            export.println(encoded);
            // if (Decode_Module.repeatDecode(encoded).equals(message)) {
                
            // }
            // else {
            //     throw new Exception("Invalid code. Try again.");
            // }
        }
        input.close();
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