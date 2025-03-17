import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';  // 'X' is the player, 'O' is the computer
    private static Random random = new Random();

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        while (true) {
            if (currentPlayer == 'X') {
                playerMove();  // Human player's turn
            } else {
                computerMove(); // Computer's turn
            }

            printBoard();

            if (checkWinner(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isBoardFull()) {
                System.out.println("The game is a tie!");
                break;
            }

            switchPlayer();
        }
    }

    // Initializes the board with empty slots
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Prints the current state of the board
    private static void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Player (human) makes a move
    private static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("This move is not valid");
            }
        }
    }

    // Computer makes the best move using Minimax with Alpha-Beta Pruning
    private static void computerMove() {
        System.out.println("Computer's turn:");
        int[] bestMove = minimax(board, 'O', Integer.MIN_VALUE, Integer.MAX_VALUE);
        board[bestMove[0]][bestMove[1]] = 'O';
        System.out.println("Computer placed 'O' at position: " + bestMove[0] + " " + bestMove[1]);
    }

    // Minimax algorithm with Alpha-Beta Pruning to determine the best move
    private static int[] minimax(char[][] board, char player, int alpha, int beta) {
        char opponent = (player == 'O') ? 'X' : 'O';
        int bestScore = (player == 'O') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int[] bestMove = new int[]{-1, -1};

        if (checkWinner('O')) return new int[]{-1, -1}; // Computer wins
        if (checkWinner('X')) return new int[]{-1, -1}; // Player wins
        if (isBoardFull()) return new int[]{-1, -1}; // Tie

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = player;
                    int score = minimaxScore(board, opponent, alpha, beta);
                    board[i][j] = '-';
                    
                    if (player == 'O') {
                        if (score > bestScore) {
                            bestScore = score;
                            bestMove[0] = i;
                            bestMove[1] = j;
                        }
                        alpha = Math.max(alpha, bestScore);
                    } else {
                        if (score < bestScore) {
                            bestScore = score;
                            bestMove[0] = i;
                            bestMove[1] = j;
                        }
                        beta = Math.min(beta, bestScore);
                    }

                    if (beta <= alpha) {
                        return bestMove; // Alpha-Beta Pruning
                    }
                }
            }
        }

        return bestMove;
    }

    // Evaluate the board with Minimax and Alpha-Beta Pruning
    private static int minimaxScore(char[][] board, char player, int alpha, int beta) {
        char opponent = (player == 'O') ? 'X' : 'O';

        if (checkWinner('O')) return 10; // Computer wins
        if (checkWinner('X')) return -10; // Player wins
        if (isBoardFull()) return 0; // Tie

        int bestScore = (player == 'O') ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = player;
                    int score = minimaxScore(board, opponent, alpha, beta);
                    board[i][j] = '-';

                    if (player == 'O') {
                        bestScore = Math.max(score, bestScore);
                        alpha = Math.max(alpha, bestScore);
                    } else {
                        bestScore = Math.min(score, bestScore);
                        beta = Math.min(beta, bestScore);
                    }

                    if (beta <= alpha) {
                        return bestScore; // Alpha-Beta Pruning
                    }
                }
            }
        }

        return bestScore;
    }

    // Checks if the given player has won
    private static boolean checkWinner(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Checks if the board is full (i.e., no more moves possible)
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // Switches the current player between 'X' (human) and 'O' (computer)
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
