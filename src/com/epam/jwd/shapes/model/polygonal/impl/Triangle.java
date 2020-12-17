package com.epam.jwd.shapes.model.polygonal.impl;

import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigureType;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.simple.impl.Point;
import com.epam.jwd.shapes.strategy.api.MultiAngleFigureStrategy;
import com.epam.jwd.shapes.strategy.impl.TriangleStrategy;
import java.util.Objects;

public class Triangle extends PolygonalFigure {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;

    Triangle(Point... points) {
        super(TriangleStrategy.getInstance(), PolygonalFigureType.TRIANGLE);
        this.firstPoint = points[0];
        this.secondPoint = points[1];
        this.thirdPoint = points[2];
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

}
