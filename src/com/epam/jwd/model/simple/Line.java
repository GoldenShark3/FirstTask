package com.epam.jwd.model.simple;

import com.epam.jwd.model.SimpleFigure;

public class Line extends SimpleFigure {
    private Point firstPoint;
    private Point secondPoint;

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
