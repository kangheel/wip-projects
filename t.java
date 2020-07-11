import java.util.ArrayList;

public class t {
    public static void main(String[] args) {
        drawSquare(7,2,4);
    }
    public static void drawSquare(int x, int y, int len) {
        int xlen = len;
        if (x+len > 10) {
            xlen = 10-x;
        }
        int ylen = len;
        if (y-len < 0) {
            ylen = len-y;
        }
        int minlen = Math.min(xlen,ylen);
        System.out.println("side length = "+ minlen + ", area = " + (int) Math.pow(minlen,2));
        drawLine(x, y, x + minlen, y);
        drawLine(x, y, x, y-minlen);
        drawLine(x+minlen, y, x, y+minlen);
        drawLine(x, y-minlen, x + minlen, y-minlen);
    }

    public static void drawLine(int x1, int y1, int x2, int y2) {
        /* implementation not shown */
    }
}