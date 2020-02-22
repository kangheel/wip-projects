public class Node {
    private int x;
    private int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "<"+x+","+y+">";
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public boolean equals(Node node) {
        return (x == node.x) && (y == node.y);
    }
}