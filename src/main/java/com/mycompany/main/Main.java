/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.main;

import com.mycompany.main.GamePlaying.BlindAlgorithms;
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
        Level currentLevel = Level.levels.get(5);
        GameState gameState = new GameState(currentLevel.board, currentLevel.coloredSqures,
                currentLevel.goalSquares);

        // gameState.printGame(gameState.getBoard());
        // for(GameState game: (gameState.states(gameState)))
        // { game.printGame(game.getBoard());}
        // Player player = new Player(gameState);
        // player.startGame();
        BlindAlgorithms algorithm = new BlindAlgorithms();

        // System.out.println("Blind Algorithm DFS");
        // algorithm.solveDFS(gameState);
        //
        // System.out.println("Blind Algorithm BFS");
        // algorithm.solveBFS(gameState);
        while (true) {
            System.out.println("Choose Algorithm:");
            System.out.println("q: Quit");
            System.out.println("1- User Play");
            System.out.println("2- DFS");
            System.out.println("3- BFS");
            System.out.println("4- DFS recursion");
            System.out.println("5- Uniform Cost search");
            char choice = (new Scanner(System.in)).next().charAt(0);
            switch (choice) {
                case '1':
                    Player player = new Player(gameState);
                    player.startGame();
                    break;
                case '2':
                    System.out.println("Solving using DFS ...");
                    algorithm.solveDFS(gameState);
                    break;
                case '3':
                    System.out.println("Solving using BFS ...");
                    algorithm.solveBFS(gameState);
                    break;
                case '4':
                    System.out.println("Solving using DFS Recursivly ...");
                    algorithm.DFSRecursive(gameState);
                    break;
                case '5':
                    System.out.println("Solving using Unifrom Cost search ...");
                    break;
                default:
                    System.out.println("Invalid choice.Try again.");
                    break;
                case 'q':
                    return;
            }
        }

    }
}
