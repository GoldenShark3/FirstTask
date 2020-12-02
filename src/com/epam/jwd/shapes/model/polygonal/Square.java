package com.epam.jwd.shapes.model.polygonal;

import com.epam.jwd.shapes.model.simple.Point;
import com.epam.jwd.shapes.strategy.MultiAngleFigureStrategy;
import com.epam.jwd.shapes.strategy.MultiAngleStrategy;

public class Square extends MultiAngleFigure {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;
    private final Point fourthPoint;

    Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        super(new Point[]{firstPoint, secondPoint, thirdPoint, fourthPoint}, MultiAngleStrategy.INSTANCE);
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
