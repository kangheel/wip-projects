import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MENACE_AI {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("MENACE-comb.txt"));
        HashMap<TTTBoard, TTTBoard> counts = new HashMap();
        while (scanner.hasNext()) {
            String r1 = scanner.nextLine();
            String r2 = scanner.nextLine();
            String r3 = scanner.nextLine();

            int[] row1 = new int[3];
            int[] row2 = new int[3];
            int[] row3 = new int[3];
            row1[0] = Integer.parseInt(r1.substring(0,r1.indexOf("|")));
            r1 = r1.substring(r1.indexOf("|")+1);
            row1[1] = Integer.parseInt(r1.substring(0,r1.indexOf("|")));
            r1 = r1.substring(r1.indexOf("|")+1);
            row1[2] = Integer.parseInt(r1.substring(0));
            row2[0] = Integer.parseInt(r2.substring(0,r2.indexOf("|")));
            r2 = r2.substring(r2.indexOf("|")+1);
            row2[1] = Integer.parseInt(r2.substring(0,r2.indexOf("|")));
            r2 = r2.substring(r2.indexOf("|")+1);
            row2[2] = Integer.parseInt(r2.substring(0));
            row3[0] = Integer.parseInt(r3.substring(0,r3.indexOf("|")));
            r3 = r3.substring(r3.indexOf("|")+1);
            row3[1] = Integer.parseInt(r3.substring(0,r3.indexOf("|")));
            r3 = r3.substring(r3.indexOf("|")+1);
            row3[2] = Integer.parseInt(r3.substring(0));

            int r11 = 8;
            int r12 = 8;
            int r13 = 8;
            int r21 = 8;
            int r22 = 8;
            int r23 = 8;
            int r31 = 8;
            int r32 = 8;
            int r33 = 8;

            if (row1[0] != 0) {
                r11 = 0;
            }
            if (row1[1] != 0) {
                r12 = 0;
            }
            if (row1[2] != 0) {
                r13 = 0;
            }
            if (row2[0] != 0) {
                r21 = 0;
            }
            if (row2[1] != 0) {
                r22 = 0;
            }
            if (row2[2] != 0) {
                r23 = 0;
            }
            if (row3[0] != 0) {
                r31 = 0;
            }
            if (row3[1] != 0) {
                r32 = 0;
            }
            if (row3[2] != 0) {
                r33 = 0;
            }

            counts.put(new TTTBoard(row1,row2,row3), new TTTBoard(new int[] {r11,r12,r13},new int[] {r21,r22,r23},new int[] {r31,r32,r33}));
            scanner.nextLine();
        }

        boolean playerTurn = false;
        Scanner playerControls = new Scanner(System.in);
        TTTBoard currentGame = new TTTBoard(new int[] {0,0,0},new int[] {0,0,0},new int[] {0,0,0});
        HashMap<TTTBoard, Integer> pathTaken = new HashMap<>();
        while (true) {
            if (winner(currentGame) == -1) {
                if (! playerTurn) {
                    TTTBoard currentBoardState = new TTTBoard(new int[] {0,0,0},new int[] {0,0,0},new int[] {0,0,0});
                    for (TTTBoard tttBoard : counts.keySet()) {
                        if (currentGame.equals(tttBoard)) {
                            currentBoardState = counts.get(tttBoard);
                        }
                    }
                    int sum = currentBoardState.sum();
                    int random = (int) (Math.random()*sum) +1;
                    int i = 1;
                    for (; i <= 9; i++) {
                        if (i == 1) {
                            if (random - currentBoardState.row1[0] < 0) {
                                break;
                            }
                            random -= currentBoardState.row1[0];
                        }
                        else if (i == 2) {
                            if (random - currentBoardState.row1[1] < 0) {
                                break;
                            }
                            random -= currentBoardState.row1[1];
                        }
                        else if (i == 3) {
                            if (random - currentBoardState.row1[2] < 0) {
                                break;
                            }
                            random -= currentBoardState.row1[2];
                        }
                        else if (i == 4) {
                            if (random - currentBoardState.row2[0] < 0) {
                                break;
                            }
                            random -= currentBoardState.row2[0];
                        }
                        else if (i == 5) {
                            if (random - currentBoardState.row2[1] < 0) {
                                break;
                            }
                            random -= currentBoardState.row2[1];
                        }
                        else if (i == 6) {
                            if (random - currentBoardState.row2[2] < 0) {
                                break;
                            }
                            random -= currentBoardState.row2[2];
                        }
                        else if (i == 7) {
                            if (random - currentBoardState.row3[0] < 0) {
                                break;
                            }
                            random -= currentBoardState.row3[0];
                        }
                        else if (i == 8) {
                            if (random - currentBoardState.row3[1] < 0) {
                                break;
                            }
                            random -= currentBoardState.row3[1];
                        }
                        else if (i == 9) {
                            if (random - currentBoardState.row3[2] < 0) {
                                break;
                            }
                            random -= currentBoardState.row3[2];
                        }
                    }
                    pathTaken.put(currentGame, i);
                    if (i == 1) {
                        currentGame.row1 = new int[] {1,currentGame.row1[1],currentGame.row1[2]};
                    }
                    else if (i == 2) {
                        currentGame.row1 = new int[] {currentGame.row1[0],1,currentGame.row1[2]};
                    }
                    else if (i == 3) {
                        currentGame.row1 = new int[] {currentGame.row1[0],currentGame.row1[1],1};
                    }
                    else if (i == 4) {
                        currentGame.row2 = new int[] {1,currentGame.row2[1],currentGame.row2[2]};
                    }
                    else if (i == 5) {
                        currentGame.row2 = new int[] {currentGame.row2[0],1,currentGame.row2[2]};
                    }
                    else if (i == 6) {
                        currentGame.row2 = new int[] {currentGame.row2[0],currentGame.row2[1],1};
                    }
                    else if (i == 7) {
                        currentGame.row3 = new int[] {1,currentGame.row3[1],currentGame.row3[2]};
                    }
                    else if (i == 8) {
                        currentGame.row3 = new int[] {currentGame.row3[0],1,currentGame.row3[2]};
                    }
                    else if (i == 9) {
                        currentGame.row3 = new int[] {currentGame.row3[0],currentGame.row3[1],1};
                    }

                    playerTurn = true;
                }
                else {
                    System.out.println("Current Game State");
                    System.out.println(currentGame);
                    System.out.println("Enter a coordinate to put your piece. Format: x,y");
                    String input = playerControls.nextLine();
                    int x = Integer.parseInt(input.substring(0,1));
                    int y = Integer.parseInt(input.substring(2));
                    if (x == 0) {
                        if (y == 0) {
                            currentGame.row1 = new int[] {2,currentGame.row1[1],currentGame.row1[2]};
                        }
                        else if (y == 1) {
                            currentGame.row1 = new int[] {currentGame.row1[0],2,currentGame.row1[2]};
                        }
                        else {
                            currentGame.row1 = new int[] {currentGame.row1[0],currentGame.row1[1],2};
                        }
                    }
                    else if (x == 1) {
                        if (y == 0) {
                            currentGame.row2 = new int[] {2,currentGame.row2[1],currentGame.row2[2]};
                        }
                        else if (y == 1) {
                            currentGame.row2 = new int[] {currentGame.row2[0],2,currentGame.row2[2]};
                        }
                        else {
                            currentGame.row2 = new int[] {currentGame.row2[0],currentGame.row2[1],2};
                        }
                    }
                    else {
                        if (y == 0) {
                            currentGame.row3 = new int[] {2,currentGame.row3[1],currentGame.row3[2]};
                        }
                        else if (y == 1) {
                            currentGame.row3 = new int[] {currentGame.row3[0],2,currentGame.row3[2]};
                        }
                        else {
                            currentGame.row3 = new int[] {currentGame.row3[0],currentGame.row3[1],2};
                        }
                    }
                    System.out.println("Current Game State");
                    System.out.println(currentGame);
                    playerTurn = false;
                }
            }
            else {
                break;
            }
        }
    }
    private static int winner(TTTBoard tttBoard) {
        boolean condition1 = (((tttBoard.row1[0] != 0 && tttBoard.row1[1] != 0) && tttBoard.row1[2] != 0) && ((tttBoard.row1[0] == tttBoard.row1[1]) && (tttBoard.row1[1] == tttBoard.row1[2])));
        boolean condition2 = (((tttBoard.row2[0] != 0 && tttBoard.row2[1] != 0) && tttBoard.row2[2] != 0) && ((tttBoard.row2[0] == tttBoard.row2[1]) && (tttBoard.row2[1] == tttBoard.row2[2])));
        boolean condition3 = (((tttBoard.row3[0] != 0 && tttBoard.row3[1] != 0) && tttBoard.row3[2] != 0) && ((tttBoard.row3[0] == tttBoard.row3[1]) && (tttBoard.row3[1] == tttBoard.row3[2])));
        boolean condition4 = (((tttBoard.row1[0] != 0 && tttBoard.row2[0] != 0) && tttBoard.row3[0] != 0) && ((tttBoard.row1[0] == tttBoard.row2[0]) && (tttBoard.row2[0] == tttBoard.row3[0])));
        boolean condition5 = (((tttBoard.row1[1] != 0 && tttBoard.row2[1] != 0) && tttBoard.row3[1] != 0) && ((tttBoard.row1[1] == tttBoard.row2[1]) && (tttBoard.row2[1] == tttBoard.row3[1])));
        boolean condition6 = (((tttBoard.row1[2] != 0 && tttBoard.row2[2] != 0) && tttBoard.row3[2] != 0) && ((tttBoard.row1[2] == tttBoard.row2[2]) && (tttBoard.row2[2] == tttBoard.row3[2])));
        boolean dcondition1 = (((tttBoard.row1[0] != 0 && tttBoard.row2[1] != 0) && tttBoard.row3[2] != 0) && ((tttBoard.row1[0] == tttBoard.row2[1]) && (tttBoard.row2[1] == tttBoard.row3[2])));
        boolean dcondition2 = (((tttBoard.row3[0] != 0 && tttBoard.row2[1] != 0) && tttBoard.row1[2] != 0) && ((tttBoard.row3[0] == tttBoard.row2[1]) && (tttBoard.row2[1] == tttBoard.row1[2])));
        if (condition1) return tttBoard.row1[0];
        else if (condition2) return tttBoard.row2[0];
        else if (condition3) return tttBoard.row3[0];
        else if (condition4) return tttBoard.row1[0];
        else if (condition5) return tttBoard.row1[1];
        else if (condition6) return tttBoard.row1[2];
        else if (dcondition1) return tttBoard.row1[0];
        else if (dcondition2) return tttBoard.row3[0];
        return -1;
    }
}