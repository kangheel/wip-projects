public class PasswordGenerator {
    static int pwCount;
    private int length;
    private String prefix;
    public PasswordGenerator(int length, String prefix) {
        this.length = length;
        this.prefix = prefix;
    }
    public PasswordGenerator(int length) {
        this(length,"A");
    }
    public String pwGen() {
        String ret = prefix+".";
        for (int i = 0; i < length; i++) {
            ret+=(int)(Math.random()*10);
        }
        pwCount++;
        return ret;
    }
}