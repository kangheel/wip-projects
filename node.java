import java.util.HashMap;
public class Node_Connection {
    private static HashMap<Node, Node> list = new HashMap<>();
    public static void main(String[] args) {
        Node[][] array = new Node[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = new Node(i,j);
            }
        }
        
        printArray(array);
        int count = 0;
        for (Node[] nodearr1: array) {
            for (Node node1: nodearr1) {
                for (Node[] nodearr2: array) {
                    for (Node node2: nodearr2) {
                        double denom = 1.0*(node1.getX()-node2.getX());
                        if (denom == 0) {
                            if (list.getOrDefault(node1,new Node(-1,-1)).equals(new Node(-1,-1))) {
                                    list.put(node1, node2);
                                    list.put(node2, node1);
                                    count++;
                            }
                            else {
                                System.out.println(node1);
                                System.out.println(node2);
                            }
                        }
                        else {
                            double slope = (node1.getY()-node2.getY())/denom;
                            if (slope == 0) {
                                if (list.getOrDefault(node1,new Node(-1,-1)).equals(new Node(-1,-1))) {
                                    list.put(node1, node2);
                                    list.put(node2, node1);
                                    count++;
                                }
                                else {
                                    System.out.println(node1);
                                    System.out.println(node2);
                                }
                            }
                            else {
                                if (list.getOrDefault(node1,new Node(-1,-1)).equals(new Node(-1,-1))) {
                                    list.put(node1, node2);
                                    list.put(node2, node1);
                                    count++;
                                }
                                else {
                                    System.out.println(node1);
                                    System.out.println(node2);
                                }
                            }
                        }
                        System.out.println(list);
                    }
                }
            }
        }
        System.out.println(count);
    }
    public static void printArray(Node[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }
}
