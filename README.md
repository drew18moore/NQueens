# NQueens

This is my version of the N-Queens problem uses the Hill-Climbing algorithm with random restarts.
This was a class assignment for *ITCS 3153 - Introduction to Artificial Intelligence* at *UNC Charlotte*.

## Project Description
The program begins with the user choosing the value of **N**.
The program generates an N*N chessboard and places each of the N queens in a random row in its own column.

The genNextState() method will iterate through each of the columns, moving each queen to every other row in its column.
The calculateHeuristic() method will be called to determine how many conflicts exist between the queens on the board.
The genNextState() method will then find the move that has the lowest heuristic value and will set that to be the next state.

If the program reaches a point in which the board is unsolvable, it will restart and generate a new random board.

This process will continue untill the heuristic value reaches zero.
At this point the end state will be printed along with the total number of state changes performed and the number of restarts.

This project was made entirely using the Java programming language.
