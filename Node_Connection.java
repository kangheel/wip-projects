import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Node_Connection {
    private static HashMap<Node, ArrayList<Node>> list = new HashMap();

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("node-paths.txt");
        Node[][] array = new Node[90][90];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = new Node(i,j);
                list.put(array[i][j],new ArrayList<Node>());
            }
        }
        
        // printArray(array);
        int count = 0;
        for (Node[] nodearr1: array) {
            for (Node node1: nodearr1) {
                for (Node[] nodearr2: array) {
                    for (Node node2: nodearr2) {
                        if (! node1.equals(node2)) {
                            double denom = 1.0*(node1.getX()-node2.getX());
                            if (denom == 0) {
                                if (! list.get(node1).contains(node2)) {
                                    if (node1.getY()-1 == node2.getY() || node1.getY()+1 == node2.getY()) {
                                        list.get(node1).add(node2);
                                        list.get(node2).add(node1);
                                        count++;
                                        // System.out.println(list + "\n");
                                    }
                                }
                            }
                            else {
                                double slope = (node1.getY()-node2.getY())/denom;
                                if (slope == 0) {
                                    if (! list.get(node1).contains(node2)) {
                                        if (node1.getX()-1 == node2.getX() || node1.getX()+1 == node2.getX()) {
                                            list.get(node1).add(node2);
                                            list.get(node2).add(node1);
                                            count++;
                                            // System.out.println(list + "\n");
                                        }
                                    }
                                }
                                else {
                                    if (! list.get(node1).contains(node2)) {
                                        if (slope == 1.0 || slope == -1.0) {
                                            if ((node1.getY()-1 == node2.getY() || node1.getY()+1 == node2.getY()) && (node1.getX()-1 == node2.getX() || node1.getX()+1 == node2.getX())) {
                                                list.get(node1).add(node2);
                                                list.get(node2).add(node1);
                                                count++;
                                                // System.out.println(list + "\n");
                                            }
                                        }
                                        else {
                                            list.get(node1).add(node2);
                                            list.get(node2).add(node1);
                                            count++;
                                            // System.out.println(list + "\n");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Node node : list.keySet()) {
            pw.println(node+": " + list.get(node) + "\n");
        }
        pw.println(count);
        pw.close();
    }
    public static void printArray(Node[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }
}
