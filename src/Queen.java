
public class Queen {
    private int row;
    private int column;

    public Queen(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setRow(int rowNum) {
        this.row = rowNum;
    }

    public void setColumn(int colNum) {
        this.column = colNum;
    }

    public boolean checkVertically(Queen[] queen) {
        for (int i = 0; i < EightQueens.SIZE; i++)
        if (this.row == queen[i].row && this.column != queen[i].column) {

        }
    }
}
