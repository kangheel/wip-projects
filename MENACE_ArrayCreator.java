import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class MENACE_ArrayCreator {
    private static PrintWriter pw;

    public static void main(String[] args) throws FileNotFoundException {
        pw = new PrintWriter("MENACE-comb.txt");
        int[][] start = fill();
        ArrayList<int[][]> turn1 = new ArrayList<>(); // computer's turn
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[][] temp = fill(start);
                temp[i][j] = 0;
                turn1.add(temp);
            }
        }

        ArrayList<int[][]> pre_turn2 = new ArrayList<>(); //human's turn
        for (int[][] array : turn1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[][] temp = fill(array);
                    if (temp[i][j] == -1) {
                        temp[i][j] = 1;
                        pre_turn2.add(temp);
                    }
                }
            }
        }

        ArrayList<int[][]> turn2 = new ArrayList<>(); //human's turn
        for (int[][] array : pre_turn2) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[][] temp = fill(array);
                    if (temp[i][j] == -1) {
                        temp[i][j] = 0;
                        turn2.add(temp);
                    }
                }
            }
        }

        ArrayList<int[][]> pre_turn3 = new ArrayList<>(); //human's turn
        for (int[][] array : turn2) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[][] temp = fill(array);
                    if (temp[i][j] == -1) {
                        temp[i][j] = 1;
                        pre_turn3.add(temp);
                    }
                }
            }
        }

        ArrayList<int[][]> turn3 = new ArrayList<>(); //human's turn
        for (int[][] array : pre_turn3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[][] temp = fill(array);
                    if (temp[i][j] == -1) {
                        temp[i][j] = 0;
                        turn3.add(temp);
                    }
                }
            }
        }

        ArrayList<int[][]> pre_turn4 = new ArrayList<>(); //human's turn
        for (int[][] array : turn3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[][] temp = fill(array);
                    if (temp[i][j] == -1) {
                        temp[i][j] = 1;
                        pre_turn4.add(temp);
                    }
                }
            }
        }

        ArrayList<int[][]> turn4 = new ArrayList<>(); //human's turn
        for (int[][] array : pre_turn4) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[][] temp = fill(array);
                    if (temp[i][j] == -1) {
                        temp[i][j] = 0;
                        turn4.add(temp);
                    }
                }
            }
        }

        ArrayList<int[][]> pre_turn5 = new ArrayList<>(); //human's turn
        for (int[][] array : turn4) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[][] temp = fill(array);
                    if (temp[i][j] == -1) {
                        temp[i][j] = 1;
                        pre_turn5.add(temp);
                    }
                }
            }
        }

        ArrayList<int[][]> turn5 = new ArrayList<>(); //human's turn
        for (int[][] array : pre_turn5) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[][] temp = fill(array);
                    if (temp[i][j] == -1) {
                        temp[i][j] = 0;
                        turn5.add(temp);
                    }
                }
            }
        }

        // System.out.println(isSame(new int[][] {{0,0,1},{0,0,0},{0,0,0}}, new int[][] {{0,0,0},{0,0,0},{0,0,0}}));

        HashSet<int[][]> uniques = new HashSet<>();
        for (int[][] array : turn5) {
            if (uniques.size() == 0) {
                uniques.add(array);
            }
            HashSet<int[][]> temp = fill(uniques);
            for (int[][] unique : uniques) {
                if (! isSame(array, unique)) {
                    temp.add(array);
                }
            }
            uniques = temp;
        }

        pw.println(uniques.toString());
        pw.println(uniques.size());
        pw.close();
    }

    private static boolean isSame(int[][] array, int[][] unique) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] != unique[i][j]) return false;
            }
        }
        return true;
    }

    private static void printArray(ArrayList<int[][]> arrays) {
        for (int[][] array : arrays) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == 2) {
                        pw.print(array[i][j]);
                    }
                    else {
                        pw.print(array[i][j] + "|");
                    }
                }
                pw.println();
            }
            pw.println();
        }
        pw.println();
        pw.println();
    }

    private static int[][] fill() {
        int[][] ret = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ret[i][j] = -1;
            }
        }
        return ret;
    }

    private static int[][] fill(int[][] copy) {
        int[][] ret = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ret[i][j] = copy[i][j];
            }
        }
        return ret;
    }

    private static HashSet<int[][]> fill(HashSet<int[][]> set) {
        HashSet<int[][]> ret = new HashSet<>();
        for (int[][] array : set) {
            ret.add(array);
        }
        return ret;
    }
}