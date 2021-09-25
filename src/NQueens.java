import java.util.Random;

public class NQueens {

    public static int SIZE;
    Queen[] QUEENS;
    int heuristic;
    int neighborsWithLowerH = 0;
    int numRestarts = 0;
    int numStateChanges = 0;

    /**
     * NQueens constructor
     * All code is ran here
     */
    public NQueens(int N) {
        SIZE = N;
        //Initialize array of Queen objects
        QUEENS = placeRandomQueens();
        // Initial heuristic
        heuristic = calculateHeuristic(QUEENS);
        // Displays current state
        System.out.println("Current h: " + heuristic);
        System.out.println("Current State:");
        printBoard(QUEENS);

        while (heuristic != 0) {
            QUEENS = genNextState(QUEENS);
            System.out.println("Neighbors Found With Lower Heuristic: " + neighborsWithLowerH);
            System.out.println("Setting New Current State\n");
            System.out.println("Current h: " + heuristic);
            System.out.println("Current State:");
            printBoard(QUEENS);
        }
        System.out.println("Solution Found!");
        System.out.println("State Changes: " + numStateChanges);
        System.out.println("Restarts: " + numRestarts);
    }

    /**
     * Prints the current state of the board
     * @param queens Array of Queen objects
     */
    private void printBoard(Queen[] queens) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (queens[j].getRow() == i)
                    System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }

    /**
     * places all N queens in a random row on its own column
     * @return Array of Queen objects
     */
    private Queen[] placeRandomQueens() {
        Queen[] queens = new Queen[SIZE];
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            int queenPlacement = rand.nextInt(SIZE);
            queens[i] = new Queen(queenPlacement, i);
        }
        return queens;
    }

    /**
     * Calculates the heuristic value of the given state
     * @param currentState current state
     * @return Heuristic value for the given state as an integer
     */
    private int calculateHeuristic(Queen[] currentState) {
        int h = 0;
        for (int i = 0; i < currentState.length; i++) {
            for (int j = i + 1; j < currentState.length; j++) {
                if (currentState[i].hasConflict(currentState[j]))
                    h++;
            }
        }
        return h;
    }

    /**
     * Runs through all neighboring states and finds the best next state with the lowest heuristic
     * @param currentState current state
     * @return The Queen[] of the best possible next state
     */
    private Queen[] genNextState(Queen[] currentState) {
        Queen[] nextState = new Queen[SIZE];
        Queen[] temp = new Queen[SIZE];
        int currentHeuristic = calculateHeuristic(currentState);
        int bestHeuristic = currentHeuristic;
        int tempHeuristic;
        neighborsWithLowerH = 0;

        // Set the next state to the current state and the temp array to the next state
        for (int i = 0; i < SIZE; i++) {
            nextState[i] = currentState[i];
            //nextState[i] = new Queen(currentState[i].getRow(), currentState[i].getColumn());
            temp[i] = nextState[i];
        }

        // Iterate through each column
        for (int i = 0; i < SIZE; i++) {
            if (i > 0)
                temp[i - 1] = new Queen(currentState[i - 1].getRow(), currentState[i - 1].getColumn());
            temp[i] = new Queen(0, temp[i].getColumn());

            // Iterate each row
            for (int j = 0; j < SIZE; j++) {
                tempHeuristic = calculateHeuristic(temp);
                // Check if temp has a better heuristic than the previously calculated best heuristic
                if (tempHeuristic < bestHeuristic) {
                    bestHeuristic = tempHeuristic;
                    neighborsWithLowerH++;
                    // Sets the next state to the best possible state
                    for (int k = 0; k < SIZE; k++)
                        nextState[k] = new Queen(temp[k].getRow(), temp[k].getColumn());
                }
                if (temp[i].getRow() != SIZE - 1)
                    temp[i].setRow(temp[i].getRow() + 1);
            }
        }
        if (bestHeuristic == currentHeuristic) {
            numRestarts++;
            nextState = placeRandomQueens();
            heuristic = calculateHeuristic(nextState);
        } else {
            heuristic = bestHeuristic;
        }
        numStateChanges++;
        return nextState;
    }
}
