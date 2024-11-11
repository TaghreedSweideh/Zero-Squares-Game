/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.main;

import com.mycompany.main.GamePlaying.Player;
import com.mycompany.main.GameStructure.GameState;
import com.mycompany.main.GameStructure.Level;
import com.mycompany.main.GameStructure.Action;
import java.util.Scanner;

/**
 *
 * @author taghr
 */
public class Main {

    public static void main(String[] args) {
        Level currentLevel = Level.levels.get(4);
        GameState gameState = new GameState(currentLevel.board, currentLevel.coloredSqures,
                currentLevel.goalSquares);
        //Action action=new Action();
      
//        gameState.printGame(gameState.getBoard());
//        for(GameState game: (gameState.states(gameState)))
//        { game.printGame(game.getBoard());}


       Player player = new Player(gameState);
        player.startGame();
        
//        System.out.println("Current Game");
//        gameState.printGame(gameState.getBoard());
//        System.out.println("game after moving Down");
//
//        gameState = action.moveDown(gameState);
//        gameState.printGame(gameState.getBoard());
//        if (gameState.checkWin(gameState.getColoredSquares())) {
//            System.out.println("You Win");
//        } else {
//            System.out.println("Still playing");
//        }
//        gameState = action.moveLeft(gameState);
//        gameState.printGame(gameState.getBoard());
//        gameState = action.moveLeft(gameState);
//        gameState.printGame(gameState.getBoard());
//        gameState = action.moveUp(gameState);
//        gameState.printGame(gameState.getBoard());
//        gameState = action.moveRight(gameState);
//        gameState.printGame(gameState.getBoard());
//        gameState = action.moveRight(gameState);
//        gameState.printGame(gameState.getBoard());
//        if (gameState.checkWin(gameState.getColoredSquares())) {
//            System.out.println("You Win");
//        } else {
//            System.out.println("Still playing");
//        }
    }
}
