import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class WIPEncryption {
    private static String fileName;
    private static boolean newPrimes = false;
    private final static double CRITICAL_VALUE = 0.00001;

    public static void main(String[] args) throws FileNotFoundException {
        fileName = "code";
        String message = "Rachel is funny";
        message = wrap(message);
        message = wrap(message);
        // uncomment below if wanting to generate a new prime
        // newPrimes = true;
        if (newPrimes)
            reducePrime();
        double slope = pickPrime();
        BigDecimal intercept = new BigDecimal(message);
        if (Math.random() < 0.5)
            slope *= -1;
        if (Math.random() < 0.5)
            intercept.multiply(new BigDecimal(-1));

        PrintWriter exporter = new PrintWriter(fileName + ".txt");
        int magnitude = 10000;

        int generateNum = 10;
        exporter.println(message);
        for (int i = 0; i < generateNum; i++) {
            BigDecimal x_val = new BigDecimal((int) (Math.random()*magnitude)-magnitude/2);
            exporter.println(new Point(x_val, (new BigDecimal(slope)).multiply(x_val).add(intercept)));
        }
        exporter.close();
    }

    private static String wrap(String message) {
        String ret = "";
        for (char character : message.toCharArray()) {
            int intAppend = character;
            String append = Integer.toString(intAppend);
            if (intAppend < 100) append = "0"+append;
            ret += append;
        }
        return ret;
    }

    public static void reducePrime() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("primes.txt"));
        PrintWriter pw = new PrintWriter("reducedPrimeList.txt");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (Math.random() < CRITICAL_VALUE)
                pw.println(line);
        }
        scanner.close();
        pw.close();
    }

    public static long pickPrime() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("reducedPrimeList.txt"));
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (Math.random() < CRITICAL_VALUE)
                break;
        }
        return Long.valueOf(line);
    }
}