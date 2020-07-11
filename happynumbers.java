import java.util.ArrayList;

public class happynumbers {
    private static ArrayList<Integer> dupes = new ArrayList();
    public static void main(String[] args) {
        System.out.println(isHappy(94));
    }
    public static boolean isHappy(int number) {
        if (number == 1 || sum(Integer.parseInt(Integer.toString(number)+fillGap(number))) == 1) return true;
        if (dupes.contains(number)) {
            return false;
        }
        dupes.add(number);
        number = Integer.parseInt(Integer.toString(number)+fillGap(number));
        System.out.println(number);
        // if (Integer.toString(number).length() == 1) {
        //     if (Math.pow(number,2) == 1) {
        //         return true;
        //     }
        //     return isHappy((int) Math.pow(number, 2));
        // }
        // else if (Integer.toString(number).length() == 2) {
        //     return isHappy((int)(Math.pow(Integer.parseInt(Integer.toString(number).substring(0,1)),2)+Math.pow(Integer.parseInt(Integer.toString(number).substring(1,2)),2)));
        // }
        return isHappy(sum(number));
    }
    
    private static int sum(int number) {
        return (int)(Math.pow(Integer.parseInt(Integer.toString(number).substring(0,1)),2)+Math.pow(Integer.parseInt(Integer.toString(number).substring(1,2)),2)+Math.pow(Integer.parseInt(Integer.toString(number).substring(2,3)),2));
    }

    // public static boolean isHappy(int number) {
    //     dupes = new ArrayList();
    //     if (dupes.contains(number)) {
    //         return false;
    //     }
    //     dupes.add(number);
    //     return Integer.toString(number).length() == 1 ? Math.pow(number,2) == 1 ? true : isHappy((int) Math.pow(number, 2)) : (Math.pow(Integer.toString(number).charAt(0)-'0',2)+Math.pow(Integer.toString(number).charAt(1)-'0',2)) == 1 ? true : isHappy((int) (Math.pow(Integer.toString(number).charAt(0)-'0',2)+Math.pow(Integer.toString(number).charAt(1)-'0',2)));
    // }
    private static String fillGap(int number) {
        String ret = "";
        for (int i = 0; i < 3-Integer.toString(number).length(); i++) {
            ret += "0";
        }
        return ret;
    }
}