/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main.GameStructure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author taghr
 */
public class Action {

    // can move left
    public boolean canMoveLeft(GameState currentGame) {
        for (Position pos : currentGame.coloredSquares) {
            int currentRow = pos.getRow();
            int currentCol = pos.getCol();
            if (currentCol > 0
                    && (currentGame.board[currentRow][currentCol - 1] != '#'
                            && !isColoredSquare(currentRow, currentCol - 1, currentGame.coloredSquares))) {
                return true;
            }
        }
        return false;
    }
    // can move right

    public boolean canMoveRight(GameState currentGame) {
        for (Position pos : currentGame.coloredSquares) {
            int currentRow = pos.getRow();
            int currentCol = pos.getCol();
            if (currentCol < currentGame.board[0].length - 1
                    && (currentGame.board[currentRow][currentCol + 1] != '#'
                            && !isColoredSquare(currentRow, currentCol + 1, currentGame.coloredSquares))) {
                return true;
            }
        }
        return false;
    }
    // can move up

    public boolean canMoveUp(GameState currentGame) {
        for (Position pos : currentGame.coloredSquares) {
            int currentRow = pos.getRow();
            int currentCol = pos.getCol();
            if (currentRow > 0
                    && (currentGame.board[currentRow - 1][currentCol] != '#'
                            && !isColoredSquare(currentRow - 1, currentCol, currentGame.coloredSquares))) {
                return true;
            }
        }
        return false;
    }
    // can move down

    public boolean canMoveDown(GameState currentGame) {
        for (Position pos : currentGame.coloredSquares) {
            int currentRow = pos.getRow();
            int currentCol = pos.getCol();
            if (currentRow < currentGame.board.length - 1
                    && (currentGame.board[currentRow + 1][currentCol] != '#'
                            && !isColoredSquare(currentRow + 1, currentCol, currentGame.coloredSquares))) {
                return true;
            }
        }
        return false;
    }

    // is colored square function
    boolean isColoredSquare(int row, int col, List<Position> coloredSquares) {
        for (Position pos : coloredSquares) {
            if (pos.getRow() == row && pos.getCol() == col) {
                return true;
            }
        }
        return false;
    }

    // is goal square
    boolean isGoalSquare(int row, int col, List<Position> goalSquares) {
        for (Position pos : goalSquares) {
            if (pos.getRow() == row && pos.getCol() == col) {
                return true;
            }
        }
        return false;
    }

    public GameState moveRight(GameState currentGame) {
        GameState newGame = currentGame.deepCopy();
        List<Position> newColoredSquaresPositions = new ArrayList<>();

        for (Position pos : currentGame.coloredSquares) {
            int currentRow = pos.getRow();
            int currentCol = pos.getCol();
            int newCol = currentCol;

            while (newCol < currentGame.board[0].length - 1
                    && (currentGame.board[currentRow][newCol + 1] != '#'
                            && !isColoredSquare(currentRow, newCol + 1, currentGame.coloredSquares))) {
                newCol++;
                // if (currentGame.board[currentRow][newCol] == 'X') {
                // System.out.println("the game is over");
                // break;
                // }
                if (currentGame.board[currentRow][newCol] == Character.toLowerCase(pos.getColor())) {
                    newGame.board[currentRow][currentCol] = ' ';
                    newGame.board[currentRow][newCol] = ' ';
                    break;
                }
            }

            if (newCol >= 0 && newCol < currentGame.board[0].length
                    && currentGame.board[currentRow][newCol] != Character.toLowerCase(pos.getColor())) {
                newColoredSquaresPositions.add(new Position(currentRow, newCol, pos.getColor()));
            }
        }

        for (Position pos : newGame.coloredSquares) {
            newGame.board[pos.getRow()][pos.getCol()] = ' ';

        }
        for (Position pos : newGame.goalSquares) {
            newGame.board[pos.getRow()][pos.getCol()] = ' ';

        }
        newGame.goalSquares.clear();
        for (Position goal : currentGame.goalSquares) {
            boolean hasMatchingColoredSquare = false;

            for (Position coloredSquare : newColoredSquaresPositions) {
                if (goal.getColor() == Character.toLowerCase(coloredSquare.getColor())) {
                    hasMatchingColoredSquare = true;
                    break;
                }
            }
            if (hasMatchingColoredSquare) {
                newGame.board[goal.getRow()][goal.getCol()] = goal.getColor();
                newGame.goalSquares.add(goal);
            }
        }
        newGame.coloredSquares.clear();

        for (Position newPos : newColoredSquaresPositions) {
            newGame.board[newPos.getRow()][newPos.getCol()] = newPos.getColor();
            newGame.coloredSquares.add(newPos);
        }

        return newGame;
    }

