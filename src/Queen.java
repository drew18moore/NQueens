
public class Queen {
    private int row;
    private int column;

    /**
     * Queen constructor
     * @param row row where the queen is located
     * @param column column where the queen is located
     */
    public Queen(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Gets the value of row for queen object
     * @return Index of row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Gets the value of the column for queen object
     * @return Index of column
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Sets the row of a queen object to the given parameter value
     * @param rowNum New row number
     */
    public void setRow(int rowNum) {
        this.row = rowNum;
    }

    public boolean hasConflict(Queen queen) {
        // checks if two queens have same row num
        if (this.row == queen.getRow())
            return true;
        // checks if two queens have same column num
        else if (this.column == queen.getColumn())
            return true;
        // checks if two queens are diagonal
        else if (Math.abs(this.row - queen.getRow()) == Math.abs(this.column - queen.getColumn()))
            return true;
        return false;
    }


}
