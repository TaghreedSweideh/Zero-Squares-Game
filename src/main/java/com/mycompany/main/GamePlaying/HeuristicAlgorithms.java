package com.mycompany.main.GamePlaying;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import com.mycompany.main.GameStructure.GameState;
import com.mycompany.main.GameStructure.Position;

public class HeuristicAlgorithms {

    public void simpleHillClimbing(GameState initState) {
        long startTime = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        GameState current = initState;
        while (true) {
            if (current.checkWin(current.getColoredSquares())) {
                printPath(current, 0);
                long endTime = System.nanoTime();
                long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

                System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");
                System.out.println("Memory Used: " + (memoryAfter - memoryBefore) / 1024 + " KB");

                return;
            }
            boolean flag = false;
            for (GameState game : current.states(current)) {
                int parentHeu = calculateHeuristic(current);
                int childHeu = calculateHeuristic(game);
                if (childHeu < parentHeu) {
                    current = game;
                    game.setParent(current);
                    flag = true;
                    break;
                }
                if (!flag) {
                    System.out.println("No better solution found");
                    return;
                }
            }
        }
    }

    public void steepestHillClimbing(GameState initState) {

        long startTime = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        GameState current = initState;

        while (true) {

            if (current.checkWin(current.getColoredSquares())) {
                printPath(current, 0);
                long endTime = System.nanoTime();
                long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

                System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000 + " ms");
                System.out.println("Memory Used: " + (memoryAfter - memoryBefore) / 1024 + " KB");
                return;
            }
            GameState bestCase = null;
            int min = Integer.MAX_VALUE;
            for (GameState game : current.states(current)) {
                int heuristic = calculateHeuristic(game);
                System.out.println("heuristic: " + heuristic);
                if (heuristic < min) {
                    min = heuristic;
                    bestCase = game;
                }
            }
            System.out.println("best heuristic: " + min);
            if (bestCase == null || min >= calculateHeuristic(current)) {
                return;
            }
            bestCase.setParent(current);
            current = bestCase;
        }

    }

    public void solveAStar(GameState initState) {

        long startTime = System.nanoTime();
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        PriorityQueue<GameState> queue = new PriorityQueue<>(
                (a, b) -> ((a.getgCost() + a.gethCost()) - (b.getgCost() + b.gethCost())));
        Map<GameState, Integer> visited = new HashMap<>();
        int visitedCount = 0;
        initState.setgCost(0);
        initState.sethCost(calculateHeuristic(initState));
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
                int newGCost = current.getgCost() + current.calculateCost(current, game);
                game.sethCost(calculateHeuristic(game));
                if (!visited.containsKey(game) || newGCost < visited.get(game)) {
                    game.setgCost(newGCost);
                    game.setParent(current);
                    queue.add(game);
                }
            }
        }
        System.out.println("No solution found.");
    }

    public int calculateHeuristic(GameState state) {
        int total = 0;

        List<Position> coloredSquares = state.getColoredSquares();
        List<Position> goalSquares = state.getGoalSquared();

        for (int i = 0; i < coloredSquares.size(); i++) {
            Position current = coloredSquares.get(i);
            Position goal = goalSquares.get(i);
            int manhattan = Math.abs(current.getRow() - goal.getRow()) + Math.abs(current.getCol() - goal.getCol());
            total += manhattan;
        }

        return total;
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
