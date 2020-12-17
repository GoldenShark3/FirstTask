package com.epam.jwd.shapes.model.polygonal.impl;

import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigureType;
import com.epam.jwd.shapes.model.polygonal.api.PolygonalFigure;
import com.epam.jwd.shapes.model.simple.impl.Point;
import com.epam.jwd.shapes.strategy.api.MultiAngleFigureStrategy;
import com.epam.jwd.shapes.strategy.impl.SquareStrategy;
import java.util.Objects;

public class Square extends PolygonalFigure {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;
    private final Point fourthPoint;

    Square(Point... points) {
        super(SquareStrategy.getInstance(), PolygonalFigureType.SQUARE);
        this.firstPoint = points[0];
        this.secondPoint = points[1];
        this.thirdPoint = points[2];
        this.fourthPoint = points[3];
    }

    @Override
    public MultiAngleFigureStrategy getPolygonalFigureStrategy() {
        return super.getPolygonalFigureStrategy();
    }

    @Override
    public String toString() {
        return "Square{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                ", fourthPoint=" + fourthPoint +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return firstPoint.equals(square.firstPoint)
               && secondPoint.equals(square.secondPoint)
               && thirdPoint.equals(square.thirdPoint)
               && fourthPoint.equals(square.fourthPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstPoint, secondPoint, thirdPoint, fourthPoint);
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

    public Point getFourthPoint() {
        return fourthPoint;
    }

}
