package com.epam.jwd.model.polygonal;

import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.MultiAngleFigureStrategy;
import com.epam.jwd.strategy.SquareStrategy;

import java.util.Objects;

public class Square extends Figure{
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point fourthPoint;

    public Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint, SquareStrategy squareStrategy) {
        super(squareStrategy);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;
    }

    @Override
    public MultiAngleFigureStrategy<Square> getPolygonalFigureStrategy() {
        return (MultiAngleFigureStrategy<Square>) super.getPolygonalFigureStrategy();
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
