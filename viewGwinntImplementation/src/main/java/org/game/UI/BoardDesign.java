package org.game.UI;

public class BoardDesign {

    private char[][] board;

    public BoardDesign() {
        board = new char[6][7];
        initializeBoard();
    }
    /**
     * Initializing the board adding adding null symbol ø temporary
     * */
    private void initializeBoard() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = 'ø';
            }
        }
    }
    /**
     * print the board after each update
     * */
    public void printBoard() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        for (int col = 0; col < 7; col++) {
            System.out.print((col + 1) + " ");
        }
        System.out.println("\n");
    }

    /**
     * return current board
     * */
    public char[][] getBoard() {
        return board;
    }
}
