public class logicaloperators {
    public static void main(String[] args) {
        int a = 127;
        int b = 1;
        String stringA = convertToBinary(a);
        String stringB = convertToBinary(b);
        System.out.println(stringA);
        System.out.println(stringB);
        int dlen = stringB.length()-stringA.length();
        if (dlen > 0) {
            stringA = getFiller(dlen) + stringA;
        }
        else if (dlen < 0) {
            stringB = getFiller(-1*dlen) + stringB;
        }
        String sumBinary = addBinary(stringA, stringB);
        System.out.println(a+"+"+b+"="+(a+b));
        System.out.println(stringA+"+"+stringB+"="+sumBinary);
        System.out.println(sumBinary+"="+convertToDecimal(sumBinary)+"\n");
        while (convertToDecimal(sumBinary) == (a+b)) {
            a = (int) (Math.random()*10);
            b = (int) (Math.random()*10);
            stringA = convertToBinary(a);
            stringB = convertToBinary(b);
            System.out.println(stringA);
            System.out.println(stringB);
            dlen = stringB.length()-stringA.length();
            if (dlen > 0) {
                stringA = getFiller(dlen) + stringA;
            }
            else if (dlen < 0) {
                stringB = getFiller(-1*dlen) + stringB;
            }
            sumBinary = addBinary(stringA, stringB);
            System.out.println(a+"+"+b+"="+(a+b));
            System.out.println(stringA+"+"+stringB+"="+sumBinary);
            System.out.println(sumBinary+"="+convertToDecimal(sumBinary)+"\n");
        }
    }

    private static String addBinary(String stringA, String stringB) {
        int dlen = stringB.length()-stringA.length();
        if (dlen > 0) {
            stringA = getFiller(dlen) + stringA;
        }
        else if (dlen < 0) {
            stringB = getFiller(-1*dlen) + stringB;
        }
        StringBuffer ret = new StringBuffer("0"+stringA);
        for (int i = stringB.length(); i > 0; i--) {
            ret.setCharAt(i, (char)(ret.charAt(i)+Integer.parseInt(stringB.substring(i-1,i))));
        }
        while (ret.toString().indexOf("3") != -1 || ret.toString().indexOf("2") != -1) {
            for (int j = ret.length()-1; j > 0; j--) {
                if (ret.charAt(j) == '2') {
                    ret.setCharAt(j, '0');
                    ret.setCharAt(j-1, (char)(ret.charAt(j-1)+1));
                }
                else if (ret.charAt(j) == '3') {
                    ret.setCharAt(j, '1');
                    ret.setCharAt(j-1, (char)(ret.charAt(j-1)+1));
                }
            }
        }
        return ret.toString().substring(0,1).equals("0") ? ret.toString().substring(1) : ret.toString();
    }

    private static String getFiller(int dlen) {
        return dlen == 0 ? "" : "0"+getFiller(dlen-1);
    }

    private static int convertToDecimal(String str) {
        return str.length() == 0 ? 0 : ((int)Math.pow(2,str.length()-1))*Integer.parseInt(str.substring(0,1))+convertToDecimal(str.substring(1));
    }

    private static String convertToBinary(int a) {
        String ret = "";
        for (int i = (int) (Math.log(a)/Math.log(2)); i >= 0; i--) {
            if (a - Math.pow(2, i) >= 0) {
                ret += "1";
                a -= Math.pow(2, i);
            }
            else {
                ret += "0";
            }
        }
        return ret;
    }
}