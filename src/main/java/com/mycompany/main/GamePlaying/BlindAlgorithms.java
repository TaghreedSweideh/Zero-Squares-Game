/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.GamePlaying;

import com.mycompany.main.GameStructure.GameState;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author taghr
 */
public class BlindAlgorithms {

    public void solveDFS(GameState initialGame) {
        long startTime = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

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
                long endTime = System.nanoTime();
                long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

                System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");
                System.out.println("Memory Used: " + (memoryAfter - memoryBefore) / 1024 + " KB");
                return;
            }

            for (GameState game : current.states(current)) {
                if (!visited.containsKey(game)) {
                    // game.printGame(game.getBoard());
                    game.setParent(current);
                    stack.push(game);
                    visited.put(game, true);

                }
            }
        }

        System.out.println("No solution found.");
    }

    public void solveBFS(GameState initiState) {
        long startTime = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

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

                long endTime = System.nanoTime();
                long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

                System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");
                System.out.println("Memory Used: " + (memoryAfter - memoryBefore) / 1024 + " KB");
                return;
            }
            for (GameState game : current.states(current)) {
                if (!visited.containsKey(game)) {
                    // game.printGame(game.getBoard());
                    game.setParent(current);
                    queue.add(game);
                    visited.put(game, true);
                }
            }
        }
        System.out.println("No solution found.");
    }

    Map<GameState, Boolean> visited = new HashMap<>();
    int visitedCount = 0;

    public void DFSRecursive(GameState initState) {
        if (visited.containsKey(initState)) {
            return;
        }
        visited.put(initState, true);
        visitedCount++;
        if (initState.checkWin(initState.getColoredSquares())) {
            printPath(initState, visitedCount);
            return;
        }
        for (GameState game : initState.states(initState)) {
            if (!visited.containsKey(game)) {
                // game.printGame(game.getBoard());
                game.setParent(initState);
                DFSRecursive(game);
            }
        }

    }

    public void solveUCS(GameState initState) {
        long startTime = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        PriorityQueue<GameState> queue = new PriorityQueue<>(Comparator.comparingInt(GameState::getgCost));
        Map<GameState, Integer> visited = new HashMap<>();
        int visitedCount = 0;
        initState.setgCost(0);
        queue.add(initState);
        while (!queue.isEmpty()) {
            GameState current = queue.poll();

            if (current.checkWin(current.getColoredSquares())) {
                printPath(current, visitedCount);
                System.out.println("Total cost of the algorithm is : " + current.getgCost());
                long endTime = System.nanoTime();
                long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

                System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");
                System.out.println("Memory Used: " + (memoryAfter - memoryBefore) / 1024 + " KB");
                return;
            }

            if (visited.containsKey(current) && visited.get(current) < current.getgCost()) {
                continue;
            }
            visited.put(current, current.getgCost());
            visitedCount++;
            for (GameState game : current.states(current)) {
                int moveCost = current.calculateCost(current, game);
                int newGCost = current.getgCost() + moveCost;
                game.setgCost(newGCost);
                game.setParent(current);
                if (!visited.containsKey(game) || newGCost < visited.get(game)) {
                    // game.printGame(game.getBoard());
                    queue.add(game);
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
