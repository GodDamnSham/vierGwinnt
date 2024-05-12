package org.game.buisnessLogic;

import org.game.entity.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    @Test
    public void testDropPieceInTheMatrix() {
        Service service = new Service();
        Player player = new Player("test1", 'X');
        service.printingTheBoard();
        service.dropPiece(0, service.getBoardDesign(), player);
        service.printingTheBoard();
        char[][] board1 = service.getBoardDesign();
        assertEquals('X', board1[5][0]);
    }
    @Test
    public void testCheckVertical() {
        char[][] board = {
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        Service service = new Service();
        char winner = service.checkVertical(board);
        assertEquals('X', winner);
    }

    @Test
    public void testCheckVerticalFails() {
        char[][] board = {
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        Service service = new Service();
        char winner = service.checkVertical(board);
        assertEquals(' ', winner);
    }
    @Test
    public void testCheckHorizontal() {
        char[][] board = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', 'X', 'X', 'X', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        Service service = new Service();
        char winner = service.checkHorizontal(board);
        assertEquals('X', winner);
    }

    @Test
    public void testCheckHorizontalFails() {
        char[][] board = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', 'X', 'X', 'O', 'X', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        Service service = new Service();
        char winner = service.checkHorizontal(board);
        assertEquals(' ', winner);
    }
    @Test
    public void testCheckDiagonalWinLeftToRight_O() {
        char[][] board = {
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', 'O', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'O', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'O', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        Service service = new Service();
        char winner = service.checkDiagonalWin(board);
        assertEquals('O', winner);
    }

    @Test
    public void testCheckDiagonalWinLeftToRight_X() {
        char[][] board = {
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', 'X', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'X', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        Service service = new Service();
        char winner = service.checkDiagonalWin(board);
        assertEquals('X', winner);
    }

    @Test
    public void testCheckDiagonalWinRightToLeft_O() {
        char[][] board = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'O', ' ', ' ', ' '},
                {' ', ' ', 'O', ' ', ' ', ' ', ' '},
                {' ', 'O', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
        };

        Service service = new Service();
        char winner = service.checkTopRightDiagonalWin(board);
        assertEquals('O', winner);
    }

    @Test
    public void testCheckDiagonalWinRightToLeft_X() {
        char[][] board = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' ', ' ', ' '},
                {' ', 'X', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
        };

        Service service = new Service();
        char winner = service.checkTopRightDiagonalWin(board);
        assertEquals('X', winner);
    }

    @Test
    public void testCheckWinner_Tie() {
        char[][] board = {
                {'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O', 'X'},
        };
        Service service = new Service();
        char winner = service.checkWinner(board);
        assertEquals('T', winner);
    }

}
