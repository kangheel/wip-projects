import java.util.Arrays;

public class cbtester {
    private int[] itemsSold;
    private double[] wages;
    public static void main(String[] args) {
        int[] k = new int[2];
        k[0] = 0;
        k[1] = 1;
        for (int i : k) {
            i = i + 10;
            System.out.println(i+" ");
        }
        for (int i : k) {
            System.out.println(i);
        }
    }
    public double computeBonusThreshold() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < itemsSold.length; i++) {
            min = Math.min(min, itemsSold[i]);
            max = Math.max(max, itemsSold[i]);
            sum += itemsSold[i];
        }
        return (sum-min-max)/(itemsSold.length-2);
    }
    public void computeWages(double fixedWage, double perItemWage) {
        double threshhold = computeBonusThreshold();
        for (int i = 0; i < itemsSold.length; i++) {
            wages[i] = (fixedWage + perItemWage*itemsSold[i]) * (itemsSold[i] > threshhold ? 1.1 : 1);
        }
    }
}