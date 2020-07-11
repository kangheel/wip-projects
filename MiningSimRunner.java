import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class MiningSimRunner {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        for (int i = 0; i < 10000; i++) {
            miningsim.main(new String[0]);
            TimeUnit.MILLISECONDS.sleep(250);
        }
    }
}