import java.util.ArrayList;

public class tester {
    public static void main(String[] args) {
        System.out.println(passwordGenerator(10));
        System.out.println(min(10,5));
        System.out.println(max(10,5));
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ints.add(i);
        }
        System.out.println(sum(ints));
        System.out.println(mean(ints));
        System.out.println(factorial(5));
    }
    public static String passwordGenerator(int length) {
        return length == 0 ? "" : (char) (Math.random()*93+33)+passwordGenerator(length-1);
    }
    public static int min(int i1, int i2) {
        return i1 > i2 ? i2 : i1;
    }
    public static int max(int i1, int i2) {
        return i2 > i1 ? i2 : i1;
    }
    public static double mean(ArrayList<Integer> ints) {
        return ((ArrayList<Integer>) ints.clone()).size() == 0 ? 0 : sum((ArrayList<Integer>)ints.clone())*1.0/ints.size();
    }
    public static int sum(ArrayList<Integer> ints) {
        ArrayList<Integer> t = (ArrayList<Integer>) ints.clone();
        return ((ArrayList<Integer>) ints.clone()).size() == 0 ? 0 : t.remove(0)+sum(t);
    }
    public static int factorial(int num) {
        return num == 0 ? 1 : num*factorial(num-1);
    }
}