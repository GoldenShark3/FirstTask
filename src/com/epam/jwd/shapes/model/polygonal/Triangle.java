package com.epam.jwd.shapes.model.polygonal;

import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.strategy.MultiAngleFigureStrategy;
import com.epam.jwd.shapes.strategy.TriangleStrategy;

public class Triangle extends MultiAngleFigure {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;

    Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        super(new Point[]{firstPoint, secondPoint, thirdPoint}, TriangleStrategy.getInstance());
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    @Override
    public MultiAngleFigureStrategy getPolygonalFigureStrategy() {
        return super.getPolygonalFigureStrategy();
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
