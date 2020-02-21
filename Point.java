import java.math.BigDecimal;

public class Point {
    BigDecimal x;
    BigDecimal y;
    BigDecimal z;
    public Point(BigDecimal x, BigDecimal y) {
        this(x,y,new BigDecimal(1.414));
    }
    public Point(BigDecimal x, BigDecimal y, BigDecimal z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        if (z.equals(new BigDecimal(1.414))) return "("+x+","+y+")";
        return "("+x+","+y+","+z+")";
    }
}