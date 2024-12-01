package com.mycompany.main.GamePlaying;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.mycompany.main.GameStructure.GameState;
import com.mycompany.main.GameStructure.Position;

public class HeuristicAlgorithms {

    int calculateHeuristic(GameState state) {
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

    void printPath(GameState goal) {
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
        System.out.println("Path length: " + path.size());
    }
}
