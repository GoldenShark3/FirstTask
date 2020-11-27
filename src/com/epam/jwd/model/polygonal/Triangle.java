package com.epam.jwd.model.polygonal;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.strategy.MultiAngleFigureStrategy;
import com.epam.jwd.strategy.TriangleStrategy;

public class Triangle extends Figure {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    Triangle(Point firstPoint, Point secondPoint, Point thirdPoint, TriangleStrategy triangleStrategy) {
        super(triangleStrategy);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    @Override
    public MultiAngleFigureStrategy<Triangle> getPolygonalFigureStrategy() {
        return (MultiAngleFigureStrategy<Triangle>) super.getPolygonalFigureStrategy();
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
