import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class MENACE_ArrayCreator {
    private static PrintWriter pw;

    public static void main(String[] args) throws FileNotFoundException {
        pw = new PrintWriter("MENACE-comb.txt");

        HashSet<TTTBoard> winners = new HashSet<>();
        TTTBoard start = new TTTBoard(new int[] {0,0,0},new int[] {0,0,0},new int[] {0,0,0});

        ArrayList<TTTBoard> turn1 = new ArrayList<>(); // computer's turn
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                TTTBoard temp = new TTTBoard(start);
                int[] cur = temp.getRow(i);
                cur[j] = 1;
                temp.setRow(i, cur);
                turn1.add(temp);
            }
        }

        ArrayList<TTTBoard> pre_turn2 = new ArrayList<>();
        HashSet<TTTBoard> uniquept2 = new HashSet<>();
        for (TTTBoard tttBoard : turn1) {
            boolean isUnique = true;
            for (TTTBoard u : uniquept2) {
                if (u.equals(tttBoard)) {
                    isUnique = false;
                }
            }
            if (uniquept2.size() == 0) {
                uniquept2.add(tttBoard);
            }
            if (isUnique) {
                uniquept2.add(tttBoard);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        TTTBoard temp = new TTTBoard(tttBoard);
                        int[] cur = temp.getRow(i);
                        if (cur[j] == 0) {
                            cur[j] = 2;
                            temp.setRow(i, cur);
                            pre_turn2.add(temp);
                        }
                    }
                }
            }
        }

        ArrayList<TTTBoard> turn2 = new ArrayList<>();
        HashSet<TTTBoard> uniquet2 = new HashSet<>();
        for (TTTBoard tttBoard : pre_turn2) {
            boolean isUnique = true;
            for (TTTBoard u : uniquet2) {
                if (u.equals(tttBoard)) {
                    isUnique = false;
                }
            }
            if (uniquet2.size() == 0) {
                uniquet2.add(tttBoard);
            }
            if (isUnique) {
                uniquet2.add(tttBoard);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        TTTBoard temp = new TTTBoard(tttBoard);
                        int[] cur = temp.getRow(i);
                        if (cur[j] == 0) {
                            cur[j] = 1;
                            temp.setRow(i, cur);
                            turn2.add(temp);
                        }
                    }
                }
            }
        }
