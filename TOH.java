import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TOH {
    public static void main(String[] args) throws InterruptedException {
        int[] stackA = new int[] {5,4,3,2,1};
        int[] stackB = new int[5];
        int[] stackC = new int[5];
        int[] goal = new int[] {5,4,3,2,1};
        
        int binary = 0; 
        
        while (! equals(stackB, goal)) {
            printStack(stackA, stackB, stackC);
            System.out.println();
            binary++;
            if (binary % 16 == 0) {
                if (Arrays.toString(stackA).contains("5")) {
                    int i = 0;
                    for (; i < stackA.length-1; i++) {
                        if (stackA[i] == 5) {
                            break;
                        }
                    }
                    stackA[i] = 0;
                    int topB = 6;
                    int topC = 6;
                    for (int j = 0; j < stackB.length; j++) {
                        if (stackB[j] != 0) {
                            topB = Math.min(topB, stackB[j]);
                        } 
                    }
                    for (int j = 0; j < stackC.length; j++) {
                        if (stackC[j] != 0) {
                            topC = Math.min(topC, stackC[j]);
                        } 
                    }

                    if (topB > 5) {
                        stackB[4] = 5;
                    }
                    else {
                        stackC[4] = 5;
                    }
                }
                else if (Arrays.toString(stackB).contains("3")) {
                    int i = 0;
                    for (; i < stackB.length-1; i++) {
                        if (stackB[i] == 5) {
                            break;
                        }
                    }
                    stackB[i] = 0;
                    int topA = 6;
                    int topC = 6;
                    for (int j = 0; j < stackA.length; j++) {
                        if (stackA[j] != 0) {
                            topA = Math.min(topA, stackA[j]);
                        } 
                    }
                    for (int j = 0; j < stackC.length; j++) {
                        if (stackC[j] != 0) {
                            topC = Math.min(topC, stackC[j]);
                        } 
                    }

                    if (topA > 5) {
                        stackA[4] = 5;
                    }
                    else {
                        stackC[4] = 5;
                    }
                }
                else {
                    int i = 0;
                    for (; i < stackC.length; i++) {
                        if (stackC[i] == 3) {
                            break;
                        }
                    }
                    stackC[i] = 0;
                    int topB = 6;
                    int topA = 6;
                    for (int j = 0; j < stackB.length; j++) {
                        if (stackB[j] != 0) {
                            topB = Math.min(topB, stackB[j]);
                        } 
                    }
                    for (int j = 0; j < stackA.length; j++) {
                        if (stackA[j] != 0) {
                            topA = Math.min(topA, stackA[j]);
                        } 
                    }

                    if (topB > 5) {
                        stackB[4] = 5;
                    }
                    else {
                        stackA[4] = 5;
                    }
                }
            }
            else if (binary % 8 == 0) {
                if (Arrays.toString(stackA).contains("4")) {
                    int i = 0;
                    for (; i < stackA.length-1; i++) {
                        if (stackA[i] == 4) {
                            break;
                        }
                    }
                    stackA[i] = 0;
                    int topB = 6;
                    int topC = 6;
                    for (int j = 0; j < stackB.length; j++) {
                        if (stackB[j] != 0) {
                            topB = Math.min(topB, stackB[j]);
                        } 
                    }
                    for (int j = 0; j < stackC.length; j++) {
                        if (stackC[j] != 0) {
                            topC = Math.min(topC, stackC[j]);
                        } 
                    }

                    if (topB > 4) {
                        stackB[4] = 4;
                    }
                    else {
                        stackC[4] = 4;
                    }
                }
                else if (Arrays.toString(stackB).contains("4")) {
                    int i = 0;
                    for (; i < stackB.length-1; i++) {
                        if (stackB[i] == 4) {
                            break;
                        }
                    }
                    stackB[i] = 0;
                    int topA = 6;
                    int topC = 6;
                    for (int j = 0; j < stackA.length; j++) {
                        if (stackA[j] != 0) {
                            topA = Math.min(topA, stackA[j]);
                        } 
                    }
                    for (int j = 0; j < stackC.length; j++) {
                        if (stackC[j] != 0) {
                            topC = Math.min(topC, stackC[j]);
                        } 
                    }

                    if (topA > 3) {
                        stackA[4] = 4;
                    }
                    else {
                        stackC[4] = 4;
                    }
                }
                else {
                    int i = 0;
                    for (; i < stackC.length; i++) {
                        if (stackC[i] == 4) {
                            break;
                        }
                    }
                    stackC[i] = 0;
                    int topB = 6;
                    int topA = 6;
                    for (int j = 0; j < stackB.length; j++) {
                        if (stackB[j] != 0) {
                            topB = Math.min(topB, stackB[j]);
                        } 
                    }
                    for (int j = 0; j < stackA.length; j++) {
                        if (stackA[j] != 0) {
                            topA = Math.min(topA, stackA[j]);
                        } 
                    }

                    if (topB > 3) {
                        stackB[4] = 4;
                    }
                    else {
                        stackA[4] = 4;
                    }
                }
            }
            else if (binary % 4 == 0) {
                if (Arrays.toString(stackA).contains("3")) {
                    int i = 0;
                    for (; i < stackA.length-1; i++) {
                        if (stackA[i] == 3) {
                            break;
                        }
                    }
                    stackA[i] = 0;
                    int topB = 6;
                    int topC = 6;
                    for (int j = 0; j < stackB.length; j++) {
                        if (stackB[j] != 0) {
                            topB = Math.min(topB, stackB[j]);
                        } 
                    }
                    for (int j = 0; j < stackC.length; j++) {
                        if (stackC[j] != 0) {
                            topC = Math.min(topC, stackC[j]);
                        } 
                    }

                    if (topB > 3) {
                        stackB[4] = 3;
                    }
                    else {
                        stackC[4] = 3;
                    }
                }
                else if (Arrays.toString(stackB).contains("3")) {
                    int i = 0;
                    for (; i < stackB.length-1; i++) {
                        if (stackB[i] == 3) {
                            break;
                        }
                    }
                    stackB[i] = 0;
                    int topA = 6;
                    int topC = 6;
                    for (int j = 0; j < stackA.length; j++) {
                        if (stackA[j] != 0) {
                            topA = Math.min(topA, stackA[j]);
                        } 
                    }
                    for (int j = 0; j < stackC.length; j++) {
                        if (stackC[j] != 0) {
                            topC = Math.min(topC, stackC[j]);
                        } 
                    }

                    if (topA > 3) {
                        stackA[4] = 3;
                    }
                    else {
                        stackC[4] = 3;
                    }
                }
                else {
                    int i = 0;
                    for (; i < stackC.length; i++) {
                        if (stackC[i] == 3) {
                            break;
                        }
                    }
                    stackC[i] = 0;
                    int topB = 6;
                    int topA = 6;
                    for (int j = 0; j < stackB.length; j++) {
                        if (stackB[j] != 0) {
                            topB = Math.min(topB, stackB[j]);
                        } 
                    }
                    for (int j = 0; j < stackA.length; j++) {
                        if (stackA[j] != 0) {
                            topA = Math.min(topA, stackA[j]);
                        } 
                    }

                    if (topB > 3) {
                        stackB[4] = 3;
                    }
                    else {
                        stackA[4] = 3;
                    }
                }
            }
            else if (binary % 2 == 0) {
                if (Arrays.toString(stackA).contains("2")) {
                    int i = 0;
                    for (; i < stackA.length-1; i++) {
                        if (stackA[i] == 2) {
                            break;
                        }
                    }
                    stackA[i] = 0;
                    int topB = 6;
                    int topC = 6;
                    for (int j = 0; j < stackB.length; j++) {
                        if (stackB[j] != 0) {
                            topB = Math.min(topB, stackB[j]);
                        } 
                    }
                    for (int j = 0; j < stackC.length; j++) {
                        if (stackC[j] != 0) {
                            topC = Math.min(topC, stackC[j]);
                        } 
                    }

                    if (topB > 2) {
                        stackB[4] = 2;
                    }
                    else {
                        stackC[4] = 2;
                    }
                }
                else if (Arrays.toString(stackB).contains("2")) {
                    int i = 0;
                    for (; i < stackB.length-1; i++) {
                        if (stackB[i] == 2) {
                            break;
                        }
                    }
                    stackB[i] = 0;
                    int topA = 6;
                    int topC = 6;
                    for (int j = 0; j < stackA.length; j++) {
                        if (stackA[j] != 0) {
                            topA = Math.min(topA, stackA[j]);
                        } 
                    }
                    for (int j = 0; j < stackC.length; j++) {
                        if (stackC[j] != 0) {
                            topC = Math.min(topC, stackC[j]);
                        } 
                    }

                    if (topA > 2) {
                        stackA[4] = 2;
                    }
                    else {
                        stackC[4] = 2;
                    }
                }
                else {
                    int i = 0;
                    for (; i < stackC.length; i++) {
                        if (stackC[i] == 2) {
                            break;
                        }
                    }
                    stackC[i] = 0;
                    int topB = 6;
                    int topA = 6;
                    for (int j = 0; j < stackB.length; j++) {
                        if (stackB[j] != 0) {
                            topB = Math.min(topB, stackB[j]);
                        } 
                    }
                    for (int j = 0; j < stackA.length; j++) {
                        if (stackA[j] != 0) {
                            topA = Math.min(topA, stackA[j]);
                        } 
                    }

                    if (topB > 2) {
                        stackB[4] = 2;
                    }
                    else {
                        stackA[4] = 2;
                    }
                }
            }
            else {
                if (Arrays.toString(stackA).contains("1")) {
                    int i = 0;
                    for (; i < stackA.length-1; i++) {
                        if (stackA[i] == 1) {
                            break;
                        }
                    }
                    stackA[i] = 0;
                    stackB[4] = 1;
                }
                else if (Arrays.toString(stackB).contains("1")) {
                    int i = 0;
                    for (; i < stackB.length; i++) {
                        if (stackB[i] == 1) {
                            break;
                        }
                    }
                    stackB[i] = 0;
                    stackC[4] = 1;
                }
                else {
                    int i = 0;
                    for (; i < stackC.length; i++) {
                        if (stackC[i] == 1) {
                            break;
                        }
                    }
                    stackC[i] = 0;
                    stackA[4] = 1;
                }
            }
            collapseDisk(stackA);
            collapseDisk(stackB);
            collapseDisk(stackC);
            TimeUnit.SECONDS.sleep(1);
        }
        printStack(stackA, stackB, stackC);
    }

    private static void printStack(int[] stackA, int[] stackB, int[] stackC) {
        String[] row5 = new String[] {stackA[4]+"",stackB[4]+"",stackC[4]+""};
        for (int i = 0; i < row5.length; i++) {
            if (row5[i].equals(0)) {
                row5[i] = " ";
            }
        }
        String[] row4 = new String[] {stackA[3]+"",stackB[3]+"",stackC[3]+""};
        for (int i = 0; i < row4.length; i++) {
            if (row4[i].equals(0)) {
                row4[i] = " ";
            }
        }
        String[] row3 = new String[] {stackA[2]+"",stackB[2]+"",stackC[2]+""};
        for (int i = 0; i < row3.length; i++) {
            if (row3[i].equals(0)) {
                row3[i] = " ";
            }
        }
        String[] row2 = new String[] {stackA[1]+"",stackB[1]+"",stackC[1]+""};
        for (int i = 0; i < row2.length; i++) {
            if (row2[i].equals(0)) {
                row2[i] = " ";
            }
        }
        String[] row1 = new String[] {stackA[0]+"",stackB[0]+"",stackC[0]+""};
        for (int i = 0; i < row1.length; i++) {
            if (row1[i].equals(0)) {
                row1[i] = " ";
            }
        }

        System.out.printf(" %s | %s | %s \n",row5[0],row5[1],row5[2]);
        System.out.printf(" %s | %s | %s \n",row4[0],row4[1],row4[2]);
        System.out.printf(" %s | %s | %s \n",row3[0],row3[1],row3[2]);
        System.out.printf(" %s | %s | %s \n",row2[0],row2[1],row2[2]);
        System.out.printf(" %s | %s | %s \n",row1[0],row1[1],row1[2]);
        System.out.println(" A | B | C ");
    }

    private static void collapseDisk(int[] stack) {
        boolean onceMore = true;
        while (onceMore) {
            int prev = stack[0];
            onceMore = false;
            for (int i = 1; i < stack.length; i++) {
                int cur = stack[i];
                if (prev == 0 && cur != 0) {
                    stack[i-1] = stack[i];
                    stack[i] = 0;
                    onceMore = true;
                }
                prev = cur;
            }
        }
    }

    private static boolean equals(int[] stackC, int[] goal) {
        for (int i = 0; i < goal.length; i++) {
            if (stackC[i] != goal[i]) {
                return false;
            }
        }
        return true;
    }
}