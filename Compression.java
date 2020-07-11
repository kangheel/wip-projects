import java.util.ArrayList;
import java.util.Arrays;

public class Compression {
    public static void main(String[] args) {
        System.out.println(compress(new int[] {1,1,1,1,1,1,1,1,1,1,2,2,2,3,3,3,3,3,3,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3}));
        System.out.println(compress(expand("[10]1[3]2[10]3[20]1[5]2[10]3")));
    }
    private static int[] expand(String numberList) {
        ArrayList<Integer> ret = new ArrayList<>();
        while (numberList.contains("[")) {
            for (int i = 0; i < Integer.parseInt(numberList.substring(numberList.indexOf("[")+1,numberList.indexOf("]"))); i++) {
                ret.add(Integer.parseInt(numberList.substring(numberList.indexOf("]")+1, numberList.indexOf("]")+2)));
            }
            numberList = numberList.substring(numberList.indexOf("]")+1);
        }
        return convertToArray(ret);
    }
    
    private static int[] convertToArray(ArrayList<Integer> arr) {
        int[] ret = new int[arr.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = arr.get(i);
        }
        return ret;
    }

    public static String compress(int[] numberList) {
        ArrayList<Integer> indiv = new ArrayList<>();
        indiv = sortUnique(indiv, numberList);
        ArrayList<Integer> length = new ArrayList<>();
        getLength(length, numberList);
        String ret = "";
        for (int i = 0; i < indiv.size(); i++) {
            ret += "["+length.get(i)+"]"+indiv.get(i);
        }
        return ret;
    }

    private static void getLength(ArrayList<Integer> length, int[] numberList) {
        int streak = 1;
        for (int i = 1; i < numberList.length; i++) {
            if (numberList[i-1] != numberList[i]) {
                length.add(streak);
                streak = 1;
            }
            else streak++;
        }
        length.add(streak);
    }

    private static ArrayList<Integer> sortUnique(ArrayList<Integer> arr, int[] numberList) {
        return arr.size() == 0 ? addIndex(arr, numberList) : numberList.length == 0 ? arr : arr.get(arr.size()-1) == numberList[0] ? sortUnique(arr, Arrays.copyOfRange(numberList, 1, numberList.length)) : addIndex(arr, numberList); 
    }

    private static ArrayList<Integer> addIndex(ArrayList<Integer> arr, int[] numberList) {
        arr.add(numberList[0]);
        return sortUnique(arr, Arrays.copyOfRange(numberList, 1, numberList.length));
    }
}