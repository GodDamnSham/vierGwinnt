package org.game.UI;

public class BoardDesign {

    private char[][] board;

    public BoardDesign() {
        board = new char[6][7];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = 'ø';
            }
        }
    }

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

    public char[][] getBoard() {
        return board;
    }
}
