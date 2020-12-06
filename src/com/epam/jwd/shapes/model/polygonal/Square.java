package com.epam.jwd.shapes.model.polygonal;

import com.epam.jwd.shapes.model.Figure;
import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.strategy.MultiAngleFigureStrategy;
import com.epam.jwd.shapes.strategy.impl.MultiAngleStrategy;
import com.epam.jwd.shapes.strategy.impl.SquareStrategy;

import java.util.Objects;

public class Square extends Figure {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;
    private final Point fourthPoint;

    Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        super(SquareStrategy.getInstance());
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;
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
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Objects.equals(firstPoint, square.firstPoint) &&
                Objects.equals(secondPoint, square.secondPoint) &&
                Objects.equals(thirdPoint, square.thirdPoint) &&
                Objects.equals(fourthPoint, square.fourthPoint);
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

    public Point[] fetchArrOfPoints() {
        return new Point[]{firstPoint, secondPoint, thirdPoint, fourthPoint};
    }
}
