/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.GamePlaying;

import com.mycompany.main.GameStructure.GameState;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author taghr
 */
public class BlindAlgorithms {

    public void solveDFS(GameState initialGame) {
        Stack<GameState> stack = new Stack();
        Map<GameState, Boolean> visited = new HashMap<>();
        stack.push(initialGame);
        visited.put(initialGame, true);
        int visitedCount = 0;
        while (!stack.isEmpty()) {
            GameState current = stack.pop();
            visitedCount++;
            if (current.checkWin(current.getColoredSquares())) {
                printPath(current, visitedCount);
                return;
            }

            for (GameState game : current.states(current)) {
                if (!visited.containsKey(game)) {
//                   game.printGame(game.getBoard());
                    game.setParent(current);
                    stack.push(game);
                    visited.put(game, true);

                }
            }
        }

        System.out.println("No solution found.");
    }

    public void solveBFS(GameState initiState) {
        Queue<GameState> queue = new LinkedList<>();
        Map<GameState, Boolean> visited = new HashMap<>();
        int visitedCount = 0;
        queue.add(initiState);
        visited.put(initiState, true);
        while (!queue.isEmpty()) {
            GameState current = queue.remove();
            visitedCount++;
            if (current.checkWin(current.getColoredSquares())) {
                printPath(current, visitedCount);
                return;
            }
            for (GameState game : current.states(current)) {
                if (!visited.containsKey(game)) {
//                    game.printGame(game.getBoard());
                    game.setParent(current);
                    queue.add(game);
                    visited.put(game, true);
                }
            }
        }
        System.out.println("No solution found.");
    }

    void printPath(GameState goal, int visitedCount) {
        List<GameState> path = new LinkedList();

        while (goal != null) {
            path.add(0, goal);
            goal = goal.getParent();
        }

        System.out.println("Solution Path:");

        for (GameState state : path) {
            state.printGame(state.getBoard());
            System.out.println();
        }

        System.out.println("Number of visited states: " + visitedCount);
        System.out.println("Path length: " + path.size());
    }
}
