public class TTTBoard {
    int[] row1;
    int[] row2;
    int[] row3;
    public TTTBoard(int[] row1,int[] row2,int[] row3) {
        this.row1 = row1;
        this.row2 = row2;
        this.row3 = row3;
    }
    public TTTBoard(TTTBoard copy) {
        this.row1 = copy.row1.clone();
        this.row2 = copy.row2.clone();
        this.row3 = copy.row3.clone();
    }
    public boolean equals(TTTBoard ttt) {
        return ((((row1[0]==ttt.row1[0]) && (row1[1]==ttt.row1[1])) && (row1[2]==ttt.row1[2]))
        && (((row2[0]==ttt.row2[0]) && (row2[1]==ttt.row2[1])) && (row2[2]==ttt.row2[2])))
        && (((row3[0]==ttt.row3[0]) && (row3[1]==ttt.row3[1])) && (row3[2]==ttt.row3[2]));
    }
    public String toString() {
        return row1[0]+"|"+row1[1]+"|"+row1[2] + "\n" + row2[0]+"|"+row2[1]+"|"+row2[2] + "\n" + row3[0]+"|"+row3[1]+"|"+row3[2]+"\n";
    }
    public int[] getRow(int row) {
        if (row == 0) return row1;
        else if (row == 1) return row2;
        return row3;
    }
    public void setRow(int row, int[] set) {
        if (row == 0) row1 = set;
        else if (row == 1) row2 = set;
        else row3 = set;
    }

    public int sum() {
        return row1[0]+row1[1]+row1[2]+row2[0]+row2[1]+row2[2]+row3[0]+row3[1]+row3[2];
    }
}