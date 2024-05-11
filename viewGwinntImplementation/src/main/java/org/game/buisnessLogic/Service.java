package org.game.buisnessLogic;

import org.game.UI.BoardDesign;
import org.game.entity.Player;

import java.util.Objects;

public class Service {
    BoardDesign boardDesign;
    public Service(){
        this.boardDesign = new BoardDesign();
    }
/**
* print the board
*/
    public void printingTheBoard(){
        this.boardDesign.printBoard();
    }
    /*
     * get current board
     * */
    public char[][] getBoardDesign(){
        return this.boardDesign.getBoard();
    }

    /**
     * check vertical for the player added symbols
     * @param board giving the current board
     */
    public char checkVertical(char[][] board) {
        for (int col = 0; col < 7; col++) {
            int countX = 0;
            int count0 = 0;
            for (int row = 0; row < 6; row++) {
                if (board[row][col] == 'X') {
                    countX++;
                    count0 = 0;
                } else if (board[row][col] == 'O') {
                    count0++;
                    countX = 0;
                } else {
                    countX = 0;
                    count0 = 0;
                }
                if (countX == 4) {
                    return 'X';
                } else if (count0 == 4) {
                    return 'O';
                }
            }
        }
        return ' ';
    }

    /**
     * check Horizontal for the player added symbols
     * @param board giving the current board
     */
    public char checkHorizontal(char[][] board) {
        for (int row = 0; row < 6; row++) {
            int countX = 0;
            int count0 = 0;
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == 'X') {
                    countX++;
                    count0 = 0;
                } else if (board[row][col] == 'O') {
                    count0++;
                    countX = 0;
                } else {
                    countX = 0;
                    count0 = 0;
                }
                if (countX == 4) {
                    return 'X';
                } else if (count0 == 4) {
                    return 'O';
                }
            }
        }
        return ' ';
    }

    //helper
    public char checkDiagonalTopLeft(char[][] board) {
        int countX = 0;
        int count0 = 0;
        for (int row = 0; row < 3; row++) {
             countX = 0;
             count0 = 0;
            for (int col = 0; col < 4; col++) {
                    char current = board[row + 1][col + 1];
                    if (current == 'X') {
                        countX++;
                        count0 = 0;
                    } else if (current == 'O') {
                        count0++;
                        countX = 0;
                    } else {
                        countX = 0;
                        count0 = 0;
                    }
                    if (countX == 4) {
                        return 'X';
                    } else if (count0 == 4) {
                        return 'O';
                    }
                }
            }
        return ' ';
    }

    //helper
    public char checkDiagonalTopRight(char[][] board) {
        int countX = 0;
        int count0 = 0;
        for (int row = 0; row < 3; row++) {
             countX = 0;
             count0 = 0;
            for (int col = 3; col < 7; col++) {
                char current = board[row][col];
                        if (board[row + 1][col - 1] == current) {
                            if (current == 'X') {
                                countX++;
                                count0 = 0;
                            } else if (current == '0') {
                                count0++;
                                countX = 0;
                            }
                        } else {
                            countX = 0;
                            count0 = 0;
                        }
                        if (countX == 4) {
                            return 'X';
                        } else if (count0 == 4) {
                            return '0';
                        }
                    }
                }
        return ' ';
    }



    /**
     * Method to check for the winner. hover over the board to find the 4 consecutive symbols
     * @param board giving the current board*/
    public char checkWinner(char[][] board) {

        char vertical = this.checkVertical(board);
        if(vertical=='X'){
            return 'X';
        }else if (vertical=='O'){
            return 'O';
        }

        char horizontal = this.checkHorizontal(board);
        if(horizontal=='X'){
            return 'X';
        }else if (horizontal=='O'){
            return 'O';
        }

        //  diagonals top-left bottom-right
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] != 'ø' && board[row][col] == board[row + 1][col + 1] &&
                        board[row][col] == board[row + 2][col + 2] && board[row][col] == board[row + 3][col + 3]) {
                    return board[row][col];
                }
            }
        }

        //  diagonals top-right bottom-left
        for (int row = 0; row < 3; row++) {
            for (int col = 3; col < 7; col++) {
                if (board[row][col] != 'ø' && board[row][col] == board[row + 1][col - 1] &&
                        board[row][col] == board[row + 2][col - 2] && board[row][col] == board[row + 3][col - 3]) {
                    return board[row][col];
                }
            }
        }


        //check if board is full then Game over
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == 'ø') {
                    return ' ';
                }
            }
        }

        return 'T';
    }

    /**
     * @param board giving the current board
     * @param p player Object to check for the current player
     * */
    public void dropPiece(int column, char[][] board, Player p) {
        for (int row = 5; row >= 0; row--) {
            if (board[row][column] == 'ø') {
                board[row][column] = Objects.equals(p.getName(), "test1") ? 'X' : 'O';
                return;
            }
        }
    }
}

