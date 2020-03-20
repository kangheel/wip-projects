import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class rng {
    private static double r;

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("randoms.txt"));
        r = 3.994999999999671;
        // while (r <= 4) {
            
        //     r += 0.001;
        // }
        // int[] bedigits = new int[10];
        // int[] mdigits = new int[10];
        // for (int i = 0; i < 10000; i++) {
        //     double mrandom = Math.random();
        //     double berandom = generateRandom();
        //     double reroll = Math.random();
        //     if (reroll < 0.55) {
        //         if (reroll < 0.45) {
        //             while ((int) (berandom*10) == 0 || (int) (berandom*10) == 9) {
        //                 berandom = generateRandom();
        //             }
        //         }
        //         else {
        //             while ((int) (berandom*10) == 9) {
        //                 berandom = generateRandom();
        //             }
        //         }
        //     }
        //     if (Double.isInfinite(berandom)) {
        //         break;
        //     }
        //     // pw.println(berandom);
        //     int befdigit = (int) (berandom*10);
        //     bedigits[befdigit]++;
        //     int mfdigit = (int) (mrandom*10);
        //     mdigits[mfdigit]++;
        // }
        int[] bedigits = new int[100];
        int[] mdigits = new int[100];
        for (int i = 0; i < 10000; i++) {
            double mrandom = Math.random();
            double berandom = generateRandom(r);
            double reroll = Math.random();
            if (Double.isInfinite(berandom)) {
                break;
            }
            if (reroll < 0.5) {
                if (reroll < 0.35) {
                    if ((int) (berandom*100) < 10) {
                        while ((int) (berandom*100) < 10 || ((int) (berandom*10) == 9) || (int) (berandom*10) == 0) {
                            berandom = generateRandom(r);
                        }
                    }
                    else {
                        while ((int) (berandom*10) == 0 || (int) (berandom*10) == 9) {
                            berandom = generateRandom(r);
                        }
                    }
                }
                else {
                    if ((int) (berandom*100) == 99) {
                        while ((int) (berandom*100) >= 90) {
                            berandom = generateRandom(r);
                        }
                    }
                    else {
                        double sreroll = Math.random();
                        if (sreroll < 0.35) {
                            while ((int) (berandom*10) == 9) {
                                berandom = generateRandom(r);
                            }
                        }
                    }
                }
            }
            // pw.println(berandom);
            int befdigit = (int) (berandom*100);
            bedigits[befdigit]++;
            int mfdigit = (int) (mrandom*100);
            mdigits[mfdigit]++;
        }
        int index = 0;
        for (int i : mdigits) {
            pw.println(index + ": " + i);
            index++;
        }
        pw.println();
        index = 0;
        for (int i : bedigits) {
            pw.println(index + ": " + i);
            index++;
        }
        // int index = 0;
        // boolean print = true;
        // int sum = 0;
        // for (int i : digits) {
        //     if (Math.abs(i) >= (2050)) {
        //         break;
        //     }
        //     else if (i == 0) {
        //         break;
        //     }
        //     sum += index*i;
        //     index++;
        // }
        // index = 0;
        // System.out.println(sum);
        // if ((int) (1.0*sum/10000) == 4) {
        //     pw.println(r);
        //     for (int i : digits) {
        //         pw.println(index + ": " + i);
        //         index++;
        //     }
        //     pw.println();
        // }
        pw.close();
    }

    public static double generateRandom(double r) {
        double prev = 0.5;
        double cur = calcPoint(r,prev);
        int index = 0;
        int random = (int) (Math.random()*(Math.random()*10000));
        while (random < 1000) {
            random = (int) (Math.random()*(Math.random()*10000));
        }
        while (true) {
            prev = cur;
            cur = calcPoint(r, prev);
            if (index == random) {
                break;
            }
            index++;
        }
        return cur;
    }

    private static double calcPoint(double r, double prev) {
        return r*prev*(1-prev);
    }
}