import java.util.Random;


public class EightQueens {

    public static final int SIZE = 8;
    int[][] BOARD;
    Queen[] QUEENS;
    int numRestarts = 0;
    int numStateChanges = 0;

    public EightQueens() {
        // Initialize 2D board of specified size
        BOARD = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                BOARD[i][j] = 0;
            }
        }

        //Initialize array of Queen objects
        QUEENS = new Queen[SIZE];
        for (int i = 0; i < SIZE; i++)
            QUEENS[i] = new Queen(0, i);


        PlaceRandomQueens(QUEENS, SIZE);
        System.out.println("================================\nQUEENS HAVE BEEN PLACED RANDOMLY\n================================");
        PrintBoard(BOARD);


    }


    private void PrintBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void PrintQueens() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(QUEENS[i].getColumn());
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(QUEENS[i].getRow());
        }
    }

    private void PlaceRandomQueens(Queen[] queens, int num) {
        Random rand = new Random();
        for (int i = 0; i < num; i++) {
            int queenPlacement = rand.nextInt(num);
            BOARD[queenPlacement][i] = 1;
            queens[i].setColumn(i);
            queens[i].setRow(queenPlacement);
        }
    }

    private void CheckIfSolved() {
        for (int i = 0; i < SIZE; i++) {

        }
    }

    private boolean IsConflict() {


        return false;
    }
}
