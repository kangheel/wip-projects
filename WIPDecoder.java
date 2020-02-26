import java.math.BigDecimal;

public class WIPDecoder {
    public static final double DELTA = 0.0001;
    public static void main(String[] args) {
        String code1 = "(-915,48056050048057055048057057049048052049048049049048056048051050049048053049049053048051050049048050049049055049049048049048133409883044)";
        String code2 = "(2305,48056050048057055048057057049048052049048049049048056048051050049048053049049053048051050049048050049049055049049048049051352140066384)";
        String message = "048056050048057055048057057049048052049048049049048056048051050049048053049049053048051050049048050049049055049049048049049048049050049";

        BigDecimal[] code1_xy = new BigDecimal[2];
        BigDecimal[] code2_xy = new BigDecimal[2];
        code1_xy[0] = new BigDecimal(Double.parseDouble(code1.substring(1,code1.indexOf(","))));
        code1 = code1.substring(code1.indexOf(",")+1);
        code1_xy[1] = new BigDecimal(Double.parseDouble(code1.substring(0,code1.indexOf(")"))));
        code2_xy[0] = new BigDecimal(Double.parseDouble(code2.substring(1,code2.indexOf(","))));
        code2 = code2.substring(code2.indexOf(",")+1);
        code2_xy[1] = new BigDecimal(Double.parseDouble(code2.substring(0,code2.indexOf(")"))));

        BigDecimal slope = (code1_xy[1].subtract(code2_xy[1])).divide(code1_xy[0].subtract(code2_xy[0]));
        String code = "0"+code1_xy[1].subtract(slope.multiply(code1_xy[0])).toString();
        code = unwrap(code);
        code = unwrap(code);
        System.out.println(code);
    }

    private static String unwrap(String code) {
        String ret = "";
        for (int i = 0; i < code.length(); i+=3) {
            String cur = code.substring(i, i+3);
            char append = (char) Integer.parseInt(cur);
            ret += append;
        }
        return ret;
    }
}