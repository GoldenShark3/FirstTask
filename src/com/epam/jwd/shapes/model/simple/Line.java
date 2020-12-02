package com.epam.jwd.shapes.model.simple;

import com.epam.jwd.shapes.model.SimpleFigure;

public class Line extends SimpleFigure {
    private final Point firstPoint;
    private final Point secondPoint;

    Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public String toString() {
        return "Line{" +
                "FirstPoint = " + firstPoint +
                ", SecondPoint = " + secondPoint + '}';
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

}
