package com.epam.jwd.model;

public class Point {
    private int x;
    private int y;

    public Point (int x, int y){
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
