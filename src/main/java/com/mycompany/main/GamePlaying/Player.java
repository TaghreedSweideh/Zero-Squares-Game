package com.mycompany.main.GamePlaying;

import com.mycompany.main.GameStructure.Action;
import com.mycompany.main.GameStructure.GameState;
import java.util.ArrayList;
import javax.swing.text.Position;

/**
 *
 * @author taghr
 */
import java.util.Scanner;

public class Player {

    private GameState gameState;
    private final Action action;

    public Player(GameState gameState) {
        this.gameState = gameState;
        this.action = new Action();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon) {
            gameState.printGame(gameState.getBoard());
            System.out.println("To move use: \nW (up) \nA (left) \nS (down) \nD (right)");

            char input = scanner.next().toUpperCase().charAt(0);
            gameWon = keyAction(input);
        }
        gameState.printGame(gameState.getBoard());
        System.out.println("************ CONGATULATIONS ************");
        System.out.println("************     YOU WON     ************");
        scanner.close();
    }

    private boolean keyAction(char input) {
        switch (input) {
            case 'W':
                if (action.canMoveUp(gameState)) {
                    gameState = action.moveUp(gameState);

                } else {
                    System.out.println("Cannot move up.");
                }
                break;
            case 'A':
                if (action.canMoveLeft(gameState)) {
                    gameState = action.moveLeft(gameState);

                } else {
                    System.out.println("Cannot move left.");
                }
                break;
            case 'S':
                if (action.canMoveDown(gameState)) {
                    gameState = action.moveDown(gameState);

                } else {
                    System.out.println("Cannot move down.");
                }
                break;
            case 'D':
                if (action.canMoveRight(gameState)) {
                    gameState = action.moveRight(gameState);

                } else {
                    System.out.println("Cannot move right.");
                }
                break;
            default:
                System.out.println("Invalid input. Use W, A, S, or D.");
                break;
        }
        return gameState.checkWin(gameState.getColoredSquares());
    }
}
