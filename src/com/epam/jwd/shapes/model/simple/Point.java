package com.epam.jwd.shapes.model.simple;

import com.epam.jwd.shapes.model.SimpleFigure;

import java.util.Objects;

public class Point extends SimpleFigure {
    private final int x;
    private final int y;

    Point (int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