    public GameState moveDown(GameState currentGame) {
        GameState newGame = currentGame.deepCopy();
        List<Position> newColoredSquaresPositions = new ArrayList<>();

        for (Position pos : currentGame.coloredSquares) {
            int currentRow = pos.getRow();
            int currentCol = pos.getCol();
            int newRow = currentRow;
            while (newRow < currentGame.board.length - 1
                    && (currentGame.board[newRow + 1][currentCol] != '#'
                            && !isColoredSquare(newRow + 1, currentCol, currentGame.coloredSquares))) {
                newRow++;
                if (currentGame.board[newRow][currentCol] == Character.toLowerCase(pos.getColor())) {
                    newGame.board[currentRow][currentCol] = ' ';
                    newGame.board[newRow][currentCol] = ' ';
                    break;

                }
            }

            if (newRow < currentGame.board.length
                    && currentGame.board[newRow][currentCol] != Character.toLowerCase(pos.getColor())) {
                newColoredSquaresPositions.add(new Position(newRow, currentCol, pos.getColor()));
            }
        }

        for (Position pos : newGame.coloredSquares) {
            newGame.board[pos.getRow()][pos.getCol()] = ' ';
        }
        for (Position pos : newGame.goalSquares) {
            newGame.board[pos.getRow()][pos.getCol()] = ' ';
        }
        newGame.goalSquares.clear();
        for (Position goal : currentGame.goalSquares) {
            boolean hasMatchingColoredSquare = false;
            for (Position coloredSquare : newColoredSquaresPositions) {
                if (goal.getColor() == Character.toLowerCase(coloredSquare.getColor())) {
                    hasMatchingColoredSquare = true;
                    break;
                }
            }
            if (hasMatchingColoredSquare) {
                newGame.board[goal.getRow()][goal.getCol()] = goal.getColor();
                newGame.goalSquares.add(goal);
            }
        }
        newGame.coloredSquares.clear();
        for (Position newPos : newColoredSquaresPositions) {
            newGame.board[newPos.getRow()][newPos.getCol()] = newPos.getColor();

            newGame.coloredSquares.add(newPos);
        }

        return newGame;
    }

    public GameState moveUp(GameState currentGame) {
        GameState newGame = currentGame.deepCopy();
        List<Position> newColoredSquaresPositions = new ArrayList<>();

        for (Position pos : currentGame.coloredSquares) {
            int currentRow = pos.getRow();
            int currentCol = pos.getCol();
            int newRow = currentRow;

            while (newRow > 0
                    && (currentGame.board[newRow - 1][currentCol] != '#'
                            && !isColoredSquare(newRow - 1, currentCol, currentGame.coloredSquares))) {
                newRow--;

                if (newRow < currentGame.board.length) {
                    if (currentGame.board[newRow][currentCol] == Character.toLowerCase(pos.getColor())) {
                        newGame.board[currentRow][currentCol] = ' ';
                        break;
                    }
                }
            }
            if (newRow >= 0 && currentGame.board[newRow][currentCol] != Character.toLowerCase(pos.getColor())) {
                newColoredSquaresPositions.add(new Position(newRow, currentCol, pos.getColor()));
            }
        }
        for (Position pos : newGame.coloredSquares) {
            newGame.board[pos.getRow()][pos.getCol()] = ' ';
        }
        for (Position pos : newGame.goalSquares) {
            newGame.board[pos.getRow()][pos.getCol()] = ' ';
        }
        newGame.goalSquares.clear();
        for (Position goal : currentGame.goalSquares) {
            boolean hasMatchingColoredSquare = false;
            for (Position coloredSquare : newColoredSquaresPositions) {
                if (goal.getColor() == Character.toLowerCase(coloredSquare.getColor())) {
                    hasMatchingColoredSquare = true;
                    break;
                }
            }
            if (hasMatchingColoredSquare) {
                newGame.board[goal.getRow()][goal.getCol()] = goal.getColor();
                newGame.goalSquares.add(goal);
            }
        }
        newGame.coloredSquares.clear();
        for (Position newPos : newColoredSquaresPositions) {
            newGame.board[newPos.getRow()][newPos.getCol()] = newPos.getColor();
            newGame.coloredSquares.add(newPos);
        }

        return newGame;
    }

    public GameState moveLeft(GameState currentGame) {
        GameState newGame = currentGame.deepCopy();
        List<Position> newColoredSquaresPositions = new ArrayList<>();

        for (Position pos : currentGame.coloredSquares) {
            int currentRow = pos.getRow();
            int currentCol = pos.getCol();
            int newCol = currentCol;
            while (newCol > 0 && (currentGame.board[currentRow][newCol - 1] != '#'
                    && !isColoredSquare(currentRow, newCol - 1, currentGame.coloredSquares))) {
                newCol--;

                if (currentGame.board[currentRow][newCol] == Character.toLowerCase(pos.getColor())) {
                    newGame.board[currentRow][currentCol] = ' ';
                    newGame.board[currentRow][newCol] = ' ';
                    break;
                }
            }
            if (newCol >= 0 && currentGame.board[currentRow][newCol] != Character.toLowerCase(pos.getColor())) {
                newColoredSquaresPositions.add(new Position(currentRow, newCol, pos.getColor()));
            }
        }

        for (Position pos : newGame.coloredSquares) {
            newGame.board[pos.getRow()][pos.getCol()] = ' ';
        }
        for (Position pos : newGame.goalSquares) {
            newGame.board[pos.getRow()][pos.getCol()] = ' ';
        }
        newGame.goalSquares.clear();
        for (Position goal : currentGame.goalSquares) {
            boolean hasMatchingColoredSquare = false;
            for (Position coloredSquare : newColoredSquaresPositions) {
                if (goal.getColor() == Character.toLowerCase(coloredSquare.getColor())) {
                    hasMatchingColoredSquare = true;
                    break;
                }
            }

            if (hasMatchingColoredSquare) {
                newGame.board[goal.getRow()][goal.getCol()] = goal.getColor();
                newGame.goalSquares.add(goal);
            }
        }
        newGame.coloredSquares.clear();
        for (Position newPos : newColoredSquaresPositions) {
            newGame.board[newPos.getRow()][newPos.getCol()] = newPos.getColor();
            newGame.coloredSquares.add(newPos);
        }

        return newGame;
    }

}
