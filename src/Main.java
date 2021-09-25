import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Welcome Message
        System.out.println("=".repeat("WELCOME TO THE N QUEENS PROBLEM".length()));
        System.out.println("WELCOME TO THE N QUEENS PROBLEM");
        System.out.println("=".repeat("WELCOME TO THE N QUEENS PROBLEM".length()));

        int N;

        // Ask the user for number of queens
        while (true) {
            System.out.print("\nHow Many Queens Do You Want To Simulate? ");
            N = scan.nextInt();
            if (N < 4)
                System.out.println("Try A Different Value. Values 3, 2, and 1 are impossible");
            else
                break;
        }

        // Start the algorithm
        new NQueens(N);
    }
}

