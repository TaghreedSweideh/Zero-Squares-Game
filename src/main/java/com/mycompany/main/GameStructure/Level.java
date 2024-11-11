package com.mycompany.main.GameStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author taghr
 */
public class Level {

    int levelNo;
    public char[][] board;
    public List<Position> coloredSqures;
    public List<Position> goalSquares;
    public static final List<Level> levels = new ArrayList<>();

    public Level() {
    }

    public Level(int levelNo, char[][] board, List<Position> coloredSquares, List<Position> goalSquares) {
        this.levelNo = levelNo;
        this.board = board;
        this.coloredSqures = coloredSquares;
        this.goalSquares = goalSquares;
    }

    static {
        //Level 1 setup
        char[][] boardLevel1 = {
            {'#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', 'R', ' ', ' ', ' ', ' ', 'r', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#'}
        };
        List<Position> coloredSquaresLevel1 = new ArrayList<>();
        coloredSquaresLevel1.add(new Position(1, 1, 'R'));
        List<Position> goalSquaresLevel1 = new ArrayList<>();
        goalSquaresLevel1.add(new Position(1, 6, 'r'));
        levels.add(new Level(1, boardLevel1, coloredSquaresLevel1, goalSquaresLevel1));
        //level 2 setup
        char[][] boardLevel2 = {{'#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', ' ', ' ', '#', ' ', ' ', ' ', '#'},
        {'#', 'O', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', '#', 'o', '#', '#', '#'},
        {' ', ' ', ' ', '#', '#', '#', ' ', ' '}};
        List<Position> coloredSquaresLevel2 = new ArrayList<>();
        coloredSquaresLevel2.add(new Position(2, 1, 'O'));
        List<Position> goalSquaresLevel2 = new ArrayList<>();
        goalSquaresLevel2.add(new Position(4, 4, 'o'));
        levels.add(new Level(2, boardLevel2, coloredSquaresLevel2, goalSquaresLevel2));
        //level 3 setup
        char[][] boardLevel3 = {{' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {' ', ' ', '#', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', 'o', ' ', ' ', ' ', '#', ' ', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {' ', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};

        List<Position> coloredSquaresLevel3 = new ArrayList<>();
        coloredSquaresLevel3.add(new Position(1, 3, 'O'));
        List<Position> goalSquaresLevel3 = new ArrayList<>();
        goalSquaresLevel3.add(new Position(3, 6, 'o'));
        levels.add(new Level(3, boardLevel3, coloredSquaresLevel3, goalSquaresLevel3));
        //level 6 setup
        char[][] boardLevel6 = {{'#', '#', '#', '#', '#', '#', ' ', ' ', ' '},
        {'#', 'o', ' ', ' ', ' ', '#', '#', ' ', ' '},
        {'#', ' ', ' ', 'b', ' ', ' ', '#', '#', '#'},
        {'#', ' ', ' ', ' ', ' ', ' ', 'B', 'O', '#'},
        {'#', '#', '#', '#', '#', '#', '#', '#', '#'}};
        List<Position> coloredSquaresLevel6 = new ArrayList<>();
        coloredSquaresLevel6.add(new Position(3, 6, 'B'));
        coloredSquaresLevel6.add(new Position(3, 7, 'O'));
        List<Position> goalSquaresLevel6 = new ArrayList<>();
        goalSquaresLevel6.add(new Position(1, 1, 'o'));
        goalSquaresLevel6.add(new Position(2, 3, 'b'));

        levels.add(new Level(6, boardLevel6, coloredSquaresLevel6, goalSquaresLevel6));

        //level 11 setup
        char[][] boardLevel11 = {{' ', '#', '#', '#', ' ', ' ', ' ', ' '},
        {'#', '#', 'y', '#', '#', '#', '#', '#'},
        {'#', 'Y', 'R', 'B', ' ', ' ', ' ', '#'},
        {'#', 'b', '#', 'r', '#', '#', '#', '#'},
        {'#', '#', '#', '#', '#', '#', '#', '#'}};
        List<Position> coloredSquaresLevel11 = new ArrayList<>();
        coloredSquaresLevel11.add(new Position(2, 1, 'Y'));
        coloredSquaresLevel11.add(new Position(2, 2, 'R'));
        coloredSquaresLevel11.add(new Position(2, 3, 'B'));
        List<Position> goalSquaresLevel11 = new ArrayList<>();
        goalSquaresLevel11.add(new Position(1, 2, 'y'));
        goalSquaresLevel11.add(new Position(3, 3, 'r'));
        goalSquaresLevel11.add(new Position(3, 1, 'b'));

        levels.add(new Level(11, boardLevel11, coloredSquaresLevel11, goalSquaresLevel11));

    }

    public Level getCurrentLevel(int levelNo) {
        for (Level level : levels) {
            if (level.levelNo == levelNo) {
                return level;
            }
        }
        return null;
    }

}

class Position {

    private int row;
    private int col;
    private char color;

    Position() {
    }

    Position(int row) {
        this.row = row;
    }

    Position(int row, int col, char color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return row == position.row && col == position.col && color == position.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, color);
    }

}
