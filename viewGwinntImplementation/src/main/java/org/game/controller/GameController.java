package org.game.controller;
import org.game.buisnessLogic.Service;
import org.game.entity.Player;

import java.util.Scanner;

public class GameController {
    /**
     * Class to control the flow of the game.
     */
    public void run(){
        Player p1 = new Player("test1", 'X');
        Player p2 = new Player("test2", 'O');
        Service service = new Service();
        Player currentPlayer = p1;
        Scanner scanner = new Scanner(System.in);
        //BoardDesign b = new BoardDesign();
        do {
            service.printingTheBoard();
            System.out.println("Player " + currentPlayer.getName() + "Enter column number 1-7: ");
            int column = scanner.nextInt() - 1;
            currentPlayer = getPlayer(column, service, currentPlayer, p1, p2);
        } while (currentPlayer != null);
        scanner.close();
    }
    /**
     * Helper method for run()
     * Method to get the Player.
     * @param column The column number chosen by the player.
     * @param service The service object.
     * @param currentPlayer The current player.
     * @param p1 Player 1.
     * @param p2 Player 2.
     * @return The next player or null if the game is over.
     */
    private static Player getPlayer(int column, Service service, Player currentPlayer, Player p1, Player p2) {
        if (column >= 0 && column < 7) {
            service.dropPiece(column, service.getBoardDesign(), currentPlayer);
            service.printingTheBoard();
            char winner = service.checkWinner( service.getBoardDesign());
            if (winner == p1.getC()) {
                System.out.println("Player " + p1.getName() + " wins!");
                return null;
            } else if (winner == p2.getC()) {
                System.out.println("Player " + p2.getName() + " wins!");
                return null;
            } else if (winner == 'T') {
                System.out.println("Tied");
                return null;
            }
            currentPlayer = (currentPlayer == p1) ? p2 : p1;
        } else {
            System.out.println("Try again.");
        }
        return currentPlayer;
    }
}

