import java.util.ArrayList;

public class apcshw {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        int i = 0;
        a.add(i);
        a.add(i);
        i = 1;
        System.out.println(a);
        ArrayList<Integer> b = a;
        System.out.println(b);
        System.out.println(a.equals(b));
        System.out.println(a.get(0).equals(a.get(1)));
        a.remove(0);
        System.out.println(a);
    }
}