///////////////////////////////////////////////////////////////////////
        ArrayList<TTTBoard> pre_turn3 = new ArrayList<>();
        HashSet<TTTBoard> uniquept3 = new HashSet<>();
        for (TTTBoard tttBoard : turn2) {
            boolean isUnique = true;
            for (TTTBoard u : uniquept3) {
                if (u.equals(tttBoard)) {
                    isUnique = false;
                }
            }
            if (uniquept3.size() == 0) {
                uniquept3.add(tttBoard);
            }
            if (isUnique) {
                uniquept3.add(tttBoard);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        TTTBoard temp = new TTTBoard(tttBoard);
                        int[] cur = temp.getRow(i);
                        if (cur[j] == 0) {
                            cur[j] = 2;
                            temp.setRow(i, cur);
                            pre_turn3.add(temp);
                        }
                    }
                }
            }
        }

        ArrayList<TTTBoard> turn3 = new ArrayList<>();
        HashSet<TTTBoard> uniquet3 = new HashSet<>();
        for (TTTBoard tttBoard : pre_turn3) {
            boolean isUnique = true;
            for (TTTBoard u : uniquet3) {
                if (u.equals(tttBoard)) {
                    isUnique = false;
                }
            }
            if (uniquet3.size() == 0) {
                uniquet3.add(tttBoard);
            }
            if (isUnique) {
                uniquet3.add(tttBoard);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        TTTBoard temp = new TTTBoard(tttBoard);
                        int[] cur = temp.getRow(i);
                        if (cur[j] == 0) {
                            cur[j] = 1;
                            temp.setRow(i, cur);
                            turn3.add(temp);
                        }
                    }
                }
            }
        }

        ArrayList<TTTBoard> pre_turn4 = new ArrayList<>();
        HashSet<TTTBoard> uniquept4 = new HashSet<>();
        for (TTTBoard tttBoard : turn3) {
            if (! winner(tttBoard)) {
                boolean isUnique = true;
                for (TTTBoard u : uniquept4) {
                    if (u.equals(tttBoard)) {
                        isUnique = false;
                    }
                }
                if (uniquept4.size() == 0) {
                    uniquept4.add(tttBoard);
                }
                if (isUnique) {
                    uniquept4.add(tttBoard);
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            TTTBoard temp = new TTTBoard(tttBoard);
                            int[] cur = temp.getRow(i);
                            if (cur[j] == 0) {
                                cur[j] = 2;
                                temp.setRow(i, cur);
                                pre_turn4.add(temp);
                            }
                        }
                    }
                }
            }
            else {
                winners.add(tttBoard);
            }
        }

        ArrayList<TTTBoard> turn4 = new ArrayList<>();
        HashSet<TTTBoard> uniquet4 = new HashSet<>();
        for (TTTBoard tttBoard : pre_turn4) {
            if (! winner(tttBoard)) {
                boolean isUnique = true;
                for (TTTBoard u : uniquet4) {
                    if (u.equals(tttBoard)) {
                        isUnique = false;
                    }
                }
                if (uniquet4.size() == 0) {
                    uniquet4.add(tttBoard);
                }
                if (isUnique) {
                    uniquet4.add(tttBoard);
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            TTTBoard temp = new TTTBoard(tttBoard);
                            int[] cur = temp.getRow(i);
                            if (cur[j] == 0) {
                                cur[j] = 1;
                                temp.setRow(i, cur);
                                turn4.add(temp);
                            }
                        }
                    }
                }
            }
            else {
                winners.add(tttBoard);
            }
        }

        ArrayList<TTTBoard> pre_turn5 = new ArrayList<>();
        HashSet<TTTBoard> uniquept5 = new HashSet<>();
        for (TTTBoard tttBoard : turn4) {
            if (! winner(tttBoard)) {
                boolean isUnique = true;
                for (TTTBoard u : uniquept5) {
                    if (u.equals(tttBoard)) {
                        isUnique = false;
                    }
                }
                if (uniquept5.size() == 0) {
                    uniquept5.add(tttBoard);
                }
                if (isUnique) {
                    uniquept5.add(tttBoard);
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            TTTBoard temp = new TTTBoard(tttBoard);
                            int[] cur = temp.getRow(i);
                            if (cur[j] == 0) {
                                cur[j] = 2;
                                temp.setRow(i, cur);
                                pre_turn5.add(temp);
                            }
                        }
                    }
                }
            }
            else {
                winners.add(tttBoard);
            }
        }

        ArrayList<TTTBoard> turn5 = new ArrayList<>();
        HashSet<TTTBoard> uniquet5 = new HashSet<>();
        for (TTTBoard tttBoard : pre_turn5) {
            if (! winner(tttBoard)) {
                boolean isUnique = true;
                for (TTTBoard u : uniquet5) {
                    if (u.equals(tttBoard)) {
                        isUnique = false;
                    }
                }
                if (uniquet5.size() == 0) {
                    uniquet5.add(tttBoard);
                }
                if (isUnique) {
                    uniquet5.add(tttBoard);
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            TTTBoard temp = new TTTBoard(tttBoard);
                            int[] cur = temp.getRow(i);
                            if (cur[j] == 0) {
                                cur[j] = 1;
                                temp.setRow(i, cur);
                                turn5.add(temp);
                            }
                        }
                    }
                }
            }
            else {
                winners.add(tttBoard);
            }
        }

        // for (TTTBoard tttBoard : winners) {
        //     pw.println(tttBoard);
        // }

        // HashSet<TTTBoard> combinations = new HashSet<>();
        // combinations.addAll(turn1);
        // combinations.addAll(pre_turn2);
        // combinations.addAll(turn2);
        // combinations.addAll(pre_turn3);
        // combinations.addAll(turn3);
        // combinations.addAll(pre_turn4);
        // combinations.addAll(turn4);
        // combinations.addAll(pre_turn5);
        // combinations.addAll(turn5);
        // combinations.addAll(winners);

        ArrayList<TTTBoard> combinations = new ArrayList<>();
        combinations.addAll(turn1);
        combinations.addAll(pre_turn2);
        combinations.addAll(turn2);
        combinations.addAll(pre_turn3);
        combinations.addAll(turn3);
        combinations.addAll(pre_turn4);
        combinations.addAll(turn4);
        combinations.addAll(pre_turn5);
        combinations.addAll(turn5);
        combinations.addAll(winners);

        for (TTTBoard tttBoard : combinations) {
            pw.println(tttBoard);
        }
        pw.close();

        // for (TTTBoard tttBoard : turn4) {
        //     System.out.println(tttBoard);
        // }

        // int[][] start = fill();
        // ArrayList<int[][]> turn1 = new ArrayList<>(); // computer's turn
        // for (int i = 0; i < 3; i++) {
        //     for (int j = 0; j < 3; j++) {
        //         int[][] temp = fill(start);
        //         temp[i][j] = 0;
        //         turn1.add(temp);
        //     }
        // }

        // ArrayList<int[][]> pre_turn2 = new ArrayList<>(); //human's turn
        // for (int[][] array : turn1) {
        //     for (int i = 0; i < 3; i++) {
        //         for (int j = 0; j < 3; j++) {
        //             int[][] temp = fill(array);
        //             if (temp[i][j] == -1) {
        //                 temp[i][j] = 1;
        //                 pre_turn2.add(temp);
        //             }
        //         }
        //     }
        // }

        // ArrayList<int[][]> turn2 = new ArrayList<>(); //human's turn
        // for (int[][] array : pre_turn2) {
        //     for (int i = 0; i < 3; i++) {
        //         for (int j = 0; j < 3; j++) {
        //             int[][] temp = fill(array);
        //             if (temp[i][j] == -1) {
        //                 temp[i][j] = 0;
        //                 turn2.add(temp);
        //             }
        //         }
        //     }
        // }

        // ArrayList<int[][]> pre_turn3 = new ArrayList<>(); //human's turn
        // for (int[][] array : turn2) {
        //     for (int i = 0; i < 3; i++) {
        //         for (int j = 0; j < 3; j++) {
        //             int[][] temp = fill(array);
        //             if (temp[i][j] == -1) {
        //                 temp[i][j] = 1;
        //                 pre_turn3.add(temp);
        //             }
        //         }
        //     }
        // }

        // ArrayList<int[][]> turn3 = new ArrayList<>(); //human's turn
        // for (int[][] array : pre_turn3) {
        //     for (int i = 0; i < 3; i++) {
        //         for (int j = 0; j < 3; j++) {
        //             int[][] temp = fill(array);
        //             if (temp[i][j] == -1) {
        //                 temp[i][j] = 0;
        //                 turn3.add(temp);
        //             }
        //         }
        //     }
        // }

        // ArrayList<int[][]> pre_turn4 = new ArrayList<>(); //human's turn
        // for (int[][] array : turn3) {
        //     for (int i = 0; i < 3; i++) {
        //         for (int j = 0; j < 3; j++) {
        //             int[][] temp = fill(array);
        //             if (temp[i][j] == -1) {
        //                 temp[i][j] = 1;
        //                 pre_turn4.add(temp);
        //             }
        //         }
        //     }
        // }

        // ArrayList<int[][]> turn4 = new ArrayList<>(); //human's turn
        // for (int[][] array : pre_turn4) {
        //     for (int i = 0; i < 3; i++) {
        //         for (int j = 0; j < 3; j++) {
        //             int[][] temp = fill(array);
        //             if (temp[i][j] == -1) {
        //                 temp[i][j] = 0;
        //                 turn4.add(temp);
        //             }
        //         }
        //     }
        // }

        // ArrayList<int[][]> pre_turn5 = new ArrayList<>(); //human's turn
        // for (int[][] array : turn4) {
        //     for (int i = 0; i < 3; i++) {
        //         for (int j = 0; j < 3; j++) {
        //             int[][] temp = fill(array);
        //             if (temp[i][j] == -1) {
        //                 temp[i][j] = 1;
        //                 pre_turn5.add(temp);
        //             }
        //         }
        //     }
        // }

        // ArrayList<int[][]> turn5 = new ArrayList<>(); //human's turn
        // for (int[][] array : pre_turn5) {
        //     for (int i = 0; i < 3; i++) {
        //         for (int j = 0; j < 3; j++) {
        //             int[][] temp = fill(array);
        //             if (temp[i][j] == -1) {
        //                 temp[i][j] = 0;
        //                 turn5.add(temp);
        //             }
        //         }
        //     }
        // }

        // // System.out.println(isSame(new int[][] {{0,0,1},{0,0,0},{0,0,0}}, new int[][] {{0,0,0},{0,0,0},{0,0,0}}));

        // HashSet<int[][]> uniques = new HashSet<>();
        // for (int[][] array : turn5) {
        //     if (uniques.size() == 0) {
        //         uniques.add(array);
        //     }
        //     HashSet<int[][]> temp = fill(uniques);
        //     for (int[][] unique : uniques) {
        //         if (! isSame(array, unique)) {
        //             temp.add(array);
        //         }
        //     }
        //     uniques = temp;
        // }

        // pw.println(uniques.toString());
        // pw.println(uniques.size());
        // pw.close();


    }
    private static boolean winner(TTTBoard tttBoard) {
        boolean condition1 = (((tttBoard.row1[0] != 0 && tttBoard.row1[1] != 0) && tttBoard.row1[2] != 0) && ((tttBoard.row1[0] == tttBoard.row1[1]) && (tttBoard.row1[1] == tttBoard.row1[2])));
        boolean condition2 = (((tttBoard.row2[0] != 0 && tttBoard.row2[1] != 0) && tttBoard.row2[2] != 0) && ((tttBoard.row2[0] == tttBoard.row2[1]) && (tttBoard.row2[1] == tttBoard.row2[2])));
        boolean condition3 = (((tttBoard.row3[0] != 0 && tttBoard.row3[1] != 0) && tttBoard.row3[2] != 0) && ((tttBoard.row3[0] == tttBoard.row3[1]) && (tttBoard.row3[1] == tttBoard.row3[2])));
        boolean condition4 = (((tttBoard.row1[0] != 0 && tttBoard.row2[0] != 0) && tttBoard.row3[0] != 0) && ((tttBoard.row1[0] == tttBoard.row2[0]) && (tttBoard.row2[0] == tttBoard.row3[0])));
        boolean condition5 = (((tttBoard.row1[1] != 0 && tttBoard.row2[1] != 0) && tttBoard.row3[1] != 0) && ((tttBoard.row1[1] == tttBoard.row2[1]) && (tttBoard.row2[1] == tttBoard.row3[1])));
        boolean condition6 = (((tttBoard.row1[2] != 0 && tttBoard.row2[2] != 0) && tttBoard.row3[2] != 0) && ((tttBoard.row1[2] == tttBoard.row2[2]) && (tttBoard.row2[2] == tttBoard.row3[2])));
        boolean dcondition1 = (((tttBoard.row1[0] != 0 && tttBoard.row2[1] != 0) && tttBoard.row3[2] != 0) && ((tttBoard.row1[0] == tttBoard.row2[1]) && (tttBoard.row2[1] == tttBoard.row3[2])));
        boolean dcondition2 = (((tttBoard.row3[0] != 0 && tttBoard.row2[1] != 0) && tttBoard.row1[2] != 0) && ((tttBoard.row3[0] == tttBoard.row2[1]) && (tttBoard.row2[1] == tttBoard.row1[2])));
        return (((condition1 || condition2) || (condition3 || condition4)) || (condition5 || condition6)) || (dcondition1 || dcondition2);
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