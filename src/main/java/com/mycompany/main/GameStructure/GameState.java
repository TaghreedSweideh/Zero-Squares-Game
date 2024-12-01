/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.GameStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author taghr
 */
public class GameState {

    GameState parent;
    int gCost = 1;
    int hCost = Integer.MAX_VALUE;
    char[][] board;
    List<Position> coloredSquares;
    List<Position> goalSquares;

    public GameState(GameState parent, int cost, char[][] board, List<Position> coloredSquares,
            List<Position> goalSquares) {
        this.parent = parent;
        this.gCost = cost;
        this.board = board;
        this.coloredSquares = coloredSquares;
        this.goalSquares = goalSquares;
    }

    public GameState(char[][] board, List<Position> coloredSquares, List<Position> goalSquares) {
        this.board = board;
        this.coloredSquares = coloredSquares;
        this.goalSquares = goalSquares;
    }

    public GameState() {
    }

    public boolean hasPrevious() {
        return this.parent != null;
    }

    public GameState getParent() {
        return parent;
    }

    public void setParent(GameState parent) {
        this.parent = parent;
    }

    public int gethCost() {
        return hCost;
    }

    public void sethCost(int hCost) {
        this.hCost = hCost;
    }

    public int getgCost() {
        return gCost;
    }

    public void setgCost(int cost) {
        this.gCost = cost;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public List<Position> getColoredSquares() {
        return coloredSquares;
    }

    public void setColoredSquares(List<Position> coloredSquares) {
        this.coloredSquares = coloredSquares;
    }

    public List<Position> getGoalSquared() {
        return goalSquares;
    }

    public void setGoalSquared(List<Position> goalSquared) {
        this.goalSquares = goalSquared;
    }

    public void printGame(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkWin(List<Position> coloredSquares) {
        return coloredSquares.isEmpty();
    }

    public List<GameState> states(GameState currentGame) {
        List<GameState> possibleStates = new ArrayList<>();
        Action action = new Action();
        if (action.canMoveLeft(currentGame)) {
            possibleStates.add(action.moveLeft(currentGame));
        }
        if (action.canMoveRight(currentGame)) {
            possibleStates.add(action.moveRight(
                    currentGame));
        }
        if (action.canMoveUp(currentGame)) {
            possibleStates.add(action.moveUp(currentGame));
        }
        if (action.canMoveDown(currentGame)) {
            possibleStates.add(action.moveDown(currentGame));
        }
        return possibleStates;

    }

    public GameState deepCopy() {
        GameState newGameState = new GameState();

        newGameState.board = new char[this.board.length][this.board[0].length];
        for (int i = 0; i < this.board.length; i++) {
            newGameState.board[i] = this.board[i].clone();
        }
        newGameState.coloredSquares = new ArrayList<>();
        for (Position pos : this.coloredSquares) {
            newGameState.coloredSquares.add(new Position(pos.getRow(), pos.getCol(), pos.getColor()));
        }

        newGameState.goalSquares = new ArrayList<>();
        for (Position pos : this.goalSquares) {
            newGameState.goalSquares.add(new Position(pos.getRow(), pos.getCol(), pos.getColor()));
        }

        return newGameState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameState gameState = (GameState) o;
        return Arrays.deepEquals(board, gameState.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
}
