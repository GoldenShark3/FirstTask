package com.epam.jwd.shapes.model.polygonal;

import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.strategy.MultiAngleFigureStrategy;
import com.epam.jwd.shapes.strategy.impl.TriangleStrategy;

import java.util.Objects;

public class Triangle extends Figure {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;

    Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        super(TriangleStrategy.getInstance());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return firstPoint.equals(triangle.firstPoint)
               && secondPoint.equals(triangle.secondPoint)
               && thirdPoint.equals(triangle.thirdPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstPoint, secondPoint, thirdPoint);
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

    public Point[] fetchArrOfPoints() {
        return new Point[]{firstPoint, secondPoint, thirdPoint};
    }
}
