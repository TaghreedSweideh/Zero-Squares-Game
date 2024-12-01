package com.mycompany.main.GameStructure;

import java.util.Objects;

/**
 *
 * @author taghr
 */
public class Position {

    int row;
    int col;
    char color;

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
