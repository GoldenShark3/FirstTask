package com.epam.jwd.model;

public class Triangle {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                '}';
    }

    public Point getFirstPoint() {
        return firstPoint;
    }


    public Point getSecondPoint() {
        return secondPoint;
    }


    public Point getThirdPoint() {
        return thirdPoint;
    }

}
