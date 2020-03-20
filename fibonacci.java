public class fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(23));
    }
    public static int fibonacci (int t) {
        return t == 0 || t == 1 ? t : fibonacci(t-1)+fibonacci(t-2);
    }
}