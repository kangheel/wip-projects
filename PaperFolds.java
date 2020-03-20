public class PaperFolds {
    @FunctionalInterface
    interface GenericInterface<T> {
        T func(T t);
    }
    
    static GenericInterface<String> f1 = str -> {
        String r = "";
        for (int i = str.length()-1; i >= 0; i--) {
            r += str.charAt(i);
        }
        return r;
    };

    static GenericInterface<String> f2 = str -> {
        String r = "";
        for (int i = 0; i < str.length(); i++) {
            r += flip(str.charAt(i));
        }
        return r;
    };

    public static void main(String[] args) {
        System.out.println(paperFolds(5));
    }

    public static String paperFolds(int t) {
        return t == 0 ? "" : t == 1 ? "v" : reverseAndFlip(paperFolds(t - 1)) + "v" + paperFolds(t - 1);
    }

    public static String reverseAndFlip(String str) {
        return f2.func(f1.func(str));
    }
    public static char flip(char c) {
        return c == 'v' ? '^' : 'v';
    }
}