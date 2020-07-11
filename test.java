import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] sample = new int[] {1,2,3,4,5};
        System.out.println(sample);
        System.out.println(Arrays.toString(sample));
        for (int i : sample) {
            System.out.println(i + " ");
        }
        System.out.println(toString(sample));
    }
    public static String toString(int[] o) {
        return o.length != 1 ? o[0]+","+toString(Arrays.copyOfRange(o, 1, o.length)) : o[0] + "";
    }
}